package com.teststoreapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HP on 1/24/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<CategoryItem> list;

    public CategoryAdapter(Context context,List<CategoryItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpt_category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        CategoryItem data = list.get(position);
        holder.first_text.setText(data.getCategory_name());
        holder.second_text.setText(data.getExtra_detail());

        Picasso.with(context).load(data.getImage_url()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        SquareImageView image;
        TextView first_text, second_text;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            first_text = itemView.findViewById(R.id.first_text);
            second_text = itemView.findViewById(R.id.second_text);
            image = itemView.findViewById(R.id.image);
        }
    }

}
