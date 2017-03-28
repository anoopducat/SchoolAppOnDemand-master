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

public class ResultAdapter  extends RecyclerView.Adapter<ResultAdapter.MyHolder> {

    ArrayList<ResultModel> Al=new ArrayList<>();
    Activity obj;
    int res;

    ResultAdapter(Activity obj,int res,ArrayList<ResultModel> Al)
    {
        this.Al=Al;
        this.obj=obj;
        this.res=res;
    }

    @Override
    public ResultAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ResultAdapter.MyHolder holder, int position) {

        ResultModel rmodel=Al.get(position);
        holder.gnm.setText(rmodel.getGrpnm());
        holder.snm.setText(rmodel.getSubnem());
        holder.obtn.setText(rmodel.getObtnd());
        holder.ful.setText(rmodel.getFll());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView crd;
        TextView gnm,snm,obtn,ful;

        public MyHolder(View itemView) {
            super(itemView);

            crd= (CardView) itemView.findViewById(R.id.result_cv);
            gnm= (TextView) itemView.findViewById(R.id.sub_grp_nm);
           snm= (TextView) itemView.findViewById(R.id.subjct);
            obtn= (TextView) itemView.findViewById(R.id.obtained_marks);
            ful= (TextView) itemView.findViewById(R.id.full_mrk);
        }
    }
}
