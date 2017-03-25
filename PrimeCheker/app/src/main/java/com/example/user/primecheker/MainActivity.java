package com.example.user.primecheker;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText input;
    Button Check;
    TextView tvCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.editText1);
        Check=(Button)findViewById(R.id.button1);
        tvCheck=(TextView) findViewById(R.id.tvPrime);

        Check.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                double n = Double.parseDouble(input.getText().toString());
                int f = 0;



                for (int i = 2; i < n; i++)
                {
                    if (n % i == 0)
                        f = 1;
                }

                if (f == 0)
                {
                    tvCheck.setText("Prime Number");

                }else{
                    tvCheck.setText("Not Prime Number");

                }
            }});
    }

}