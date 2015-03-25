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
    private ArrayList<PathRecord> mList; //PathRecord의 ArrayList를 내부에 가진다.

    public PathRecordAdapter(ArrayList<PathRecord> itemList) {
        mList = itemList;
    } //Constructor of PathRecordAdapter

    @Override
    public int getCount() {
        return mList.size();
    } //들어있는 PathRecord의 숫자를 return해준다.

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    } //position번째의 item을 리턴한다. #Object는 뭐지?

    @Override
    public long getItemId(int position) {
        return position;
    } //?그냥 인풋을 리턴?

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        /*Context란?
         즉, 안드로이드 플랫폼상에서의 관점으로 샆펴보면, Context 는 다음과 같은두 가지 역할을 수행하기 때문에 꼭 필요한 존재입니다.
         자신이 어떤 어플리케이션을 나타내고 있는지 알려주는 ID 역할
            ActivityManagerService 에 접근할 수 있도록 하는 통로 역할
            정리하자면 이렇습니다.일반 OS 플랫폼에서 어플리케이션은 곧 Process 입니다.
         특정 어플리케이션이 OS 에게 내가 어떤 Process 인지만 알려주면 어플리케이션 관련된 정보를 얼마든지 획득 할 수 있습니다.
         이른바 자신의 존재 자체가 자신임을 증명해주는 '지문인식' 혹은 '홍채인식' 등의 '생체인식' 과 비슷한 개념이기 떄문에
          Context 와 같은 애매한 중간 매개체가 존재할 이유가 없습니다.
          하지만 안드로이드 플랫폼은 조금 다릅니다. 비유하자면 '생체인식' 보다는 'ID카드' 를 통한 보안 시스템과 유사한 구조입니다.
           특정 어플리케이션이 자신이 본인임을 확인 받을 수 있는 방법은 자신이 작동중인 Process 를 보여주는 것이 아니라,
            자신이 건내받은 ID카드를 제시하는 것 입니다. 이 때 ID카드의 역할을 수행하는 것이 바로 Context 이고,
           당연히 이 카드는 위변조가 가능하기때문에, 자신의 권한을 제삼의 어플리케이션에게 넘겨주는 PendingIntent 와 같은 기능도 가능해집니다.
         */

        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if ( convertView == null ) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //LayoutInflater Instantiates a layout XML file into its corresponding View objects. It is never used directly.
            //Instead, use getLayoutInflater() or getSystemService(String) to retrieve a standard LayoutInflater instance
            // that is already hooked up to the current context and correctly configured for the device you are running on.
            // For example:  LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.path_record_item, parent, false);
            //public View inflate (XmlPullParser parser, ViewGroup root, boolean attachToRoot)
            //For performance reasons, view inflation relies heavily on pre-processing of XML files that is done at build time.
            // Therefore, it is not currently possible to use LayoutInflater with an XmlPullParser over a plain XML file at runtime.
            //parser : XML dom node containing the description of the view hierarchy.
            //root : Optional view to be the parent of the generated hierarchy (if attachToRoot is true),
            //or else simply an object that provides a set of LayoutParams values for root of the returned hierarchy (if attachToRoot is false.)
            //attachToRoot : Whether the inflated hierarchy should be attached to the root parameter? If false,
            // root is only used to create the correct subclass of LayoutParams for the root view in the XML.
            //Return : The root View of the inflated hierarchy. If root was supplied and attachToRoot is true, this is root;
            // otherwise it is the root of the inflated XML file.

            PathRecord item = mList.get(position); //position번째 path를 받아온다.

            TextView tvDistance = (TextView) convertView.findViewById(R.id.tv_path_distance); //tv_path_distance라는 ID를 가지는 textview에 거리:item.getDistance()"km"
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
