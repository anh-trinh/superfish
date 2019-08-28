package com.tnta.superfish.superfish.utils.opening;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.tnta.superfish.superfish.MainActivity;

public class StartGameBoard {

    private Canvas canvas;

    private final String START_NEW_GAME = "Click to start a new game";
    private final String HIGH_SCORE = "High Score";
    private final String GUIDE_FIRST_LINE = "Try to get the highest score";
    private final String GUIDE_SECOND_LINE = "Swipe to eat food and attack enemies";
    private final String GUIDE_THIRD_LINE = "Swipe to eat food and attack enemies";
    private final String GUIDE_FOURTH_LINE = "Welcome to Holy Fish!";
    private final String GUIDE_FIFTH_LINE = "Raise your fish to become a super fish";
    private final String GUIDE_SIXTH_LINE = "Now click to start a new game";

    public StartGameBoard(Canvas canvas) {
        this.canvas = canvas;
    }

    public void doDrawStartScreen(Canvas canvas){
        if (isSavedScoreExist()) {
            String text2 = "Click to start a new game";
            Paint p2 = new Paint();
            Rect bounds2 = new Rect();
            p2.setColor(Color.WHITE);
            p2.setTextSize(canvas.getHeight() / 15);
            p2.setStyle(Paint.Style.STROKE);
            p2.setStrokeWidth(3);
            p2.getTextBounds(text2, 0, text2.length(), bounds2);
            canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);
        } else {
            String text2 = "Click to start a new game";
            Paint p2 = new Paint();
            Rect bounds2 = new Rect();
            p2.setColor(Color.WHITE);
            p2.setTextSize(canvas.getHeight() / 15);
            p2.setStyle(Paint.Style.STROKE);
            p2.setStrokeWidth(3);
            p2.getTextBounds(text2, 0, text2.length(), bounds2);
            canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height()), p2);
            String text3 = "High Score: " + MainActivity.preference.getScore();
            Paint p3 = new Paint();
            Rect bounds3 = new Rect();
            p3.setColor(Color.WHITE);
            p3.setTextSize(canvas.getHeight() / 21);
            p3.setStyle(Paint.Style.FILL_AND_STROKE);
            p3.getTextBounds(text3, 0, text3.length(), bounds3);
            canvas.drawText(text3, (canvas.getWidth() / 2) - (bounds3.width() / 2), (canvas.getHeight() / 2), p3);
        }
    }

    public void doDrawGuildLine(Canvas canvas) {
        String text2 = "Try to get the highest score";
        Paint p2 = new Paint();
        Rect bounds2 = new Rect();
        p2.setColor(Color.WHITE);
        p2.setTextSize(canvas.getHeight() / 15);
        p2.setStyle(Paint.Style.FILL_AND_STROKE);
        p2.getTextBounds(text2, 0, text2.length(), bounds2);
        canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);
        String text3 = "Swipe to eat food and attack enemies";
        Paint p3 = new Paint();
        Rect bounds3 = new Rect();
        p3.setColor(Color.WHITE);
        p3.setTextSize(canvas.getHeight() / 15);
        p3.setStyle(Paint.Style.FILL_AND_STROKE);
        p3.getTextBounds(text3, 0, text3.length(), bounds3);
        canvas.drawText(text3, (canvas.getWidth() / 2) - (bounds3.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2)-(bounds3.height()), p3);
        String text4 = "Welcome to Holy Fish!";
        Paint p4 = new Paint();
        Rect bounds4 = new Rect();
        p4.setColor(Color.YELLOW);
        p4.setTextSize(canvas.getHeight() / 15);
        p4.setStyle(Paint.Style.FILL_AND_STROKE);
        p4.getTextBounds(text4, 0, text4.length(), bounds4);
        canvas.drawText(text4, (canvas.getWidth() / 2) - (bounds4.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2)-(bounds3.height())-(bounds4.height()), p4);
        String text5 = "Raise your fish to become a super fish";
        Paint p5 = new Paint();
        Rect bounds5 = new Rect();
        p5.setColor(Color.WHITE);
        p5.setTextSize(canvas.getHeight() / 15);
        p5.setStyle(Paint.Style.FILL_AND_STROKE);
        p5.getTextBounds(text5, 0, text5.length(), bounds5);
        canvas.drawText(text5, (canvas.getWidth() / 2) - (bounds5.width() / 2), (canvas.getHeight() / 2) + (bounds2.height() / 2), p5);
        String text6 = "Now click to start a new game";
        Paint p6 = new Paint();
        Rect bounds6 = new Rect();
        p6.setColor(Color.YELLOW);
        p6.setTextSize(canvas.getHeight() / 15);
        p6.setStyle(Paint.Style.FILL_AND_STROKE);
        p6.getTextBounds(text6, 0, text6.length(), bounds6);
        canvas.drawText(text6, (canvas.getWidth() / 2) - (bounds6.width() / 2), (canvas.getHeight() / 2) + (bounds2.height() / 2)+(bounds5.height()), p6);
    }

    private void doDrawText(String text, Paint paint, float coordinateX, float coordinateY) {
        canvas.drawText(text, coordinateX, coordinateY, paint);
    }

    private Paint designText(String text, int color, int size, Paint.Style style) {
        Paint paint = new Paint();
        Rect bound = new Rect();
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setStyle(style);
        paint.getTextBounds(text, 0, text.length(), bound);
        return paint;
    }

    private boolean isSavedScoreExist() {
        if (MainActivity.preference.getScore() == null) {
            return false;
        }
        return true;
    }
}
