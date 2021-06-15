package com.sunidhi.texteditor;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.sunidhi.texteditor.databinding.ActivityMainBinding;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AtomicBoolean isColorBold = new AtomicBoolean(true);
        AtomicBoolean isColorUnderline = new AtomicBoolean(true);
        AtomicBoolean isColorItalic = new AtomicBoolean(true);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        binding.text.setFontSize(22);
        binding.text.setEditorFontColor(Color.BLACK);
        binding.text.setBackgroundColor(Color.parseColor("#EAEAEA"));
        binding.text.setPlaceholder("Enter Job Description here...");
        binding.text.setPadding(10,10,10,10);

        binding.boldButton.setOnClickListener(v ->{
                binding.text.setBold();
            if(isColorBold.get())
            {
                binding.boldButton.setBackgroundResource(R.drawable.pressed);
                isColorBold.set(false);
            }
            else
            {
                binding.boldButton.setBackgroundResource(R.drawable.normal);
                isColorBold.set(true);
            }

          });

        binding.underlineButton.setOnClickListener(v ->{
                binding.text.setUnderline();
        if(isColorUnderline.get())
        {
            binding.underlineButton.setBackgroundResource(R.drawable.pressed);
            isColorUnderline.set(false);
        }
        else {
            binding.underlineButton.setBackgroundResource(R.drawable.normal);
            isColorUnderline.set(true);
        }
        });

        binding.italicButton.setOnClickListener(v -> {
            binding.text.setItalic();
            if (isColorItalic.get()) {
                binding.italicButton.setBackgroundResource(R.drawable.pressed);
                isColorItalic.set(false);
            } else {
                binding.italicButton.setBackgroundResource(R.drawable.normal);
                isColorItalic.set(true);
            }
        });


    }

}