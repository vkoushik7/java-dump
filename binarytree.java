import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int k) {
        val = k;
        left = null;
        right = null;
    }
}

class binarytree {
    private static Node create(int[] arr, int depth, int i) {
        if (i >= arr.length)
            return null;
        Node root = new Node(arr[i]);
        root.left = create(arr, depth + 1, 2 * depth + 1);
        root.right = create(arr, depth + 1, 2 * depth + 2);
        return root;
    }

    private static void dfs(Node root) {
        if (root == null)
            return;
        dfs(root.left);
        System.out.print(root.val + " ");
        dfs(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sarr = s.split(" ");
        int n = sarr.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(sarr[i]);
        }
        // 3 2 4 3 2
        Node root = create(arr, 0, 0);
        dfs(root);
    }
}