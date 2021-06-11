package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree_Prims {

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

    static class Pair implements Comparable<Pair> {

        int v;
        int av;
        int wt;

        @Override
        public int compareTo(Pair o) {
            return wt - o.wt;
        }

        @Override
        public String toString() {
            return "[" + v + "-" + av + "@" + wt + "]";
        }

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
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

        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean visited[] = new boolean[vtces];
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            if (rem.av != -1) {
                System.out.println(rem);
            }

            for (Edge e : graph[rem.v]) {
                pq.add(new Pair(e.nbr, rem.v, e.wt));
            }
        }
    }
}
