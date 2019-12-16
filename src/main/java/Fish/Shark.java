package Fish;

import Animal.Animal;
import Interface.IsSwimmer;

public class Shark extends Animal implements IsSwimmer {

    public Shark (String animalType, String animalName, String yearOfBirth)
    {
        super(animalType, animalName, yearOfBirth);
    }

    @Override
    public void isSwimmer() {
        System.out.println("Shark is a swimmer");
    }
}

