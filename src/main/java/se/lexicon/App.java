package se.lexicon;


public class App {
    public static void main(String[] args) {


        System.out.println("Initial size: " + NameRepository.getSize());

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Size after setNames: " + NameRepository.getSize());

        NameRepository.add("Ali Reza");
        NameRepository.add("Sara Svensson");


        System.out.println("All names:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);

        }

        System.out.println("\nFind by first name 'Erik':");
        for (String name : NameRepository.findByFirstName("Erik")) {
            System.out.println(name);
        }

        System.out.println("\nFind by last name 'Svensson':");
        for (String name : NameRepository.findByLastName("Svensson")) {
            System.out.println(name);
        }


        System.out.println("\nUpdate 'Ali Reza' to 'Ali Safari':");
        boolean updated = NameRepository.update("Ali Reza", "Ali Safari");
        System.out.println("Updated: " + updated);


        System.out.println("\nRemove 'Sara Svensson':");
        boolean removed = NameRepository.remove("Sara Svensson");
        System.out.println("Removed: " + removed);

        System.out.println("\nFinal list:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }
    }
}
