package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/1/2017.
 */

public class ProfileAdapter extends BaseAdapter {

    Activity obj;
    int res;
    ArrayList<ProfileModel> Al=new ArrayList<>();
    ProfileAdapter(Activity obj,int res,ArrayList<ProfileModel> Al)
    {

        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }
    @Override
    public int getCount() {
        return Al.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vv= LayoutInflater.from(obj).inflate(res,parent,false);

        ImageView iv= (ImageView) vv.findViewById(R.id.iv_grid);
        TextView tv= (TextView) vv.findViewById(R.id.tv_name);

        ProfileModel pf=Al.get(position);
        iv.setImageResource(pf.getImage());
        tv.setText(pf.getName());

        return vv;
    }
}
