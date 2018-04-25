package com.dola.incubatorpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminSelectedIncubator extends AppCompatActivity {
    EditText IncNum,ChileName,Date,Weight,Gender,IdNum;
    Button viewdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_selected_incubator);

        IncNum =(EditText)findViewById(R.id.IncNum_SeleInc);

//        ChileName =(EditText)findViewById(R.id.ChildNam_SeleInc);
//        Date =(EditText)findViewById(R.id.Date_SeleInc);
//        Weight =(EditText)findViewById(R.id.Weight_SeleInc);
//        Gender =(EditText)findViewById(R.id.Gender_SeleInc);
//        IdNum =(EditText)findViewById(R.id.IdNum_SeleInc);

        viewdetail = (Button) findViewById(R.id.ViewDetail);

        viewdetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminSelectedIncubator.this, ViewDetails.class);

                String name = IncNum.getText().toString();
                intent.putExtra("Inc",name);

                startActivity(intent);
            }
        });
    }
}
