package com.quy.testexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvc;
    private ArrayList<Shirt> shirts;

    public static ArrayList<CartItem> cartItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvc = findViewById(R.id.rvc);
        shirts = new ArrayList<>();
        shirts.add(new Shirt(1,R.drawable.one,"Google",10.0));
        shirts.add(new Shirt(2,R.drawable.two,"Google",15.0));
        shirts.add(new Shirt(3,R.drawable.three,"Google",20.0));
        shirts.add(new Shirt(4,R.drawable.four,"Google",25.0));
        shirts.add(new Shirt(5,R.drawable.five,"Google",30.0));
        shirts.add(new Shirt(6,R.drawable.siz,"Google",35.0));
        cartItem = new ArrayList<>();
        AdapterShirt adapterShirt = new AdapterShirt(shirts,this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        rvc.setLayoutManager(gridLayoutManager);
        rvc.setAdapter(adapterShirt);
    }
}