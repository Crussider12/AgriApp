package agri.app.calendarModule;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import agri.app.R;

public class EventDetailsAdapter extends RecyclerView.Adapter<EventDetailsAdapter.EntryViewHolder> {
    private final LayoutInflater mInflater;
    private List<EventRespnse> EventDataList;
    private Context context;
    //private  EventClickListener eventClickListener;

    public EventDetailsAdapter(Context context, List<EventRespnse> EventDataList) {
        super();
        this.context = context;
        this.EventDataList = EventDataList;
        //eventClickListener = (EventClickListener) context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_event_detail_row, parent, false);
        return new EntryViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(EntryViewHolder holder, final int position) {
        final EventRespnse eventDataDao = EventDataList.get(position);
        holder.iv_df.setImageDrawable(context.getDrawable(R.drawable.cloud_with_sun));
        holder.tv_details.setText(eventDataDao.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CalenderEventDetailsActivity.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        if (EventDataList != null) {
            return EventDataList.size();
        } else {
            return 0;
        }
    }

    class EntryViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_details;
        private ImageView  iv_df;

        private EntryViewHolder(View itemView) {
            super(itemView);
            tv_details = itemView.findViewById(R.id.tv_details);
            iv_df = itemView.findViewById(R.id.iv_df);


        }
    }
}
