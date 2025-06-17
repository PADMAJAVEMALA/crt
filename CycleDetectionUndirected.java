import java.util.*;

public class CycleDetectionUndirected {
    private Map<Integer, List<Integer>> adjList;

    public CycleDetectionUndirected() {
        adjList = new HashMap<>();
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // Detect cycle in the graph
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DFS to detect cycle
    private boolean dfs(int current, int parent, Set<Integer> visited) {
        visited.add(current);

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, current, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Found a back-edge (a cycle)
                return true;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CycleDetectionUndirected graph = new CycleDetectionUndirected();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        boolean hasCycle = graph.hasCycle();

        if (hasCycle) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }

        scanner.close();
    }
}
