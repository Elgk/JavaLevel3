package lesson1.hwFruitBox;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        for (int i = 0; i < 15; i++) {
            box1.addFruit(apple);
        }
        for (int i = 0; i < 11; i++) {
            box2.addFruit(orange);
        }
        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());

        System.out.println(box2.compareBox(box1));
        Box<Apple> box3 = new Box<>();
        box1.moveFruit(box3);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());
    }
}
