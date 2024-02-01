package com.vaibhav.onlineshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.vaibhav.onlineshop.Activity.DetailsActivity;
import com.vaibhav.onlineshop.databinding.ViewholderCartBinding;
import com.vaibhav.onlineshop.databinding.ViewholderPupListBinding;
import com.vaibhav.onlineshop.domain.PopularDomain;
import com.vaibhav.onlineshop.helper.ChangeNumberItemListener;
import com.vaibhav.onlineshop.helper.ManagmentCart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemListener changeNumberItemListener;

    ManagmentCart managmentCart;
    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemListener changeNumberItemListener) {
        this.items = items;

        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context= parent.getContext();
        managmentCart = new ManagmentCart(context);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        binding.titletxt.setText(items.get(position).getTitle());
        binding.FeeEachIten.setText("$"+items.get(position).getPrice());
        binding.totalEachItem.setText("$"+Math.round(items.get(position).getNumberInChart()*items.get(position).getPrice()));
        binding.numberItemTxt.setText(String.valueOf( items.get(position).getNumberInChart()));

        int drawableResourced=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(binding.pic);

        binding.plusCartBtn.setOnClickListener(v -> managmentCart.plusNumberItem(items, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListener.change();
        }));

        binding.minusCartBtn.setOnClickListener(v -> managmentCart.minusNumberItem(items, position, () -> {
            notifyDataSetChanged();
            changeNumberItemListener.change();
        }));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(ViewholderCartBinding binding){
            super(binding.getRoot());
        }

    }
}
