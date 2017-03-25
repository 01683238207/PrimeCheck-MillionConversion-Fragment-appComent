package com.example.user.millionconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSubmit;
    TextView showView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = (Button) findViewById(R.id.SubButton);
        showView = (TextView) findViewById(R.id.ViwResult);
        editText = (EditText) findViewById(R.id.textSet);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int m = 1, n = Integer.parseInt(editText.getText().toString());
        String s = "";
        if (n >= 100) {
            m = n / 100;
            for (int i = 1; i <= m; i++)
                s = "Googol " + s;
            n %= 100;
        }
        if (n >= 30) {
            m = n / 30;
            for (int i = 1; i <= m; i++)
                s = "Nonillion " + s;
            n %= 30;
        }
        if (n >= 21) {
            m = n / 21;
            for (int i = 1; i <= m; i++)
                s = "Sexitillion " + s;
            n %= 21;
        }
        if (n >= 18) {
            m = n / 18;
            for (int i = 1; i <= m; i++)
                s = "Quintillion " + s;
            n %= 18;
        }
        if (n >= 15) {
            m = n / 15;
            for (int i = 1; i <= m; i++)
                s = "Quadrillion " + s;
            n %= 15;
        }
        if (n >= 12) {
            m = n / 12;
            for (int i = 1; i <= m; i++)
                s = "Trillion " + s;
            n %= 12;
        }
        if (n >= 9) {
            m = n / 9;
            for (int i = 1; i <= m; i++)
                s = "Billion " + s;
            n %= 9;
        }
        if (n >= 6) {
            m = n / 6;
            for (int i = 1; i <= m; i++)
                s = "Million " + s;
            n %= 6;
        }
        if (n >= 3) {
            m = n / 3;
            for (int i = 1; i <= m; i++)
                s = "Thousend " + s;
            n %= 3;
        }
        if (n == 2) {
            s = "Houndred " + s;
        }
        if (n == 1) {
            s = "Ten " + s;
        }
        if (n == 0) {
            s = "One " + s;
        }
        showView.setText(s);
    }
}
