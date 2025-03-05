

package lab5;

import java.util.*;

public class Graph {
    private int[][] a;
    private String[] label;
    private int n;

    public void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, a[i], 0, n);
        }
    }

    public void setLabel(String[] c) {
        label = Arrays.copyOf(c, c.length);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(label[v] + " ");
            for (int i = 0; i < n; i++) {
                if (a[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(label[v] + " ");
                for (int i = n - 1; i >= 0; i--) {
                    if (a[v][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
    }
}
