package com.example.ftcscouting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

public class DrawingView extends View {

    // Drawing path
    private Path drawPath;
    // Drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    // Initial color
    private int paintColor = 0xFF000000; // Black
    // Canvas
    private Canvas drawCanvas;
    // Canvas bitmap
    private Bitmap canvasBitmap;
    // Background image
    private Drawable backgroundImage;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    // Setup drawing
    private void setupDrawing() {
        Log.d("DrawingView", "setupDrawing called");
        // Prepare for drawing and setup paint stroke properties
        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        // Canvas paint setup
        canvasPaint = new Paint(Paint.DITHER_FLAG);

        // Load the background image from drawable resources
        backgroundImage = ContextCompat.getDrawable(getContext(), R.drawable.field); // Replace game_field with your image name
    }

    // Size assigned to view
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d("DrawingView", "onSizeChanged called");
        super.onSizeChanged(w, h, oldw, oldh);

        // Create bitmap, canvas, and canvas paint
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

        // Set the bounds of the background image to match the view's size
        if (backgroundImage != null) {
            backgroundImage.setBounds(0, 0, w, h);
        }
    }

    // Draw the view - will be called after touch event
    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("DrawingView", "onDraw called");
        super.onDraw(canvas);

        // Draw the background image first
        if (backgroundImage != null) {
            backgroundImage.draw(canvas);
        }

        // Draw the path
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    // Register user touches as drawing action
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);

                getParent().requestDisallowInterceptTouchEvent(true); // Add this line
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:

                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();

                getParent().requestDisallowInterceptTouchEvent(false); // Add this line
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    // Update color
    public void setColor(String newColor) {
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
    }

    // Set new color
    public void setErase(boolean isErase) {
        if (isErase) {
            drawPaint.setColor(Color.WHITE);
        } else {
            drawPaint.setColor(paintColor);
        }
    }

    // Start new drawing
    public void clearDrawing() {
        drawCanvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
        drawPath.reset();
        invalidate();
    }

    // Get the drawing bitmap
    public Bitmap getDrawingBitmap() {
        return canvasBitmap;
    }
}