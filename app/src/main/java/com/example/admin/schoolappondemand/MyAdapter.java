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
 * Created by admin on 3/1/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    ArrayList<Student> Al=new ArrayList<>();
    int res;
    Activity obj;

    MyAdapter(Activity obj,int res,ArrayList<Student> Al)
    {
        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }

    @Override
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyHolder holder, int position) {

        Student s=Al.get(position);
        holder.tv1.setText(s.getId());
        holder.tv2.setText(s.getName());
        holder.tv3.setText(Al.get(position).getNclass());
        holder.tv4.setText(Al.get(position).getSection());
        holder.tv5.setText(Al.get(position).getSubject());
        holder.tv6.setText(Al.get(position).getChapter());
        holder.tv7.setText(Al.get(position).getLesson());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.cv1);
            tv1= (TextView) itemView.findViewById(R.id.tv_as_id);
            tv2= (TextView) itemView.findViewById(R.id.as_name);
            tv3= (TextView) itemView.findViewById(R.id.tv_cls);
            tv4= (TextView) itemView.findViewById(R.id.tv_sction);
            tv5= (TextView) itemView.findViewById(R.id.tv_subject);
            tv6= (TextView) itemView.findViewById(R.id.tv_chapter);
            tv7= (TextView) itemView.findViewById(R.id.tv_lesson);
        }
    }
}
