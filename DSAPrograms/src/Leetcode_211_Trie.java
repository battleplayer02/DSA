import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Leetcode_211_Trie {

    public static class WordDictionary {

        /**
         * Initialize your data structure here.
         */
        public class Node {

            Node childNode[];
            boolean isEnd;

            public Node() {
                childNode = new Node[26];
            }

            public boolean find(String word, int i) {
                if (i == word.length()) {
                    return isEnd;
                }
                if (word.charAt(i) == '.') {
                    for (Node child : childNode) {
                        if (child != null && child.find(word, i + 1)) {
                            return true;
                        }
                    }
                } else {
                    if (childNode[word.charAt(i) - 'a'] == null) {
                        return false;
                    } else {
                        return childNode[word.charAt(i) - 'a'].find(word, i + 1);
                    }
                }
                return false;
            }
        }
        final private Node root = new Node();

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.childNode[ch - 'a'] == null) {
                    curr.childNode[ch - 'a'] = new Node();
                }
                curr = curr.childNode[ch - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return root.find(word, 0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        WordDictionary obj = new WordDictionary();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");

            if (inp[0].equals("addWord")) {
                obj.addWord(inp[1]);
            } else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            }
        }

    }
}
