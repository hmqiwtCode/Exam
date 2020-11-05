package com.quy.testexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView total;
    private TextView total_money;
    private Double totalTien = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_acivity);
        recyclerView = findViewById(R.id.rcview);
        total = findViewById(R.id.total);
        total_money = findViewById(R.id.total_money);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        AdapterItemCart adapterItemCart = new AdapterItemCart(this,MainActivity.cartItem);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterItemCart);

        for (CartItem cart : MainActivity.cartItem){
            totalTien += cart.getPrices() * cart.getSoluong();
        }

        DecimalFormat df = new DecimalFormat("#.###");

        total.setText("$" + df.format(totalTien));
        total_money.setText("$" +  df.format(totalTien));

    }
}