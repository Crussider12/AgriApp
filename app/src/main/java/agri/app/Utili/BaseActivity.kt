package agri.app.Utili

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

abstract class BaseActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_base)

    }
    abstract fun setToolBar(name:String)

}
