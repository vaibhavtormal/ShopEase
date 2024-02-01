package com.vaibhav.onlineshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.vaibhav.onlineshop.R;
import com.vaibhav.onlineshop.databinding.ActivityDetailsBinding;
import com.vaibhav.onlineshop.domain.PopularDomain;
import com.vaibhav.onlineshop.helper.ManagmentCart;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private PopularDomain object;
    private int numberorder=1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundle();
        managmentCart=new ManagmentCart(this);
        stausBarColor();
    }
    private void stausBarColor(){
        Window window= DetailsActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(DetailsActivity.this,R.color.white));
    }
    private void getBundle(){
        object= (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId)
                .into(binding.itemPic);

        binding.titletxt.setText(object.getTitle());
        binding.priceText.setText("$"+object.getPrice());
        binding.descriptiontxt.setText(object.getDescription());
        binding.reviewtxtd.setText(object.getReview()+"");
        binding.ratingtxt.setText(object.getScore()+"");

        binding.addtoCart.setOnClickListener(v -> {

                object.setNumberInChart(numberorder);
                managmentCart.insertFood(object);

        });
        binding.backbutn.setOnClickListener(v -> finish());
    }
}