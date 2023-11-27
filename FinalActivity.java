package com.example.carselection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        // Intentからデータを取得
        Intent intent = getIntent();
        String carType = intent.getStringExtra("carType");
        String leisure = intent.getStringExtra("leisure");

        // TextViewを取得して結果を表示
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(carType +"と"+ leisure+ "とグッズを予約しました");

        // 必要なら最終アクティビティのためのコードを追加してください
    }
}
