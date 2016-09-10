package com.joanna.alexandria;

import java.sql.Timestamp;

/**
 * Created by Joanna on 16-09-10.
 */
public class Book {
    private String mTitle;
    private String mAuthor;
    private String mOwner;
    private Timestamp mAdded;

    public Book(String title, String author, String owner, Timestamp added) {
        mTitle = title;
        mAuthor = author;
        mOwner = owner;
        mAdded = added;
    }
}
