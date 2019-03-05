package agri.app.weatherFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.CircularGauge;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;

import java.util.ArrayList;

import agri.app.Adapter.WeatherFragmentAdapter.RecyclerViewWeatherWindDay;
import agri.app.R;
import agri.app.databinding.FragmentWeatherBinding;

import static android.support.constraint.Constraints.TAG;


public class WeatherFragment extends Fragment {

    View view;
    private FragmentWeatherBinding fragmentWeatherBinding;
    private ArrayList<String>mDayWind = new ArrayList<>();
    private ArrayList<String>mDayTime = new ArrayList<>();
//    private ArrayList<WeatherDayTempModule>mData = new ArrayList<>();

    public WeatherFragment(){

    }

    public static WeatherFragment newInstance() {
        WeatherFragment weatherFragment = new WeatherFragment();
        return weatherFragment;
    }
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentWeatherBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_weather, container, false);
        // Inflate the layout for this fragment
        view= fragmentWeatherBinding.getRoot();


        initView();
        initImageBitmaps();
        windDirection(view);
        windSpeedDirection(view);
//        initRecyclerWeatherDayTemp();
        initRecyclerWeatherDayWind();
        return view;


    }
    private void initView() {
        mContext = getActivity();
    }

//    private void initRecyclerWeatherDayTemp(){
//        Log.d(TAG, "initRecyclerWeatherDayTemp: ");
//
//        RecyclerViewWeatherDay recyclerViewWeatherDay = new RecyclerViewWeatherDay(this,mData);
//        LinearLayoutManager linearLayoutManager;
//        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        fragmentWeatherBinding.weatherDayTime.setLayoutManager(linearLayoutManager);
//        fragmentWeatherBinding.weatherDayTime.setAdapter(recyclerViewWeatherDay);
//
//
//    }


    private void initRecyclerWeatherDayWind(){
        Log.d(TAG, "initRecyclerWeatherDayWind: ");

        RecyclerViewWeatherWindDay recyclerViewWeatherWindDay = new RecyclerViewWeatherWindDay(this,mDayWind, mDayTime);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentWeatherBinding.windDayTime.setLayoutManager(linearLayoutManager);
        fragmentWeatherBinding.windDayTime.setAdapter(recyclerViewWeatherWindDay);
    }

    private void windSpeedDirection(View view){

        AnyChartView anyChartView = view.findViewById(R.id.any_chart_windspeed);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar1));

        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff")
                .stroke(null)
                .padding(0, 0, 0, 0)
                .margin(30, 30, 30, 30);
        circularGauge.startAngle(0)
                .sweepAngle(360);

        double currentValue = 13.8D;
        circularGauge.data(new SingleValueDataSet(new Double[] { currentValue }));

        circularGauge.axis(0)
                .startAngle(-150)
                .radius(80)
                .sweepAngle(300)
                .width(3)
                .ticks("{ type: 'line', length: 4, position: 'outside' }");

        circularGauge.axis(0).labels().position("outside");

        circularGauge.axis(0).scale()
                .minimum(0)
                .maximum(140);

        circularGauge.axis(0).scale()
                .ticks("{interval: 10}")
                .minorTicks("{interval: 10}");

        circularGauge.needle(0)
                .stroke(null)
                .startRadius("6%")
                .endRadius("38%")
                .startWidth("2%")
                .endWidth(0);

        circularGauge.cap()
                .radius("4%")
                .enabled(true)
                .stroke(null);

        circularGauge.label(0)
                .text("<span style=\"font-size: 25\">Wind Speed</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(0)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(100)
                .padding(15, 20, 0, 0);

        circularGauge.label(1)
                .text("<span style=\"font-size: 20\">" + currentValue + "</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(1)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(-100)
                .padding(5, 10, 0, 0)
                .background("{fill: 'none', stroke: '#c1c1c1', corners: 3, cornerType: 'ROUND'}");

        circularGauge.range(0,
                "{\n" +
                        "    from: 0,\n" +
                        "    to: 25,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'green 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        circularGauge.range(1,
                "{\n" +
                        "    from: 80,\n" +
                        "    to: 140,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'red 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        anyChartView.setChart(circularGauge);
    }

    private void windDirection(View view){
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_winddirection);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar2));

        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff")
                .stroke("null")
                .padding(0, 0, 0, 0)
                .margin(30, 30, 30, 30)
                .startAngle(0)
                .sweepAngle(360);

        circularGauge.data(new SingleValueDataSet(new Double[] { 18.1 }));

        circularGauge.axis(0)
                .startAngle(0)
                .radius(80)
                .sweepAngle(360)
                .width(3)
                .drawFirstLabel(false)
                .ticks("{ type: 'line', length: 4, position: 'outside' }");

        circularGauge.axis(0).labels()
                .position("outside")
                .useHtml(true);
        circularGauge.axis(0).labels().format(
                "function () {\n" +
                        "    return this.value + '&deg;'\n" +
                        "  }");

        circularGauge.axis(0).scale()
                .minimum(0)
                .maximum(360);
        circularGauge.axis(0).scale()
                .ticks("{interval: 45}")
                .minorTicks("{interval: 10}");

        circularGauge.marker(0)
                .fill(new SolidFill("#64b5f6", 1))
                .stroke("null");
        circularGauge.marker(0)
                .size(7)
                .radius(80);

        circularGauge.label(0)
                .text("<span style=\"font-size: 25\">Wind Direction</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(0)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(50)
                .padding(15, 20, 0, 0);

        circularGauge.label(1)
                .text("<span style=\"font-size: 20\">18.1</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(1)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(-20)
                .padding(5, 10, 0, 0)
                .background("{fill: 'none', stroke: '#c1c1c1', corners: 3, cornerType: 'ROUND'}");

        anyChartView.setChart(circularGauge);
    }
    public void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");
//
//        WeatherDayTempModule weatherDayTempModule = new WeatherDayTempModule();
//        weatherDayTempModule.setIcon(R.drawable.ic_wind);
//        weatherDayTempModule.setTemp("16");
//        weatherDayTempModule.setTime("03:00");
//        mData.add(weatherDayTempModule);
//
//        weatherDayTempModule = new WeatherDayTempModule();
//        weatherDayTempModule.setIcon(R.drawable.ic_wind);
//        weatherDayTempModule.setTemp("22");
//        weatherDayTempModule.setTime("06:00");
//        mData.add(weatherDayTempModule);
//
//        weatherDayTempModule = new WeatherDayTempModule();
//        weatherDayTempModule.setIcon(R.drawable.ic_wind);
//        weatherDayTempModule.setTemp("27");
//        weatherDayTempModule.setTime("09:00");
//        mData.add(weatherDayTempModule);
//
//        weatherDayTempModule = new WeatherDayTempModule();
//        weatherDayTempModule.setIcon(R.drawable.ic_wind);
//        weatherDayTempModule.setTemp("20");
//        weatherDayTempModule.setTime("12:00");
//        mData.add(weatherDayTempModule);





        mDayTime.add("03:00");
        mDayWind.add("6 km/h");

        mDayTime.add("06:00");
        mDayWind.add("7.3 km/h");

        mDayTime.add("09:00");
        mDayWind.add("6.2 km/h");

        mDayTime.add("12:00");
        mDayWind.add("4.9 km/h");

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        //  setNavigationVisibility(false);
    }
}
