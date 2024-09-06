// pick, not pick, half pick knapsack
import java.util.*;
class GFG {
    private static int solve(int[] pot,int[] val,int bal) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int cost : costs) {
            maxHeap.add((double) cost);
        }
        int potionsAdded = 0;
        while (amount > 0 && !maxHeap.isEmpty()) {
            double maxCost = maxHeap.poll();
            if (maxCost <= amount) {
                amount -= maxCost;
                potionsAdded++;
            } else {
                maxHeap.add(maxCost / 2);
            }
        }
        return potionsAdded;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pot = new int[n];
        int[] val = new int[n];
        for (int i=0;i<n;i++) {
            pot[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            val[i] = sc.nextInt();
        }
        int bal = sc.nextInt();
        solve(pot,val,bal);
    }
}