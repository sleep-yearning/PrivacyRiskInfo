package com.bp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class Home extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHandler dbHandler = new DBHandler(this,null,null,1);
        if (!dbHandler.checkIfInside(dbHandler.TABLE_PERSONAL,dbHandler.COLUMN_KEY+" = \'firstrun\'")){
            dbHandler.close();
            Intent intent = new Intent(getApplicationContext(),OnboardingActivity.class);
            startActivity(intent);
        }
        dbHandler.close();
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout lectionButton = (RelativeLayout) findViewById(R.id.firstLayout);

        RelativeLayout settingsButton = (RelativeLayout) findViewById(R.id.sixtLayout);

        settingsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(i);
            }
        });


        lectionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ClassListActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout trophyButton = (RelativeLayout) findViewById(R.id.fifthLayout);


        trophyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),TrophyRoomActivity.class);
                startActivity(i);


            }

        });

        RelativeLayout animationButton = (RelativeLayout) findViewById(R.id.thirdLayout);

        animationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AnimationLauncher.class);
                startActivity(i);

            }

        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_activities, menu);
        menu.findItem(R.id.goOn).setVisible(false);
        menu.findItem(R.id.goBack).setVisible(false);
        menu.findItem(R.id.action_options).setVisible(false);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
