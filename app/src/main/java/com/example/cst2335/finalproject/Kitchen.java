package com.example.cst2335.finalproject;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Kitchen extends AppCompatActivity {

    private KitchenMainFragment ambient_fragment;
    private KitchenMainFragment fragment2;
    boolean fragmentAdded = false;
    public static final String FRAGMENT_TAG = "fragment_tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);


        ambient_fragment = new KitchenMainFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
                transaction
                .add(R.id.fragment_container, ambient_fragment, "AMBIENT_FRAGMENT")
                .commit();
    }




    public void ambientHandler(View view) {
    }

    public void applianceHandler(View view) {
    }

    public void groceryHandler(View view) {
    }

    public void emergencyHandler(View view) {
    }

    public void dineOutHandler(View view) {
    }

    public void userSettingHandler(View view) {
    }

    public void newApplianceHandler(View view) {
    }
}
