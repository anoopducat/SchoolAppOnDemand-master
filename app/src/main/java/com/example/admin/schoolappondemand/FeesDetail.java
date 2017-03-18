package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FeesDetail extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<FeeDetailModel> Al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_detail);
        recyclerView= (RecyclerView) findViewById(R.id.rv_feedetail);



        FeeDetailModel feeDetailModel=new FeeDetailModel();
        feeDetailModel.setFeetype("Skating");
        feeDetailModel.setFeetotal("1050");
        feeDetailModel.setFeepaid("500");
        feeDetailModel.setFeedue("400");
        feeDetailModel.setFeedate("04/02/2017");
        Al.add(feeDetailModel);

        FeeDetailModel feeDetailModel1=new FeeDetailModel();
        feeDetailModel1.setFeetype("Tution Fee");
        feeDetailModel1.setFeetotal("700");
        feeDetailModel1.setFeepaid("500");
        feeDetailModel1.setFeedue("400");
        feeDetailModel1.setFeedate("05/02/2017");
        Al.add(feeDetailModel1);

        FeeDetailModel feeDetailModel2=new FeeDetailModel();
        feeDetailModel2.setFeetype("Annual Charges");
        feeDetailModel2.setFeetotal("1000");
        feeDetailModel2.setFeepaid("500");
        feeDetailModel2.setFeedue("400");
        feeDetailModel2.setFeedate("04/03/2017");
        Al.add(feeDetailModel2);

        FeeDetailModel feeDetailModel3=new FeeDetailModel();
        feeDetailModel3.setFeetype("Online Web/MultimediaFee");
        feeDetailModel3.setFeetotal("500");
        feeDetailModel3.setFeepaid("500");
        feeDetailModel3.setFeedue("0");
        feeDetailModel3.setFeedate("08/02/2017");
        Al.add(feeDetailModel3);

        FeeDetailModel feeDetailModel4=new FeeDetailModel();
        feeDetailModel4.setFeetype("Other Misc");
        feeDetailModel4.setFeetotal("3000");
        feeDetailModel4.setFeepaid("2500");
        feeDetailModel4.setFeedue("500");
        feeDetailModel4.setFeedate("11/02/2017");
        Al.add(feeDetailModel4);

        FeeDetailModel feeDetailModel5=new FeeDetailModel();
        feeDetailModel5.setFeetype("Student WelFare");
        feeDetailModel5.setFeetotal("1150");
        feeDetailModel5.setFeepaid("1500");
        feeDetailModel5.setFeedue("1500");
        feeDetailModel5.setFeedate("04/03/2017");
        Al.add(feeDetailModel5);

        FeeDetailModel feeDetailModel6=new FeeDetailModel();
        feeDetailModel6.setFeetype("SchoolarShip Fee");
        feeDetailModel6.setFeetotal("500");
        feeDetailModel6.setFeepaid("400");
        feeDetailModel6.setFeedue("100");
        feeDetailModel6.setFeedate("04/02/2017");
        Al.add(feeDetailModel6);

        FeeDetailAdapter obj=new FeeDetailAdapter(this,R.layout.fee_card,Al);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(obj);

    }
}
