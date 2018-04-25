package com.dola.incubatorpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {
    TextView IncNum,ChileName,Date,Weight,Gender,IdNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        IncNum =(TextView)findViewById(R.id.IncNum_UserInc);

        //String name = getIntent().getStringExtra("Inc");



//        ChileName =(TextView)findViewById(R.id.ChildNum_UserInc);
//        Date =(TextView)findViewById(R.id.Date_UserInc);
//        Weight =(TextView)findViewById(R.id.Weight_UserInc);
//        Gender =(TextView)findViewById(R.id.Gender_UserInc);
//        IdNum =(TextView)findViewById(R.id.IdNum_UserInc);

    }
}