package com.example.lee.bicycleplanning.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lee.bicycleplanning.R;
import com.example.lee.bicycleplanning.adapters.PathRecordAdapter;
import com.example.lee.bicycleplanning.records.PathRecord;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ChooseRecommendedPathFragment extends Fragment {

    private ArrayList<PathRecord> mRecommendedPathList;
    private SupportMapFragment mMapFragment;
    private GoogleMap mMap;

    public ChooseRecommendedPathFragment() {
        // Required empty public constructor
        mRecommendedPathList = new ArrayList<PathRecord>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        mMapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map_container);
        if (mMapFragment == null) {
            mMapFragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map_container, mMapFragment).commit();
        }
        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                LatLng asri = new LatLng(37.4544695, 126.950351);
                mMap.addMarker(new MarkerOptions()
                        .position(asri)
                        .title("서울대 133동"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(asri, 17));
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_choose_recommended_path, container, false);

        mRecommendedPathList.add( new PathRecord(15.3, 60, 0) );
        mRecommendedPathList.add( new PathRecord(1, 5, 4) );
        mRecommendedPathList.add( new PathRecord(30, 120, 3) );
        mRecommendedPathList.add( new PathRecord(60, 240, 2) );

        ListView listView = (ListView) view.findViewById(R.id.lv_recommended_paths);
        listView.setAdapter( new PathRecordAdapter(mRecommendedPathList) );

        return view;
    }
}