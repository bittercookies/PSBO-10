package com.example.psbo_10.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.psbo_10.Interface.ItemClickListener;
import com.example.psbo_10.Model.Book;
import com.example.psbo_10.R;
import com.example.psbo_10.ViewHolder.BookViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class BookByCategory extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference table_book;

    RecyclerView recycler_book;
    RecyclerView.LayoutManager layoutManager;

    String catID = "";

    FirebaseRecyclerAdapter<Book, BookViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_by_category);

        database = FirebaseDatabase.getInstance();
        table_book = database.getReference("Book");

        recycler_book = (RecyclerView) findViewById(R.id.recycler_book);
        recycler_book.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_book.setLayoutManager(layoutManager);

        if(getIntent() != null)
            catID = getIntent().getStringExtra("cat_id");
        if(!catID.isEmpty() && catID != null)
        {
            loadListBook(catID);
        }


    }

    private void loadListBook(String catID) {
        adapter = new FirebaseRecyclerAdapter<Book, BookViewHolder>(Book.class,
                R.layout.book_item,
                BookViewHolder.class,
                table_book.orderByChild("cat_id").equalTo(catID)
        ) {
            @Override
            protected void populateViewHolder(BookViewHolder viewHolder, Book model, int position) {
                viewHolder.book_name.setText(model.getTitle());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.book_image);

                final Book local = model;
                viewHolder.setItemClickListener((new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent bookDetail = new Intent(BookByCategory.this, BookDetail.class);
                        bookDetail.putExtra("BookID", adapter.getRef(position).getKey());
                        startActivity(bookDetail);

                    }
                }));
            }
        };

        Log.d("TAG", ""+adapter.getItemCount());
        recycler_book.setAdapter(adapter);
    }
}
