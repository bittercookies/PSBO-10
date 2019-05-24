package com.example.psbo_10.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.psbo_10.Model.Book;
import com.example.psbo_10.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class BookDetail extends AppCompatActivity {

    TextView book_title, book_price, book_synopsis;
    ImageView book_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;

    String bookID = "";

    FirebaseDatabase database;
    DatabaseReference book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        database = FirebaseDatabase.getInstance();
        book = database.getReference("Book");

        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);

        book_synopsis = (TextView) findViewById(R.id.book_synopsis);
        book_title = (TextView) findViewById(R.id.book_name);
        book_price = (TextView) findViewById(R.id.book_price);
        book_image = (ImageView) findViewById(R.id.img_book);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if(getIntent() != null)
            bookID = getIntent().getStringExtra("BookID");

        if(!bookID.isEmpty()){
            getDetailBook(bookID);
        }


    }

    private void getDetailBook(String bookID) {
        book.child(bookID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Book book = dataSnapshot.getValue(Book.class);

                Picasso.with(getBaseContext()).load(book.getImage())
                        .into(book_image);

                collapsingToolbarLayout.setTitle(book.getTitle());
                book_price.setText(book.getPrice());
                book_title.setText(book.getTitle());
                book_synopsis.setText(book.getSynopsis());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
