package cinema;


public class ProfitCalculator {
    private int profit;

    public ProfitCalculator() {
        this.profit = 0;
    }

    public int totalPrice(int rows, int columns) {
        if (columns * rows <= 60) {
            profit = columns * rows * 10;
        }
        if (columns * rows > 60 && rows % 2 == 0) {
            profit = (10 * columns * rows / 2) + (8 * columns * rows / 2);
        } else if (columns * rows > 60 && rows % 2 != 0) {
            profit = (10 * columns * (rows / 2)) + (8 * columns * ((rows / 2) + 1));
        }
        return profit;
    }

    public int seatPrice(int row, int screenRows, int screenSeats) {
        if (screenRows * screenSeats <= 60) {
            profit =  10;
        }
        if (screenRows * screenSeats > 60 && screenRows % 2 == 0 && row <= screenRows / 2) {
            profit = 10;
        } else if (screenRows * screenSeats > 60 && screenRows % 2 == 0 && row > screenRows / 2) {
            profit = 8;
        } else if (screenRows * screenSeats > 60 && screenRows % 2 != 0 && row <= screenRows / 2) {
            profit = 10;
        } else if (screenRows * screenSeats > 60 && screenRows % 2 != 0 && row >= ((screenRows / 2) + 1)) {
            profit = 8;
        }
        return profit;
    }

}
