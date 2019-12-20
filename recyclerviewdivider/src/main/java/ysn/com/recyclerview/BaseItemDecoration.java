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
 * @Description RecyclerView分割线, 顺时针绘制 (默认四角留白, 如有需要自行通过padding填充)
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
            int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            RvItemDecoration rvItemDecoration = getRvItemDecoration(itemPosition);
            if (rvItemDecoration == null) {
                return;
            }
            // 绘制左边分割线
            drawLeft(view, canvas, rvItemDecoration.getLeftDecoration());

            // 绘制头部分割线
            drawTop(view, canvas, rvItemDecoration.getTopDecoration());

            // 绘制右边分割线
            drawRight(view, canvas, rvItemDecoration.getRightDecoration());

            // 绘制底部分割线
            drawBottom(view, canvas, rvItemDecoration.getBottomDecoration());
        }
    }

    /**
     * 绘制左边分割线
     */
    private void drawLeft(View view, Canvas canvas, Decoration decoration) {
        if (decoration.isHide()) {
            return;
        }

        float topSpan = decoration.getPaddingStart();
        float bottomSpan = -decoration.getPaddingEnd();

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        float top = view.getTop() - params.topMargin + topSpan;
        float bottom = view.getBottom() + params.bottomMargin + bottomSpan;
        float right = view.getLeft() - params.leftMargin;
        float left = right - decoration.getWidth();
        paint.setColor(decoration.getColor());
        canvas.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制头部分割线
     */
    private void drawTop(View view, Canvas canvas, Decoration topDecoration) {
        if (topDecoration.isHide()) {
            return;
        }

        float leftSpan = topDecoration.getPaddingStart();
        float rightSpan = -topDecoration.getPaddingEnd();

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
    private void drawRight(View view, Canvas canvas, Decoration decoration) {
        if (decoration.isHide()) {
            return;
        }

        float topSpan = decoration.getPaddingStart();
        float bottomSpan = -decoration.getPaddingEnd();

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        float top = view.getTop() - params.topMargin + topSpan;
        float bottom = view.getBottom() + params.bottomMargin + bottomSpan;
        float left = view.getRight() + params.rightMargin;
        float right = left + decoration.getWidth();
        paint.setColor(decoration.getColor());
        canvas.drawRect(left, top, right, bottom, paint);
    }

    /**
     * 绘制底部分割线
     */
    private void drawBottom(View view, Canvas canvas, Decoration bottomDecoration) {
        if (bottomDecoration.isHide()) {
            return;
        }

        float leftSpan = bottomDecoration.getPaddingStart();
        float rightSpan = -bottomDecoration.getPaddingEnd();

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        float left = view.getLeft() - params.leftMargin + leftSpan;
        float right = view.getRight() + params.rightMargin + rightSpan;
        float top = view.getBottom() + params.bottomMargin;
        float bottom = top + bottomDecoration.getWidth();
        paint.setColor(bottomDecoration.getColor());
        canvas.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        RvItemDecoration rvItemDecoration = getRvItemDecoration(itemPosition);
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
