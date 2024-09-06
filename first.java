import java.util.*;
class BIT {
    long[] tree;
    int n;
    public BIT(int n) {
        this.n = n;
        tree = new long[n+1];
        tree[0] = 0;
        for (int i=0;i<n;i++) add(i,1);
    }
    public void add(int in,long val) {
        in += 1;
        while (in<=n) {
            tree[in] += val;
            in += (in & -in);
        }
    }
    public long getSum(int in) {
        long sum = 0;
        in += 1;
        while (in>0) {
            sum += tree[in];
            in -= (in & -in);
        }
        return sum;
    }
    public long rangeSum(int i,int j) {
        return getSum(j) - getSum(i-1);
    }
}
class Solution {
    private int lower_bound(long[] arr,long k) {
        int in = Arrays.binarySearch(arr,k);
        if (in<0) in = -(in+1);
        return in;
    }
    private int upper_bound(long[] arr,long k) {
        int in = Arrays.binarySearch(arr,k);
        if (in<0) in = -(in+1);
        else {
            while (in<arr.length && arr[in]==k) in += 1;
        }
        return in;
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] ps = new long[n+1];
        for (int i=0;i<n;i++) {
            ps[i+1] = ps[i] + nums[i];
        }
        long[] pss = ps.clone();
        Arrays.sort(pss);
        BIT tree = new BIT(pss.length);
        int ans = 0;
        for (long i:ps) {
            int in = lower_bound(pss,i);
            int inl = lower_bound(pss,i+lower);
            int inu = upper_bound(pss,i+upper) - 1;
            System.out.println(in+" "+inl+" "+inu);
            tree.add(in,-1);
            ans += tree.rangeSum(inl,inu);
        }
        return ans;
    }
}
class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) arr[i] = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(new Solution().countRangeSum(arr, a, b));
    }
}