package com.dola.incubatorpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserSelectedIncubator extends AppCompatActivity {
    public TextView IncNum,ChileName,Date,Weight,Gender,IdNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected_incubator);

        IncNum =(TextView)findViewById(R.id.IncNum_UserInc);
        ChileName =(TextView)findViewById(R.id.ChildNum_UserInc);
        Date =(TextView)findViewById(R.id.Date_UserInc);
        Weight =(TextView)findViewById(R.id.Weight_UserInc);
        Gender =(TextView)findViewById(R.id.Gender_UserInc);
        IdNum =(TextView)findViewById(R.id.IdNum_UserInc);

        Button viewdetail = (Button) findViewById(R.id.ViewDetail);

        viewdetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSelectedIncubator.this, ViewDetails.class);

                String name = getIntent().getStringExtra("Name");
                IncNum.setText(name);

                startActivity(intent);
            }
        });
    }
}
