package ysn.com.recyclerviewdivider;

/**
 * @Author yangsanning
 * @ClassName Divider
 * @Description 一句话概括作用
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class Divider {

    public Line leftLine;
    public Line topLine;
    public Line rightLine;
    public Line bottomLine;


    public Divider(Line leftLine, Line topLine, Line rightLine, Line bottomLine) {
        this.leftLine = leftLine;
        this.topLine = topLine;
        this.rightLine = rightLine;
        this.bottomLine = bottomLine;
    }

    public Line getLeftLine() {
        return leftLine;
    }

    public void setLeftLine(Line leftLine) {
        this.leftLine = leftLine;
    }

    public Line getTopLine() {
        return topLine;
    }

    public void setTopLine(Line topLine) {
        this.topLine = topLine;
    }

    public Line getRightLine() {
        return rightLine;
    }

    public void setRightLine(Line rightLine) {
        this.rightLine = rightLine;
    }

    public Line getBottomLine() {
        return bottomLine;
    }

    public void setBottomLine(Line bottomLine) {
        this.bottomLine = bottomLine;
    }
}
