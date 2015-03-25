package com.example.lee.bicycleplanning.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.example.lee.bicycleplanning.R;

public class SetElapsedTimeFragment extends Fragment {
    public SetElapsedTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_set_elapsed_time, container, false);

        NumberPicker hourPicker = (NumberPicker) view.findViewById(R.id.numberpicker_hour);
        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(12);

        NumberPicker minutePicker = (NumberPicker) view.findViewById(R.id.numberpicker_minute);
        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(59);

        Button btnConfirmTime = (Button) view.findViewById(R.id.btn_confirm_time);
        btnConfirmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseContainerFragment) getParentFragment()).replaceFragment(new ChooseRecommendedPathFragment(), true);
            }
        });

        return view;
    }
}
