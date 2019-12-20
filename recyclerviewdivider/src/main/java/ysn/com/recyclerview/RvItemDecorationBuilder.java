package ysn.com.recyclerview;

import android.support.annotation.ColorInt;

/**
 * @Author yangsanning
 * @ClassName RvItemDecorationBuilder
 * @Description 通过 RvItemDecorationBuilder, 自由定义属于你的分割线 (默认四角留白, 如有需要自行通过padding填充)
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class RvItemDecorationBuilder {

    private Decoration leftDecoration;
    private Decoration topDecoration;
    private Decoration rightDecoration;
    private Decoration bottomDecoration;

    public RvItemDecorationBuilder buildLeft(@ColorInt int color, float width) {
        this.leftDecoration = new Decoration(color, width);
        return this;
    }

    public RvItemDecorationBuilder buildLeft(boolean isShow, @ColorInt int color, float width) {
        this.leftDecoration = new Decoration(isShow, color, width);
        return this;
    }

    public RvItemDecorationBuilder buildLeft(@ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.leftDecoration = new Decoration(color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildLeft(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.leftDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildTop(@ColorInt int color, float width) {
        this.topDecoration = new Decoration(color, width);
        return this;
    }

    public RvItemDecorationBuilder buildTop(boolean isShow, @ColorInt int color, float width) {
        this.topDecoration = new Decoration(isShow, color, width);
        return this;
    }

    public RvItemDecorationBuilder buildTop(@ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.topDecoration = new Decoration(color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildTop(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.topDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildRight(@ColorInt int color, float width) {
        this.rightDecoration = new Decoration(color, width);
        return this;
    }

    public RvItemDecorationBuilder buildRight(boolean isShow, @ColorInt int color, float width) {
        this.rightDecoration = new Decoration(isShow, color, width);
        return this;
    }

    public RvItemDecorationBuilder buildRight(@ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.rightDecoration = new Decoration(color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildRight(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.rightDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildBottom(@ColorInt int color, float width) {
        this.bottomDecoration = new Decoration(color, width);
        return this;
    }

    public RvItemDecorationBuilder buildBottom(boolean isShow, @ColorInt int color, float width) {
        this.bottomDecoration = new Decoration(isShow, color, width);
        return this;
    }

    public RvItemDecorationBuilder buildBottom(@ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.bottomDecoration = new Decoration(color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildBottom(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.bottomDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    /**
     * 最后必须调用
     */
    public RvItemDecoration finish() {
        // 提供一个默认不显示的 Decoration, 防止空指针
        Decoration decoration = new Decoration();
        leftDecoration = (leftDecoration != null ? leftDecoration : decoration);
        topDecoration = (topDecoration != null ? topDecoration : decoration);
        rightDecoration = (rightDecoration != null ? rightDecoration : decoration);
        bottomDecoration = (bottomDecoration != null ? bottomDecoration : decoration);
        return new RvItemDecoration(leftDecoration, topDecoration, rightDecoration, bottomDecoration);
    }
}

