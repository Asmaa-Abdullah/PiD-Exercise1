package MainMenue;

import Animal.Animal;
import Bird.Chicken;
import Bird.Duck;
import Bird.Parakeet;
import Mammal.Cat;
import Mammal.Dog;
import Mammal.Dolphin;
import Mammal.Horse;
import Fish.Shark;
import Interface.IsSwimmer;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalCatalog extends Animal
{

    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Animal> swimmerList = new ArrayList<>();

   /* public void run() throws Exception {
        readAnimalFile();
        System.out.println("-------------------------------");
        System.out.println("show animal list ");
        printList(animalList);
        createSwimmerList();
        System.out.println("-------------------------------");
        System.out.println("show swimmer List");
        printList(swimmerList);
        writeSwimmerToFile ();

    }*/

    private Animal createAnimal(String animalType, String name, String yearOfBirth)
    {
        String year = validateDate(yearOfBirth);
        Animal animal = null;
        String type = animalType.toLowerCase();

        if (type.contains("dog") || type.contains("retriever") || type.contains("shepherd"))
        {
            animal = new Dog(type,name, year);
        }
        else if (type.contains("cat"))
        {
            animal = new Cat(type,name, year);
        }
        else if (type.contains("horse"))
        {
            animal = new Horse(type,name, year);
        }
        else if (type.contains("chicken"))
        {
            animal = new Chicken(type,name, year);
        }
        else if (type.contains("parakeet"))
        {
            animal = new Parakeet(type,name, year);
        }
        else if (type.contains("duck"))
        {
            animal = new Duck(type,name, year);
        }
        else if (type.contains("dolphin"))
        {
            animal = new Dolphin(type,name, year);
        }
        else if (type.contains("shark"))
        {
            animal = new Shark(type,name, year);
        }
        return animal;
    }


    private void createSwimmerList()
    {
        for (Animal animal : animalList)
        {
            if (animal instanceof IsSwimmer)
            {
                swimmerList.add(animal);
            }
        }
    }

    /**
     *  To write the swimmerList to swimmer.csv file (another way)
     */
    public void writeSwimmers2File()  {
        String csvFileName = "/Users/asmaaabdullah/Desktop/Animals/src/main/java/Files/swimmer.csv";

        // Create a BufferedWriter to write the swimmerList to swimmer.csv file.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFileName))) {

            for (Animal swimmer: swimmerList) {
                bufferedWriter.write(swimmer.getAnimalType() + "," + swimmer.getAnimalName() + "," + swimmer.getYearOfBirth() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
    *  To write the swimmerList to swimmer.csv file
    */
    private void writeSwimmerToFile () {

        File fileName = new File("/Users/asmaaabdullah/Desktop/Animals/src/main/java/Files/swimmer.csv");

        try ( FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8 );
             CSVWriter writer = new CSVWriter(osw)) {
            for (Animal swimmer1: swimmerList) {

                String[] entries = { swimmer1.getAnimalType(),swimmer1.getAnimalName(),swimmer1.getYearOfBirth() };
                writer.writeNext(entries,false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSwimmerList()
    {
        printList(swimmerList);
    }

    public void printAnimalList()
    {
        printList(animalList);
    }

    //To print any list that have elements of type animal. In this way i don't need to create
    // 2 method to print each list
    public void printList(ArrayList<Animal> list)
    {
        for (Animal animal: list)
        {
            System.out.println(animal);
        }
    }

    /**
     * Parse yearOfBirth as integer to string
     * @param birth
     * @return
     */
   private String validateDate(String birth)
    {
        if (birth.matches("\\d+")) {
            return birth;
        } else {
            System.out.println("Invalid year of birth");
            return null;
        }
    }

    /**
     * To sort animalList by name
     */
    public void sortByName(){
        List<Animal> sortedList = animalList.stream()
                .sorted(Comparator.comparing(Animal::getAnimalName))
                .collect(Collectors.toList());

        for (Animal animal: sortedList) {
            System.out.println(animal);
        }
    }

    /**
     * Read animals.csv file
     * Add to animalList
     */

    public void readAnimalFile()
    {
        String csvFileName = "/Users/asmaaabdullah/Desktop/Animals/src/main/java/Files/animals.csv";
        String line = "";
        String cvsSplitBy = ",";

        // Create a BufferedReader to read the file line by line until an "End of File" (EOF) character is reached.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = bufferedReader.readLine()) != null) {

                // use comma as separator
                String[] animalLine = line.split(cvsSplitBy);

                // the createAnimal method will check if the string in the file is correct, if it is correct it will create an animal object
                // if it is not correct it will return null
                Animal animal = createAnimal(animalLine[0], animalLine[1], animalLine[2]);

                //if null the loop need to go back and read the next line with excuting adding the animal list to list or print it
                if (animal == null)
                {
                    System.out.println("animal data is incorrect");
                    continue;
                }
                animalList.add(animal);
                System.out.println(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}