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
class prims {
    private static int solve(Map<Integer, ArrayList<Pair>> hm, int start, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        Set<Integer> visited = new HashSet<>();
        pq.add(new Pair(start, 0));
        int ans = 0;
        while (!pq.isEmpty() && visited.size() < n) {
            Pair current = pq.poll();
            int node = current.getKey();
            int weight = current.getValue();
            if (visited.contains(node)) continue;
            visited.add(node);
            ans += weight;
            System.out.println(node);
            if (hm.containsKey(node)) {
                for (Pair neighbor : hm.get(node)) {
                    if (!visited.contains(neighbor.getKey())) {
                        pq.add(new Pair(neighbor.getKey(), neighbor.getValue()));
                    }
                }
            }
        }
        return visited.size() == n ? ans : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, ArrayList<Pair>> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (!hm.containsKey(a)) hm.put(a, new ArrayList<>());
            hm.get(a).add(new Pair(b, c));
            if (!hm.containsKey(b)) hm.put(b, new ArrayList<>());
            hm.get(b).add(new Pair(a, c));
        }
        int ans = solve(hm, 0, n);
        System.out.println(ans);
    }
}