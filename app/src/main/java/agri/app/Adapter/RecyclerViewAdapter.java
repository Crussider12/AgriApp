package agri.app.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import agri.app.homeFragmentModule.HomeFragment;
import agri.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageName = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private HomeFragment mcontext;

    public RecyclerViewAdapter(HomeFragment mcontext, ArrayList<String> mImageName, ArrayList<String> mImages) {
        this.mImageName = mImageName;
        this.mImages = mImages;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.veg_list_item, viewGroup,false);

        //viewholder object
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG,"onBindViewHolder: called");

        //getting image in image view widget
        Glide.with(mcontext)
                .load(mImages.get(i))
                .into(viewHolder.circleImageView);

        //setting text
        viewHolder.imagename.setText(mImageName.get(i));


        //Setting what happens when clicked on name or image area
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"OnClick"+mImageName.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {

        //important to set size
        return mImageName.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView circleImageView;
        TextView imagename;
        CardView parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            circleImageView = itemView.findViewById(R.id.image);
            imagename = itemView.findViewById(R.id.image_name);
            parent_layout = itemView.findViewById(R.id.list_item);



        }
    }
}
