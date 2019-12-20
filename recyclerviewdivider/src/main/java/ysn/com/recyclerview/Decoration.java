package ysn.com.recyclerview;

import android.support.annotation.ColorInt;

/**
 * @Author yangsanning
 * @ClassName Decoration
 * @Description 分割线的属性
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class Decoration {

    private boolean isShow;

    private int color;

    private float width;

    /**
     * paddingStart: 分割线起始的padding (水平方向左为start，垂直方向上为start)
     * paddingEnd: 分割线尾部的padding (水平方向右为end，垂直方向下为end)
     */
    private float paddingStart;
    private float paddingEnd;

    public Decoration() {
        this(false, 0xff666666, 0, 0, 0);
    }

    public Decoration(int color, float width) {
        this(true, color, width);
    }

    public Decoration(boolean isShow, int color, float width) {
        this(isShow, color, width, 0, 0);
    }

    public Decoration(int color, float width, float paddingStart, float paddingEnd) {
        this(true, color, width, paddingStart, paddingEnd);
    }

    public Decoration(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.isShow = isShow;
        this.color = color;
        this.width = width;
        this.paddingStart = paddingStart;
        this.paddingEnd = paddingEnd;
    }

    public float getPaddingStart() {
        return paddingStart;
    }

    public void setPaddingStart(float paddingStart) {
        this.paddingStart = paddingStart;
    }

    public float getPaddingEnd() {
        return paddingEnd;
    }

    public void setPaddingEnd(float paddingEnd) {
        this.paddingEnd = paddingEnd;
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
