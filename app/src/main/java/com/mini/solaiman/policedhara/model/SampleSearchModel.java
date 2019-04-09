package com.mini.solaiman.policedhara.model;

import ir.mirrajabi.searchdialog.core.Searchable;

/**
 * Created by Solaiman on 22-Mar-18.
 */

public class SampleSearchModel implements Searchable {
    private String mTitle;

    public SampleSearchModel(String title) {
        mTitle = title;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public SampleSearchModel setTitle(String title) {
        mTitle = title;
        return this;
    }
}