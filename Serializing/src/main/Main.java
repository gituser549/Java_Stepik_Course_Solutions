package main;

import Animal.Animal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {
    public static void main(String[] args) {
        System.out.println("It's alive! It's alive!");
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int animalsAmount = 0;
            try {
                animalsAmount = inputStream.readInt();
            } catch (IOException exc) {
                throw new java.lang.IllegalArgumentException();
            }
            Animal[] animals = new Animal[animalsAmount];
            for (int i = 0; i < animalsAmount; i++) {
                Object curObj;
                try {
                    curObj = inputStream.readObject();
                } catch (IOException exc) {
                    throw new java.lang.IllegalArgumentException();
                }
                if (curObj instanceof Animal) {
                    animals[i] = (Animal) curObj;
                } else {
                    throw new java.lang.IllegalArgumentException();
                }
            }
            return animals;
        } catch (IOException | ClassNotFoundException exc) {
            throw new java.lang.IllegalArgumentException();
        }
    }
}