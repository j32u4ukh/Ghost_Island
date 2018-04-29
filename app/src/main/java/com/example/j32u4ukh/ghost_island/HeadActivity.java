package com.example.j32u4ukh.ghost_island;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class HeadActivity extends AppCompatActivity {
    // 資料庫
    SharedPreferences sharedPreferences;
    String stringMemory;
    static int[] intMemory = new int[105]; // 總長度
    static int length = 93; // 次數與金額的資料尾巴，下一個開始是線索
    static int month, date;
    // 元件
    RadioGroup groupGender;
    Button headButton;
    EditText editFB, editAge, editTextTimes1, editTextMoney1;
    ToggleButton toggleButton1;
    Boolean hasBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        // 取得元件
        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        editFB = (EditText)findViewById(R.id.editFB);
        editAge = (EditText)findViewById(R.id.editAge);
        editTextTimes1 = (EditText)findViewById(R.id.editTextTimes1);
        editTextMoney1 = (EditText)findViewById(R.id.editTextMoney1);
        headButton = (Button)findViewById(R.id.headButton);
        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton1);
        // 建立資料庫
        sharedPreferences = getSharedPreferences("recode", MODE_PRIVATE);
        // 取得stringMemory
        stringMemory = sharedPreferences.getString("stringMemory", "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");

        // 取得intMemory
        for(int i = 0; i < intMemory.length; i++){
            int n = (i + 1) * 4;
            intMemory[i] = Integer.parseInt(stringMemory.substring(n - 4, n));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 取得日期
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH) + 1;
        date = calendar.get(Calendar.DAY_OF_MONTH);
        // 取得基本資料
        // 檢查是否有填寫資料
        hasBeen = sharedPreferences.getBoolean("hasBeen", false);
        if(hasBeen){
            Intent intent = new Intent(HeadActivity.this, MainActivity.class);
            startActivity(intent);
        }
        // Button
        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    // 記憶基本資料
                    // FB名稱
                    sharedPreferences.edit().putString("fbName", editFB.getText().toString()).apply();
                    // 性別：length + 7
                    switch (groupGender.getCheckedRadioButtonId()){
                        case R.id.Gender0:
                            intMemory[length + 7] = 0;
                            break;
                        case R.id.Gender1:
                            intMemory[length + 7] = 1;
                            break;
                        case R.id.Gender2:
                            intMemory[length + 7] = 2;
                            break;
                    }
                    // 年齡：length + 8
                    intMemory[length + 8] = Integer.parseInt(editAge.getText().toString().trim());
                    // 過去消費情形調查
                        // 過去消費次數
                    intMemory[length + 9] = Integer.parseInt(editTextTimes1.getText().toString().trim());
                        // 消費金額
                    intMemory[length + 10] = Integer.parseInt(editTextMoney1.getText().toString().trim());
                        // 是否和其他人一起消費
                    if(toggleButton1.isChecked()){
                        intMemory[length + 11] += 1;
                    }
                    // 更新資料庫
                    String string = "";
                    for (int i = 0; i < intMemory.length; i++){
                        String n = String.format("%04d", intMemory[i]);
                        string += n;
                    }
                    sharedPreferences.edit().putString("stringMemory", string).apply();
                    sharedPreferences.edit().putBoolean("hasBeen", true).apply();
                    Intent intent = new Intent(HeadActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(HeadActivity.this, "資料不得為空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private boolean isValid() {
        return !"".equals(editFB.getText().toString()) &&
                !"".equals(editAge.getText().toString().trim()) &&
                !"".equals(editTextTimes1.getText().toString().trim()) &&
                !"".equals(editTextMoney1.getText().toString().trim());
    }
}
