package main.mypractice.lang.object.example1;

public class Animal {

    private String name;       // 공통
    private int age;           // 공통

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void animalInfo(){
        System.out.print("동물의 나이는 : " + age + "이며, 동물의 이름은 : " + name + "입니다.");

        if(this instanceof Dog){
            System.out.println(", 강아지 종류 : " + ((Dog)this).getDoggy() + " 입니당.");
        }else if(this instanceof Cat){
            System.out.println(", 고양이 종류 : " + ((Cat)this).getKitty() + " 입니당.");
        }
    }
}