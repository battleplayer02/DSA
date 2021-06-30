import java.io.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Leetcode_208_Trie {

    public static class Trie {

        private class Node {

            Node[] chilNodes;
            boolean isEnd;

            public Node() {
                chilNodes = new Node[26];
            }

            public Node(Node[] chilNodes, boolean isEnd) {
                this.chilNodes = chilNodes;
                this.isEnd = isEnd;
            }
        }
        final private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.chilNodes[ch - 'a'] == null) {
                    curr.chilNodes[ch - 'a'] = new Node();
                }
                curr = curr.chilNodes[ch - 'a'];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.chilNodes[ch - 'a'] == null) {
                    return false;
                } else {
                    curr = curr.chilNodes[ch - 'a'];
                }
            }
            return curr.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given
         * prefix.
         */
        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (curr.chilNodes[ch - 'a'] == null) {
                    return false;
                } else {
                    curr = curr.chilNodes[ch - 'a'];
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Trie obj = new Trie();
        while (read.ready()) {
            String inp[] = read.readLine().split(" ");

            if (inp[0].equals("insert")) {
                obj.insert(inp[1]);
            } else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            } else if (inp[0].equals("startsWith")) {
                System.out.println(obj.startsWith(inp[1]));
            }
        }

    }
}
