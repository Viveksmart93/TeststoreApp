package com.teststoreapp;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 1/18/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    Context context;
    List<String> list;
    boolean isGrid = true;
    private static final int LIST_ITEM = 0;
    private static final int GRID_ITEM = 1;

    public ListAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isGrid){
            return GRID_ITEM;
        }else {
            return LIST_ITEM;
        }
    }

    public boolean toggleItemViewType () {
        isGrid = !isGrid;
        return isGrid;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public ListViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

}
