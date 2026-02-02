package main.mypractice.lang.object.example1;

public class ObjectMain {

    public static void main(String[] args) {
        Cat cat = new Cat("식빵냥이", 2, "먼치킨");
        Dog dog = new Dog("칸트", 14, "재패니즈스피츠");

        cat.animalInfo();
        dog.animalInfo();

        Animal animal = new Cat("우유냥이", 5, "페르시아");

        animal.animalInfo();

        Animal animal2 = new Animal("초쿄", 3);
        animal2.animalInfo();


        Animal animal3 = new Cat("라떼냥이",3, "먼치킨" );
        //animal3.meowMoew(); // 불가
        Cat cat2 = new Cat("흑당냥이", 2, "검은고양이네로");
        cat2.meowMoew();    // 가능
    }
}
