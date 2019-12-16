package Mammal;

import Animal.Animal;
import Interface.IsSwimmer;

public class Dolphin extends Animal implements IsSwimmer {

    public Dolphin (String animalType, String animalName, String yearOfBirth)
    {
        super(animalType, animalName, yearOfBirth);
    }

    @Override
    public void isSwimmer() {
        System.out.println("Dolphin is a swimmer");
    }
}
