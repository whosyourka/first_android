package first.person.com.katekit.githubpersonfirst.main

import android.os.Bundle
import android.view.View
import com.katekit.common.acitivity.BaseActivity
import first.person.com.katekit.githubpersonfirst.R

/**
 *   Created by HMC on 2018/7/20
 */
class SecondMainActivity : BaseActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        findViewById<View>(R.id.button).setOnClickListener {
            finish()
        }
        finish()

    }
}