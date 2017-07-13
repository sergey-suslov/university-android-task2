package com.noveogroup.university_android_task2.PersonRecyclerView;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


public class SimpleItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private RecyclerViewAdapter mAdapter;

    public SimpleItemTouchHelper(RecyclerViewAdapter mAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.END);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        mAdapter.mDataSet.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        viewHolder.itemView.setAlpha(1 - dX / c.getWidth());
        viewHolder.itemView.setTranslationX(dX - dX * 0.35f);
    }
}
