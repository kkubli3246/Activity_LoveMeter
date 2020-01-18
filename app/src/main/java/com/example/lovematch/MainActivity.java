package com.example.lovematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn_compare;
    EditText et_yourName;
    EditText et_someElseName;
    ImageView iv_needle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_compare = (Button) findViewById(R.id.btn_compare);
        et_yourName = (EditText) findViewById(R.id.et_yourName);
        et_someElseName = (EditText)findViewById(R.id.et_someoneElseName);
        iv_needle = (ImageView)findViewById(R.id.iv_needle);

        btn_compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourName = et_yourName.getText().toString().toLowerCase();
                String otherName = et_someElseName.getText().toString().toLowerCase();
                int score = 0;

                for(int i = 0; i < yourName.length(); i++){
                    for(int j = 0; j < otherName.length(); j++){
                        if(yourName.charAt(i) == otherName.charAt(j)){
                            score++;
                        }
                    }
                }
                for(int i = 0; i < otherName.length(); i++){
                    for(int j = 0; j < yourName.length(); j++){
                        if(otherName.charAt(i) == yourName.charAt(j)){
                            score++;
                        }
                    }
                }

                float result = (float)score  / ((float)yourName.length() + (float)otherName.length());
                int loveScore = ((int)(result * 100) * 2);

                RotateAnimation rotate = new RotateAnimation(0-1080 , loveScore, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setFillAfter(true);
                rotate.setDuration(3000);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                Toast.makeText(MainActivity.this, "Love Score: " + loveScore, Toast.LENGTH_SHORT).show();
                iv_needle.startAnimation(rotate);


            }
        });
    }
}
