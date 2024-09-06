import java.util.*;
class Tree{ 
    int[] tree;
    int n = 0;
    public Tree(int[] arr) {
        n = arr.length;
        tree = new int[2*n];
        for (int i=0;i<n;i++) tree[n+i] = arr[i];
        for (int i=n-1;i>0;i--) {
            tree[i] = tree[2*i] + tree[2*i + 1];
        }
    }
    public void update(int i,int val) {
        int pos = n + i;
        tree[pos] = val;
        while (pos>0) {
            int l = pos,r = pos;
            if (pos%2==0) r += 1;
            else l -= 1;
            tree[pos/2] = tree[l] + tree[r];
            pos /= 2;
        }
    }
    public int sumRange(int l,int r) {
        l += n;
        r += n;
        int sum = 0;
        while (l<=r) {
            if (l%2==1) {
                sum += tree[l];
                l += 1;
            }
            if (r%2==1) {
                sum += tree[r];
                r -= 1;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
    public void printTree() {
        for (int i:tree) System.out.print(i+" ");
    }
}
class segmentTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) arr[i] = sc.nextInt();
        Tree t = new Tree(arr);
        t.printTree();
    }    
}
