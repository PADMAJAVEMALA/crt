import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryCapitalMapping {
    public static void main(String[] args) {
        Map<String, String> countryCapitalMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of country-capital pairs to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter country name: ");
            String country = scanner.nextLine();

            System.out.print("Enter capital city: ");
            String capital = scanner.nextLine();

            countryCapitalMap.put(country, capital);
        }

        System.out.println("\nCountry-Capital mapping:");
        for (Map.Entry<String, String> entry : countryCapitalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Query capital for a country
        System.out.print("\nEnter a country to find its capital: ");
        String queryCountry = scanner.nextLine();

        String capital = countryCapitalMap.get(queryCountry);
        if (capital != null) {
            System.out.println("Capital of " + queryCountry + " is " + capital);
        } else {
            System.out.println("Country not found in the map.");
        }

        scanner.close();
    }
}
