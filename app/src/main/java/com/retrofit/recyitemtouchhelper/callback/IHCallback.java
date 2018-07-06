package com.retrofit.recyitemtouchhelper.callback;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.retrofit.recyitemtouchhelper.adapter.MoveAdapter;

/**
 * @author :created by ${yangpf}
 * 时间:2018/7/6 15
 * 邮箱：xxx@.qq.com
 */
public class IHCallback extends ItemTouchHelper.Callback {

    private MoveAdapter moveAdapter;

    public IHCallback(MoveAdapter moveAdapter) {
        this.moveAdapter = moveAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下的拖动
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //只允许从右向左侧滑
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        moveAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        moveAdapter.onItemDissmiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            //滑动时改变Item的透明度
            final float alpha = 1 - Math.abs(dX) / (float)viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
        }
    }
}
