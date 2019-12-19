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

    private Decoration leftLine;
    private Decoration topLine;
    private Decoration rightLine;
    private Decoration bottomLine;

    public RvItemDecorationBuilder buildLeft(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.leftLine = new Decoration(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public RvItemDecorationBuilder buildTop(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.topLine = new Decoration(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public RvItemDecorationBuilder buildRight(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.rightLine = new Decoration(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public RvItemDecorationBuilder buildBottom(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.bottomLine = new Decoration(isShow, color, width, startSpan, endSpan);
        return this;
    }

    /**
     * 最后必须调用
     */
    public RvItemDecoration finish() {
        //提供一个默认不显示的defaultLine, 防止空指针
        Decoration defaultLine = new Decoration();
        leftLine = (leftLine != null ? leftLine : defaultLine);
        topLine = (topLine != null ? topLine : defaultLine);
        rightLine = (rightLine != null ? rightLine : defaultLine);
        bottomLine = (bottomLine != null ? bottomLine : defaultLine);
        return new RvItemDecoration(leftLine, topLine, rightLine, bottomLine);
    }
}

