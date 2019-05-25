package com.example.psbo_10.Activity;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psbo_10.Database;
import com.example.psbo_10.Model.Order;
import com.example.psbo_10.Model.Request;
import com.example.psbo_10.Model.User;
import com.example.psbo_10.R;
import com.example.psbo_10.ViewHolder.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity {

    RecyclerView recycler_cart;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference requests;

    TextView txtTotalPrice;
    Button btnPlace;

    List<Order> cart = new ArrayList<>();

    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Requests");

        recycler_cart = (RecyclerView) findViewById(R.id.listCart);
        recycler_cart.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_cart.setLayoutManager(layoutManager);

        txtTotalPrice = (TextView)findViewById(R.id.total);
        btnPlace = (Button)findViewById(R.id.btnPlaceOrder);

        btnPlace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                showAlertDialog();
            }
        });

        loadListBook();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Cart.this);
        alertDialog.setTitle("One more step!");
        alertDialog.setMessage("Masukkan alamat Anda: ");

        final EditText edtAddress = new EditText(Cart.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        edtAddress.setLayoutParams(lp);
        alertDialog.setView(edtAddress);
        alertDialog.setIcon(R.drawable.ic_shopping_basket_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Request request = new Request(
                        User.getCurrentUser().getPhone(),
                        User.getCurrentUser().getName(),
                        edtAddress.getText().toString(),
                        txtTotalPrice.getText().toString(),
                        cart
                );

                // Submit data to Firebase.

                requests.child(String.valueOf(System.currentTimeMillis())).setValue(request);
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Cart.this, "Terima kasih, order Anda telah diterima.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.dismiss();
            }
        });

        alertDialog.show();
    }

    private void loadListBook() {
        cart = new Database(this).getCarts();
        adapter = new CartAdapter(cart, this);
        recycler_cart.setAdapter(adapter);

        int total = 0;
        for(Order order:cart)
            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getDuration()));
        Locale locale = new Locale("id", "id");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        txtTotalPrice.setText(fmt.format(total));
    }
}
