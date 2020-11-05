package com.quy.testexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailShirt extends AppCompatActivity {

    private ImageView imageView;
    private TextView header;
    private TextView prices;
    private Button button;

    private View view0;
    private View view1;
    private View view2;
    private View view3;

    private Shirt shirt;
    private String size = "X";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shirt);

        imageView = findViewById(R.id.imageView2);
        header = findViewById(R.id.textView4);
        prices = findViewById(R.id.textView5);
        button = findViewById(R.id.button);

        shirt = (Shirt) getIntent().getSerializableExtra("shirt");
        imageView.setImageResource(shirt.getImage());
        header.setText(shirt.getHeader());
        prices.setText("$" + shirt.getPrices() + "");

        view0 = findViewById(R.id.view);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CartItem cartItem = new CartItem(shirt.getId(),shirt.getImage(),shirt.getHeader(),shirt.getPrices(),size,1);
                if (MainActivity.cartItem.contains(cartItem)){
                    int position = MainActivity.cartItem.indexOf(cartItem);
                    MainActivity.cartItem.get(position).setSoluong(MainActivity.cartItem.get(position).getSoluong()+1);
                }else{
                    MainActivity.cartItem.add(cartItem);
                }
                Intent intent = new Intent(DetailShirt.this,CartActivity.class);
                startActivity(intent);
            }
        });


        view0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view0.setBackgroundResource(R.drawable.ic_baseline_check_24);
                view1.setBackgroundResource(0);
                view2.setBackgroundResource(0);
                view3.setBackgroundResource(0);
                size = "X";
            }
        });


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view0.setBackgroundResource(0);
                view1.setBackgroundResource(R.drawable.ic_baseline_check_24);
                view2.setBackgroundResource(0);
                view3.setBackgroundResource(0);
                size = "L";
            }
        });


        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view0.setBackgroundResource(0);
                view1.setBackgroundResource(0);
                view2.setBackgroundResource(R.drawable.ic_baseline_check_24);
                view3.setBackgroundResource(0);
                size = "XL";
            }
        });


        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view0.setBackgroundResource(0);
                view1.setBackgroundResource(0);
                view2.setBackgroundResource(0);
                view3.setBackgroundResource(R.drawable.ic_baseline_check_24);
                size = "S";
            }
        });
    }
}