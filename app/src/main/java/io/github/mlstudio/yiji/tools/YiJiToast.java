package io.github.mlstudio.yiji.tools;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import com.github.johnpersano.supertoasts.SuperToast;

import io.github.mlstudio.yiji.YiJiApplication;

/**
 * Created by Weiping on 2015/11/30.
 */
public class YiJiToast {
    private static YiJiToast ourInstance = new YiJiToast();

    private YiJiToast() {
    }

    public static YiJiToast getInstance() {
        return ourInstance;
    }

    public void showToast(int text, @ColorInt int color) {
        SuperToast.cancelAllSuperToasts();
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(YiJiApplication.getAppContext());
        superToast.setAnimations(YiJiUtil.TOAST_ANIMATION);
        superToast.setDuration(SuperToast.Duration.SHORT);
        superToast.setTextColor(Color.parseColor("#ffffff"));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setText(YiJiApplication.getAppContext().getResources().getString(text));
        superToast.setBackground(color);
        superToast.getTextView().setTypeface(YiJiUtil.typefaceLatoLight);
        superToast.show();
    }

    public void showToast(String text, int color) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(YiJiApplication.getAppContext());
        superToast.setAnimations(YiJiUtil.TOAST_ANIMATION);
        superToast.setDuration(SuperToast.Duration.SHORT);
        superToast.setTextColor(Color.parseColor("#ffffff"));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setText(text);
        superToast.setBackground(color);
        superToast.getTextView().setTypeface(YiJiUtil.typefaceLatoLight);
        superToast.show();
    }
}
