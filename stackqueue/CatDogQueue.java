package com.cheng.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列  详情见程序员代码面试指南
 * @author nuonuo
 * @create 2020-12-18 11:42
 */
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                '}';
    }
}
class Dog extends Pet{

    public Dog() {
        super("dog");
    }
}
class Cat extends Pet{

    public Cat() {
        super("cat");
    }
}

/**
 * 需要实现add()  pollAll()  pollDog()   pollCat()   isEmpty() isDogEmpty() isCatEmpty()
 * 思路：设计一个PetEnter类  将Pet作为成员变量  另一个成员变量为count 记录当前实例的序号 已达到时间戳的目的
 */
class PetEnter {
    private Pet pet;
    private long count;

    public PetEnter(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}
public class CatDogQueue {
    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());

    }
    //猫狗队列实际上存放PetEnter 根据count属性就可判断实例创建的顺序
    private Queue<PetEnter> dogs;
    private Queue<PetEnter> cats;
    private long count;//队列保存一个时间戳，没加入一个对象，时间戳都会+1

    public CatDogQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogs.add(new PetEnter(pet, this.count++));
            return;
        }
        if (pet.getType().equals("cat")) {
            cats.add(new PetEnter(pet, this.count++));
            return;
        }
        throw new RuntimeException("the pet is not cat or dog");
    }
    public Pet pollAll() {
        if (isEmpty()) {
            throw new RuntimeException("Pet queue is empty");
        }
        if (isCatEmpty()) {
            return dogs.poll().getPet();
        }
        if (isDogEmpty()) {
            return cats.poll().getPet();
        }
        return dogs.peek().getCount() < cats.peek().getCount() ?
                dogs.poll().getPet() : cats.poll().getPet();
    }
    public Cat pollCat() {
        if (isCatEmpty()) {
            throw new RuntimeException("Cat queue is empty");
        }
        return (Cat) cats.poll().getPet();
    }
    public Dog pollDog() {
        if (isDogEmpty()) {
            throw new RuntimeException("Dog queue is empty");
        }
        return (Dog) dogs.poll().getPet();
    }

    public boolean isEmpty() {
        return isDogEmpty() && isCatEmpty();
    }
    public boolean isDogEmpty() {
        return dogs.isEmpty();
    }
    public boolean isCatEmpty() {
        return cats.isEmpty();
    }

}
