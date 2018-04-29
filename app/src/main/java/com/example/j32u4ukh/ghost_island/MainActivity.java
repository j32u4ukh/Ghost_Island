package com.example.j32u4ukh.ghost_island;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import com.google.zxing.integration.android.*;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import static com.example.j32u4ukh.ghost_island.HeadActivity.date;
import static com.example.j32u4ukh.ghost_island.HeadActivity.intMemory;
import static com.example.j32u4ukh.ghost_island.HeadActivity.month;


public class MainActivity extends AppCompatActivity {
    // 資料庫
    SharedPreferences sharedPreferences;
    String stringMemory;
    // 取得元件
    Button get_QRcode;
    TextView storeInformation1, textViewInteractive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 建立資料庫
        sharedPreferences = getSharedPreferences("recode", MODE_PRIVATE);
        // 取得元件
        get_QRcode = (Button) findViewById(R.id.get_qrcode);
        storeInformation1 = (TextView) findViewById(R.id.storeInformation1);
        textViewInteractive = (TextView) findViewById(R.id.textViewInteractive);
        // 取得stringMemory
        stringMemory = sharedPreferences.getString("stringMemory", "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");

        // 取得intMemory
        for(int i = 0; i < intMemory.length; i++){
            int n = (i + 1) * 4;
            intMemory[i] = Integer.parseInt(stringMemory.substring(n - 4, n));
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        storeInformation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "可以選擇外帶就不用等空位囉~", Toast.LENGTH_SHORT).show();
            }
        });

        // 讀取QRcode
        get_QRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 判斷是否為遊戲期間
                if(month == 10){
                    IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
                    scanIntegrator.initiateScan();
                }else {
                    Toast.makeText(MainActivity.this, "目前非遊戲期間", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 互動區
        int time = 0, money = 0;
        for(int i = 1; i <= 31; i++){
            time += intMemory[i];
            money += intMemory[i + 31];
        }
        String time_money = String.format(getResources().getString(R.string.interactive00), time, money) + "\n";
        String show;
        switch (time){
            case 0:
                show = time_money + getResources().getString(R.string.interactive01);
                textViewInteractive.setText(show);
                break;
            case 1:
                show = time_money + getResources().getString(R.string.interactive02);
                textViewInteractive.setText(show);
                break;
            case 2:
                show = time_money + getResources().getString(R.string.interactive03);
                textViewInteractive.setText(show);
                break;
            case 3:
                show = time_money + getResources().getString(R.string.interactive04);
                textViewInteractive.setText(show);
                break;
            case 4:
                show = time_money + getResources().getString(R.string.interactive05);
                textViewInteractive.setText(show);
                break;
            case 5:
                show = time_money + getResources().getString(R.string.interactive06);
                textViewInteractive.setText(show);
                break;
            case 6:
                show = time_money + getResources().getString(R.string.interactive07);
                textViewInteractive.setText(show);
                break;
            case 7:
                show = time_money + getResources().getString(R.string.interactive08);
                textViewInteractive.setText(show);
                break;
            case 8:
                show = time_money + getResources().getString(R.string.interactive09);
                textViewInteractive.setText(show);
                break;
            case 9:
                show = time_money + getResources().getString(R.string.interactive10);
                textViewInteractive.setText(show);
                break;
            case 10:
                show = time_money + getResources().getString(R.string.interactive11);
                textViewInteractive.setText(show);
                break;
            case 11:
                show = time_money + getResources().getString(R.string.interactive12);
                textViewInteractive.setText(show);
                break;
            case 12:
                show = time_money + getResources().getString(R.string.interactive13);
                textViewInteractive.setText(show);
                break;
            case 13:
                show = time_money + getResources().getString(R.string.interactive14);
                textViewInteractive.setText(show);
                break;
            case 14:
                show = time_money + getResources().getString(R.string.interactive15);
                textViewInteractive.setText(show);
                break;
            case 15:
                show = time_money + getResources().getString(R.string.interactive16);
                textViewInteractive.setText(show);
                break;
            case 16:
                show = time_money + getResources().getString(R.string.interactive17);
                textViewInteractive.setText(show);
                break;
            case 17:
                show = time_money + getResources().getString(R.string.interactive18);
                textViewInteractive.setText(show);
                break;
            case 18:
                show = time_money + getResources().getString(R.string.interactive19);
                textViewInteractive.setText(show);
                break;
            case 19:
                show = time_money + getResources().getString(R.string.interactive20);
                textViewInteractive.setText(show);
                break;
            case 20:
                show = time_money + getResources().getString(R.string.interactive21);
                textViewInteractive.setText(show);
                break;
            case 21:
                show = time_money + getResources().getString(R.string.interactive22);
                textViewInteractive.setText(show);
                break;
            case 22:
                show = time_money + getResources().getString(R.string.interactive23);
                textViewInteractive.setText(show);
                break;
            case 23:
                show = time_money + getResources().getString(R.string.interactive24);
                textViewInteractive.setText(show);
                break;
            case 24:
                show = time_money + getResources().getString(R.string.interactive25);
                textViewInteractive.setText(show);
                break;
            case 25:
                show = time_money + getResources().getString(R.string.interactive26);
                textViewInteractive.setText(show);
                break;
            case 26:
                show = time_money + getResources().getString(R.string.interactive27);
                textViewInteractive.setText(show);
                break;
            case 27:
                show = time_money + getResources().getString(R.string.interactive28);
                textViewInteractive.setText(show);
                break;
            default:
                show = time_money + getResources().getString(R.string.interactive30);
                textViewInteractive.setText(show);
                break;
        }
    }

    /*-------------------------------------------------------------撰寫功能區----------------------------------------------------------------*/

    // 讀取 QRcode 後執行的動作
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Intent intentCost = new Intent(MainActivity.this, Cost.class);
        if(scanningResult!=null){
            String scanContent = scanningResult.getContents();
            // 判斷QRcode內容後分流
            switch (scanContent){
                case "robin_hood_1 = gold_1000":
                    if(date < 8){
                        startActivity(intentCost);
                    }else {
                        intMemory[0] += 1;
                    }
                    break;
                case "robin_hood_2 = gold_2000":
                    if(date < 15){
                        startActivity(intentCost);
                    }else {
                        intMemory[0] += 1;
                    }
                    break;
                case "robin_hood_3 = gold_3000":
                    if(date < 22){
                        startActivity(intentCost);
                    }else {
                        intMemory[0] += 1;
                    }
                    break;
                case "robin_hood_4 = gold_4000":
                    if(date < 29){
                        startActivity(intentCost);
                    }else {
                        intMemory[0] += 1;
                    }
                    break;
                case "robin_hood_5 = gold_5000":
                    startActivity(intentCost);
                    break;
                default:
                    Toast.makeText(this, "非本遊戲的QRcode", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else{
            Toast.makeText(getApplicationContext(),"無效QRcode", Toast.LENGTH_SHORT).show();
        }

    }

    // 建立menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.function, menu);
        return true;
    }

    // 設定menu被按之後的動作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // 前往線索顯示頁
            case R.id.trails:
                Intent intent_trails = new Intent(MainActivity.this, Trail.class);
                startActivity(intent_trails);
                break;
            // 寄信
            case R.id.send:
                // 更新資料庫
                String string = "";
                for (int i = 0; i < intMemory.length; i++){
                    String n = String.format("%04d", intMemory[i]);
                    string += n;
                }

                // 信件內容
                String fb_name = sharedPreferences.getString("fbName", "");
                String subject = fb_name + "：鬼島遊戲數據";
                String content = string;

                // 將內容填入相對應位置
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:j32u4ukh@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                //取得所有可用的App資訊
                List<ResolveInfo> ResolveInfoList = getPackageManager().queryIntentActivities(intent, 0);
                for(ResolveInfo Resolve : ResolveInfoList){
                    // 尋找Gmail的Package
                    if(Resolve.activityInfo.name.contains("com.google.android.gm")){
                        ActivityInfo activity = Resolve.activityInfo;
                        ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        intent.setComponent(name);
                        startActivity(intent);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    // 按返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


}
