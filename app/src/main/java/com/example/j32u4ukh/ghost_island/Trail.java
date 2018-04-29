package com.example.j32u4ukh.ghost_island;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;
import static com.example.j32u4ukh.ghost_island.HeadActivity.intMemory;
import static com.example.j32u4ukh.ghost_island.HeadActivity.length;

public class Trail extends AppCompatActivity {
    // 顯示線索
    TextView trail1, trail2, trail3, trail4, trail5, trail6, trail7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);
        // 線索1~10
        trail1 = (TextView)findViewById(R.id.trail1);
        trail2 = (TextView)findViewById(R.id.trail2);
        trail3 = (TextView)findViewById(R.id.trail3);
        trail4 = (TextView)findViewById(R.id.trail4);
        trail5 = (TextView)findViewById(R.id.trail5);
        trail6 = (TextView)findViewById(R.id.trail6);
        trail7 = (TextView)findViewById(R.id.trail7);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 顯示線索
        showTrail(length + 1, trail1);
        showTrail(length + 2, trail2);
        showTrail(length + 3, trail3);
        showTrail(length + 4, trail4);
        showTrail(length + 5, trail5);
        showTrail(length + 6, trail6);
        // 互動區
        int time = 0;
        for(int i = 1; i <= 31; i++){
            time += intMemory[i];
        }
        switch (time){
            case 0:
                trail7.setText(R.string.trail7);
                break;
            case 1:
                trail7.setText(R.string.ANS01);
                break;
            case 2:
                trail7.setText(R.string.ANS02);
                break;
            case 3:
                trail7.setText(R.string.ANS03);
                break;
            case 4:
                trail7.setText(R.string.ANS04);
                break;
            case 5:
                trail7.setText(R.string.ANS05);
                break;
            case 6:
                trail7.setText(R.string.ANS06);
                break;
            case 7:
                trail7.setText(R.string.ANS07);
                break;
            case 8:
                trail7.setText(R.string.ANS08);
                break;
            case 9:
                trail7.setText(R.string.ANS09);
                break;
            case 10:
                trail7.setText(R.string.ANS10);
                break;
            case 11:
                trail7.setText(R.string.ANS11);
                break;
            case 12:
                trail7.setText(R.string.ANS12);
                break;
            case 13:
                trail7.setText(R.string.ANS13);
                break;
            case 14:
                trail7.setText(R.string.ANS14);
                break;
            case 15:
                trail7.setText(R.string.ANS15);
                break;
            case 16:
                trail7.setText(R.string.ANS16);
                break;
            case 17:
                trail7.setText(R.string.ANS17);
                break;
            case 18:
                trail7.setText(R.string.ANS18);
                break;
            case 19:
                trail7.setText(R.string.ANS19);
                break;
            case 20:
                trail7.setText(R.string.ANS20);
                break;
            case 21:
                trail7.setText(R.string.ANS21);
                break;
            case 22:
                trail7.setText(R.string.ANS22);
                break;
            case 23:
                trail7.setText(R.string.ANS23);
                break;
            case 24:
                trail7.setText(R.string.ANS24);
                break;
            case 25:
                trail7.setText(R.string.ANS25);
                break;
            case 26:
                trail7.setText(R.string.ANS26);
                break;
            case 27:
                trail7.setText(R.string.ANS27);
                break;
            case 28:
                trail7.setText(R.string.ANS28);
                break;
            default:
                trail7.setText(R.string.ANS30);
                break;
        }
    }

    /*-------------------------------------------------------------撰寫功能區----------------------------------------------------------------*/
    // 隱藏線索
    public void showTrail(int number, TextView textView){
        if(intMemory[number] < 1){
            textView.setText(R.string.trail);
        }
    }
    // 按返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
