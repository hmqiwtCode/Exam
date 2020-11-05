package com.quy.testexam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterShirt extends RecyclerView.Adapter<AdapterShirt.ItemShirt> {

    private ArrayList<Shirt> arrShirt;
    private Context context;

    public AdapterShirt(ArrayList<Shirt> arrShirt,Context context){
        this.arrShirt = arrShirt;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemShirt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemShirt(LayoutInflater.from(context).inflate(R.layout.custom_item_shirt,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemShirt holder, int position) {
        final Shirt shirt = arrShirt.get(position);
        holder.img.setImageResource(shirt.getImage());
        holder.header.setText(shirt.getHeader());
        holder.prices.setText(shirt.getPrices() + "");

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailShirt.class);
                intent.putExtra("shirt", shirt);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrShirt.size();
    }

    class ItemShirt extends RecyclerView.ViewHolder{
        ConstraintLayout layout;
        ImageView img;
        TextView header;
        TextView prices;

        public ItemShirt(@NonNull View view) {
            super(view);
            layout = view.findViewById(R.id.layout);
            img = view.findViewById(R.id.imageView);
            header = view.findViewById(R.id.textView);
            prices = view.findViewById(R.id.textView2);
        }
    }
}
