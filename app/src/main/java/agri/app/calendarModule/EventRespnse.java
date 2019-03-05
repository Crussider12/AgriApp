package agri.app.calendarModule;

public class EventRespnse {
    String title;
    String description;
    String color;
    long timeInMillis;
    String date;

    int day;


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public EventRespnse(String title, String description, String color, int day, String date, long timeInMillis) {
        this.title = title;
        this.description = description;
        this.color = color;

        this.day = day;
        this.timeInMillis = timeInMillis;
        this.date = date;
    }

    public  EventRespnse() {

    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}