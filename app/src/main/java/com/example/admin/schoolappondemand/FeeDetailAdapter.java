package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/9/2017.
 */

public class FeeDetailAdapter extends RecyclerView.Adapter<FeeDetailAdapter.MyHolder> {

    ArrayList<FeeDetailModel> Al=new ArrayList<>();
    int res;
    Activity obj;

    FeeDetailAdapter(Activity obj,int res,ArrayList<FeeDetailModel> Al)
    {
        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }

    @Override
    public FeeDetailAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FeeDetailAdapter.MyHolder holder, int position) {

        FeeDetailModel fdm=Al.get(position);

        holder.tv2.setText(fdm.getFeetype());
        holder.tv3.setText(fdm.getFeetotal());
        holder.tv4.setText(fdm.getFeepaid());
        holder.tv5.setText(fdm.getFeedue());
        holder.tv6.setText(fdm.getFeedate());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tv2,tv3,tv4,tv5,tv6;

        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.fee_card);
            tv2= (TextView) itemView.findViewById(R.id.skating);
            tv3= (TextView) itemView.findViewById(R.id.skt_fee_ttl);
            tv4= (TextView) itemView.findViewById(R.id.paid);
            tv5= (TextView) itemView.findViewById(R.id.due);
            tv6= (TextView) itemView.findViewById(R.id.dt);
        }
    }
}
