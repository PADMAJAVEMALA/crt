import java.util.*;

public class NodesAtKDistance {
    private Map<Integer, List<Integer>> adjList;

    public NodesAtKDistance() {
        adjList = new HashMap<>();
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // Print all nodes at distance k from the source
    public void printNodesAtDistanceK(int source, int k) {
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        distance.put(source, 0);
        queue.offer(source);

        System.out.println("Nodes at distance " + k + " from node " + source + ":");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currDist = distance.get(current);

            if (currDist == k) {
                System.out.print(current + " ");
                continue; // Don't explore further from nodes already at distance k
            }

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currDist + 1);
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(); // For formatting
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodesAtKDistance graph = new NodesAtKDistance();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each undirected edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter source node: ");
        int source = scanner.nextInt();

        System.out.print("Enter distance k: ");
        int k = scanner.nextInt();

        graph.printNodesAtDistanceK(source, k);

        scanner.close();
    }
}
