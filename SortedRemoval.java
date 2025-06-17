import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Step 2: Use PriorityQueue to keep elements sorted
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println("Enter " + n + " integers:");

        // Step 3: Insert elements into the PriorityQueue
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            pq.add(num);
        }

        // Step 4: Remove and print elements in sorted order
        System.out.println("Elements in sorted order:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        scanner.close();
    }
}

