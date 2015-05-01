package com.shortylabs.androidtruetypeprogress;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;


/**
 */
public class ProgressDialogFragment extends DialogFragment {

    private TextView mIconTextView;


    public ProgressDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_progress_dialog, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // modal and no title bar
        setStyle(DialogFragment.STYLE_NORMAL | DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Translucent);
        setRetainInstance(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels / 2;

        Window window = getDialog().getWindow();
        window.setLayout(width, width);
        window.setGravity(Gravity.CENTER);


    }
}
