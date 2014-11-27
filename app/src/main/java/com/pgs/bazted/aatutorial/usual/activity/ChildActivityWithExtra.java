package com.pgs.bazted.aatutorial.usual.activity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.pgs.bazted.aatutorial.usual.app.AndAApplication;
import com.pgs.bazted.db.Message;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazted on 04/11/14.
 */
@EActivity
public class ChildActivityWithExtra extends ListActivity {
    @Extra
    String childExtraKey;

    @Extra
    long timestamp;


    @NonConfigurationInstance
    @Bean
    OurBean bean;

    @InstanceState


    long InstanceStatetimestamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @App
    AndAApplication andAApplication;


    @AfterInject
    void start() {
        getFromDb();
    }


    @Background(delay = 1000, serial = "SERIAL")
    void getFromDb() {
        Dao<Message, Long> dao = andAApplication.getDao();
        List<Message> messages = new ArrayList<Message>();
        for (int i = 0; i < 15; i++) {
            Message message = Message.generateDummy(i);
            messages.add(message);

        }
        showMessages(messages);
    }

    @UiThread
    void updateProgress() {

    }

    @UiThread
    void showMessages(List<Message> messages) {
        setListAdapter(new MessageAdapter(messages, this));
    }


    @ItemClick(android.R.id.list)
    void list(Message message) {
        Toast.makeText(this, message.getMessage(), Toast.LENGTH_LONG).show();
    }

    public class MessageAdapter extends BaseAdapter {
        private final List<Message> messages;
        private final Context context;

        public MessageAdapter(List<Message> messages, Context context) {
            this.messages = messages;
            this.context = context;
        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Message getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessagView build;
            if (convertView == null) {
                build = MessagView_.build(context);
            } else {
                build = (MessagView) convertView;
            }
            build.bind(getItem(position));
            return build;
        }
    }

}
