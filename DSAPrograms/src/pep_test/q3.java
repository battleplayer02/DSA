package pep_test;

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt(); // board length
        int M = scn.nextInt(); // Number of faces of dice
        c = 0;
        paths = new ArrayList<String>();
        count(N, M, 1, "", paths);
        System.out.println(c);
        System.out.println(paths);
        print(N, M, 1, "");
    }

    static int c = 0;

    public static void count(int N, int M, int i, String path, ArrayList<String> paths) {
        if (i == N + 1) {
            c++;
            paths.add(path);
            return;
        }
        if (i > N) {
            return;
        }
        for (int j = 1; j <= M; j++) {
            count(N, M, i + j, path + j, paths);
        }
    }

    public static void print(int N, int M, int i, String path) {
        if (i == N + 1) {
            System.out.println(path);
            paths.add(path);
            return;
        }
        if (i > N) {
            return;
        }
        for (int j = 1; j <= M; j++) {
            print(N, M, i + j, path + j);
        }
    }

    static public ArrayList<String> paths = new ArrayList<String>();
}