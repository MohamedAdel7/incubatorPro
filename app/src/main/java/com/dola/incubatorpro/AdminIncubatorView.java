package com.dola.incubatorpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AdminIncubatorView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_incubator_view);

        TextView incubator1 = (TextView) findViewById(R.id.incubator1);

        incubator1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminIncubatorView.this, AdminSelectedIncubator.class);
                startActivity(intent);
            }
        });
        TextView incubator2 = (TextView) findViewById(R.id.incubator2);

        incubator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminIncubatorView.this, AdminSelectedIncubator.class);
                startActivity(intent);
            }
        });
        TextView incubator3 = (TextView) findViewById(R.id.incubator3);

        incubator3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminIncubatorView.this, AdminSelectedIncubator.class);
                startActivity(intent);
            }
        });
        TextView incubator4 = (TextView) findViewById(R.id.incubator4);

        incubator4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminIncubatorView.this, AdminSelectedIncubator.class);
                startActivity(intent);
            }
        });
    }
}