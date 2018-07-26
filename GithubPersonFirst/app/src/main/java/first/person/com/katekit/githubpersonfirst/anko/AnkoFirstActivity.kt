package first.person.com.katekit.githubpersonfirst.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.katekit.common.util.ToastUtil
import first.person.com.katekit.githubpersonfirst.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AnkoFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    private var btnLogin: Button? = null
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
            btnLogin = button("Login") {
                textSize = 26f
            }.lparams(width = matchParent, height = wrapContent) {
                topMargin = dip(10)
                bottomMargin = dip(30)
            }
            themedButton("hahaha", theme = R.style.myTheme) {
                onClick {
                    //                    ToastUtil.show(this@AnkoFirstActivity,"haha")
                    ToastUtil.show(ctx, "haha")
                    btnLogin?.text = "啦啦啦"
                }
            }


        }
    }
}
