/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        int[][] adjMatrix = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };
        String[] labels = {"A", "B", "C", "D"};

        Graph graph = new Graph();
        graph.setAMatrix(adjMatrix, 4);
        graph.setLabel(labels);

        System.out.println("BFS:");
        graph.bfs(0);
        
        System.out.println("DFS:");
        graph.dfs(0);

        int[][] weightMatrix = {
            {0, 2, 0, 6},
            {2, 0, 3, 8},
            {0, 3, 0, 0},
            {6, 8, 0, 0}
        };
        WGraph wGraph = new WGraph(weightMatrix);
        
        System.out.println("Dijkstra:");
        wGraph.dijkstra(0);
        
        System.out.println("Minimum Spanning Tree:");
        wGraph.primMST();

        System.out.println("Graph Coloring:");
        GraphColoring.sequentialColoring(adjMatrix);
    }
}
