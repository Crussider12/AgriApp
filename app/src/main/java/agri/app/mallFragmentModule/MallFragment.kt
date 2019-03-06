package agri.app.mallFragmentModule

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import agri.app.Adapter.MallAdapters.MallCategoryAdapter


import agri.app.R
import agri.app.Utili.BaseFragment
import agri.app.eventListner.ItemClickListner
import android.support.v7.widget.*
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MallFragment : BaseFragment(), ItemClickListner {
    override fun onClick(v: View?) {

    }


    lateinit var mContext: Context
    var categoryList = ArrayList<String>()
    lateinit var mallCategoryAdapter:MallCategoryAdapter
    lateinit var gridviewOfCategory:RecyclerView
    lateinit var itemClickListner: ItemClickListner

    override fun itemClickListner(position: Int) {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val productListFragment = MallProductListFragment()
        fragmentTransaction.replace(R.id.fragment_container, productListFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(agri.app.R.layout.fragment_mall, container, false)
        initView(view)
        return view

    }


    fun initView(view:View) {
        mContext = this!!.activity!!

        setToolBar("Mall",view)
        gridviewOfCategory = view.findViewById(R.id.gridviewOfCategory)

        itemClickListner  =this

        mallCategoryAdapter = MallCategoryAdapter(categoryList,mContext,itemClickListner)
        val mLayoutManager =  GridLayoutManager(mContext,2);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gridviewOfCategory.setLayoutManager(mLayoutManager);
        gridviewOfCategory.setItemAnimator( DefaultItemAnimator());
        gridviewOfCategory.setAdapter(mallCategoryAdapter)


    }



    companion object {

        fun newInstance(): MallFragment {
            return MallFragment()
        }
    }

    override fun setToolBar(name: String,view:View) {
        (activity as AppCompatActivity).supportActionBar!!.show()
        activity?.navigation?.visibility = View.VISIBLE
        (activity as AppCompatActivity).supportActionBar!!.title = name
    }

}
