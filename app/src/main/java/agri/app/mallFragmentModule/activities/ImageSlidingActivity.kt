package agri.app.mallFragmentModule.activities

import agri.app.R
import agri.app.Utili.constants.INTENT_FLAGS.ITEM_POSITION
import android.content.Context
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import kotlinx.android.synthetic.main.activity_image_sliding.*
import kotlinx.android.synthetic.main.layout_common_toolbar.*
import kotlinx.android.synthetic.main.layout_image_full_screen.view.*
import java.util.ArrayList


class ImageSlidingActivity :AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
       when(v?.id){
          R.id.imgToolbarHome ->{
              onBackPressed()
          }
        }
    }


    var productImagesArrayList=ArrayList<Int>()
     var position:Int=0



    companion object {
        var NUM_PAGES = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_sliding)
        getDataFromIntent()

    }

    private fun getDataFromIntent() {
        var intent =intent
        //productImagesArrayList = intent.getStringArrayListExtra(PARCELABLE_OBJECT)
        position= intent.getIntExtra(ITEM_POSITION,0)

        productImagesArrayList.add(R.drawable.pgr)
        productImagesArrayList.add(R.drawable.seed)
        productImagesArrayList.add(R.drawable.fertilizer)

        initalization()

    }

    private fun initalization() {
        imgToolbarHome.setOnClickListener(this)
        viewpager.adapter = ImageSliderAdapter(this, productImagesArrayList,position)
       NUM_PAGES = productImagesArrayList!!.size

        if(NUM_PAGES ==1){
            tabIndicator.setupWithViewPager(null, true)
        }else{
            tabIndicator.setupWithViewPager(viewpager, true)
        }

        val tab = tabIndicator.getTabAt(position)
        tab?.select()
    }


}

internal class ImageSliderAdapter(private val context: Context, private val imageModelArrayList: ArrayList<Int>,var selectedPosition:Int) :
    PagerAdapter() {

    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.layout_image_full_screen, null)

     /*   var imageModelUrl = imageModelArrayList.get(position)

        Glide.with(context)
            .load(imageModelUrl)
            .apply(RequestOptions())
            .into(view.imgFullScreen)*/

        view.imgFullScreen.setImageResource(imageModelArrayList.get(position))

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }


}
