package com.example.windows10.aplikasilogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d2a.aplikasilogin.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences loginPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginPref = getSharedPreferences(LoginActivity.LOGINPREF, MODE_PRIVATE);
        if(!loginPref.contains("token")){
            Intent it = new Intent(this, LoginActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Arif Hidayat", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView txtName = (TextView)findViewById(R.id.txt_name);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sp.getString("your name", "belum diisi");
        String fav = sp.getString("Favorite", "1");
        txtName.setText(name+"-"+fav);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "ini setting", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }else if(id == R.id.action_logout){
            Toast.makeText(this, "ini logout", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor loginEdit = loginPref.edit();
            loginEdit.clear();
            loginEdit.apply();

            Intent it = new Intent(this, LoginActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
