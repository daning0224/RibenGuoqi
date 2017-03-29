package com.bawei.ribenguoqi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.ribenguoqi.R;

/**
 * 作    者：云凯文
 * 时    间：2017/3/29
 * 描    述：
 * 修改时间：
 */

public class MyView extends View {

    private int radius;
    private int width;
    private int height;
    private Paint mPaint;
    private String text;


    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        radius = (int) typedArray.getDimension(R.styleable.MyView_circle_radius, 50);
        text = typedArray.getString(R.styleable.MyView_text);
        //创建画笔
        mPaint = new Paint();

    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getWidth() / 2;
        height = getHeight() / 2;
        setMeasuredDimension(400, 300);
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制矩形
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
        canvas.drawRect(width - 160, height - 100, width + 160, height + 100, mPaint);
        //绘制圆
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(width, height, radius, mPaint);
        //绘制文本
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        int textWidth = rect.width();
        int textHeight = rect.height();
        canvas.drawText(text, width - (textWidth / 2), height + 120 + (textHeight / 2), mPaint);

    }
}
