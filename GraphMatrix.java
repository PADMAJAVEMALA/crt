import java.util.Scanner;

public class GraphMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices]; // All values initialized to 0
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;  // Remove for directed graph
    }

    // Print the adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int e = scanner.nextInt();

        GraphMatrix graph = new GraphMatrix(v);

        System.out.println("Enter " + e + " edges (format: u v):");
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int vtx = scanner.nextInt();
            graph.addEdge(u, vtx);
        }

        graph.printMatrix();
        scanner.close();
    }
}
