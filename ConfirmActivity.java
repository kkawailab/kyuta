package com.example.carselection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        System.out.println("予約画面へ遷移");

        Intent intent = getIntent();
        String carType = intent.getStringExtra("carType");
        String leisure = intent.getStringExtra("leisure");

        // レイアウト内のTextViewにデータを表示
        TextView carTypeTextView = findViewById(R.id.carTypeTextView);
        carTypeTextView.setText("車のタイプ: " + carType);

        TextView leisureTextView = findViewById(R.id.leisureTextView);
        leisureTextView.setText("レジャー活動: " + leisure);

        // チェックボックスの取得
        LinearLayout itemContainer = findViewById(R.id.itemContainer);
        CheckBox item1CheckBox = itemContainer.findViewById(R.id.item1CheckBox);
        CheckBox item2CheckBox = itemContainer.findViewById(R.id.item2CheckBox);
        CheckBox item3CheckBox = itemContainer.findViewById(R.id.item3CheckBox);

        // レジャー活動に応じてチェックボックスのラベルを設定
        switch (leisure) {
            case "スキー":
                item1CheckBox.setText("スキー板");
                item2CheckBox.setText("ウェア");
                item3CheckBox.setText("リフト券");
                break;
            case "バーベキュー":
                item1CheckBox.setText("炭");
                item2CheckBox.setText("食材");
                item3CheckBox.setText("コンロ");
                break;
            case "釣り":
                item1CheckBox.setText("釣り竿");
                item2CheckBox.setText("餌");
                item3CheckBox.setText("バケツ");
                break;
            default:
                // その他のレジャー活動に対する処理を追加
                item1CheckBox.setText("無し");
                item2CheckBox.setText("無し");
                item3CheckBox.setText("無し");
                break;
        }

        Button reservationButton = findViewById(R.id.reservationButton);

        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 予約の処理を実行

                Intent finalIntent = new Intent(ConfirmActivity.this, FinalActivity.class);
                finalIntent.putExtra("carType", carType);
                finalIntent.putExtra("leisure", leisure);
                startActivity(finalIntent);
            }
        });
    }
}

