package agri.app.Adapter.MallAdapters

import agri.app.R
import agri.app.eventListner.ItemClickListner
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList


class MallProductListAdapter(val items: ArrayList<String>, val context: Context?, var clickListner: ItemClickListner) : RecyclerView.Adapter<MallProductListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MallProductListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.mall_product_list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: MallProductListAdapter.MyViewHolder, p1: Int) {

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            val position = adapterPosition
            clickListner.itemClickListner(position)

        }

        init {
            itemView.setOnClickListener(this)
        }

    }

}