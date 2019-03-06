package agri.app.Utili

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

 abstract class BaseFragment: Fragment(),View.OnClickListener{

 abstract fun setToolBar(name:String,view:View)


}