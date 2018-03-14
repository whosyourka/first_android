package first.person.com.katekit.githubpersonfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.katekit.common.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.test);
        textView.setOnClickListener(v -> {
            ToastUtil.show(this,"haha");
        });
    }
}
