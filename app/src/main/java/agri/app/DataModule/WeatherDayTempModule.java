package agri.app.DataModule;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class WeatherDayTempModule {

    public String time,temp;
    public int icon;


    public WeatherDayTempModule() {

    }


    public void setTime(String time) {
        this.time = time;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public String getTemp() {
        return temp;
    }

    public int getIcon() {
        return icon;
    }
//For loading image through binding we use int type id and pass the id to the image view and use some binding anotations

//    @BindingAdapter("imageTempIcon")
//    public static void loadImage(ImageView v, int icon){
//
//        v.setImageDrawable(v.getContext().getDrawable(icon));
//
//    }
}
