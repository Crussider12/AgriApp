package agri.app.Adapter.WeatherFragmentAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import agri.app.R;
import agri.app.weatherFragmentModule.WeatherFragment;

public class RecyclerViewWeatherWindDay extends RecyclerView.Adapter<RecyclerViewWeatherWindDay.DayWindViewHolder> {
    private static final String TAG = "RecyclerViewWeatherDay";

    private ArrayList<String> mImageName = new ArrayList<>();
    private ArrayList<String> mDayTime = new ArrayList<>();
    private WeatherFragment mcontext;

    public RecyclerViewWeatherWindDay(WeatherFragment mcontext, ArrayList<String> mImageName, ArrayList<String> mImages) {
        this.mImageName = mImageName;
        this.mDayTime = mImages;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public DayWindViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this function doest change much for recycler view other then layout list item name

        //responsible for inflating views
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_day_wind_list, viewGroup,false);

        //viewholder object
        DayWindViewHolder holder = new DayWindViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DayWindViewHolder viewHolder, final int i) {

        // important as defines most of ui here
        Log.d(TAG,"onBindViewHolder: called");

        //getting image in image view widget
//        Glide.with(mcontext)
//                .load(mImages.get(i))
//                .into(viewHolder.circleImageView);

        //setting text
        viewHolder.imagename.setText(mImageName.get(i));
        viewHolder.dayTime.setText(mDayTime.get(i));


    }

    @Override
    public int getItemCount() {

        //important to set size
        return mImageName.size();
    }



    public class DayWindViewHolder extends RecyclerView.ViewHolder{


        TextView imagename;
        TextView dayTime;
        LinearLayout parent_layout;
        public DayWindViewHolder(@NonNull View itemView) {
            super(itemView);



            imagename = itemView.findViewById(R.id.wind_temp);
            dayTime = itemView.findViewById(R.id.wind_time);
            parent_layout = itemView.findViewById(R.id.day_wind);



        }
    }


}