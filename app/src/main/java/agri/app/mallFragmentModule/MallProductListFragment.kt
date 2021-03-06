package agri.app.mallFragmentModule

import agri.app.Adapter.MallAdapters.MallProductListAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import agri.app.R
import agri.app.Utili.BaseFragment
import agri.app.eventListner.ItemClickListner

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_common_toolbar.*
import kotlinx.android.synthetic.main.layout_common_toolbar.view.*
import java.util.ArrayList


class MallProductListFragment : BaseFragment(), ItemClickListner, View.OnClickListener {
    override fun setToolBar(name: String, view: View) {
        (activity as AppCompatActivity).supportActionBar!!.hide()
        activity?.navigation?.visibility = View.GONE
        view?.txtToolbarTitle.text = name
        view?.imgToolbarHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        when (v?.id) {
            R.id.imgToolbarHome -> {
                if (getFragmentManager()!!.getBackStackEntryCount() > 0)
                    getFragmentManager()?.popBackStack();

            }
        }
    }

    override fun itemClickListner(position: Int) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val productListDetailFragment = MallProductListDetailFragment()
        fragmentTransaction.replace(R.id.fragment_container, productListDetailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    var productList = ArrayList<String>()
    lateinit var mallProductListAdapter: MallProductListAdapter
    lateinit var gridViewProductList: RecyclerView
    lateinit var itemClickListner: ItemClickListner

    lateinit var mContext: Context
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var itemView = inflater.inflate(R.layout.fragment_mall_product_list, container, false)
        initView(itemView)

        return itemView
    }

    private fun initView(itemView: View) {
        mContext = this!!.activity!!


        setToolBar("Mall", itemView)
        gridViewProductList = itemView.findViewById(R.id.gridViewProductList)
        itemClickListner = this
        mallProductListAdapter = MallProductListAdapter(productList, mContext, itemClickListner)
        val mLayoutManager = GridLayoutManager(mContext, 2);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gridViewProductList.setLayoutManager(mLayoutManager);
        gridViewProductList.setItemAnimator(DefaultItemAnimator());
        gridViewProductList.setAdapter(mallProductListAdapter)


    }


    companion object {

        fun newInstance(): MallProductListFragment {
            return MallProductListFragment()
        }


    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
        activity?.navigation?.visibility = View.VISIBLE
        //  setNavigationVisibility(false);
    }
}
