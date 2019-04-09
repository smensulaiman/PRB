package com.mini.solaiman.policedhara.DBHelper;

/**
 * Created by Solaiman on 28-Feb-18.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "DBook.db";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void forceDatabaseReload(Context context){
        MyDatabase dbHelper = new MyDatabase(context);
        dbHelper.setForcedUpgradeVersion(DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.setVersion(-1);
        db.close();
        db = dbHelper.getWritableDatabase();
    }

    private void openDB() throws Exception{
        db = getReadableDatabase();
    }

    public List<String> getAllBooks(int i) {
        List<String> booklist = new ArrayList<String>();
        try {
            openDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select * from BookDetails where PART = 1";
        Cursor cr = db.rawQuery(sql,null);

        boolean check = true;

        if(cr != null && cr.getCount()>0){
            cr.moveToFirst();
            while (check){
                booklist.add(cr.getString(cr.getColumnIndex("CHAPTERS")));
                check = cr.moveToNext();
            }
        }
        cr.close();
        db.close();
        return booklist;
    }
    public List<String> getPart(String part) {
        List<String> partList = new ArrayList<String>();
        try {
            openDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select name from "+part;
        Cursor cr = db.rawQuery(sql,null);

        boolean check = true;

        if(cr != null && cr.getCount()>0){
            cr.moveToFirst();
            while (check){
                partList.add(cr.getString(cr.getColumnIndex("name")));
                check = cr.moveToNext();
            }
        }
        sql = "select name from parttwo";
        cr = db.rawQuery(sql,null);

        check = true;

        if(cr != null && cr.getCount()>0){
            cr.moveToFirst();
            while (check){
                partList.add(cr.getString(cr.getColumnIndex("name")));
                check = cr.moveToNext();
            }
        }
        cr.close();
        db.close();
        return partList;
    }

    public ArrayList<String> getSearch() {
        ArrayList<String> partList=new ArrayList<>();
        try {
            openDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select CHAPTERS from BookDetails";
        Cursor cr = db.rawQuery(sql,null);

        boolean check = true;

        if(cr != null && cr.getCount()>0){
            cr.moveToFirst();
            while (check){
                partList.add(cr.getString(cr.getColumnIndex("CHAPTERS")));
                check = cr.moveToNext();
            }
        }
        cr.close();
        db.close();
        return partList;
    }

    String text;
    public String getDescb(String chapter,String des) {

        try {
            openDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select * from BookDetails where CHAPTERS =\'"+chapter+"\'";
        Cursor cr = db.rawQuery(sql,null);

        if(cr != null && cr.moveToFirst()){
            text = cr.getString(cr.getColumnIndex(des));
            cr.close();
        }else{
            text = sql;
                    }
        cr.close();
        db.close();

        return text;
    }

    public List<String> getThird(String a){

        String [] pattern =  a.split("-");
        String queryPattern = null;
        int i =  Integer.parseInt(pattern[0]);
        int j =  Integer.parseInt(pattern[1]);
        queryPattern = String.valueOf(i);
        for(int x =  i+1 ; x<=j ; x++){
          queryPattern +=" or ID = "+String.valueOf(x);
        }
        List<String>thirdList =  new ArrayList<>();
        try{
            openDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        String query = "select CHAPTERS from BookDetails where ID ="+queryPattern;
        Cursor cr = db.rawQuery(query,null);
        cr.moveToFirst();
        boolean check = true;
        if(cr != null && cr.getCount()>0){

            while(check){
                if(cr.getString(cr.getColumnIndex("CHAPTERS"))!=null) {
                    thirdList.add(cr.getString(cr.getColumnIndex("CHAPTERS")));
                }
                check=cr.moveToNext();
            }
        }else{
            thirdList.add("your query is: "+query);
        }
        return thirdList;
    }

    public List<String> getPro(String posk,String poso,String obj) {
        List<String> proList = new ArrayList<String>();
        try {
            openDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select "+obj+" from BookDetails where PART =\'"+posk+"\' and ODD ='"+poso+"\'";
        Cursor cr = db.rawQuery(sql,null);

        boolean check = true;
        if(cr != null && cr.getCount()>0){
            cr.moveToFirst();
            while (check){
                proList.add(cr.getString(cr.getColumnIndex(obj)));
                check = cr.moveToNext();
            }
        }else{
            proList.add(sql);
        }
        cr.close();
        db.close();

        return proList;
    }

}