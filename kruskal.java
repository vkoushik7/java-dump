import java.util.*;
class edge {
    int src,dest,we;
    public edge(int a,int b,int c) {
        src = a;
        dest = b;
        we = c;
    }
    public int getSrc() {
        return src;
    }
    public int getDest() {
        return dest;
    }
    public int getWe() {
        return we;
    }
}
class kruskal {
    static int[] par;
    public static int find(int a) {
        while (a!=par[a]) {
            par[a] = par[par[a]];
            a = par[a];
        }
        return a;
    }
    public static boolean union(int a,int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa==pb) return false;
        par[pa] = pb;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<edge> ls = new ArrayList<>();
        for (int i=0;i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ls.add(new edge(a,b,c));
        }
        Collections.sort(ls,(a,b)->a.getWe()-b.getWe());
        par = new int[n];
        for (int i=0;i<n;i++) par[i] = i;
        int c = 0,ans = 0;
        for (edge e:ls) {
            if (!union(e.getSrc(), e.getDest())) continue;
            c += 1;
            ans += e.getWe();
            System.out.println(e.getSrc()+" - "+e.getDest()+" --> "+e.getWe());
            if (c==n-1) break;
        }
        System.out.println(ans);
    }    
}
