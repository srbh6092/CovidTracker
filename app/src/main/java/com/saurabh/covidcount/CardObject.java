package com.saurabh.covidcount;

public class CardObject {
    String location;
    int total;
    int indian;
    int foreign;
    int recovered;
    int active;
    int deaths;

    public CardObject(String location, int total, int indian, int foreign, int recovered, int active, int deaths) {
        this.location = location;
        this.total = total;
        this.indian = indian;
        this.foreign = foreign;
        this.recovered = recovered;
        this.active = active;
        this.deaths = deaths;
    }

    public String getLocation() {
        return location;
    }

    public int getTotal() {
        return total;
    }

    public int getIndian() {
        return indian;
    }

    public int getForeign() {
        return foreign;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getActive() {
        return active;
    }

    public int getDeaths() {
        return deaths;
    }
}
