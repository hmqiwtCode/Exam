package com.quy.testexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItemCart extends RecyclerView.Adapter<AdapterItemCart.ItemCart> {

    private Context context;
    private ArrayList<CartItem> cartItems;


    public AdapterItemCart(Context context,ArrayList<CartItem> cartItems){
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public ItemCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemCart(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCart holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.imageView.setImageResource(cartItem.getImage());
        holder.header.setText(cartItem.getHeader());
        holder.size.setText(cartItem.getSize());
        holder.prices.setText("$" + cartItem.getPrices() + "");
        holder.sl.setText(cartItem.getSoluong()+"");
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class ItemCart extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView header;
        TextView size;
        TextView prices;
        TextView sl;
        ImageButton remove;
        ImageButton add;
        public ItemCart(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imgItem);
            header = view.findViewById(R.id.headerItem);
            size = view.findViewById(R.id.sizeItem);
            prices = view.findViewById(R.id.priceItem);
            sl = view.findViewById(R.id.slItem);
            remove = view.findViewById(R.id.btnRemove);
            add = view.findViewById(R.id.btnAdd);
        }
    }
}
