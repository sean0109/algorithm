package main.mypractice.lang.object.example1;

public class Dog extends Animal {

    private String doggy;

    public String getDoggy() {
        return doggy;
    }

    public Dog(String name, int age, String doggy) {
        super(name, age);
        this.doggy = doggy;
    }
}
