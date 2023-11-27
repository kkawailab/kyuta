package com.example.carselection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Selected car type
        RadioGroup carRadioGroup = findViewById(R.id.radio_group);

        // Selected leisure activity
        RadioGroup leisureRadioGroup = findViewById(R.id.leisure_group);

        Button submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract selected car type and leisure activity
                int selectedCarType = carRadioGroup.getCheckedRadioButtonId();
                String carType = "";
                switch (selectedCarType) {
                    case R.id.radio_button_light:
                        carType = "軽";
                        break;
                    case R.id.radio_button_sedan:
                        carType = "セダン";
                        break;
                    case R.id.radio_button_van:
                        carType = "ワンボックス";
                        break;
                }

                int selectedLeisure = leisureRadioGroup.getCheckedRadioButtonId();
                String leisure = "";
                switch (selectedLeisure) {
                    case R.id.leisure_button_fishing:
                        leisure = "釣り";
                        break;
                    case R.id.leisure_button_bbq:
                        leisure = "バーベキュー";
                        break;
                    case R.id.leisure_skii:
                        leisure = "スキー";
                        break;
                }

                // Send selected values to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                System.out.println("インテント成功");
                intent.putExtra("carType", carType);
                intent.putExtra("leisure", leisure);
                startActivity(intent);
            }
        });
    }
}
