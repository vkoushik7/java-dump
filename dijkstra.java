import java.util.*;
class Pair {
    int key,val;
    public Pair(int k,int v) {
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
public class dijkstra {
    private static int[] solve(int n,Map<Integer, ArrayList<Pair>> hm) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        Set<Integer> vis = new HashSet<>();
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dest = p.getKey(),w = p.getValue();
            if (vis.contains(dest)) continue;
            vis.add(dest);
            if (dis[dest]<w) continue;
            if (!hm.containsKey(dest)) continue;
            for (Pair pa: hm.get(dest)) {
                int next = pa.getKey(),we = pa.getValue();
                if (dis[dest]+we<dis[next]) {
                    dis[next] = dis[dest]+we;
                    pq.add(new Pair(next,dis[next]));
                }
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, ArrayList<Pair>> hm = new HashMap<>();
        for (int i=0;i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (!hm.containsKey(a)) hm.put(a,new ArrayList<>());
            hm.get(a).add(new Pair(b,c));
        }
        int[] ans = solve(n,hm);
        for (int i:ans) System.out.print(i+" ");
    }
}
