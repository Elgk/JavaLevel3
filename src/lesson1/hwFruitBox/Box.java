package lesson1.hwFruitBox;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruit(T fruit){
        box.add(fruit);
    }
    public float getWeight(){
        float sum = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            sum += box.get(i).getWeight();
        }
        return sum;
    }
    public boolean compareBox(Box<?> another){
        if (Math.abs(this.getWeight() - another.getWeight()) <= 0.001) {
            return true;
        }else {return false;}
    }
    public void moveFruit(Box<T> anotherBox){
        if (anotherBox == this){
            return;
        }
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }
}
