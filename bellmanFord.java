import java.util.*;
public class bellmanFord {
    public static int solve(int n,int[][] g,int src,int dest) {
        int[] dist = new int[n+1];
        int[] pred = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for (int[] i:g) {
            int a = i[0],b = i[1],w = i[2];
            if (dist[b]>dist[a]+w) {
                dist[b] = dist[a]+w;
                pred[b] = a;
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        while (dest!=src) {
            ls.add(dest);
            dest = pred[dest];
        }
        ls.add(dest);
        Collections.reverse(ls);
        System.out.println(ls);
        return dist[dest];
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] g = {{1,2,5},{1,3,3},{1,4,7},{2,4,3},{2,5,2},{3,4,1},{4,5,2}}; 
        int src = 1,dest = 5;
        System.out.println(solve(n,g,src,dest));
    }
}
