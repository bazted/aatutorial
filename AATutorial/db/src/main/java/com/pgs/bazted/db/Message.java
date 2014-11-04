package com.pgs.bazted.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


@DatabaseTable(tableName = "message")
public class Message implements Serializable {

    @Expose
    @DatabaseField(id = true)
    private long id;

    @Expose
    @SerializedName("test_date")
    @DatabaseField(dataType = DataType.DATE_LONG)
    private Date date;

    @Expose
    @DatabaseField
    private boolean isRead;

    @Expose
    @DatabaseField
    private String message;

    @Expose
    @DatabaseField
    private String title;


    public static Message generateDummy(int position) {
        final Calendar instance = Calendar.getInstance();
        final boolean isEven = position % 3 != 0;
        if (isEven) {
            instance.add(Calendar.HOUR_OF_DAY, -1 * position);
        } else {
            instance.add(Calendar.DAY_OF_MONTH, -1 * position);
        }
        Message message = new Message();
        message.setId(position);
        message.setMessage(isEven
                ? "Message text from position=" + position
                : "Long long long long long Message text from position=" + position);
        message.setRead(isEven);
        message.setTitle("Message title=" + position);
        message.setDate(instance.getTime());

        return message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", isRead=" + isRead +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}