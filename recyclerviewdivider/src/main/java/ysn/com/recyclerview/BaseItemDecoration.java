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
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            RvItemDecoration rvItemDecoration = getRvItemDecoration(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition());
            if (rvItemDecoration == null) {
                return;
            }
            // 绘制左边分割线
            drawLeft(view, canvas, rvItemDecoration.getLeftDecoration());

            // 绘制头部分割线
            drawTop(view, canvas, rvItemDecoration);

            // 绘制右边分割线
            drawRight(view, canvas, rvItemDecoration.getRightDecoration());

            // 绘制底部分割线
            drawBottom(view, canvas, rvItemDecoration.getBottomDecoration());
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
        if (leftLine.getPaddingStart() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -leftLine.getWidth();
        } else {
            topSpan = leftLine.getPaddingStart();
        }

        float bottomSpan;
        if (leftLine.getPaddingEnd() <= 0) {
            bottomSpan = leftLine.getWidth();
        } else {
            bottomSpan = -leftLine.getPaddingEnd();
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
    private void drawTop(View view, Canvas canvas, RvItemDecoration rvItemDecoration) {
        Decoration topDecoration = rvItemDecoration.getTopDecoration();
        if (topDecoration.isHide()) {
            return;
        }

        float leftSpan = 0;
        Decoration leftDecoration = rvItemDecoration.getLeftDecoration();
        if (leftDecoration.isShow()) {
            leftSpan = -leftDecoration.getWidth();
        }

        if (topDecoration.getPaddingStart()>0) {
            leftSpan += topDecoration.getPaddingStart();
        }

        float rightSpan;
        if (topDecoration.getPaddingEnd() <= 0) {
            rightSpan = topDecoration.getWidth();
        } else {
            rightSpan = -topDecoration.getPaddingEnd();
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        float left = view.getLeft() - params.leftMargin + leftSpan;
        float right = view.getRight() + params.rightMargin + rightSpan;
        float bottom = view.getTop() - params.topMargin;
        float top = bottom - topDecoration.getWidth();
        paint.setColor(topDecoration.getColor());
        canvas.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制右边分割线
     */
    private void drawRight(View child, Canvas c, Decoration rightLine) {
        if (rightLine.isHide()) {
            return;
        }

        float topSpan;
        if (rightLine.getPaddingStart() <= 0) {
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -rightLine.getWidth();
        } else {
            topSpan = rightLine.getPaddingStart();
        }

        float bottomSpan;
        if (rightLine.getPaddingEnd() <= 0) {
            bottomSpan = rightLine.getWidth();
        } else {
            bottomSpan = -rightLine.getPaddingEnd();
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
        if (bottomLine.getPaddingStart() <= 0) {
            // 上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -bottomLine.getWidth();
        } else {
            leftSpan = bottomLine.getPaddingStart();
        }

        float rightSpan;
        if (bottomLine.getPaddingEnd() <= 0) {
            rightSpan = bottomLine.getWidth();
        } else {
            rightSpan = -bottomLine.getPaddingEnd();
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
