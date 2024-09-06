import java.util.*;
class tree {
    int n; 
    int[] tree,arr;
    public tree(int[] arr) {
        n = arr.length;
        this.arr = arr;
        tree = new int[n + 1];
        for (int i=0;i<arr.length;i++) add(i,arr[i]);
    }
    public void add(int i,int val) {
        i += 1;
        while (i<=n) {
            tree[i] += val;
            i += (i & -i);
        }
    }
    public void update(int i,int val) {
        int d = val - arr[i];
        arr[i] = val;
        add(i,d);
    }
    public int sum(int i) {
        int sum = 0;
        i += 1;
        while (i>0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }
    public int rangeSum(int i,int j) {
        return sum(j) - sum(i-1);
    }
    public void printTree() {
        for (int i:tree) System.out.print(i+" ");
    }
}
class fenwickTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) arr[i] = sc.nextInt();
        tree t = new tree(arr);
        t.printTree();
        // System.out.println(t.rangeSum(0,n-1));
    }
}
