import java.util.*;
class Pair {
    int key, val;
    public Pair(int k, int v) {
        key = k;
        val = v;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return val;
    }
}
class floyd {
    static int inf = 99999;
    private static void solve(int[][] arr) {
        int n = arr.length;
        int[][] dist = new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                dist[i][j] = arr[i][j];
            }
        }
        // for (int k=0;k<n;k++) {
        //     for (int i=0;i<n;i++) {
        //         for (int j=0;j<n;j++) {
        //             dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
        //         }
        //     }
        // }
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                for (int k=0;k<n;k++) dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
            }
        }
        print(dist);
    }
    private static void print(int[][] dist) {
        int n = dist.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<n;j++) arr[i][j] = sc.nextInt();
        }
        solve(arr);
    }
}
