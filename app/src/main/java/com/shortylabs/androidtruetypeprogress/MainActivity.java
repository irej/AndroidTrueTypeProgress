package com.shortylabs.androidtruetypeprogress;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mSnowBtn;
    public static final String IS_SNOWING = "mIsSnowing";
    public static final String SNOW_PROGRESS_FRAGMENT = "snowProgressFragment";
    private boolean mIsSnowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSnowBtn = (Button) findViewById(R.id.snow_button);
        mSnowBtn.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_SNOWING, mIsSnowing);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mIsSnowing = savedInstanceState.getBoolean(IS_SNOWING);
        if (mIsSnowing) {
            showProgress();
            snow();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //**********************************************************************************************
    // implement View.OnClickListener

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.snow_button:
                // pseudo snow
                showProgress();
                snow();
                break;
        }

    }

    private void snow() {
        mIsSnowing = true;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                stopSnow();
            }
        }, 10000);


    }

    private void stopSnow() {
        mIsSnowing = false;
        hideProgress();
    }


    //*********************************************************************************************

    public void showProgress() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag(SNOW_PROGRESS_FRAGMENT);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = new ProgressDialogFragment();
        newFragment.show(ft, SNOW_PROGRESS_FRAGMENT);
    }

    public void hideProgress() {

        DialogFragment dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag(
                SNOW_PROGRESS_FRAGMENT);
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }

    }
}
