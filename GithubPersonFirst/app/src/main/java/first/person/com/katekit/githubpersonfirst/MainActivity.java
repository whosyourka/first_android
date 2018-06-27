package first.person.com.katekit.githubpersonfirst;

import android.app.Activity;
import android.os.Bundle;

import com.katekit.common.util.log.LogUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        LogUtil.d("haha");
        LogUtil.d("hehe");
        LogUtil.d("lala");
        LogUtil.d("gaga");
    }


}
