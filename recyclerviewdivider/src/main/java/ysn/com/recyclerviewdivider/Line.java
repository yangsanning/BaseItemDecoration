package ysn.com.recyclerviewdivider;

import android.support.annotation.ColorInt;

/**
 * @Author yangsanning
 * @ClassName Line
 * @Description 一句话概括作用
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class Line {

    private boolean isShow;

    private int color;

    private float width;
    /**
     * startSpan,分割线起始的padding（水平方向左为start，垂直方向上为start）
     * endSpan,分割线尾部的padding（水平方向右为end，垂直方向下为end）
     */
    private float startSpan;
    private float endSpan;

    public Line() {
        this(false, 0xff666666, 0, 0, 0);
    }

    public Line(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.isShow = isShow;
        this.color = color;
        this.width = width;
        this.startSpan = startSpan;
        this.endSpan = endSpan;
    }

    public float getStartSpan() {
        return startSpan;
    }

    public void setStartSpan(float startSpan) {
        this.startSpan = startSpan;
    }

    public float getEndSpan() {
        return endSpan;
    }

    public void setEndSpan(float endSpan) {
        this.endSpan = endSpan;
    }

    public boolean isShow() {
        return isShow;
    }

    public boolean isHide() {
        return !isShow();
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
