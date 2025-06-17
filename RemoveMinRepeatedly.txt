import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveMinRepeatedly {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 9, 2, 5));

        while (!numbers.isEmpty()) {
            // Find the minimum element
            Integer min = Collections.min(numbers);

            // Remove the minimum element
            numbers.remove(min);

            // Print the modified list
            System.out.println("List after removing min: " + numbers);
        }
    }
}