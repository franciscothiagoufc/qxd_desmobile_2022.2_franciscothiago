package com.example.trabalho1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter {
    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new inputs();
            case 1:
                return new menus();
            case 2:
                return new click();
            default:
                return new inputs();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}
