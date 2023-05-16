import java.util.ArrayList;

public class Homework {
    /**
     * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     * подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     * Можно сравнивать коробки с яблоками и апельсинами;
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     * g. Не забываем про метод добавления фрукта в коробку.
     * @param args
     */
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        System.out.println(apple1.getWeight());
        Box<Apple> box1 = new Box<>( 1);
        box1.addToBox(apple1);
        box1.addToBox(apple2);
        System.out.println(box1.getFruits());
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Orange> box2 = new Box<>(2);
        if (box1.compareBox(box2)) {
            System.out.println("вес ящиков одинаков");
        } else {
            System.out.println("вес ящиков отличатеся");
        }
        System.out.println();


    }
}

abstract class Fruit{
    public final float weight;

    public float getWeight() {
        return weight;
    }

    Fruit(float weight) {
        this.weight = weight;
    }
}
class Apple extends Fruit{

    Apple() {
        super(1.0f);
    }
    public float getWeight(){
        return weight;
    }
}
class Orange extends Fruit{

    Orange() {
        super(1.5f);
    }
    public float getWeight(){
        return weight;
    }
}

class Box<T extends Fruit> {

    private final int boxNumber;
    public ArrayList<T> fruits;


    Box(int boxNumber) {

        this.boxNumber = boxNumber;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addToBox(T fruit) {
        if(fruits == null) {
            fruits.add(fruit);
        }
        else{
            if (getFruits().get(0).getClass() == fruit.getClass()) {
                fruits.add(fruit);
                System.out.println("Fruit is added");
            } else {
                System.out.println("It's a different fruit, it cannot be added");
            }
        }
        }



    public double getWeight() {
        double sumWeight = 0.0;
        ArrayList<T> fruits = getFruits();
        if (fruits.size() > 0) sumWeight = fruits.size() * fruits.get(0).getWeight();
        return sumWeight;
    }

    public boolean compareBox(Box box) {
        if (getWeight() == box.getWeight()) return true;
        else return false;
    }
}