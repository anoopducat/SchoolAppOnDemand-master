package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/24/2017.
 */

public class LatestNews extends RecyclerView.Adapter<LatestNews.MyHolder> {

    ArrayList<NewsModel> Al=new ArrayList<>();
    int res;
    Activity obj;

    public LatestNews(int res,Activity obj,ArrayList<NewsModel> Al) {
        this.Al=Al;
        this.res = res;
        this.obj = obj;
    }




    @Override
    public LatestNews.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(LatestNews.MyHolder holder, int position) {

        NewsModel model=Al.get(position);

        holder.iv.setImageResource(model.getNwimg());
        holder.heading.setText(model.getNwsheading());
        holder.dt.setText(model.getNwsdt());
        holder.news.setText(model.getNws());



    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView iv;
        TextView heading,dt,news;
        Button mrdtl;

        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.crd_nws);
            iv= (ImageView) itemView.findViewById(R.id.iv_nws_title);
            heading= (TextView) itemView.findViewById(R.id.nws_hdng);
            dt= (TextView) itemView.findViewById(R.id.nws_dt);
            news= (TextView) itemView.findViewById(R.id.nws);
            mrdtl= (Button) itemView.findViewById(R.id.shw_nws);
        }
    }
}
