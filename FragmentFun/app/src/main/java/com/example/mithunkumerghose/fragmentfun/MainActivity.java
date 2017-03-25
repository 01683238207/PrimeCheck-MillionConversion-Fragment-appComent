package com.example.mithunkumerghose.fragmentfun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mithunkumerghose.fragmentfun.fragments.MainFragment;
import com.example.mithunkumerghose.fragmentfun.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button firstFrag, secondFrag;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFrag = (Button) findViewById(R.id.firstFragment);
        secondFrag = (Button) findViewById(R.id.secondFragment);

        firstFrag.setOnClickListener(this);
        secondFrag.setOnClickListener(this);

        fragment = new MainFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.firstFragment:
                fr.replace(R.id.fragment_container, new MainFragment())
                        .commit();
                break;
            case R.id.secondFragment:
                SecondFragment fragment = new SecondFragment();
                fr.replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            default:
                break;
        }
    }
}
