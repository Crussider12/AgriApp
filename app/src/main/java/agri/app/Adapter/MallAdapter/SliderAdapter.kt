package agri.app.Adapter.MallAdapters

import agri.app.R
import android.content.Context
import android.content.Intent
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import agri.app.mallFragmentModule.activities.ImageSlidingActivity
import agri.app.Utili.constants.INTENT_FLAGS.ITEM_POSITION
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_slider.view.*
import java.util.ArrayList

internal class SliderAdapter(private val context: Context, private val imageModelArrayList: ArrayList<Int>) :
    PagerAdapter() {

    override fun getCount(): Int {
        return imageModelArrayList.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_slider, null)

        var imageModelUrl = imageModelArrayList.get(position)

        Glide.with(context)
            .load(imageModelUrl)
            .apply(RequestOptions())
            .into(view.imageView)


        view.imageView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent(context, ImageSlidingActivity::class.java)
               // intent.putStringArrayListExtra(PARCELABLE_OBJECT,imageModelArrayList)
                intent.putExtra(ITEM_POSITION,position)
                context.startActivity(intent)

            }

        })

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
