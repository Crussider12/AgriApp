package agri.app.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import agri.app.R;

public class MandiDetailsAdapter extends RecyclerView.Adapter<MandiDetailsAdapter.ViewHolder> {

    private static final String TAG = "MandiDetailsAdapter";

    private ArrayList<String> data = new ArrayList<>();
    private Context context;

    public MandiDetailsAdapter(Context context, ArrayList<String> data) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_mandi_item_detail, viewGroup, false);

        //viewholder object
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        // important as defines most of ui here

    }

    @Override
    public int getItemCount() {

        //important to set size
        return 20;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}