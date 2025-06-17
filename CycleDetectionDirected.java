import java.util.*;

public class CycleDetectionDirected {
    private Map<Integer, List<Integer>> adjList;

    public CycleDetectionDirected() {
        adjList = new HashMap<>();
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    // Check for cycle
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DFS to detect cycle
    private boolean dfs(int current, Set<Integer> visited, Set<Integer> recStack) {
        visited.add(current);
        recStack.add(current);

        for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack.contains(neighbor)) {
                return true; // Back edge found -> cycle
            }
        }

        recStack.remove(current);
        return false;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CycleDetectionDirected graph = new CycleDetectionDirected();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each directed edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }

        scanner.close();
    }
}
