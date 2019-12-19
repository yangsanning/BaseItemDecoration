package ysn.com.recyclerviewdivider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author yangsanning
 * @ClassName RecyclerViewDivider
 * @Description RecyclerView分割线, 顺时针绘制
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public abstract class RecyclerViewDivider extends RecyclerView.ItemDecoration {

    private Context context;

    private Paint paint;

    public RecyclerViewDivider(Context context) {
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            Divider divider = getDivider(((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition());
            if (divider == null) {
                return;
            }
            // 绘制左边分割线
            drawChildLeftVertical(child, c, divider.getLeftLine());

            // 绘制头部分割线
            drawChildTopHorizontal(child, c, divider.getTopLine());

            // 绘制右边分割线
            drawChildRightVertical(child, c, divider.getRightLine());

            // 绘制底部分割线
            drawChildBottomHorizontal(child, c, divider.getBottomLine());
        }
    }

    /**
     * 绘制左边分割线
     */
    private void drawChildLeftVertical(View child, Canvas c, Line leftLine) {
        if (leftLine.isHide()) {
            return;
        }

        float topSpan;
        float bottomSpan;

        if (leftLine.getStartSpan() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -leftLine.getWidth();
        } else {
            topSpan = leftLine.getStartSpan();
        }

        if (leftLine.getEndSpan() <= 0) {
            bottomSpan = leftLine.getWidth();
        } else {
            bottomSpan = -leftLine.getEndSpan();
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        float top = child.getTop() - params.topMargin + topSpan;
        float bottom = child.getBottom() + params.bottomMargin + bottomSpan;
        float right = child.getLeft() - params.leftMargin;
        float left = right - leftLine.getWidth();
        paint.setColor(leftLine.getColor());
        c.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制头部分割线
     */
    private void drawChildTopHorizontal(View child, Canvas c, Line topLine) {
        if (topLine.isHide()) {
            return;
        }
        float leftSpan;
        float rightSpan;

        if (topLine.getStartSpan() <= 0) {
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -topLine.getWidth();
        } else {
            leftSpan = topLine.getStartSpan();
        }
        if (topLine.getEndSpan() <= 0) {
            rightSpan = topLine.getWidth();
        } else {
            rightSpan = -topLine.getEndSpan();
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        float left = child.getLeft() - params.leftMargin + leftSpan;
        float right = child.getRight() + params.rightMargin + rightSpan;
        float bottom = child.getTop() - params.topMargin;
        float top = bottom - topLine.getWidth();
        paint.setColor(topLine.getColor());
        c.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制右边分割线
     */
    private void drawChildRightVertical(View child, Canvas c, Line rightLine) {
        if (rightLine.isHide()) {
            return;
        }

        float topSpan;
        float bottomSpan;

        if (rightLine.getStartSpan() <= 0) {
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -rightLine.getWidth();
        } else {
            topSpan = rightLine.getStartSpan();
        }
        if (rightLine.getEndSpan() <= 0) {
            bottomSpan = rightLine.getWidth();
        } else {
            bottomSpan = -rightLine.getEndSpan();
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        float top = child.getTop() - params.topMargin + topSpan;
        float bottom = child.getBottom() + params.bottomMargin + bottomSpan;
        float left = child.getRight() + params.rightMargin;
        float right = left + rightLine.getWidth();
        paint.setColor(rightLine.getColor());
        c.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制底部分割线
     */
    private void drawChildBottomHorizontal(View child, Canvas c, Line bottomLine) {
        if (bottomLine.isHide()) {
            return;
        }
        float leftSpan;
        float rightSpan;

        if (bottomLine.getStartSpan() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -bottomLine.getWidth();
        } else {
            leftSpan = bottomLine.getStartSpan();
        }

        if (bottomLine.getEndSpan() <= 0) {
            rightSpan = bottomLine.getWidth();
        } else {
            rightSpan = -bottomLine.getEndSpan();
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        float left = child.getLeft() - params.leftMargin + leftSpan;
        float right = child.getRight() + params.rightMargin + rightSpan;
        float top = child.getBottom() + params.bottomMargin;
        float bottom = top + bottomLine.getWidth();
        paint.setColor(bottomLine.getColor());
        c.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        Divider divider = getDivider(itemPosition);

        if (divider == null) {
            divider = new DividerBuilder().create();
        }

        int left = divider.getLeftLine().isShow() ? (int) divider.getLeftLine().getWidth() : 0;
        int top = divider.getTopLine().isShow() ? (int) divider.getTopLine().getWidth() : 0;
        int right = divider.getRightLine().isShow() ? (int) divider.getRightLine().getWidth() : 0;
        int bottom = divider.getBottomLine().isShow() ? (int) divider.getBottomLine().getWidth() : 0;

        outRect.set(left, top, right, bottom);
    }

    /**
     * 通过 DividerBuilder, 自由定义你的 StyleDivider
     *
     * @see DividerBuilder
     */
    public abstract @Nullable
    Divider getDivider(int itemPosition);
}
