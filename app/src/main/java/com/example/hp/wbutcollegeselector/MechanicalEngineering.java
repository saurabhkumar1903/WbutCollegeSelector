package com.example.hp.wbutcollegeselector;

/**
 * Created by hp on 28-07-2017.
 */

class MechanicalEngineering {
    private String openingRank;
    private String closingRank;
    private String totalseat;
    private String seatAvailable;

    public MechanicalEngineering(String openingRank, String closingRank) {
        this.openingRank = openingRank;
        this.closingRank = closingRank;
    }
    public MechanicalEngineering() {
        this.openingRank = "0";
        this.closingRank = "0";
        this.totalseat = "5";

        this.seatAvailable = "5";
    }
    public String getOpeningRank() {
        return openingRank;
    }

    public void setOpeningRank(String openingRank) {
        this.openingRank = openingRank;
    }

    public String getClosingRank() {
        return closingRank;
    }

    public void setClosingRank(String closingRank) {
        this.closingRank = closingRank;
    }

    public String getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(String totalseat) {
        this.totalseat = totalseat;
    }

    public String getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(String seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public MechanicalEngineering(String openingRank, String closingRank, String totalseat, String seatAvailable) {
        this.openingRank = openingRank;
        this.closingRank = closingRank;
        this.totalseat = totalseat;

        this.seatAvailable = seatAvailable;
    }

   }
