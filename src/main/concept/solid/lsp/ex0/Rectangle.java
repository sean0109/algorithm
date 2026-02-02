package main.concept.solid.lsp.ex0;

public class Rectangle {

    private int width;
    private int height;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea(){
        return width * height;
    }
}
