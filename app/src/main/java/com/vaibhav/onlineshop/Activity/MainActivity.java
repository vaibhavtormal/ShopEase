package com.vaibhav.onlineshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.vaibhav.onlineshop.Adapter.PopularAdapter;
import com.vaibhav.onlineshop.R;
import com.vaibhav.onlineshop.databinding.ActivityMainBinding;
import com.vaibhav.onlineshop.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        stausBarColor();
        initRecylarView();
        bottomNavigation();

    }

    private void bottomNavigation() {
        binding.cartbtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void stausBarColor(){
        Window window= MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple_Dark));
    }

    private void initRecylarView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-shirt Black","item_1",15,4,500,"Introducing the timeless elegance of our Black Color T-shirt – a wardrobe staple that transcends trends and seasons. Crafted with meticulous attention to detail, our T-shirt embodies versatility and sophistication."));
        items.add(new PopularDomain("Smart Watch","item_2",10,4.5,1500,"Discover the future at your fingertips with our latest Smartwatch – a seamless blend of cutting-edge technology and sophisticated design. Engineered to enhance every aspect of your life, our Smartwatch is the ultimate companion for the modern achiever."));
        items.add(new PopularDomain("Phone","item_3",23,3.5,20000,"Introducing the latest addition to our tech arsenal: the Stubbron Smartphone. Seamlessly blending cutting-edge innovation with sleek design, this smartphone is set to revolutionize your mobile experience Get ready to immerse yourself in a world of boundless connectivity and unmatched performance. The 96k Smartphone boasts a stunning 6.67 inch display, delivering crystal-clear visuals and vibrant colors that breathe life into your content."));
        items.add(new PopularDomain("teady","teady",85,4,800,"Meet our cuddly companion, the Stubbron96k Teddy Bear. Crafted with love and care, this timeless classic brings warmth and comfort to hearts of all ages Soft to the touch and oh-so-huggable, our Teddy Bear is the perfect snuggle buddy for lazy afternoons and cozy nights in. With its plush fur and adorable features, it's sure to become an instant favorite in your home"));
        items.add(new PopularDomain("Shoes","shoes",96,4.5,1999,"Step into style and comfort with our latest collection of Stubbron Shoes. Crafted with precision and passion, these shoes are the epitome of fashion-forward footwear Embrace every stride with confidence as you slip into the plush comfort of our [Brand/Model] Shoes. Engineered with state-of-the-art cushioning technology, they provide unparalleled support and stability, ensuring all-day comfort no matter where life takes you."));
        items.add(new PopularDomain("PocoX6","pocox6",6,3.5,21999,"The Poco X6 Pro is a smartphone with a triple camera setup, including a main camera with an Omnivision OV64B sensor that offers a 64.0-megapixel resolution, a wide-angle lens with an 8.0-megapixel resolution, a macro lens with a 2.0-megapixel resolution, and a selfie camera with an Omnivision OV16A1Q sensor that offers a resolution of 16.0 megapixels.1 The device is equipped with sensors such as side-mounted fingerprint, accelerometer, gyro, proximity, and compass. The Poco X6 Pro was launched in India on January 11, 2024, and is available in various colors including Black, White, and Mint. The device weighs 198 grams and has a dimensions of 160.5 x 74.3 x 8.1 mm"));


        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}