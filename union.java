import java.util.*;

public class union {
    static int[] par;
    static int[] rank;

    private static int find(int i) {
        while (i != par[i]) {
            par[i] = par[par[i]]; // Path Compression
            i = par[i];
        }
        return i;
    }

    private static int union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 == p2)
            return 0;
        if (rank[p2] > rank[p1]) {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        print();
        return 1;
    }

    public static void print() {
        for (int i:par) System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            hm.put(a, b);
        }
        par = new int[m];
        for (int i = 0; i < m; i++)
            par[i] = i;
        rank = new int[m];
        Arrays.fill(rank, 1);
        print();
        for (int i : hm.keySet()) {
            m -= union(i, hm.get(i));
        }
        System.out.println(m);
    }
}