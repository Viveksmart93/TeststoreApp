package com.teststoreapp;

import android.content.Intent;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gjz on 16/01/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static final int VIEW_TYPE_SMALL = 1;
    private static final int VIEW_TYPE_BIG = 2;

    private List<String> mItems;
    private GridLayoutManager mLayoutManager;

    ViewGroup recyclerView;

    public ItemAdapter(List<String> items, GridLayoutManager layoutManager) {
        mItems = items;
        mLayoutManager = layoutManager;
    }

    @Override
    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE) {
            return VIEW_TYPE_BIG;
        } else {
            return VIEW_TYPE_SMALL;
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        recyclerView = parent;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(mItems.get(position));
        holder.expand_view.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean shouldExpand = holder.expand_view.getVisibility() == View.GONE;

                ChangeBounds transition = new ChangeBounds();
                transition.setDuration(125);

                if (shouldExpand) {
                    holder.expand_view.setVisibility(View.VISIBLE);
                    /*holder.expand_view.setImageResource(R.drawable.collapse_symbol);*/
                } else {
                    holder.expand_view.setVisibility(View.GONE);
                    /*holder.expand_view.setImageResource(R.drawable.expand_symbol);*/
                }

                TransitionManager.beginDelayedTransition(recyclerView, transition);
                holder.itemView.setActivated(shouldExpand);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout expand_view;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            expand_view = itemView.findViewById(R.id.expand_view);
        }
    }
}
