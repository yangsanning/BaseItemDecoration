package ysn.com.demo.divider;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;

import ysn.com.demo.R;
import ysn.com.recyclerviewdivider.Divider;
import ysn.com.recyclerviewdivider.DividerBuilder;
import ysn.com.recyclerviewdivider.RecyclerViewDivider;

/**
 * @Author yangsanning
 * @ClassName LinearLayoutDivider
 * @Description 一句话概括作用
 * @Date 2019/8/5
 * @History 2019/8/5 author: description:
 */
public class LinearLayoutDivider extends RecyclerViewDivider {

    private Context context;
    private float width;

    public LinearLayoutDivider(Context context) {
        super(context);
        this.context = context;
        width = context.getResources().getDimension(R.dimen.dp5);
    }

    @Nullable
    @Override
    public Divider getDivider(int itemPosition) {
        Divider divider = new DividerBuilder()
                .setRightLine(true, getColor(R.color.divider_right), width, 0, 0)
                .setTopLine(true, getColor(R.color.divider_top), width, 0, 0)
                .setLeftLine(true, getColor(R.color.divider_left), width, 0, 0)
            .setBottomLine(true, getColor(R.color.divider_bottom), width, 0, 0)
                .create();

        return divider;
    }

    private int getColor(@ColorRes int colorRes) {
        return context.getResources().getColor(colorRes);
    }
}
