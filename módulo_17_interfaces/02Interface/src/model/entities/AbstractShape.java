package model.entities;

import enums.Color;

public abstract class AbstractShape implements Shape{
    private Color color;

    //Builders
    public AbstractShape(){

    }
    public AbstractShape(Color color) {
        this.color = color;
    }

    //Encapsuladors
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
