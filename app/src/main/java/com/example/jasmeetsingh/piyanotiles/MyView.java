package com.example.jasmeetsingh.piyanotiles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class MyView extends View {

    private Paint tPaint, sPaint;
    private int score = 0;
    private float progress = 5;
    public static final String TAG = "TAG";
    private boolean callOnDraw = false;
    float counter1 = 0;
    int cellWidth, cellHeight, height, width;
    int array[][] = new int[5][4];
    float x, y;
    private boolean flag = true;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        createColorArray();
    }

    private void createColorArray() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int k = random.nextInt(4);
            while (i > 0 && array[i - 1][k] == Color.BLACK) {
                k = random.nextInt(4);
            }
            for (int j = 0; j < 4; j++) {
                if (j == k) {

                    if (i == 4) {
                        array[i][j] = Color.rgb(0, 255, 255);

                    } else {
                        array[i][j] = Color.BLACK;
                    }
                } else {
                    array[i][j] = Color.WHITE;
                }

            }
        }

        tPaint = new Paint();
        tPaint.setTextSize(150);
        tPaint.setColor(Color.RED);
        tPaint.setFakeBoldText(true);
        tPaint.setShadowLayer(5f, 8f, 8f, Color.DKGRAY);

        sPaint = new Paint();
        sPaint.setTextSize(75);
        sPaint.setColor(Color.RED);
        sPaint.setFakeBoldText(true);
        sPaint.setShadowLayer(5f, 8f, 8f, Color.DKGRAY);
    }
}
