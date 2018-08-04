package com.example.myplugin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mypluginannotations.MyAnnotations;
@MyAnnotations("haha")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testAnnotaions();

    }
    private void testAnnotaions() {
        System.out.println("testAnnotaions");
    }
}
