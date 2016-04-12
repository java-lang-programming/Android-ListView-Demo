package com.java_lang_programming.android_listview_demo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.java_lang_programming.android_listview_demo.R;

public class ListViewActivity extends AppCompatActivity {

    public final static String PRESENTER_TAG = "Presenter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();

        ListViewFragment itemFragment = (ListViewFragment) fragmentManager.findFragmentById(R.id.list_view_frag);
        if (itemFragment == null) {
            //Create, set up and add the presenter.
//            presenter = new PresenterFragmentImpl();
//            setUpPresenter(presenter, fragmentManager, updatableViewResId, model, queries, actions);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(itemFragment, PRESENTER_TAG);
            fragmentTransaction.commit();
        } else {
            //Set up the presenter.
            // setUpPresenter(presenter, fragmentManager, updatableViewResId, model, queries, actions);
        }
    }

}
