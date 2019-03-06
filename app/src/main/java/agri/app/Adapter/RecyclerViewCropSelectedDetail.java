package agri.app.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import agri.app.addCropFragmentModule.AddCropFragment;
import agri.app.R;

public class RecyclerViewCropSelectedDetail extends RecyclerView.Adapter<RecyclerViewCropSelectedDetail.CropViewHolder> {

    private static final String TAG = "RecyclerViewCropSelecte";

    private ArrayList<String> miImage;
    private ArrayList<String> miMandiName;
    private ArrayList<String> miMandiPrice;
    private ArrayList<String> miMandiDistance;
    private ArrayList<String> miMandiItemName;
    private AddCropFragment micontext;
    private ArrayList<String> miCropItemReqName;
    private ArrayList<String> miCropItemReqQuant;
    public Boolean isScrolled = false;
    public Context context;


    public RecyclerViewCropSelectedDetail(AddCropFragment mcontext, ArrayList<String> mMandiName, ArrayList<String> mMandiPrice,
                                          ArrayList<String> mMandiDistance, ArrayList<String> mMandiItemName, ArrayList<String> mImage,
                                          ArrayList<String> mCropItemReqName, ArrayList<String> mCropItemReqQuant) {

        this.miImage = mImage;
        this.miMandiName = mMandiName;
        this.miMandiPrice = mMandiPrice;
        this.miMandiDistance = mMandiDistance;
        this.miMandiItemName = mMandiItemName;
        this.miCropItemReqName = mCropItemReqName;
        this.miCropItemReqQuant = mCropItemReqQuant;
        this.micontext = mcontext;
    }

    @NonNull
    @Override
    public CropViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name


        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_selected_item_detail_item, viewGroup, false);

        //viewholder object
        CropViewHolder holder = new CropViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CropViewHolder viewHolder, final int i) {

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

        //Child Recycler View initialisation
        final RecyclerViewCropDetailChild cropDetailChildre = new RecyclerViewCropDetailChild(context, miCropItemReqName,
                miCropItemReqQuant);

        //These two for making one view on one row at a swipe time
        RecyclerView.LayoutManager linearLayoutManager = new GridLayoutManager(context, 2);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        viewHolder.recyclerView.setAdapter(cropDetailChildre);

        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder((Activity) v.getContext());

                alertDialog.setTitle("Details:");
                alertDialog.setMessage("Are you sure you want to delete this?");
                alertDialog.setIcon(R.drawable.ic_arrow_back);

                alertDialog.setPositiveButton(
                        "Delete",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do the stuff..
                            }
                        }
                );
            alertDialog.show();

                Log.d(TAG, "onClick: add");

            }
        });

        viewHolder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: cancel");

            }
        });
    }


    @Override
    public int getItemCount() {
        //important to set size
        return miMandiName.size();
    }

    public class CropViewHolder extends RecyclerView.ViewHolder {

        //Databinding

        ImageView itemImage;
        TextView mandiName, mandiPrice, mandiDistance, mandiItemName;
        CardView parent_layout;
        RecyclerView recyclerView;
        Button add, cancel;


        public CropViewHolder(@NonNull View itemView) {
            super(itemView);

            mandiItemName = itemView.findViewById(R.id.crop_selected_detail_item_name);
            itemImage = itemView.findViewById(R.id.crop_selected_detail_item_image);
            mandiName = itemView.findViewById(R.id.crop_selected_detail_item_fin_yi);
            mandiPrice = itemView.findViewById(R.id.crop_selected_detail_item_fin_rate);
            mandiDistance = itemView.findViewById(R.id.crop_selected_detail_item_fin_scale);
            parent_layout = itemView.findViewById(R.id.crop_selected_detail_item_card);
            recyclerView = itemView.findViewById(R.id.crop_selected_child_rec);
            cancel = itemView.findViewById(R.id.crop_selection_cancel);
            add = itemView.findViewById(R.id.crop_selection_add);
        }
    }


}
