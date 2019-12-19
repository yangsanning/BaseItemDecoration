package ysn.com.recyclerview;

import android.support.annotation.ColorInt;

/**
 * @Author yangsanning
 * @ClassName RvItemDecorationBuilder
 * @Description 通过 RvItemDecorationBuilder, 自由定义属于你的分割线
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class RvItemDecorationBuilder {

    private Decoration leftDecoration;
    private Decoration topDecoration;
    private Decoration rightDecoration;
    private Decoration bottomDecoration;

    public RvItemDecorationBuilder buildLeft(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.leftDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildTop(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.topDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
        return this;
    }

    public RvItemDecorationBuilder buildRight(boolean isShow, @ColorInt int color, float width, float paddingStart, float paddingEnd) {
        this.rightDecoration = new Decoration(isShow, color, width, paddingStart, paddingEnd);
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
        //提供一个默认不显示的defaultLine, 防止空指针
        Decoration defaultLine = new Decoration();
        leftDecoration = (leftDecoration != null ? leftDecoration : defaultLine);
        topDecoration = (topDecoration != null ? topDecoration : defaultLine);
        rightDecoration = (rightDecoration != null ? rightDecoration : defaultLine);
        bottomDecoration = (bottomDecoration != null ? bottomDecoration : defaultLine);
        return new RvItemDecoration(leftDecoration, topDecoration, rightDecoration, bottomDecoration);
    }
}

