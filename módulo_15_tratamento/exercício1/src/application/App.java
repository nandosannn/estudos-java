package application;
import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DoimainExcepction;

import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            Integer number = input.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            input.nextLine();
            String date1 = input.nextLine();
            LocalDate date2 = LocalDate.parse(date1, f1);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            String date3 = input.nextLine();
            LocalDate date4 = LocalDate.parse(date3, f1);

            Reservation reservation = new Reservation(number, date2, date4);

            System.out.println(reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            date1 = input.nextLine();
            date2 = LocalDate.parse(date1, f1);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            date3 = input.nextLine();
            date4 = LocalDate.parse(date3, f1);

            reservation.updateDates(date2, date4);
            System.out.println(reservation);

        }
        catch (DoimainExcepction e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        input.close();
        
    }
}
