package com.example.lee.bicycleplanning.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lee.bicycleplanning.R;
import com.example.lee.bicycleplanning.records.PathRecord;

import java.util.ArrayList;

/**
 * Created by lee on 2015-03-22.
 */
public class PathRecordAdapter extends BaseAdapter {
    private ArrayList<PathRecord> mList;

    public PathRecordAdapter(ArrayList<PathRecord> itemList) {
        mList = itemList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if ( convertView == null ) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.path_record_item, parent, false);

            PathRecord item = mList.get(position);

            TextView tvDistance = (TextView) convertView.findViewById(R.id.tv_path_distance);
            tvDistance.setText("거리: " + item.getDistance() + "km");

            TextView tvElapsedTime = (TextView) convertView.findViewById(R.id.tv_path_elapsed_time);
            tvElapsedTime.setText("소요시간: " + item.getElapsedTimeInMinute() + "분");

            TextView tvRatings = (TextView) convertView.findViewById(R.id.tv_path_ratings);
            tvRatings.setText("평점: " + item.getRating() + "점");

            // 리스트 아이템을 터치 했을 때 이벤트 발생
            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context, "item" + pos + " long touched", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        return convertView;
    }
}
