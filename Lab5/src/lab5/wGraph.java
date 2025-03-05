

package lab5;

import java.util.Arrays;


public class WGraph {
    private int[][] weightMatrix;
    private int n;

    public WGraph(int[][] matrix) {
        n = matrix.length;
        weightMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, weightMatrix[i], 0, n);
        }
    }

    public void dijkstra(int src) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            if (dist[u] == Integer.MAX_VALUE) break;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (weightMatrix[u][v] > 0 && dist[u] + weightMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + weightMatrix[u][v];
                }
            }
        }
        System.out.println("Shortest distances from source: " + Arrays.toString(dist));
    }

    public void primMST() {
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!mstSet[j] && (u == -1 || key[j] < key[u])) {
                    u = j;
                }
            }
            mstSet[u] = true;
            for (int v = 0; v < n; v++) {
                if (weightMatrix[u][v] > 0 && !mstSet[v] && weightMatrix[u][v] < key[v]) {
                    key[v] = weightMatrix[u][v];
                    parent[v] = u;
                }
            }
        }
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " : " + weightMatrix[i][parent[i]]);
        }
    }
}
