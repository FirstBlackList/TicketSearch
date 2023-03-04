package ru.netology.domain;

public class TicketInformation implements Comparable<TicketInformation> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;

    public TicketInformation(int id, int price, String departureAirport, String arrivalAirport) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public int compareTo(TicketInformation obj) {
        if (this.getPrice() < obj.getPrice()) {
            return -1;
        } else if (this.getPrice() > obj.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
