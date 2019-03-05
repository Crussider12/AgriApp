package agri.app.Adapter.CropHomeAdapter;

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

public class RecyclerViewCropDetailCard extends RecyclerView.Adapter<RecyclerViewCropDetailCard.ViewHolder>{

    private static final String TAG = "RecyclerViewCropDetailC";

    private ArrayList<String> miImage;
    private ArrayList<String> miCropName;
    private ArrayList<String> miCropFarmName;
    private ArrayList<String> miCropVariety;
    private ArrayList<String> miCropLandSize;
    private ArrayList<String> miCropSOD;
    private HomeFragment micontext;

    public int dx;
    public Context context;

    public RecyclerViewCropDetailCard(HomeFragment mcontext, ArrayList<String> mCropName, ArrayList<String> mCropFarmName,
                                 ArrayList<String> mCropVariety, ArrayList<String> mCropLandSize, ArrayList<String> mCropSOD, ArrayList<String> mImage) {

        this.miImage = mImage;
        this.miCropName = mCropName;
        this.miCropFarmName = mCropFarmName;
        this.miCropVariety = mCropVariety;
        this.miCropLandSize = mCropLandSize;
        this.miCropSOD = mCropSOD;
        this.micontext = mcontext;
    }

    public void updateArrow(int dX) {
        dx=dX;

      //  notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerViewCropDetailCard.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_item_list, viewGroup, false);

        //viewholder object
        RecyclerViewCropDetailCard.ViewHolder holder = new RecyclerViewCropDetailCard.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewCropDetailCard.ViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG, "onBindViewHolder: called");
        if (i == miCropName.size() - 1) {
            viewHolder.arrow_r.setVisibility(View.INVISIBLE);
        } else if (i == 0) {
            viewHolder.arrow_l.setVisibility(View.INVISIBLE);
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
        viewHolder.cropName.setText(miCropName.get(i));
        viewHolder.cropFarmName.setText(miCropFarmName.get(i));
        viewHolder.cropVariety.setText(miCropVariety.get(i));
        viewHolder.cropLandArea.setText(miCropLandSize.get(i));
        viewHolder.cropDateOfSow.setText(miCropSOD.get(i));


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
        return miCropName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Databinding

        ImageView itemImage, arrow_r, arrow_l;
        TextView cropName, cropFarmName, cropVariety, cropLandArea, cropDateOfSow;
        CardView parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.crop_item_image);
            cropName = itemView.findViewById(R.id.crop_item_name);
            cropFarmName = itemView.findViewById(R.id.crop_item_farm_name);
            cropVariety = itemView.findViewById(R.id.crop_item_variety);
            cropLandArea = itemView.findViewById(R.id.crop_item_area);
            cropDateOfSow = itemView.findViewById(R.id.crop_item_sod);
            arrow_r = itemView.findViewById(R.id.crop_card_arrow_right);
            arrow_l = itemView.findViewById(R.id.crop_card_arrow_left);
            parent_layout = itemView.findViewById(R.id.crop_home);

        }
    }



}
