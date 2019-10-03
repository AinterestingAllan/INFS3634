package com.example.worldclock;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    static boolean nowTimeIs24 = true;
    static ZonedDateTime ztimeSydney;
    static ZonedDateTime ztimeChicago;
    static ZonedDateTime ztimeShanghai;
    static ZonedDateTime ztimeParis;
    static ZonedDateTime ztimeTokyo;

    static String fomat24 = "yyyy/MM/dd HH:mm:ss";
    static String fomat12 = "yyyy/MM/dd hha:mm:ss";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView tv1 = findViewById(R.id.textView1);
        final TextView tv2 = findViewById(R.id.textView2);
        final TextView tv3 = findViewById(R.id.textView3);
        final TextView tv4 = findViewById(R.id.textView4);
        final TextView tv5 = findViewById(R.id.textView5);
        final TextView tv6 = findViewById(R.id.textView6);
        final TextView tv7 = findViewById(R.id.textView7);
        final TextView tv8 = findViewById(R.id.textView8);
        final TextView tv9 = findViewById(R.id.textView9);
        final TextView tv10 = findViewById(R.id.textView10);

        final Button bt = findViewById(R.id.button3);

        ztimeSydney =
                ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Australia/Sydney"));
        ztimeChicago =
                ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("America/Chicago"));
        ztimeShanghai =
                ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Shanghai"));
        ztimeParis =
                ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"));
        ztimeTokyo =
                ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Tokyo"));

        tv1.setText("Sydney");
        tv3.setText("Chicago");
        tv5.setText("Shanghai");
        tv7.setText("Paris");
        tv9.setText("Tokyo");

        tv2.setText(ztimeSydney.format(DateTimeFormatter.ofPattern(fomat24)));
        tv4.setText(ztimeChicago.format(DateTimeFormatter.ofPattern(fomat24)));
        tv6.setText(ztimeShanghai.format(DateTimeFormatter.ofPattern(fomat24)));
        tv8.setText(ztimeParis.format(DateTimeFormatter.ofPattern(fomat24)));
        tv10.setText(ztimeTokyo.format(DateTimeFormatter.ofPattern(fomat24)));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nowTimeIs24) {
                    tv2.setText(ztimeSydney.format(DateTimeFormatter.ofPattern(fomat12)));
                    tv4.setText(ztimeChicago.format(DateTimeFormatter.ofPattern(fomat12)));
                    tv6.setText(ztimeShanghai.format(DateTimeFormatter.ofPattern(fomat12)));
                    tv8.setText(ztimeParis.format(DateTimeFormatter.ofPattern(fomat12)));
                    tv10.setText(ztimeTokyo.format(DateTimeFormatter.ofPattern(fomat12)));
                    nowTimeIs24 = false;
                    bt.setText("Switch to 24");
                } else {
                    tv2.setText(ztimeSydney.format(DateTimeFormatter.ofPattern(fomat24)));
                    tv4.setText(ztimeChicago.format(DateTimeFormatter.ofPattern(fomat24)));
                    tv6.setText(ztimeShanghai.format(DateTimeFormatter.ofPattern(fomat24)));
                    tv8.setText(ztimeParis.format(DateTimeFormatter.ofPattern(fomat24)));
                    tv10.setText(ztimeTokyo.format(DateTimeFormatter.ofPattern(fomat24)));
                    nowTimeIs24 = true;
                    bt.setText("Switch to 12");
                }
            }
        });

        new TimeThread().start();

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class TimeThread extends Thread {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @SuppressLint("HandlerLeak")
        private Handler mHandler = new Handler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    final TextView tv1 = findViewById(R.id.textView1);
                    final TextView tv2 = findViewById(R.id.textView2);
                    final TextView tv3 = findViewById(R.id.textView3);
                    final TextView tv4 = findViewById(R.id.textView4);
                    final TextView tv5 = findViewById(R.id.textView5);
                    final TextView tv6 = findViewById(R.id.textView6);
                    final TextView tv7 = findViewById(R.id.textView7);
                    final TextView tv8 = findViewById(R.id.textView8);
                    final TextView tv9 = findViewById(R.id.textView9);
                    final TextView tv10 = findViewById(R.id.textView10);

                    final Button bt = findViewById(R.id.button3);


                    MainActivity.ztimeSydney =
                            ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Australia/Sydney"));
                    MainActivity.ztimeChicago =
                            ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("America/Chicago"));
                    MainActivity.ztimeShanghai =
                            ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Shanghai"));
                    MainActivity.ztimeParis =
                            ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"));
                    MainActivity.ztimeTokyo =
                            ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Tokyo"));
                    // Stuff that updates the UI
                    if (nowTimeIs24) {
                        tv2.setText(ztimeSydney.format(DateTimeFormatter.ofPattern(fomat24)));
                        tv4.setText(ztimeChicago.format(DateTimeFormatter.ofPattern(fomat24)));
                        tv6.setText(ztimeShanghai.format(DateTimeFormatter.ofPattern(fomat24)));
                        tv8.setText(ztimeParis.format(DateTimeFormatter.ofPattern(fomat24)));
                        tv10.setText(ztimeTokyo.format(DateTimeFormatter.ofPattern(fomat24)));
                    } else {
                        tv2.setText(ztimeSydney.format(DateTimeFormatter.ofPattern(fomat12)));
                        tv4.setText(ztimeChicago.format(DateTimeFormatter.ofPattern(fomat12)));
                        tv6.setText(ztimeShanghai.format(DateTimeFormatter.ofPattern(fomat12)));
                        tv8.setText(ztimeParis.format(DateTimeFormatter.ofPattern(fomat12)));
                        tv10.setText(ztimeTokyo.format(DateTimeFormatter.ofPattern(fomat12)));
                    }
                }
            }
        };
    }
}
