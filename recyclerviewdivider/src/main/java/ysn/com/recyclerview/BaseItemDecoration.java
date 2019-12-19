package ysn.com.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author yangsanning
 * @ClassName BaseItemDecoration
 * @Description RecyclerView分割线, 顺时针绘制
 * @Date 2019/4/28
 * @History 2019/4/28 author: description:
 */
public abstract class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint;

    protected BaseItemDecoration() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RvItemDecoration rvItemDecoration = getRvItemDecoration(((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition());
            if (rvItemDecoration == null) {
                return;
            }
            // 绘制左边分割线
            drawLeft(child, c, rvItemDecoration.getLeftDecoration());

            // 绘制头部分割线
            drawTop(child, c, rvItemDecoration.getTopDecoration());

            // 绘制右边分割线
            drawRight(child, c, rvItemDecoration.getRightDecoration());

            // 绘制底部分割线
            drawBottom(child, c, rvItemDecoration.getBottomDecoration());
        }
    }

    /**
     * 绘制左边分割线
     */
    private void drawLeft(View child, Canvas c, Decoration leftLine) {
        if (leftLine.isHide()) {
            return;
        }

        float topSpan;
        if (leftLine.getStartSpan() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -leftLine.getWidth();
        } else {
            topSpan = leftLine.getStartSpan();
        }

        float bottomSpan;
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
    private void drawTop(View child, Canvas c, Decoration topLine) {
        if (topLine.isHide()) {
            return;
        }

        float leftSpan;
        if (topLine.getStartSpan() <= 0) {
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -topLine.getWidth();
        } else {
            leftSpan = topLine.getStartSpan();
        }

        float rightSpan;
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
    private void drawRight(View child, Canvas c, Decoration rightLine) {
        if (rightLine.isHide()) {
            return;
        }

        float topSpan;
        if (rightLine.getStartSpan() <= 0) {
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -rightLine.getWidth();
        } else {
            topSpan = rightLine.getStartSpan();
        }

        float bottomSpan;
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
    private void drawBottom(View child, Canvas c, Decoration bottomLine) {
        if (bottomLine.isHide()) {
            return;
        }

        float leftSpan;
        if (bottomLine.getStartSpan() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -bottomLine.getWidth();
        } else {
            leftSpan = bottomLine.getStartSpan();
        }

        float rightSpan;
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
        RvItemDecoration rvItemDecoration = getRvItemDecoration(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition());
        if (rvItemDecoration == null) {
            rvItemDecoration = new RvItemDecorationBuilder().finish();
        }

        int left = rvItemDecoration.getLeftDecoration().isShow() ? (int) rvItemDecoration.getLeftDecoration().getWidth() : 0;
        int top = rvItemDecoration.getTopDecoration().isShow() ? (int) rvItemDecoration.getTopDecoration().getWidth() : 0;
        int right = rvItemDecoration.getRightDecoration().isShow() ? (int) rvItemDecoration.getRightDecoration().getWidth() : 0;
        int bottom = rvItemDecoration.getBottomDecoration().isShow() ? (int) rvItemDecoration.getBottomDecoration().getWidth() : 0;
        outRect.set(left, top, right, bottom);
    }

    /**
     * 通过 RvItemDecorationBuilder, 自由定义属于你的分割线
     *
     * @see RvItemDecorationBuilder
     */
    public abstract @Nullable
    RvItemDecoration getRvItemDecoration(int itemPosition);
}
