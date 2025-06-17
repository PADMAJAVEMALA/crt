import java.util.*;

public class BipartiteGraph {
    private Map<Integer, List<Integer>> adjList;

    public BipartiteGraph() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);  // Undirected
    }

    // Check if graph is bipartite using BFS
    public boolean isBipartite() {
        Map<Integer, Integer> color = new HashMap<>();

        for (int node : adjList.keySet()) {
            if (!color.containsKey(node)) {
                if (!bfsCheck(node, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    // BFS helper function to check bipartiteness
    private boolean bfsCheck(int start, Map<Integer, Integer> color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color.put(start, 0);  // Start with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = color.get(node);

            for (int neighbor : adjList.get(node)) {
                if (!color.containsKey(neighbor)) {
                    color.put(neighbor, 1 - currentColor); // Alternate color
                    queue.offer(neighbor);
                } else if (color.get(neighbor) == currentColor) {
                    return false; // Same color on both ends = not bipartite
                }
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BipartiteGraph graph = new BipartiteGraph();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each undirected edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isBipartite()) {
            System.out.println("Graph is bipartite.");
        } else {
            System.out.println("Graph is NOT bipartite.");
        }

        scanner.close();
    }
}
