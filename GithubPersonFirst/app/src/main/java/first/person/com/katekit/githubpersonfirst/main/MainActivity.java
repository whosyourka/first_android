package first.person.com.katekit.githubpersonfirst.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.katekit.common.acitivity.BaseActivity;
import com.katekit.common.util.log.LogUtil;

import first.person.com.katekit.githubpersonfirst.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondMainActivity.class));
                LogUtil.d("setOnClickListener");
            }
        });
        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtil.d("setOnTouchListener:"+event.getAction());
                return false;
            }
        });
    }


}
