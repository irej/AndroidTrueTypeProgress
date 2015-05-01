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
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mLoginBtn;
    public static final String LOGIN_PROGRESS_FRAGMENT = "loginProgressFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginBtn = (Button) findViewById(R.id.login_button);
        mLoginBtn.setOnClickListener(this);
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
            case R.id.login_button:
                // pseudo login
                showProgress();
                login();
                break;
        }

    }

    private void login() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                loginSuccess();
            }
        }, 10000);


    }

    private void loginSuccess() {
        hideProgress();
        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_LONG).show();
    }


    //*********************************************************************************************

    public void showProgress() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag(LOGIN_PROGRESS_FRAGMENT);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = new ProgressDialogFragment();
        newFragment.show(ft, LOGIN_PROGRESS_FRAGMENT);
    }

    public void hideProgress() {

        DialogFragment dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag(
                LOGIN_PROGRESS_FRAGMENT);
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }

    }
}
