package com.example.d2a.aplikasilogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static String LOGINPREF = "login.pref.file";

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginApp(View view) {
        EditText inpUsername = (EditText)findViewById(R.id.inp_username);
        EditText inpPassword = (EditText)findViewById(R.id.inp_password);

        String username = inpUsername.getText().toString();
        String password = inpPassword.getText().toString();

        if (username.equals("doscom") && password.equals("doscomDC")){
            SharedPreferences sp = getSharedPreferences(LOGINPREF, MODE_PRIVATE);
            SharedPreferences.Editor spEdit = sp.edit();
            spEdit.putString("username", username);
            spEdit.putString("token", "uertuqweytuhuihfudakfbvcnvbajdhv");
            spEdit.apply();


            Intent it = new Intent(this, MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);
        }

    }
}
