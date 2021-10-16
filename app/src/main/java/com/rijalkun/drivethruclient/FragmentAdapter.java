package com.rijalkun.drivethruclient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
//                ConnectMysql connectMysql = new ConnectMysql();
                return new FragmentMakanan();
            case 1:
                return new MinumanFragment();
        }
        return new FragmentMakanan();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
