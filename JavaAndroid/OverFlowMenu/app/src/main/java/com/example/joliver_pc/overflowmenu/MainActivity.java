package com.example.joliver_pc.overflowmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    /*
        Things to Remmember:
            1. Add items in res >> menu >> menu_main.xml
            2. Add strings in strings.xml
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //override this method
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //get main_menu RelativeLayout instance from activity_main.xml

        RelativeLayout main_menu = (RelativeLayout) findViewById(R.id.main_menu);

        switch(id){
            case R.id.menu_green:
                main_menu.setBackgroundColor(Color.GREEN);
                return true; //tell the method that you successfully handled this
            case R.id.menu_red:
                main_menu.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_yellow:
                main_menu.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
