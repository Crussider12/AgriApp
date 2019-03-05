package agri.app.Adapter.MallAdapters

import agri.app.R
import agri.app.eventListner.ItemClickListner
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*


class MallCategoryAdapter(val items: ArrayList<String>, val context: Context?, var clickListner: ItemClickListner) : RecyclerView.Adapter<MallCategoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MallCategoryAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.mall_category_group_item_, p0, false))
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: MallCategoryAdapter.MyViewHolder, p1: Int) {

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            var position = adapterPosition
            clickListner.itemClickListner(position)

        }

        init {
            itemView.setOnClickListener(this)
        }

    }

}

/*
class MallCategoryAdapter(val items : ArrayList<String>, val context: Context?,itemClickListner:ItemClickListner) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        //return items.size
        return 20
    }
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mall_category_group_item_, p0, false))
    }
    override fun onBindViewHolder(p0: ViewHolder, position: Int) {

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
    override fun onClick(v: View?) {
        var position =adapterPosition

    }
    // Holds the TextView that will add each animal to
    //val tvAnimalType = view.tv_animal_type
}*/
