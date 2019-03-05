package com.app.categorywiseproductlistplug.adapters


import agri.app.R
import agri.app.eventListner.ItemClickListner
import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.backgroundDrawable


class RecyclerViewHorizontalListAdapter(
    private val productSizesList: List<String>,
    internal var context: Context, var itemClickListener: ItemClickListner
) : RecyclerView.Adapter<RecyclerViewHorizontalListAdapter.MyViewHolder>() {

    var selectedPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val groceryProductView =
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_list_size_item, parent, false)
        return MyViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtview.setText(productSizesList[position])

            if (selectedPosition == position) {
                holder.txtview.setTextColor(context.resources.getColor(R.color.colorWhite))
                holder.itemView.backgroundDrawable =
                    context.resources.getDrawable(R.drawable.button_background_reg)
            } else {
                holder.txtview.setTextColor(context.resources.getColor(R.color.colorPrimary))
                holder.itemView.backgroundDrawable =
                    context.resources.getDrawable(R.drawable.button_border)
            }

    }

    override fun getItemCount(): Int {
        return productSizesList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        internal var txtview: TextView

        override fun onClick(v: View?) {

            selectedPosition = adapterPosition
            notifyDataSetChanged()
            itemClickListener.itemClickListner(position)

        }

        init {
            txtview = view.findViewById(R.id.textView)
            itemView.setOnClickListener(this)
        }
    }
}