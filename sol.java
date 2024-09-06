import java.util.*;
class Node {
    int val;
    Node left, right;
    Node(int data) {
        this.val = data;
        left = right = null;
    }
}
class tree {
    Node root;
    public tree() {
        root = null;
    }
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left == null) {
                temp.left = new Node(data);
                return;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(data);
                return;
            } else {
                q.add(temp.right);
            }
        }
    }
    public void inorder(Node root) {
        if (root == null || root.val == -1) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public int findDis(int a,int b) {
        Node temp = findLCA(root,a,b);
        return dist(temp,a) + dist(temp,b);
    }
    private Node findLCA(Node root,int a,int b) {
        if (root==null || root.val==a || root.val==b || root.val==-1) return root;
        Node l = findLCA(root.left, a, b);
        Node r = findLCA(root.right, a, b);
        if (l!=null && r!=null) return root;
        return l != null ? l : r;
    }
    private int dist(Node root,int a) {
        if (root==null || root.val == -1) return -1;
        if (root.val==a) return 0;
        int l = dist(root.left,a);
        if (l!=-1) return l + 1;
        int r = dist(root.right,a);
        if (r!=-1) return r + 1;
        return -1;
    }
}
class sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree t = new tree();
        for (int i = 0; i < n; i++) {
            t.insert(sc.nextInt());
        }
        int a = sc.nextInt(),b = sc.nextInt();
        System.out.println(t.findDis(a,b));
    }
}