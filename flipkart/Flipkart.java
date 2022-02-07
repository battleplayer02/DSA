import java.util.*;

public class Flipkart {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // find maximum level sum of a binary tree
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (!q1.isEmpty()) {
            TreeNode temp = q1.poll();
            sum += temp.val;
            if (temp.left != null)
                q2.add(temp.left);
            if (temp.right != null)
                q2.add(temp.right);
            if (q1.isEmpty()) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache);
        lruCache.put(1, 1);
        System.out.println(lruCache);
        lruCache.put(2, 2);
        System.out.println(lruCache);
        lruCache.put(2, 64);
        System.out.println(lruCache);
        lruCache.put(3, 3);
        System.out.println(lruCache);
    }

    // lru cache
    static public class LRUCache {
        class Node {
            int key;
            int value;
            Node next;
            Node prev;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            Node() {
            }
        }

        Node head = new Node();
        Node tail = new Node();
        HashMap<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null)
                return -1;
            remove(node);
            add(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                remove(node);
                add(node);
            } else {
                if (map.size() == capacity) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                Node new_node = new Node(key, value);
                add(new_node);
                map.put(key, new_node);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            sb.append("[\n");
            while (temp != null) {
                sb.append("\t" + temp.key + " : " + temp.value + ",\n");
                temp = temp.next;
            }
            sb.append("head: " + head.key + " tail: " + tail.key + " size:" + map.size());
            sb.append("\n]");
            return sb.toString();
        }
    }

    // union find
    // leetcode 684. Redundant Connection
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int edge[] : edges) {
            int a = edge[0];
            int b = edge[1];
            int pa = find(parent, a);
            int pb = find(parent, b);
            if (pa == pb)
                return edge;
            parent[pa] = pb;
        }
        return null;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // dfs leetcode graph #133
    public Node cloneGraph(Node root) {
        if (root == null)
            return null;
        return clone(root, new HashMap<>());
    }

    public Node clone(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);

        Node new_node = new Node(node.val);

        map.put(node, new_node);
        for (Node n : node.neighbors) {
            new_node.neighbors.add(clone(n, map));
        }
        return new_node;
    }

    // bfs leetcode graph #133
    public Node cloneGraph(Node root) {
        if (root == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        map.put(root, new Node(root.val));
        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (Node n : temp.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(temp).neighbors.add(map.get(n));
            }
        }
        return map.get(root);
    }

    // 1443. Minimum Time to Collect All Apples in a Tree
    class Solution {
        class Node {
            int val;
            List<Node> neighbors;

            public Node(int val) {
                this.val = val;
                neighbors = new ArrayList<>();
            }
        }

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Node[] graph = new Node[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new Node(i);
            }
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                graph[a].neighbors.add(graph[b]);
                graph[b].neighbors.add(graph[a]);
            }
            boolean[] visited = new boolean[n];
            int result = dfs(graph[0], visited, hasApple);
            return result;
        }
        public int dfs(Node node,boolean visited[], List<Boolean> hasApples){
            if(visited[node.val])
                return 0;
            visited[node.val] = true;
            int result = 0;
            for(Node n : node.neighbors){
                result += dfs(n,visited,hasApples);
            }
            if(hasApples.get(node.val))
                result += 2;
            return result;
        }
    }

}
