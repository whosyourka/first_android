package first.person.com.katekit.githubpersonfirst.anko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.katekit.common.util.ToastUtil
import first.person.com.katekit.githubpersonfirst.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AnkoFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_anko_first)

//        UI {
//            editText {
//                hint = "Name"
//            }
//        }？？？？？？？？？？？？？？？？？？


//        val ID_OK = 1
//        relativeLayout {
//            button("Ok") {
//                id = ID_OK
//            }.lparams { alignParentTop() }
//
//            button("Cancel").lparams { below(ID_OK) }
//        }
        MyActivityUI().setContentView(this)

    }
}

class MyActivityUI : AnkoComponent<AnkoFirstActivity> {
    override fun createView(ui: AnkoContext<AnkoFirstActivity>) = with(ui) {
        verticalLayout {
//            include<View>(R.layout.something) {
//                backgroundColor = Color.RED
//            }.lparams(width = matchParent) { margin = dip(12) }
            padding = dip(100)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hintResource = R.string.app_name
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
            }.lparams(width = wrapContent, height = wrapContent) {

                topMargin = dip(R.dimen.activity_horizontal_margin)
                bottomMargin = dip(30)
                setPadding(0, 0, 20, 20)
            }
            themedButton("hahaha", theme = R.style.myTheme) {
                onClick {
                    //                    ToastUtil.show(this@AnkoFirstActivity,"haha")
                    ToastUtil.show(ctx, "haha")
                }
            }

        }
    }
}
