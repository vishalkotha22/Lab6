package com.example.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment{
    ViewPager2 mViewPager2;
    int position;
    Button button;
    public static Fragment newInstance(ViewPager2 mViewPager2, int pos){
        MainFragment fragment = new MainFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.position = pos;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
//        new TabLayoutMediator(tabLayout, mViewPager2,
//                (tab, position) -> tab.setText("I am " + (position + 1))
//        ).attach();
//        button = view.findViewById(R.id.press_me);
//        button.setText("Press " + position);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                Toast.makeText(getContext(), "toasty"+position, Toast.LENGTH_SHORT).show();
//            }
//        });

        //add to tablayout
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, mViewPager2,
                (tab, position) -> tab.setText("I am  " + (position + 1))
        ).attach();
        //assign response to button onclick
        button = view.findViewById(R.id.press_me);
        //set text to the current fragment's position number
        button.setText("Press Me "+position);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"toasty"+position, Toast.LENGTH_LONG).show();
            }
        });
    }
}
