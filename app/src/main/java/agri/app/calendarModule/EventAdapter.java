package agri.app.calendarModule;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;



import java.util.List;

import agri.app.R;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EntryViewHolder> {
    private final LayoutInflater mInflater;
    private List<EventRespnse> EventDataList;
    private Context context;
    //private  EventClickListener eventClickListener;

    public EventAdapter(Context context, List<EventRespnse> EventDataList) {
        super();
        this.context = context;
        this.EventDataList = EventDataList;
        //eventClickListener = (EventClickListener) context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_event_row, parent, false);
        return new EntryViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(EntryViewHolder holder, final int position) {
        final EventRespnse eventDataDao = EventDataList.get(position);
        holder.tv_Description.setText(eventDataDao.getDescription());
        holder.tv_title.setText(eventDataDao.getTitle());
        //holder.fl_card.setBackgroundTintList(context.getResources().getColorStateList(R.color.black));
        holder.tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // eventClickListener.onClickEvent(eventDataDao);

            }
        });
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
        private final TextView tv_title, tv_Description, tv_next;

        private FrameLayout fl_card;
        private EntryViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_Description = itemView.findViewById(R.id.tv_Description);
            tv_next = itemView.findViewById(R.id.tv_next);

            fl_card = itemView.findViewById(R.id.fl_card);

        }
    }
}


