package com.pgs.bazted.aatutorial.usual.activity;

import com.j256.ormlite.dao.Dao;
import com.pgs.bazted.aatutorial.db.DatabaseHelper;
import com.pgs.bazted.db.Message;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

/**
 * Created by bazted on 05/11/14.
 */
@EBean
public class OurBean {


    @OrmLiteDao(helper = DatabaseHelper.class, model = Message.class)
    Dao<Message, Long> dao;


}
