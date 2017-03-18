package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/18/2017.
 */

public class CircularAdapter extends RecyclerView.Adapter<CircularAdapter.MyHolder> {

    ArrayList<CircularModel> Al=new ArrayList<>();
    int res;
    Activity obj;

    CircularAdapter(Activity obj,int res,ArrayList<CircularModel> Al)
    {
        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }

    @Override
    public CircularAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(CircularAdapter.MyHolder holder, int position) {

        CircularModel cmdl=Al.get(position);

        holder.det.setText(cmdl.getDtname());
        holder.crlhed.setText(cmdl.getNem());
        holder.crl_dsr.setText(cmdl.getDescription());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView det,crlhed,crl_dsr,pc;
        ImageButton ib;


        public MyHolder(View itemView) {
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.crd_circular);
            det= (TextView) itemView.findViewById(R.id.tv_crclr_dt);
            crlhed= (TextView) itemView.findViewById(R.id.tv_crclr_demo);
            crl_dsr= (TextView) itemView.findViewById(R.id.tv_drcrtn_crclr);
            pc= (TextView) itemView.findViewById(R.id.rdcrclr);
            ib= (ImageButton) itemView.findViewById(R.id.btn_iv_crlr);
        }
    }
}
