package main.mypractice.lang.object.example1;

public class Cat extends Animal {

    private String kitty;

    public String getKitty() {
        return kitty;
    }

    public Cat(String name, int age, String kitty) {
        super(name, age);
        this.kitty = kitty;
    }

    @Override
    void animalInfo() {
        // 오버라이드 되어 있으면 자식꺼 호출
        System.out.println("I am a Cat");
    }

    void meowMoew(){
        System.out.println("Meow");
    }
}
