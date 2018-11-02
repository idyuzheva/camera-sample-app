package com.camera.sample;

import android.content.Context;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import android.view.Surface;

import org.opencv.android.JavaCameraView;

public class CameraPreview extends JavaCameraView {

    private int mRatioWidth = 0;
    private int mRatioHeight = 0;

    public CameraPreview(Context context, int cameraId) {
        super(context, cameraId);
    }

    public CameraPreview(Context context) {
        this(context, 0);
    }

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAspectRatio(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (0 == mRatioWidth || 0 == mRatioHeight) {
            setMeasuredDimension(width, height);
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
            } else {
                setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
            }
        }
    }

    protected MediaRecorder mRecorder;
    protected Surface mSurface = null;

    public void setRecorder(MediaRecorder rec) {
        mRecorder = rec;
        if (mRecorder != null) {
            mSurface = mRecorder.getSurface();
        }
    }
}
