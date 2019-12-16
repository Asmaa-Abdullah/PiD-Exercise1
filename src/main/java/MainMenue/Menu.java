package MainMenue;

import Animal.Animal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
   // ArrayList<Animal> animalArrayList;
   // ArrayList<Animal> swimmerArrayList;
    AnimalCatalog animalCatalog = new AnimalCatalog();
    Scanner input = new Scanner(System.in);
    public int selection = 0;

    public void mainMenu() throws ParseException {

        System.out.println("*********************************************************");
        System.out.println("\n**       Welcome to the ToDo List Application       **\n");
        System.out.println("*********************************************************");

        printAnimals();
    }


    public void printAnimals()
    {
        do {
            System.out.println("\n1 - Print all animal sorted alphabetically");
            System.out.println("2 - Print not swim animals");
            System.out.println("3 - Print swim animals");
            System.out.println("4 - Quit");
            System.out.println("\nInsert your choice: ");

            selection = input.nextInt();
            switch (selection) {
                case 1:
                    animalCatalog.readAnimalFile();
                    //animalCatalog.sortByName();
                    break;
                case 2:
                    animalCatalog.printAnimalList();
                    break;
                case 3:
                    animalCatalog.printSwimmerList();
                    break;
                case 4:
                    System.out.println("\n ********  End of exercise  ******** ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");

            }
        } while (selection != 4) ;
    }
}
