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
 * Created by admin on 3/23/2017.
 */

public class SchoolNewsAdapter extends RecyclerView.Adapter<SchoolNewsAdapter.Myholder> {

    ArrayList<NewsModel> Al=new ArrayList<>();
    int res;
    Activity obj;

    public SchoolNewsAdapter(Activity obj, int res, ArrayList<NewsModel> Al) {
        this.Al=Al;
        this.res = res;
        this.obj = obj;
    }

    @Override
    public SchoolNewsAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        Myholder myholder=new Myholder(view);



        return myholder;
    }

    @Override
    public void onBindViewHolder(SchoolNewsAdapter.Myholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myholder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView iv;
        TextView heading,dt,news;
        Button mrdtl;


        public Myholder(View itemView) {
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
