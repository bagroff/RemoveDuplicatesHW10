import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> collection = generateRandomCollection(100, 50);

        System.out.println("Source collection:");
        printCollection(collection);

        int duplicatesRemoved = removeDuplicates(collection);

        System.out.println("\nCollection after removing duplicates:");
        printCollection(collection);

        System.out.println("\nNumber of deleted duplicates: " + duplicatesRemoved);
    }

    // Random generation collection method
    private static List<Integer> generateRandomCollection(int size, int limit) {
        List<Integer> collection = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int number = random.nextInt(limit);
            collection.add(number);
        }

        return collection;
    }

    // Remove duplicates method from collection and return the count of removed elements
    private static int removeDuplicates(List<Integer> collection) {
        Set<Integer> uniqueElements = new HashSet<>();
        int duplicatesRemoved = 0;

        for (int i = 0; i < collection.size(); i++) {
            Integer element = collection.get(i);

            if (uniqueElements.contains(element)) {
                collection.remove(i);
                duplicatesRemoved++;
                i--;
            } else {
                uniqueElements.add(element);
            }
        }

        return duplicatesRemoved;
    }

    // Output console collection method
    private static void printCollection(List<Integer> collection) {
        for (Integer element : collection) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
