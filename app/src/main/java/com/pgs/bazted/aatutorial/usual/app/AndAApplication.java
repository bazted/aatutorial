package com.pgs.bazted.aatutorial.usual.app;

import com.j256.ormlite.dao.Dao;
import com.pgs.bazted.aatutorial.db.DatabaseHelper;
import com.pgs.bazted.aatutorial.usual.prefs.AuthPrefs_;
import com.pgs.bazted.db.Message;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.sql.SQLException;

/**
 * Created by bazted on 04/11/14.
 */
@EApplication
public class AndAApplication extends android.app.Application {

    @OrmLiteDao(helper = DatabaseHelper.class, model = Message.class)
    Dao<Message, Long> dao;

    public Dao<Message, Long> getDao() {
        return dao;
    }

    @Pref
    AuthPrefs_ authPrefs;

    @Override
    public void onCreate() {
        super.onCreate();

        String s = authPrefs.token().get();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        try {
            Dao<Message, Long> dao = databaseHelper.getDao(Message.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
