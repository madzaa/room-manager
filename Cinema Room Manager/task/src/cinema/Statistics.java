package cinema;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Statistics {
    private int ticketsSold;
    private int totalIncome;
    private int currentIncome;
    private double percentage;

    public Statistics() {
        this.ticketsSold = 0;
        this.currentIncome = 0;
        this.totalIncome = 0;
        this.percentage = 0;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public BigDecimal getPercentage() {
        BigDecimal bigDecimal = new BigDecimal(this.percentage);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal;
    }

    public int getCurrentIncome() {
        return this.currentIncome;
    }

    public int getTotalIncome() {
        return this.totalIncome;
    }


}
