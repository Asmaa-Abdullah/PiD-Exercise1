package Animal;

public abstract class  Animal {

    private String animalType;
    private String animalName;
    private String yearOfBirth;

    public Animal() {

    }

    public Animal(String animalType, String animalName, String yearOfBirth) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%-24s\t%-14s\t%4s", animalType, animalName, yearOfBirth);
    }
}

