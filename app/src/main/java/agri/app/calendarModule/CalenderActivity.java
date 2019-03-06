package agri.app.calendarModule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import agri.app.MainActivity;
import agri.app.R;

public class CalenderActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
    private boolean shouldShow = false;
    private CompactCalendarView compactCalendarView;
    private TextView tv_date, txtToolbarTitleName;
    private RecyclerView recyclerView;
    private Calendar calendar = Calendar.getInstance(Locale.getDefault());
    private ViewFlipper viewflipper;
    private ArrayList<EventDataDao> eventDataList = new ArrayList<>();
    private ArrayList<EventRespnse> eventDataListView = new ArrayList<>();
    private ImageView imgToolBarBack;
    private EventAdapter eventAdapter;
    private Context context;
    private RelativeLayout rl_head;

    CollapsingToolbarLayout toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        initViews();


    }

    private void addEventToCalender(ArrayList<EventDataDao> eventDataList) {
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        // List<Event> events = new ArrayList<>();
        //long millis=eventDataList.get(3).getTimeInMillis();

        for (int j = 0; j < eventDataList.size(); j++) {
            calendar.setTime(firstDayOfMonth);
            if (eventDataList.get(j).getMonth() > -1) {
                calendar.set(Calendar.MONTH, eventDataList.get(j).getMonth());
            }
            if (eventDataList.get(j).getYear() > -1) {
                calendar.set(Calendar.ERA, GregorianCalendar.AD);
                calendar.set(Calendar.YEAR, eventDataList.get(j).getYear());
            }
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < eventDataList.get(j).getEventRespnses().size(); i++) {
                calendar.add(Calendar.DATE, eventDataList.get(j).getEventRespnses().get(i).getDay() - 1);
                setToMidnight(calendar);
                long timeInMillis = calendar.getTimeInMillis();
                events.add(setcalenderEvents(Color.argb(255, 169, 68, 65), timeInMillis, eventDataList.get(j).getEventRespnses().get(i), getEventCountPerDate(eventDataList)));
                compactCalendarView.addEvents(events);

            }

        }


        compactCalendarView.invalidate();
//        List<Event> eventsList = compactCalendarView.getEvents(millis); // can also take a Date object


    }

    private void initViews() {
        context = this;
        viewflipper = findViewById(R.id.viewflipper);
        compactCalendarView = findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);

        rl_head = findViewById(R.id.rl_head);
        ;
        viewflipper.showNext(); //show calendar
        compactCalendarView.setCurrentDate(Calendar.getInstance().getTime()); //I don't know what to put inside setCurrentDate(), a date, yeah, but.. ?
        compactCalendarView.invalidate(); //refresh calendar

        toolbar = findViewById(R.id.collapsing_toolbar);
        txtToolbarTitleName = toolbar.findViewById(R.id.txtToolbarTitle);
        txtToolbarTitleName.setText("Calendar");
        imgToolBarBack = toolbar.findViewById(R.id.imgToolbarHome);
        imgToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    startActivity(new Intent(CalenderActivity.this, MainActivity.class));

            }
        });


        recyclerView = findViewById(R.id.bookings_listview);
        tv_date = findViewById(R.id.tv_date);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(eventAdapter);
        //  recyclerView.setOnTouchListener(new RelativeLayoutTouchListener(this, rl_head));
        ArrayList<EventRespnse> eventRespnses = new ArrayList<>();
        eventRespnses.add(new EventRespnse("Irrigation", "Irrigation Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 1, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventRespnses.add(new EventRespnse("pesticide", "pesticide Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 1, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventRespnses.add(new EventRespnse("operations", "operations Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 1, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventDataList.add(new EventDataDao(dateFormatForMonth.format(new Date()), Calendar.FEBRUARY, 2019, eventRespnses));

        ArrayList<EventRespnse> eventRespnses1 = new ArrayList<>();
        eventRespnses1.add(new EventRespnse("harvesting", "harvesting Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 2, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventRespnses1.add(new EventRespnse("PGR", "PGR Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 2, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventDataList.add(new EventDataDao(dateFormatForMonth.format(new Date()), Calendar.FEBRUARY, 2019, eventRespnses1));

        ArrayList<EventRespnse> eventRespnses2 = new ArrayList<>();
        eventRespnses2.add(new EventRespnse("field", "field Event is on  " + dateFormatForMonth.format(new Date()) + " at " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + " " + getString(R.string.detail_data), "black", 3, dateFormatForMonth.format(new Date()), calendar.getTimeInMillis()));
        eventDataList.add(new EventDataDao(dateFormatForMonth.format(new Date()), Calendar.FEBRUARY, 2019, eventRespnses2));


        addEventToCalender(eventDataList);

        tv_date.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date date) {
                tv_date.setText(dateFormatForMonth.format(date));
                List<Event> EventMap = compactCalendarView.getEvents(date);
                Log.d(TAG, "inside onclick " + dateFormatForMonth.format(date));
                if (EventMap != null) {
                    Log.d(TAG, EventMap.toString());
                    eventDataListView.clear();

                    for (Event event : EventMap) {
                        EventRespnse eventRespnse = new EventRespnse();
                        eventRespnse = (EventRespnse) event.getData();

                        eventDataListView.add(eventRespnse);

                    }

                    eventAdapter = new EventAdapter(context, eventDataListView);
                    recyclerView.setAdapter(eventAdapter);

                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                tv_date.setText(dateFormatForMonth.format(firstDayOfNewMonth));
            }
        });

    }

    private void setToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND));
    }


    @Override
    public void onResume() {
        super.onResume();

        tv_date.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));

    }

    private int getEventCountPerDate(ArrayList<EventDataDao> eventDataList) {
        int count = 1;


        return count;
    }

    private Event setcalenderEvents(int color, long timeInMillis, EventRespnse eventRespnse, int eventCountPerDay) {
        /**/


        Event event = new Event(color, timeInMillis, eventRespnse);


        return event;

    }


}
