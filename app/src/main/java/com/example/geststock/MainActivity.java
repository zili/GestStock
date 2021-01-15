package com.example.geststock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.geststock.model.MyDBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDBHelper db = new MyDBHelper(this);
/*      db.insertArticle("Pain");
        db.insertArticle("Lait");*/
        List<String> lst = db.getAllArticles();
        lst.forEach(l -> Log.i("GEST-STK", l));
    }
}