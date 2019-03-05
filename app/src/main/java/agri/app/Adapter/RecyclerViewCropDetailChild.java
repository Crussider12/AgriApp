package agri.app.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

import agri.app.R;

public class RecyclerViewCropDetailChild extends RecyclerView.Adapter<RecyclerViewCropDetailChild.CropChildViewHolder> {

    private static final String TAG = "RecyclerViewCropDetailC";


    private ArrayList<String> miReqItemName;
    private ArrayList<String> miReqItemQuantity;
    public Context micontext;

    public RecyclerViewCropDetailChild(Context mcontext, ArrayList<String> mReqItemName, ArrayList<String> mReqItemQuanity) {

        this.miReqItemName = mReqItemName;
        this.miReqItemQuantity = mReqItemQuanity;
        this.micontext = mcontext;
    }

    @NonNull
    @Override
    public CropChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_selected_item_detail_item_requirement, viewGroup, false);

        //viewholder object
        CropChildViewHolder holder = new CropChildViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final CropChildViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG, "onBindViewHolder: called");


        //setting text
        viewHolder.itemReqName.setText(miReqItemName.get(i));
        viewHolder.itemReqQuant.setText(miReqItemQuantity.get(i));

    }

    @Override
    public int getItemCount() {
        //important to set size
        return miReqItemName.size();
    }

    public class CropChildViewHolder extends RecyclerView.ViewHolder {

        //Databinding

        TextView itemReqName,  itemReqQuant;
        CardView parent_layout;

        public CropChildViewHolder(@NonNull View itemView) {
            super(itemView);

            itemReqName = itemView.findViewById(R.id.crop_item_req_name);
            itemReqQuant = itemView.findViewById(R.id.crop_item_req_quant);
            parent_layout = itemView.findViewById(R.id.crop_select_req);
        }
    }



}
