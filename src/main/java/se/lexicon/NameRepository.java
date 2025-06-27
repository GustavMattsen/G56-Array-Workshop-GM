package se.lexicon;

import java.util.Arrays;

public class NameRepository {


    // Array to store the names
    private static String[] names = new String[0];

    // Returns the number of names in the array
    public static int getSize() {
        return names.length;

    }

    // Replaces the current names with a new array
    public static void setNames(String[] newNames) {
        names = newNames;
    }

    // Clears all names
    public static void clear() {
        names = new String[0];
    }

    // Returns a copy of all the names
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    // Finds a name that matches fullName and isn't case-sensitive
    public static String find(String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                return names[i];
            }

        }
        return null;

    }


    // Adds a name if it doesn't already exist
    public static boolean add(String fullName) {
        if (find(fullName) != null) {
            return false; // Name already exists
        }


        // Create a new array that is one size bigger
        String[] newArray = new String[names.length + 1];

        // Copy over all the old names
        for (int i = 0; i < names.length; i++) {
            newArray[i] = names[i];
        }

        // Add the new name
        newArray[names.length] = fullName;



        // Replace the old array
        names = newArray;

        return true;
    }

    // Finds all names with the given first name
    public static String[] findByFirstName(String firstName) {
        int matchCount = 0;

        // First count how many match
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2 && parts[0].equalsIgnoreCase(firstName)) {
                matchCount++;
            }
        }

        // create a result array
        String[] result = new String[matchCount];
        int index = 0;

        // Add matching names to the result
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2 && parts[0].equalsIgnoreCase(firstName)) {
                result[index] = names[i];
                index++;
            }
        }

        return result;
    }


    // Finds all the names with the given last name
    public static String[] findByLastName(String lastName) {
        int matchCount = 0;

        // First count how many match
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2 && parts[1].equalsIgnoreCase(lastName)) {
                matchCount++;
            }

        }

        // Create a result array
        String[] result = new String[matchCount];
        int index = 0;

        // Add matching names to the result
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2 && parts[1].equalsIgnoreCase(lastName)) {
                result[index] = names[i];
                index++;
            }
        }

        return result;
    }

    // Update an existing name
    public static boolean update(String original, String updatedName) {
        // If the new name already exists, return false
        if (find(updatedName) != null) {
            return false;
        }

        // find the name to update
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(original)) {
                names[i] = updatedName;
                return true;
            }
        }


        return false; // Original name not found
    }

    // Removes a name
    public static boolean remove(String fullName) {
        int indexToRemove = -1;

        // Find the index of the name to remove
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                indexToRemove = i;
                break;
            }
        }

        // If name not found
        if (indexToRemove == -1) {
            return false;
        }

        // Create a new array that's one name smaller
        String[] newArray = new String[names.length - 1];
        int j = 0;


        // copy everything except the one name to remove
        for (int i = 0; i < names.length; i++) {
            if (i != indexToRemove) {
                newArray[j] = names[i];
                j++;
            }
        }

        // Replace the old array
        names = newArray;
        return true;
    }
}