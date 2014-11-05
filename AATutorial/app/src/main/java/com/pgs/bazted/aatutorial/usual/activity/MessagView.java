package com.pgs.bazted.aatutorial.usual.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pgs.bazted.aatutorial.R;
import com.pgs.bazted.db.Message;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by bazted on 05/11/14.
 */
@EViewGroup(R.layout.view_message)
public class MessagView extends LinearLayout {

    @ViewById(R.id.position_tv)
    TextView posiTextView;

    @ViewById(R.id.message_tv)
    TextView message_tv;

    public MessagView(Context context) {
        super(context);
    }

    public MessagView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MessagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(Message message) {
        posiTextView.setText(message.getTitle());
        message_tv.setText(message.getMessage());
    }

}
