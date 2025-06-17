import java.util.*;

public class BFSGraph {
    private Map<Integer, List<Integer>> adjList;

    public BFSGraph() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Remove this for a directed graph
    }

    // BFS traversal from a given source node
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        System.out.println("BFS Traversal starting from node " + start + ":");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BFSGraph graph = new BFSGraph();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter starting node for BFS: ");
        int start = scanner.nextInt();

        graph.bfs(start);

        scanner.close();
    }
}
