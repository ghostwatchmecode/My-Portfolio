package com.example.courseworkapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class IntroSliderMain extends AppCompatActivity {

    private ViewPager viewPager;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro_slider_main);

        // Initialize ViewPager and Next Button
        viewPager = findViewById(R.id.viewpager);
        nextBtn = findViewById(R.id.BtnNext);

        // Configure ViewPager with the adapter
        IntroPagerAdapter introPagerAdapter = new IntroPagerAdapter();
        viewPager.setAdapter(introPagerAdapter);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if this is the last slide
                if (viewPager.getCurrentItem() == introPagerAdapter.getCount() - 1) {
                    // If it is the last slide, start the MainActivity
                    startActivity(new Intent(IntroSliderMain.this, MainActivity.class));
                    finish(); // Close the intro slider activity
                } else {
                    // Move to the next slide
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
    }

    // Adapter for handling the slides in the ViewPager
    private class IntroPagerAdapter extends PagerAdapter {
        private int[] layouts = {R.layout.fragment_intro_slider1, R.layout.fragment_intro_slider2,
                R.layout.fragment_intro_slider3};
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(IntroSliderMain.this);
            View layout = inflater.inflate(layouts[position], container, false);
            container.addView(layout);
            return layout;
        }

        @Override
        public int getCount() {
            // Return the total number of slides
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            // Determine whether the view is associated with the object (slide).
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            // Remove the view associated with the object (slide)
            container.removeView((View) object);
        }
    }
}