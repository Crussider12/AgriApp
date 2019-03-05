package agri.app.Adapter.MandiFragmentAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import agri.app.mandiFragmentModule.MandiFragment;
import agri.app.R;

public class RecyclerViewMandiDetailCard extends RecyclerView.Adapter<RecyclerViewMandiDetailCard.ViewHolder> {

    private static final String TAG = "RecyclerViewMandiCard";

    private ArrayList<String> miImage;
    private ArrayList<String> miMandiName;
    private ArrayList<String> miMandiPrice;
    private ArrayList<String> miMandiDistance;
    private ArrayList<String> miMandiItemName;
    private MandiFragment micontext;
    public Boolean isScrolled = false;
    public Context context;

    public RecyclerViewMandiDetailCard(MandiFragment mcontext, ArrayList<String> mMandiName, ArrayList<String> mMandiPrice,
                                 ArrayList<String> mMandiDistance,ArrayList<String> mMandiItemName, ArrayList<String> mImage) {

        this.miImage = mImage;
        this.miMandiName = mMandiName;
        this.miMandiPrice = mMandiPrice;
        this.miMandiDistance = mMandiDistance;
        this.miMandiItemName = mMandiItemName;
        this.micontext = mcontext;
    }

    public void updateArrow(Boolean scroll) {
        isScrolled = scroll;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mandi_home_list_item, viewGroup, false);

        //viewholder object
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG, "onBindViewHolder: called");

        //getting image in image view widget


        Glide.with(micontext)
                .load(miImage.get(i))
                .apply(new RequestOptions().override(460, 460).fitCenter())
                .into(viewHolder.itemImage);

        //setting text
        viewHolder.mandiName.setText(miMandiName.get(i));
        viewHolder.mandiPrice.setText(miMandiPrice.get(i));
        viewHolder.mandiDistance.setText(miMandiDistance.get(i));
        viewHolder.mandiItemName.setText(miMandiItemName.get(i));

        //Setting what happens when clicked on name or image area
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "OnClick" + miImage.get(i));
            }
        });
    }


    @Override
    public int getItemCount() {
        //important to set size
        return miMandiName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Databinding

        ImageView itemImage;
        TextView mandiName, mandiPrice, mandiDistance, mandiItemName;
        CardView parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mandiItemName = itemView.findViewById(R.id.mandi_detail_item_name);
            itemImage = itemView.findViewById(R.id.mandi_detail_item_image);
            mandiName = itemView.findViewById(R.id.mandi_detail_item_mandi_name);
            mandiPrice = itemView.findViewById(R.id.mandi_detail_item_price);
            mandiDistance = itemView.findViewById(R.id.mandi_detail_item_dist);
            parent_layout = itemView.findViewById(R.id.mandi_detail_item_card);

        }
    }
}
