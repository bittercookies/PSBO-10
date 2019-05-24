package com.example.psbo_10.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.psbo_10.Interface.ItemClickListener;
import com.example.psbo_10.R;

public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView book_name;
    public ImageView book_image;

    private ItemClickListener itemClickListener;

    public BookViewHolder(View itemView) {
        super(itemView);

        book_name = (TextView) itemView.findViewById(R.id.book_name);
        book_image = (ImageView) itemView.findViewById(R.id.book_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view){
        this.itemClickListener.onClick(view, getAdapterPosition(), false);
    }


}
