package Bird;

import Animal.Animal;
import Interface.IsSwimmer;

public class Duck extends Animal implements IsSwimmer {

    public Duck(String animalType, String animalName, String yearOfBirth)
    {
        super(animalType, animalName, yearOfBirth);
    }

    @Override
    public void isSwimmer() {
        System.out.println("Duck is a swimmer");
    }
}
