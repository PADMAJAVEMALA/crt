import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public Graph() {
        adjList = new HashMap<>();
    }

    // Method to add an edge (undirected by default)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        adjList.get(v).add(u);  // Remove this line for a directed graph
    }

    // Method to print the graph
    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.print(node + " -> ");
            for (int neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the graph
    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge as two integers (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u, v);
        }

        System.out.println("\nAdjacency List of the graph:");
        g.printGraph();

        scanner.close();
    }
}
