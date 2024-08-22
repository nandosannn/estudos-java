package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.*;;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;
    
    public static DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    //Construtores
    public Reservation(){

    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        if (checkout.isBefore(checkin)) {
            throw new DoimainExcepction("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //Encapsuladores
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    //Métodos
    public long duration(){
        long diff = ChronoUnit.DAYS.between(checkin, checkout);
        return diff;
    }
    
    public void updateDates(LocalDate checkin, LocalDate checkout){
        LocalDate now = LocalDate.now();
        if (checkout.isBefore(checkin)) {
            throw new DoimainExcepction( "Error in reservation: Check-out date must be after check-in date"); 
        }

        if (checkin.isBefore(now) || checkout.isBefore(now)) {
           throw new DoimainExcepction("Error in reservation: Reservation dates for update must be future dates"); 
        }
        
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room " + getRoomNumber() + ", check-in: " + getCheckin().format(f1) + ", check-out: " + getCheckout().format(f1) + ", " + duration() + " nights"; 
    }
}
