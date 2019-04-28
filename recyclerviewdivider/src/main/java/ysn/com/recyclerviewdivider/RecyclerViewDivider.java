package ysn.com.recyclerviewdivider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author yangsanning
 * @ClassName RecyclerViewDivider
 * @Description 一句话概括作用
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

            int itemPosition = ((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition();

            Divider divider = getDivider(itemPosition);

            if (divider.getLeftLine().isShow()) {
                int width = ConvertUtils.dp2px(context, divider.getLeftLine().getWidth());
                int startSpan = ConvertUtils.dp2px(context, divider.getLeftLine().getStartSpan());
                int endSpan = ConvertUtils.dp2px(context, divider.getLeftLine().getEndSpan());
                drawChildLeftVertical(child, c, divider.getLeftLine().getColor(), width, startSpan, endSpan);
            }
            
            if (divider.getTopLine().isShow()) {
                int width = ConvertUtils.dp2px(context, divider.getTopLine().getWidth());
                int startSpan = ConvertUtils.dp2px(context, divider.getTopLine().getStartSpan());
                int endSpan = ConvertUtils.dp2px(context, divider.getTopLine().getEndSpan());
                drawChildTopHorizontal(child, c, divider.topLine.getColor(), width, startSpan, endSpan);
            }
            
            if (divider.getRightLine().isShow()) {
                int width = ConvertUtils.dp2px(context, divider.getRightLine().getWidth());
                int startSpan = ConvertUtils.dp2px(context, divider.getRightLine().getStartSpan());
                int endSpan = ConvertUtils.dp2px(context, divider.getRightLine().getEndSpan());
                drawChildRightVertical(child, c, divider.getRightLine().getColor(), width, startSpan, endSpan);
            }
            
            if (divider.getBottomLine().isShow()) {
                int width = ConvertUtils.dp2px(context, divider.getBottomLine().getWidth());
                int startSpan = ConvertUtils.dp2px(context, divider.getBottomLine().getStartSpan());
                int endSpan = ConvertUtils.dp2px(context, divider.getBottomLine().getEndSpan());
                drawChildBottomHorizontal(child, c, divider.getBottomLine().getColor(), width, startSpan, endSpan);
            }
        }
    }

    private void drawChildLeftVertical(View child, Canvas c, @ColorInt int color, int width, int startSpan, int endSpan) {
        int topSpan;
        int bottomSpan;

        if (startSpan <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -width;
        } else {
            topSpan = startSpan;
        }

        if (endSpan <= 0) {
            bottomSpan = width;
        } else {
            bottomSpan = -endSpan;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        int top = child.getTop() - params.topMargin + topSpan;
        int bottom = child.getBottom() + params.bottomMargin + bottomSpan;
        int right = child.getLeft() - params.leftMargin;
        int left = right - width;
        paint.setColor(color);
        c.drawRect(left, top, right, bottom, paint);
    }

    private void drawChildTopHorizontal(View child, Canvas c, @ColorInt int color, int width, int startSpan, int endSpan) {
        int leftSpan;
        int rightSpan;

        if (startSpan <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -width;
        } else {
            leftSpan = startSpan;
        }
        if (endSpan <= 0) {
            rightSpan = width;
        } else {
            rightSpan = -endSpan;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin + leftSpan;
        int right = child.getRight() + params.rightMargin + rightSpan;
        int bottom = child.getTop() - params.topMargin;
        int top = bottom - width;
        paint.setColor(color);

        c.drawRect(left, top, right, bottom, paint);

    }

    private void drawChildBottomHorizontal(View child, Canvas c, @ColorInt int color, int width, int startSpan, int endSpan) {
        int leftSpan;
        int rightSpan;

        if (startSpan <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            leftSpan = -width;
        } else {
            leftSpan = startSpan;
        }

        if (endSpan <= 0) {
            rightSpan = width;
        } else {
            rightSpan = -endSpan;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin + leftSpan;
        int right = child.getRight() + params.rightMargin + rightSpan;
        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + width;
        paint.setColor(color);

        c.drawRect(left, top, right, bottom, paint);

    }
    
    private void drawChildRightVertical(View child, Canvas c, @ColorInt int color, int width, int startSpan, int endSpan) {
        int topSpan;
        int bottomSpan;

        if (startSpan <= 0) {
            //padding<0当作==0处理
            //上下左右默认分割线的两头都出头一个分割线的宽度，避免十字交叉的时候，交叉点是空白
            topSpan = -width;
        } else {
            topSpan = startSpan;
        }
        if (endSpan <= 0) {
            bottomSpan = width;
        } else {
            bottomSpan = -endSpan;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        int top = child.getTop() - params.topMargin + topSpan;
        int bottom = child.getBottom() + params.bottomMargin + bottomSpan;
        int left = child.getRight() + params.rightMargin;
        int right = left + width;
        paint.setColor(color);
        c.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        Divider divider = getDivider(itemPosition);

        if (divider == null) {
            divider = new DividerBuilder().create();
        }

        int left = divider.getLeftLine().isShow() ? ConvertUtils.dp2px(context, divider.getLeftLine().getWidth()) : 0;
        int top = divider.getTopLine().isShow() ? ConvertUtils.dp2px(context, divider.getTopLine().getWidth()) : 0;
        int right = divider.getRightLine().isShow() ? ConvertUtils.dp2px(context, divider.getRightLine().getWidth()) : 0;
        int bottom = divider.getBottomLine().isShow() ? ConvertUtils.dp2px(context, divider.getBottomLine().getWidth()) : 0;

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
