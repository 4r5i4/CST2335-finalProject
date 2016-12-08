package com.example.cst2335.finalproject;

import android.content.Intent;
import android.net.Uri;
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
    String emergency = "911";

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
        Intent ambientSettingIntent = new Intent(this, AmbianceSettingScrollingActivity.class);
        startActivity(ambientSettingIntent);
    }

    public void applianceHandler(View view) {
        Intent ambientSettingIntent = new Intent(this, ApplianceActivity.class);
        startActivity(ambientSettingIntent);
    }

    public void groceryHandler(View view) {
        Intent ambientSettingIntent = new Intent(this, GroceryActivity.class);
        startActivity(ambientSettingIntent);
    }

    public void emergencyHandler(View view) {
        String uri = "tel:" + emergency.trim() ;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void dineOutHandler(View view) {
        Intent ambientSettingIntent = new Intent(this, DineOutActivity.class);
        startActivity(ambientSettingIntent);
    }

    public void userSettingHandler(View view) {
        Intent ambientSettingIntent = new Intent(this, UserSettingActivity.class);
        startActivity(ambientSettingIntent);
    }

    public void newApplianceHandler(View view) {
        Intent ambientSettingIntent = new Intent(this, NewApplianceActivity.class);
        startActivity(ambientSettingIntent);
    }
}
