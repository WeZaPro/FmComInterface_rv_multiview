package com.example.fmcominterface_rv_multiview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener{
    // set add Fragment
    // implement Interface
    // getData from Interface(Bundle) + setAgruments
    // replace FM

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    .commit();

            /*getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_bottom,fragmentB)
                    .commit();*/
        }
    }

    @Override
    public void myCallback(MyChidModel myChidModel) {

        FragmentB fragmentB = new FragmentB();
        Bundle b = new Bundle();
        b.putParcelable("key",myChidModel);
        fragmentB.setArguments(b);

        Toast.makeText(getApplicationContext(),"on MainActivity get data is ==> "+myChidModel.getCountryNames(),Toast.LENGTH_SHORT).show();

        getSupportFragmentManager()
                .beginTransaction()
                /*.replace(R.id.contentContainer_bottom,fragmentB)*/
                .replace(R.id.contentContainer_top,fragmentB)
                .addToBackStack("")
                .commit();

    }
}
