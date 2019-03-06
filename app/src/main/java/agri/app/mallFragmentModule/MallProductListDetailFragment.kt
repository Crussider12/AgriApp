package agri.app.mallFragmentModule

import agri.app.Adapter.MallAdapters.SliderAdapter
import agri.app.R
import agri.app.Utili.BaseFragment
import agri.app.eventListner.ItemClickListner
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.app.categorywiseproductlistplug.adapters.RecyclerViewHorizontalListAdapter
import kotlinx.android.synthetic.main.activity_image_sliding.*
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_common_toolbar.*
import kotlinx.android.synthetic.main.layout_common_toolbar.view.*

class MallProductListDetailFragment :BaseFragment(), ItemClickListner {
    override fun setToolBar(name: String, view: View) {
        (activity as AppCompatActivity).supportActionBar!!.hide()
        activity?.navigation?.visibility = View.GONE
        view.imgToolbarHome?.setOnClickListener(this)
        view.txtToolbarTitle.text =name
    }


    lateinit var viewPager: ViewPager
    lateinit var tabIndicator: TabLayout
    lateinit var nestedScrolProductDetail: NestedScrollView
    lateinit var webViewDescription: WebView
    lateinit var horizontalListAdapter: RecyclerViewHorizontalListAdapter
    var productSizeArrayList = ArrayList<String>()
    lateinit var recyclerviewHorizontalView: RecyclerView
    var productImages = ArrayList<Int>()


    var webData = "<!DOCTYPE html><head> <meta http-equiv=\"Content-Type\" " +
            "content=\"text/html; charset=utf-8\"> <html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1250\">" +
            "<meta name=\"spanish press\" content=\"spain, spanish newspaper, news,economy,politics,sports\"><title></title></head><body id=\"body\">" +
            "<script src=\"http://www.myscript.com/a\"></script>Vegetables are parts of plants that are consumed by humans or other animals as food. The original meaning is still commonly used and is applied to plants collectively to refer to all edible plant matter, including the flowers, fruits, stems, leaves, roots, and seeds. The alternate definition of the term vegetable is applied somewhat arbitrarily, often by culinary and cultural tradition. It may exclude foods derived from some plants that are fruits, nuts, and cereal grains, but include fruits from others such as tomatoes and courgettes and seeds such as pulses.\n" +
            "\n" +
            "Originally, vegetables were collected from the wild by hunter-gatherers and entered cultivation in several parts of the world, probably during the period 10,000 BC to 7,000 BC, when a new agricultural way of life developed. At first, plants which grew locally would have been cultivated, but as time went on, trade brought exotic crops from elsewhere to add to domestic types. Nowadays, most vegetables are grown all over the world as climate permits, and crops may be cultivated in protected environments in less suitable locations</body></html>"


    lateinit var itemClickListner: ItemClickListner
    lateinit var mContext: Context
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val itemView = inflater.inflate(R.layout.fragment_mall_product_list_detail, container, false)
        initView(itemView)

        return itemView
    }

    private fun initView(itemView: View) {
        mContext = this!!.activity!!
        itemClickListner = this

        setToolBar("Mall",itemView)


        viewPager = itemView.findViewById(R.id.viewPager)
        tabIndicator = itemView.findViewById(R.id.indicator)
        nestedScrolProductDetail = itemView.findViewById(R.id.nestedScrolProductDetail)
        webViewDescription = itemView.findViewById(R.id.webViewDescription)
        recyclerviewHorizontalView = itemView.findViewById(R.id.recyclerviewHorizontalView)
        imgToolbarHome?.setOnClickListener(this)

        val webSettings = webViewDescription.getSettings()
        webSettings.setJavaScriptEnabled(true)

        webViewDescription.loadData(webData, "text/html", "UTF-8");
        webViewDescription.isVerticalScrollBarEnabled = false
        webViewDescription.isHorizontalScrollBarEnabled = false

        productImages.add(R.drawable.pgr)
        productImages.add(R.drawable.seed)
        productImages.add(R.drawable.fertilizer)

        NUM_PAGES = productSizeArrayList.size

        /* tabIndicator.setupWithViewPager(viewpager, true)*/

        if (NUM_PAGES == 1) {
            tabIndicator.setupWithViewPager(null, true)
        } else {
            tabIndicator.setupWithViewPager(viewpager, true)
        }


        productSizeArrayList.add("200 gms")
        productSizeArrayList.add("300 gms")
        productSizeArrayList.add("600 gms")
        productSizeArrayList.add("700 gms")
        productSizeArrayList.add("900 gms")


        viewPager.adapter = SliderAdapter(mContext, productImages)

        horizontalListAdapter =
                RecyclerViewHorizontalListAdapter(productSizeArrayList, mContext, itemClickListner)
        val horizontalLayoutManager =
                LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontalView.layoutManager = horizontalLayoutManager
        recyclerviewHorizontalView.adapter = horizontalListAdapter

    }

    companion object {

        fun newInstance(): MallProductListDetailFragment {
            return MallProductListDetailFragment()
        }

        var NUM_PAGES = 0
    }

    override fun itemClickListner(position: Int) {

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.imgToolbarHome->{
                 if (getFragmentManager()!!.getBackStackEntryCount()>0)
                    getFragmentManager()?.popBackStack();

            }


        }

    }


}
