package ysn.com.recyclerview;

/**
 * @Author yangsanning
 * @ClassName RvItemDecoration
 * @Description ItemDecoration
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public class RvItemDecoration {

    private Decoration leftDecoration;
    private Decoration topDecoration;
    private Decoration rightDecoration;
    private Decoration bottomDecoration;

    public RvItemDecoration(Decoration leftDecoration, Decoration topDecoration,
                            Decoration rightDecoration, Decoration bottomDecoration) {
        this.leftDecoration = leftDecoration;
        this.topDecoration = topDecoration;
        this.rightDecoration = rightDecoration;
        this.bottomDecoration = bottomDecoration;
    }

    public Decoration getLeftDecoration() {
        return leftDecoration;
    }

    public void setLeftDecoration(Decoration leftDecoration) {
        this.leftDecoration = leftDecoration;
    }

    public Decoration getTopDecoration() {
        return topDecoration;
    }

    public void setTopDecoration(Decoration topDecoration) {
        this.topDecoration = topDecoration;
    }

    public Decoration getRightDecoration() {
        return rightDecoration;
    }

    public void setRightDecoration(Decoration rightDecoration) {
        this.rightDecoration = rightDecoration;
    }

    public Decoration getBottomDecoration() {
        return bottomDecoration;
    }

    public void setBottomDecoration(Decoration bottomDecoration) {
        this.bottomDecoration = bottomDecoration;
    }
}
