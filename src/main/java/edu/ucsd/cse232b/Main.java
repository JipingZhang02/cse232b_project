package edu.ucsd.cse232b;

import java.util.Date;

public class Main {
    static class Cat{
        final int age;

        public Cat(int age) {
            this.age = age;
        }
    }

    static class Dog{
        final int age;

        public Dog(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        long a = new Date().getTime();
        Class cls = a%2==0?Cat.class:Dog.class;
        System.out.println(cls.newInstance());
    }
}