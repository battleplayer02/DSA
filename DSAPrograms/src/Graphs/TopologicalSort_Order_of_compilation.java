/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class TopologicalSort_Order_of_compilation {

    static class Edge {

        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here
        boolean visited[] = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < vtces; v++) {
            if (!visited[v]) {
                topologicalSort(graph, v, visited, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int v, boolean[] visited, Stack<Integer> st) {
        visited[v] = true;
        for (Edge e : graph[v]) {
            if (visited[e.nbr] == false) {
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(v);
    }
}
