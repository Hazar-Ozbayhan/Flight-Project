package Proje2;

import java.util.Date;

public class Flight {

    protected Date date;
    protected double time;
    protected String firstCity;
    protected String secondCity;
    protected String carrier;
    protected int price;
    protected Flight right;
    protected Flight left;

    public Flight(Date date, Double time, String firstCity, String secondCity, String carrier, int price) {
        this.date = date;
        this.time = time;
        this.firstCity = firstCity;
        this.secondCity = secondCity;
        this.carrier = carrier;
        this.price = price;
    }

    public Flight() {

    }

    @Override
    public String toString() {
        return "Flight{" + "date=" + date + ", time=" + time + ", from " + firstCity + " to " + secondCity + "carrier=" + carrier + " price=" + price + '}';
    }

}
