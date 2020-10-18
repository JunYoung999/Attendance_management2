package com.example.attendance_management;


import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;

public abstract class ListenerFactory {

//    public static View.OnTouchListener touchListenerFactory(final int colorId) {
//        return new View.OnTouchListener() {
//            private boolean touched = false;
//            int originalColor = -1;
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                ColorDrawable colorDrawable = (ColorDrawable)view.getBackground();
//                if(originalColor == -1) {
//                    originalColor = colorDrawable.getColor();
//                }
//                touched = !touched;
//                int selectedColor;
//                if(touched) {
//                    selectedColor = colorId;
//                } else {
//                    selectedColor = originalColor;
//                }
//                switch(motionEvent.getAction()){
//                    case MotionEvent.ACTION_UP : ;
//                    case MotionEvent.ACTION_MOVE : ;
//                    case MotionEvent.ACTION_DOWN : view.setBackgroundColor(selectedColor); break;
//                }
//                return false;
//            }
//        };
//    }
//    public static View.OnClickListener clickListenerFactory(final SelfdiagnosisActivity activity, final int symptomIdx, final int flag, final int colorId) {
//        return new View.OnClickListener() {
//            private boolean clicked = false;
//            @Override
//            public void onClick(View view) {
//                clicked = !clicked;
//                if(!clicked) {
//                    activity.setSymptomsFlag(symptomIdx, 0);
//                    return;
//                }
//                activity.setSymptomsFlag(symptomIdx, flag);
//            }
//        };
//    }
    public static View.OnClickListener clickListenerFactory(final SelfdiagnosisActivity activity, final int symptomIdx, final int flag, final int colorId) {
        return new View.OnClickListener() {
            private boolean clicked = false;
            int originalColor = -1;
            @Override
            public void onClick(View view) {
                ColorDrawable colorDrawable = (ColorDrawable)view.getBackground();
                if(originalColor == -1) {
                    originalColor = colorDrawable.getColor();
                }
                clicked = !clicked;
                int selectedColor;
                if(clicked) {
                    selectedColor = colorId;
                } else {
                    selectedColor = originalColor;
                }
                view.setBackgroundColor(selectedColor);
                int selectedFlag = 0;
                if (clicked) {
                    selectedFlag = flag;
                }
                activity.setSymptomsFlag(symptomIdx, selectedFlag);
                activity.call();
            }
        };
    }
}
