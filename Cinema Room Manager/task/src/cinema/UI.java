package cinema;

import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(this.scanner.next());
        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.parseInt(this.scanner.next());
        ScreenRoom screenRoom = new ScreenRoom(rows, columns);
        screenRoom.initialiseRoom();

        while (true) {
            System.out.println(
                    "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            String input = this.scanner.next();
            if (input.equals("0")) {
                break;
            } else {
                switch (input) {
                    case "1":
                        screenRoom.printBookedTickets();
                        break;
                    case "2":
                        screenRoom.bookingInput();
                        break;
                    case "3":
                        screenRoom.statistics();
                        break;
                }
            }
        }
    }
}
