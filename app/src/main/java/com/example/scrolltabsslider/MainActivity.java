package com.example.scrolltabsslider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pagerId);

        FragmentManager fragmentManager = getSupportFragmentManager();

        CustomAdapter adapter = new CustomAdapter(fragmentManager);

        viewPager.setAdapter(adapter);
    }
}

class CustomAdapter extends FragmentStatePagerAdapter{

    public CustomAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        if (position==0){
            fragment = new FragmentOne();
        }
        else if (position==1){
            fragment = new FragmentTwo();
        }
        else if (position==2){
            fragment = new FragmentThree();
        }
        return fragment;
    }

    @Override
    public int getCount() {

        // Page count number of page
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position==0){
            return "Tab One";
        }
        else if (position==1){
            return "Tab Two";
        }
        else if (position==2){
            return "Tab Three";
        }

        return null;
    }
}