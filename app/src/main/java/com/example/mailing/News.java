package com.example.mailing;

import java.util.Date;
import java.util.UUID;

public class News {
    private UUID mId;
    private String mTitle;
    private String mContent;
    private Date mDate;
    private Boolean mPassed;


    public News() {
        // Генерирование уникального идентификатора
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public String toString() {
        return mTitle;
    }


    public UUID getId() {
        return mId;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }


    public Boolean getPassed() {
        return mPassed;
    }

    public void setPassed(Boolean passed) {
        mPassed = passed;
    }
}
