import java.util.*;
public class topologicalSort {
    public static ArrayList<Integer> solve(int n,int[][] g) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] in = new int[n];
        for (int[] i:g) in[i[1]] += 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<n;i++) if (in[i]==0) q.add(i);
        while (!q.isEmpty()) {
            int a = q.poll();
            ans.add(a);
            for (int[] i:g) {
                if (i[0]!=a) continue;
                in[i[1]] -= 1;
                if (in[i[1]]==0) q.add(i[1]);
            }
        } 
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] g = {{0,1},{0,2},{1,3},{2,1},{2,3},{3,4}};
        System.out.println(solve(n,g));
    }    
}
