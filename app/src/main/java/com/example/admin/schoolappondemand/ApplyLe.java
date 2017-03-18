package com.example.admin.schoolappondemand;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyLe extends Fragment  implements View.OnClickListener{

    private EditText fromet;
    private EditText toet;

    private DatePickerDialog frmdtpkr;

    private DatePickerDialog totpkr;

    private SimpleDateFormat dateFormat;


    public ApplyLe() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_apply_le, container, false);

        dateFormat=new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        fromet= (EditText) view.findViewById(R.id.et_le_from);
        fromet.setInputType(InputType.TYPE_NULL);
        fromet.requestFocus();

        toet= (EditText) view.findViewById(R.id.et_le_to);
        toet.setInputType(InputType.TYPE_NULL);


        setDateTimeField();


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setDateTimeField() {

        fromet.setOnClickListener(this);
        toet.setOnClickListener(this);

        Calendar cal=Calendar.getInstance();

       frmdtpkr=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               Calendar nedt=Calendar.getInstance();
               nedt.set(year,month,dayOfMonth);
               fromet.setText(dateFormat.format(nedt.getTime()));


           }
       },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));

        totpkr=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Calendar nedt=Calendar.getInstance();

                nedt.set(year,month,dayOfMonth);
                toet.setText(dateFormat.format(nedt.getTime()));
            }
        },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
    }



    @Override
    public void onClick(View v) {

        if(v==fromet){
            frmdtpkr.show();
        }else if(v==toet){
            totpkr.show();
        }

    }

    }

