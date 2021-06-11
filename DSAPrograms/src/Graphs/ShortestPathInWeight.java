/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Administrator
 */
public class ShortestPathInWeight {

    static class Edge {

        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {

        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public String toString() {
            return v + " via " + psf + " @ " + wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return wsf - o.wsf;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[vtces];
        pq.add(new Pair(src, src + "", 0));
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem);
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }
}
