package com.dola.incubatorpro;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfg {

    private SharedPreferences sharedPreferences ;
    private Context context ;

    public SharedPreferenceConfg(Context context){

        this.context = context ;
        sharedPreferences = context.getSharedPreferences("com.dola.exam_login_preference",Context.MODE_PRIVATE);
    }
    public void writeLoginStatus(boolean status){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("com.dola.exam_login_status_preference",status);
        editor.commit();
    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean("com.dola.exam_login_status_preference",false);
        return status;
    }
}
