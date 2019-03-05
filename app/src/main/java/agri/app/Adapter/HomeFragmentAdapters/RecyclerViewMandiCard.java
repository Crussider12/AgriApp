package agri.app.Adapter.HomeFragmentAdapters;

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

import agri.app.homeFragmentModule.HomeFragment;
import agri.app.R;
import agri.app.databinding.FragmentHomeBinding;


public class RecyclerViewMandiCard extends RecyclerView.Adapter<RecyclerViewMandiCard.ViewHolder> {

    private static final String TAG = "RecyclerViewMandiCard";

    private ArrayList<String> miImage;
    private ArrayList<String> miMandiName;
    private ArrayList<String> miMandiPrice;
    private ArrayList<String> miMandiDistance;
    private HomeFragment micontext;
    FragmentHomeBinding fragmentHomeBinding;
    public int dx;
    public Context context;

    public RecyclerViewMandiCard(HomeFragment mcontext, ArrayList<String> mMandiName, ArrayList<String> mMandiPrice,
                                 ArrayList<String> mMandiDistance, ArrayList<String> mImage) {

        this.miImage = mImage;
        this.miMandiName = mMandiName;
        this.miMandiPrice = mMandiPrice;
        this.miMandiDistance = mMandiDistance;
        this.micontext = mcontext;
    }

    public void updateArrow(int dX) {
        dx=dX;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.veg_card_item_home, viewGroup, false);

        //viewholder object
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG, "onBindViewHolder: called");
        if (i == miMandiName.size() - 1) {
            viewHolder.arrow_r.setVisibility(View.INVISIBLE);
        } else if (i == 0) {
            viewHolder.arrow_l.setVisibility(View.INVISIBLE);
//        } else if (dx > 0 && viewHolder.arrow_l.getVisibility()==View.VISIBLE && viewHolder.arrow_r.getVisibility()==View.VISIBLE) {
//            viewHolder.arrow_l.setVisibility(View.INVISIBLE);
//            viewHolder.arrow_r.setVisibility(View.INVISIBLE);
//
//        }else if(dx < 0 && viewHolder.arrow_l.getVisibility()!=View.VISIBLE && viewHolder.arrow_r.getVisibility()!=View.VISIBLE){
//            viewHolder.arrow_l.setVisibility(View.VISIBLE);
//            viewHolder.arrow_r.setVisibility(View.VISIBLE);
//
//        }
//        else if (dx > 0 && viewHolder.arrow_l.getVisibility()==View.INVISIBLE && viewHolder.arrow_r.getVisibility()==View.INVISIBLE) {
//            viewHolder.arrow_l.setVisibility(View.INVISIBLE);
//            viewHolder.arrow_r.setVisibility(View.INVISIBLE);
//
//        }else if(dx < 0 && viewHolder.arrow_l.getVisibility()!=View.INVISIBLE && viewHolder.arrow_r.getVisibility()!=View.INVISIBLE){
//            viewHolder.arrow_l.setVisibility(View.VISIBLE);
//            viewHolder.arrow_r.setVisibility(View.VISIBLE);
//
//        }else {
        }else{
            viewHolder.arrow_l.setVisibility(View.VISIBLE);
            viewHolder.arrow_r.setVisibility(View.VISIBLE);
        }

        //getting image in image view widget


        Glide.with(micontext)
                .load(miImage.get(i))
                .apply(new RequestOptions().override(460, 460).fitCenter())
                .into(viewHolder.itemImage);

        //setting text
        viewHolder.mandiName.setText(miMandiName.get(i));
        viewHolder.mandiPrice.setText(miMandiPrice.get(i));
        viewHolder.mandiDistance.setText(miMandiDistance.get(i));


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

        ImageView itemImage, arrow_r, arrow_l;
        TextView mandiName, mandiPrice, mandiDistance;
        CardView parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.mandi_item_image);
            mandiName = itemView.findViewById(R.id.mandi_item_name);
            mandiPrice = itemView.findViewById(R.id.mandi_item_price);
            mandiDistance = itemView.findViewById(R.id.mandi_item_dist);
            arrow_r = itemView.findViewById(R.id.mandi_card_arrow_right);
            arrow_l = itemView.findViewById(R.id.mandi_card_arrow_left);
            parent_layout = itemView.findViewById(R.id.mandi_home);

        }
    }
}
