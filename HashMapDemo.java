import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Adding entries to the map
        map.put("Apple", 100);
        map.put("Banana", 60);
        map.put("Orange", 80);

        System.out.println("Initial Map: " + map);

        // Retrieving a value
        System.out.print("Enter fruit name to get its price: ");
        String fruit = scanner.nextLine();
        if (map.containsKey(fruit)) {
            System.out.println("Price of " + fruit + ": " + map.get(fruit));
        } else {
            System.out.println(fruit + " is not in the map.");
        }

        // Updating a value
        System.out.print("Enter fruit to update price: ");
        String updateFruit = scanner.nextLine();
        if (map.containsKey(updateFruit)) {
            System.out.print("Enter new price: ");
            int newPrice = scanner.nextInt();
            map.put(updateFruit, newPrice);
            System.out.println(updateFruit + " updated. New Map: " + map);
        } else {
            System.out.println(updateFruit + " not found.");
        }

        scanner.nextLine(); // clear newline

        // Removing an entry
        System.out.print("Enter fruit to remove: ");
        String removeFruit = scanner.nextLine();
        if (map.remove(removeFruit) != null) {
            System.out.println(removeFruit + " removed. Updated Map: " + map);
        } else {
            System.out.println(removeFruit + " not found.");
        }

        // Checking if a key or value exists
        System.out.println("Contains 'Apple'? " + map.containsKey("Apple"));
        System.out.println("Contains price 60? " + map.containsValue(60));

        // Iterating over entries
        System.out.println("\nFinal map entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        scanner.close();
    }
}
