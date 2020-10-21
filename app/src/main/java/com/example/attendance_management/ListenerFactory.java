package com.example.attendance_management;


import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;

public abstract class ListenerFactory {
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
