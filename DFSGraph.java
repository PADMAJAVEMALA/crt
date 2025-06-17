import java.util.*;

public class DFSGraph {
    private Map<Integer, List<Integer>> adjList;

    public DFSGraph() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        adjList.get(v).add(u); // Remove this line for a directed graph
    }

    // DFS traversal (recursive)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from node " + start + ":");
        dfsRecursive(start, visited);
        System.out.println();
    }

    // Recursive helper method
    private void dfsRecursive(int current, Set<Integer> visited) {
        if (visited.contains(current)) return;

        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            dfsRecursive(neighbor, visited);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DFSGraph graph = new DFSGraph();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter starting node for DFS: ");
        int start = scanner.nextInt();

        graph.dfs(start);

        scanner.close();
    }
}
