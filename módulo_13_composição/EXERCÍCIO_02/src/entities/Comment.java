package entities;

public class Comment {
    private String text;

    //Contrutor
    public Comment(){

    }

    public Comment(String text) {
        this.text = text;
    }

    //Encapsuladores
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //toString
    public String toString(){
        return text;
    }
}
