package com.pgs.bazted.aatutorial.usual.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.pgs.bazted.aatutorial.R;
import com.pgs.bazted.aatutorial.usual.activity.ChildActivityWithExtra_;
import com.pgs.bazted.aatutorial.usual.app.AndAApplication;
import com.pgs.bazted.db.Message;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
@EFragment(R.layout.fragment_main)
public class PlaceholderFragment extends Fragment {

    @App
    AndAApplication andAApplication;

    @FragmentArg
    String place;

    @ViewById(R.id.text_view)
    TextView textView;

    public PlaceholderFragment() {

    }


    @AfterViews
    void start() {
        if (!TextUtils.isEmpty(place)) {
            textView.setText(place);
        }
    }


    @Click(R.id.text_view)
    void textCLicked() {
        startActivity(
                ChildActivityWithExtra_.intent(this)
                        .childExtraKey("child")
                        .timestamp(System.currentTimeMillis())
                        .get()
        );
    }


}