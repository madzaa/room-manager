package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class ScreenRoom {
    private final int rows;
    private final int columns;
    private final String[][] roomArray;
    private final Statistics statistics;
    private final ProfitCalculator profitCalculator;

    public ScreenRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.roomArray = new String[this.rows][this.columns];
        this.statistics = new Statistics();
        this.profitCalculator = new ProfitCalculator();
    }

    public void initialiseRoom() {
        for (String[] strings : roomArray) {
            Arrays.fill(strings, "S");
        }
        statistics.setTotalIncome(profitCalculator.totalPrice(this.rows,this.columns));
    }

    public void bookingInput() {
        Scanner input = new Scanner(System.in);
        ProfitCalculator calculator = new ProfitCalculator();

        while (true) {
            System.out.println("Enter a row number:");
            int row = Integer.parseInt(input.next());

            System.out.println("Enter a seat number in that row:");
            int seat = Integer.parseInt(input.next());

            if (row > this.rows || seat > this.columns) {
                System.out.println("Wrong input!");
            } else if (roomArray[row - 1][seat - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                calculator.seatPrice(row, this.rows, this.columns);
                addBooking(row, seat);
                printBookedTickets();
                break;
            }
        }
    }

    private void addBooking(int row, int seat) {

        for (int i = 0; i < roomArray.length; i++) {
            for (int j = 0; j < roomArray[i].length; j++) {
                 if (roomArray[i][j].equals("B")) {
                    System.out.println("That ticket has already been purchased!");
                } else if ((i + 1) == row && (j + 1) == seat) {
                    roomArray[i][j] = "B";
                    addStatistics(row, seat);
                }
            }
        }
    }

    public void addStatistics(int row, int seat) {
        statistics.setTicketsSold(statistics.getTicketsSold() + 1);
        statistics.setCurrentIncome(statistics.getCurrentIncome() + this.profitCalculator.seatPrice(row, this.rows, this.columns));
        statistics.setPercentage(((statistics.getTicketsSold() * 100.0) / (this.rows * this.columns)));
        System.out.println("Ticket price: $" + profitCalculator.seatPrice(row,this.rows,this.columns));
    }

    public void printBookedTickets() {
        System.out.print("Cinema:\n  ");
        for (int i = 0; i < this.columns; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < roomArray.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < roomArray[i].length; j++) {
                System.out.print(roomArray[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void statistics() {
        System.out.println(
                "Number of purchased tickets: " + statistics.getTicketsSold() +
                "\nPercentage: " + (statistics.getPercentage()) +"%"+
                "\nCurrent income: $" + statistics.getCurrentIncome() +
                "\nTotal income:  $" + statistics.getTotalIncome()
        );

    }
}
