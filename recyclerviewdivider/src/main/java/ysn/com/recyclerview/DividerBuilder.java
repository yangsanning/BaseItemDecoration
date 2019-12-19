package ysn.com.recyclerview;

import android.support.annotation.ColorInt;

/**
 * @Author yangsanning
 * @ClassName 通过 DividerBuilder, 自由定义你的 StyleDivider
 * @Description 用于创建
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class DividerBuilder {

    private Line leftLine;
    private Line topLine;
    private Line rightLine;
    private Line bottomLine;

    public DividerBuilder setLeftLine(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.leftLine = new Line(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public DividerBuilder setTopLine(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.topLine = new Line(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public DividerBuilder setRightLine(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.rightLine = new Line(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public DividerBuilder setBottomLine(boolean isShow, @ColorInt int color, float width, float startSpan, float endSpan) {
        this.bottomLine = new Line(isShow, color, width, startSpan, endSpan);
        return this;
    }

    public Divider create() {
        //提供一个默认不显示的sideline，防止空指针
        Line defaultLine = new Line();

        leftLine = (leftLine != null ? leftLine : defaultLine);
        topLine = (topLine != null ? topLine : defaultLine);
        rightLine = (rightLine != null ? rightLine : defaultLine);
        bottomLine = (bottomLine != null ? bottomLine : defaultLine);

        return new Divider(leftLine, topLine, rightLine, bottomLine);
    }
}

