

package lab5;


import java.util.*;

public class GraphColoring {
    public static void sequentialColoring(int[][] graph) {
        int n = graph.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean[] available = new boolean[n];

        for (int u = 1; u < n; u++) {
            Arrays.fill(available, true);
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }
            for (int c = 0; c < n; c++) {
                if (available[c]) {
                    result[u] = c;
                    break;
                }
            }
        }
        System.out.println("Vertex colors: " + Arrays.toString(result));
    }
}