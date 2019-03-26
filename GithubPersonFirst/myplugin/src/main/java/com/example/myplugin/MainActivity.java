package com.example.myplugin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myplugin.aspectj.IFirstAnnotation;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aspectClick(null);
        bundle12(null);
    }


    @IFirstAnnotation("测试Aspect")
    public void aspectClick(View view) {
        System.out.println("aspectClick");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @IFirstAnnotation("测试Aspect")
    public void bundle12(Bundle view) {
        System.out.println("Bundle");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
