package com.example.geststock.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(@Nullable Context context) {
        super(context, "GestStock", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table article (id integer primary key, libelle text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists article");
            onCreate(db);
    }

    public void insertArticle(String lib) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("libelle", lib);
        db.insert("article",null,cv);
    }
    public List<String> getAllArticles(){
       List<String> arts = new ArrayList<>();
       Cursor cur = getData();
       cur.moveToFirst();
       while (!cur.isAfterLast()){
           arts.add(cur.getString(0)+ " - "+ cur.getString(1) );
           cur.moveToNext();
       }
       return  arts;
    }

    private Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return  db.rawQuery("select * from article",null);
    }

}
