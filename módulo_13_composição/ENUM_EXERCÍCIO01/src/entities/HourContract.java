package entities;

import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;
    
    //Contrutores
    public HourContract(){
    }

    public HourContract(LocalDate date, Double valuePerHour, Integer hours){
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    //Encapsuladores
    public LocalDate getDate(){
        return date;
    }

    public Double getValuePerHour(){
        return valuePerHour;
    }

    public Integer getHours(){
        return hours;
    }

    public void setDate(LocalDate date){
        this.date =  date;
    }

    public void setValuePerHour(Double valuePerHour){
        this.valuePerHour = valuePerHour;
    }

    public void setHours(Integer hours){
        this.hours = hours;
    }

    //Métodos
    public Double totalValue(){
        return hours * valuePerHour;
    }
}
