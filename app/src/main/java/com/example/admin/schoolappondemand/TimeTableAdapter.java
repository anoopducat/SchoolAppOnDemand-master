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
 * Created by admin on 3/28/2017.
 */

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyHolder> {

    ArrayList<TimeTableModel> Al=new ArrayList<>();
    int res;
    Activity obj;

   TimeTableAdapter(Activity obj,int res,ArrayList<TimeTableModel> Al){
       this.obj=obj;
       this.res=res;
       this.Al=Al;
   }

    @Override
    public TimeTableAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder mh=new MyHolder(view);

        return mh;
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.MyHolder holder, int position) {

        TimeTableModel tmodel=Al.get(position);
        holder.tvd.setText(tmodel.getTtday());
        holder.tvp.setText(tmodel.getTtperiod());
        holder.tvs.setText(tmodel.getTtsubct());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tvd,tvp,tvs;

        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.time_table_cv);
            tvd= (TextView) itemView.findViewById(R.id.t_dayname);
            tvp= (TextView) itemView.findViewById(R.id.t_period);
            tvs= (TextView) itemView.findViewById(R.id.t_subject);
        }
    }
}
