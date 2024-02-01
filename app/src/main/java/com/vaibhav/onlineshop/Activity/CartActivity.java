package com.vaibhav.onlineshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.vaibhav.onlineshop.Adapter.CartAdapter;
import com.vaibhav.onlineshop.R;
import com.vaibhav.onlineshop.databinding.ActivityCartBinding;
import com.vaibhav.onlineshop.helper.ChangeNumberItemListener;
import com.vaibhav.onlineshop.helper.ManagmentCart;

public class CartActivity extends AppCompatActivity {
    private ManagmentCart managmentCart;
    ActivityCartBinding binding;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart=new ManagmentCart(this);
        setVariables();
        initlist();
        calculatorCart();
        stausBarColor();
    }
    private void stausBarColor(){
        Window window= CartActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(CartActivity.this,R.color.purple_Dark));
    }

    private void initlist() {
        if (managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrool.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrool.setVisibility(View.VISIBLE);
        }
        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), () -> calculatorCart()));

    }
    private void calculatorCart(){
        double percentTax=0.02;
        double delivery=10;
        tax=Math.round(managmentCart.getTotalFee()*percentTax*100)/100;

        double total = Math.round(managmentCart.getTotalFee()+tax+delivery)*100/100;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100)/100;

        binding.totalFeetxt.setText("$"+itemTotal);
        binding.taxtxt.setText("$"+tax);
        binding.Delevery.setText("$"+delivery);
        binding.totaltxt.setText("$"+total);

    }
    private void setVariables() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}