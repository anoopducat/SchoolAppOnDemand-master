package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 3/6/2017.
 */

public class HomeHrkAdapter extends RecyclerView.Adapter<HomeHrkAdapter.MyHolder> {

    ArrayList<HomeWorkModel> Al = new ArrayList<>();
    int res;
    Activity obj;

    HomeHrkAdapter(Activity obj, int res, ArrayList<HomeWorkModel> Al) {
        this.obj = obj;
        this.res = res;
        this.Al = Al;
    }

    @Override
    public HomeHrkAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(obj).inflate(res, parent, false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(HomeHrkAdapter.MyHolder holder, int position) {

        HomeWorkModel homeWorkModel = Al.get(position);
        holder.hmk_date.setText(homeWorkModel.gethDate());
        holder.hmk_lsn.setText(homeWorkModel.getHlesson());
        holder.hmk_chptr.setText(homeWorkModel.getHchapter());
        holder.teacher.setText(homeWorkModel.getTchr());

        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(obj, "Success", Toast.LENGTH_SHORT).show();


                AlertDialog.Builder alert= new AlertDialog.Builder(obj);
                alert.setTitle("Do you want to Download attechment file ?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        new DownloadFile().execute("http://maven.apache.org/maven-1.x/maven.pdf", "maven.pdf");


                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });

                AlertDialog dialog = alert.create();
                dialog.show();






            }
        });


    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView hmk_date, hmk_day, hmk_lsn, hmk_chptr, teacher;
        ImageView ivbk;
        ImageButton ib;

        public MyHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.hmrk_card);
            hmk_date = (TextView) itemView.findViewById(R.id.tv_date);
            hmk_day = (TextView) itemView.findViewById(R.id.tv_day);
            hmk_lsn = (TextView) itemView.findViewById(R.id.lsn_nmbr);
            hmk_chptr = (TextView) itemView.findViewById(R.id.chptr_no);
            ivbk = (ImageView) itemView.findViewById(R.id.iv_book);
            teacher = (TextView) itemView.findViewById(R.id.tv_day);
            ib = (ImageButton) itemView.findViewById(R.id.hmrk_dwld);
        }
    }

    public class DownloadFile extends AsyncTask<String, Void, Void> {

        ProgressDialog progressDialog;


        @Override
        protected Void doInBackground(String... params) {

            String fileUrl = params[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = params[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "testthreepdf");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            PFileDownloader.downloadFile(fileUrl, pdfFile);

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();



            progressDialog = new ProgressDialog(obj);
            progressDialog.setMessage("DownLoading Start...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            progressDialog.dismiss();

            Toast.makeText(obj, "Downloading Complete", Toast.LENGTH_SHORT).show();

            File pdfFile = new File(Environment.getExternalStorageDirectory() + "/testthreepdf/" + "maven.pdf");  // -> filename = maven.pdf
            Uri path = Uri.fromFile(pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(path, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try{
                obj.startActivity(pdfIntent);
            }catch(ActivityNotFoundException e){
                Toast.makeText(obj, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
            }


        }
    }

}
