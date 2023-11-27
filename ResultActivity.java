package com.example.carselection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String carType = intent.getStringExtra("carType");
        String leisure = intent.getStringExtra("leisure");
        System.out.println("結果へ遷移");
        ImageView resultImageView = findViewById(R.id.resultImageView);

        switch (leisure) {
            case "釣り":
                resultImageView.setImageResource(R.drawable.__456_);
                break;
            case "バーベキュー":
                resultImageView.setImageResource(R.drawable.__457_);
                break;
            case "スキー":
                resultImageView.setImageResource(R.drawable.__458_);
                break;
            default:
                resultImageView.setImageResource(R.drawable.ic_launcher_background);
                break;
        }

        TextView resultTextView = findViewById(R.id.ResultView);

        switch (leisure) {
            case "釣り":
                resultTextView.setText(carType + "に乗ってはちまんかまどに行きませんか？\nhttps://amakoya.com/");
                break;
            case "バーベキュー":
                resultTextView.setText(carType + "に乗ってつぐ高原グリーンランドに行きませんか？\nhttps://www.green-park.net/");
                break;
            case "スキー":
                resultTextView.setText(carType + "に乗ってめいほうスキー場に行きませんか？\nhttps://www.meihoski.co.jp/winter/");
                break;
            default:
                resultTextView.setText("不正なレジャー活動が選択されました");

        }

        // ボタンをレイアウトから取得
        Button confirmButton = findViewById(R.id.confirmButton);
        System.out.println("ボタン取得");

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ConfirmActivity に遷移するIntentを作成
                Intent intent = new Intent(ResultActivity.this, ConfirmActivity.class);
                System.out.println("コンフィルム生成");

                // 任意のデータをConfirmActivityに渡す場合はここでputExtraを使って追加
                intent.putExtra("carType", carType);
                intent.putExtra("leisure", leisure);
                System.out.println("遷移前");
                // ConfirmActivityに遷移
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    System.out.println(e);
                }
                // startActivity(intent);
            }
        }
        );


    }
}
