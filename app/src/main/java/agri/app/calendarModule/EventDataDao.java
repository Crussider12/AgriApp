package agri.app.calendarModule;

import java.util.ArrayList;

public class EventDataDao {

    String date;
    int month;
    int year;




    ArrayList<EventRespnse> eventRespnses;
    public EventDataDao(String date, int month, int year, ArrayList<EventRespnse> eventRespnses) {
        this.date = date;
        this.month = month;
        this.year = year;

        this.eventRespnses = eventRespnses;
    }
    public ArrayList<EventRespnse> getEventRespnses() {
        return eventRespnses;
    }

    public  EventDataDao(){

    }
    public void setEventRespnses(ArrayList<EventRespnse> eventRespnses) {
        this.eventRespnses = eventRespnses;
    }

    public void EventDao(){

    }




    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }










    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





}
