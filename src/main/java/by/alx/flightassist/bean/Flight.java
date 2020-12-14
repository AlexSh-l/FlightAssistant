package by.alx.flightassist.bean;

import java.sql.Date;
import java.sql.Time;

public class Flight {
    public Flight(){
        super();
    }
    private String destination;
    private String start;
    private Time start_time;
    private Time end_time;
    private String flightnum;
    private String planetype;
    private String airport;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum;
    }

    public String getPlanetype() {
        return planetype;
    }

    public void setPlanetype(String planetype) {
        this.planetype = planetype;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
}
