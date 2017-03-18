package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by admin on 3/6/2017.
 */

public class HomeHrkAdapter extends RecyclerView.Adapter<HomeHrkAdapter.MyHolder> {

    ArrayList<HomeWorkModel> Al=new ArrayList<>();
    int res;
    Activity obj;

    HomeHrkAdapter(Activity obj, int res, ArrayList<HomeWorkModel> Al)
    {
        this.obj= obj;
        this.res=res;
        this.Al=Al;
    }

    @Override
    public HomeHrkAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(obj).inflate(res,parent,false);

      MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(HomeHrkAdapter.MyHolder holder, int position) {

        HomeWorkModel homeWorkModel=Al.get(position);
     holder.hmk_date.setText(homeWorkModel.gethDate());
        holder.hmk_lsn.setText(homeWorkModel.getHlesson());
        holder.hmk_chptr.setText(homeWorkModel.getHchapter());
        holder.teacher.setText(homeWorkModel.getTchr());



    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView hmk_date,hmk_day,hmk_lsn,hmk_chptr,teacher;
        ImageView ivbk;

        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.hmrk_card);
            hmk_date= (TextView) itemView.findViewById(R.id.tv_date);
            hmk_day= (TextView) itemView.findViewById(R.id.tv_day);
            hmk_lsn= (TextView) itemView.findViewById(R.id.lsn_nmbr);
            hmk_chptr= (TextView) itemView.findViewById(R.id.chptr_no);
            ivbk= (ImageView) itemView.findViewById(R.id.iv_book);
            teacher= (TextView) itemView.findViewById(R.id.tv_day);
        }
    }
}
