package com.example.j32u4ukh.ghost_island;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import static com.example.j32u4ukh.ghost_island.HeadActivity.intMemory;
import static com.example.j32u4ukh.ghost_island.HeadActivity.length;


public class Cost extends AppCompatActivity {
    // 取得元件
    Button cancel, enter;
    EditText editText;
    ToggleButton toggleButton3;
    // int
    int date;
    // 資料庫
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        // 建立資料庫
        sharedPreferences = getSharedPreferences("recode", MODE_PRIVATE);
        // 取得元件
        cancel = (Button)findViewById(R.id.cancel);
        enter = (Button)findViewById(R.id.enter);
        editText = (EditText)findViewById(R.id.editText);
        toggleButton3 = (ToggleButton)findViewById(R.id.toggleButton3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 取得日期
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cost.this, MainActivity.class);
                startActivity(intent);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取得金額
                int cost = Integer.parseInt(editText.getText().toString());
                // 紀錄次數、金額和線索次數
                intMemory[date] += 1;
                intMemory[date + 31] += cost;
                if(toggleButton3.isChecked()){
                    intMemory[date + 62] += 1;
                }
                // 隨機給予線索1~6
                int rand = (int) (Math.random() * 6) + 1;
                switch (rand){
                    case 1:
                        Toast.makeText(Cost.this, R.string.trail1, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(Cost.this, R.string.trail2, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(Cost.this, R.string.trail3, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(Cost.this, R.string.trail4, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(Cost.this, R.string.trail5, Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(Cost.this, R.string.trail6, Toast.LENGTH_SHORT).show();
                        break;
                }
                intMemory[length + rand] += 1;
                String string = "";
                for (int i = 0; i < intMemory.length; i++){
                    String n = String.format("%04d", intMemory[i]);
                    string += n;
                }
                sharedPreferences.edit().putString("stringMemory", string).apply();
                Intent intentTrail = new Intent(Cost.this, Trail.class);
                startActivity(intentTrail);
            }
        });
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
