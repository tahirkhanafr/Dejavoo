package com.mikronexus.dejavoo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
 Button button;
 TextView tVdate;
    String appId = "com.mikronexus.cfa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        button=findViewById(R.id.Switch);
        tVdate=findViewById(R.id.date);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy 'at' h:mm a", Locale.getDefault());
        String currentDateTimeString = dateFormat.format(calendar.getTime());
        tVdate.setText(currentDateTimeString);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appId);
                if (launchIntent != null) {
                    startActivity(launchIntent);// start the activity of other app
                } else {
                    Toast.makeText(MainActivity.this, "Other app not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}