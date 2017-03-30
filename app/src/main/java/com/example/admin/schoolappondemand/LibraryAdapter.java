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
 * Created by admin on 3/29/2017.
 */

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.MyHolder> {
    Activity obj;
    int res;
    ArrayList<LibreryModel> Al=new ArrayList<>();

    LibraryAdapter(Activity obj,int res,ArrayList<LibreryModel> Al)
    {
        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }


    @Override
    public LibraryAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder holder=new MyHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(LibraryAdapter.MyHolder holder, int position) {

        LibreryModel lmodel=Al.get(position);
        holder.acsn.setText(lmodel.getAcsnno());
        holder.bktl.setText(lmodel.getTitle());
        holder.bksubtl.setText(lmodel.getSubtitle());
        holder.bkedsn.setText(lmodel.getBookedition());
        holder.issdt.setText(lmodel.getIssuedat());
        holder.rtndt.setText(lmodel.getReturndat());
        holder.dudet.setText(lmodel.getDuedat());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView crd;
        TextView acsn,bktl,bksubtl,bkedsn,issdt,rtndt,dudet;

        public MyHolder(View itemView) {
            super(itemView);

            crd= (CardView) itemView.findViewById(R.id.crd_lib);
            acsn= (TextView) itemView.findViewById(R.id.accessn);
            bktl= (TextView) itemView.findViewById(R.id.tile);
            bksubtl= (TextView) itemView.findViewById(R.id.Sub_tile);
            bkedsn= (TextView) itemView.findViewById(R.id.bk_edsn);
            issdt= (TextView) itemView.findViewById(R.id.iss_dt);
            rtndt= (TextView) itemView.findViewById(R.id.rtrn_dt);
            dudet= (TextView) itemView.findViewById(R.id.du_dt);
        }
    }
}
