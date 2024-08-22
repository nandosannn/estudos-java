package entities;

import entities.enums.Color;

public abstract class Shape {
    private Color color;

    //Contrutores
    public Shape(){

    }

    public Shape(Color color) {
        this.color = color;
    }

    //Encapsuladores
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Métodos
    public abstract Double area();

}
