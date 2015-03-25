package com.example.lee.bicycleplanning.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lee.bicycleplanning.MainActivity;
import com.example.lee.bicycleplanning.R;

public class FindPathFragment extends Fragment {

    public FindPathFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_find_path, container, false);

        Button buttonCurrentLocation = (Button) view.findViewById(R.id.btn_current_location);
        buttonCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseContainerFragment) getParentFragment()).replaceFragment(new SetElapsedTimeFragment(), true);
            }
        });

        return view;
    }
}
