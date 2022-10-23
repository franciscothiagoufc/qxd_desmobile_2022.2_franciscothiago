package com.example.trabalho1;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link click#newInstance} factory method to
 * create an instance of this fragment.
 */
public class click extends Fragment {
    public click() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_click, container, false);
        Button long_click = view.findViewById(R.id.click_long);
        final MediaPlayer mp = MediaPlayer.create(this.getContext(), R.raw.bell);
        long_click.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mp.start();
                return false;
            }
        });
        return view;
    }
}