import java.util.*;
import java.util.List;

class sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int st = 0, i = 1;
        while (arr[st] > arr[i]) {
            i += 1;
            st += 1;
        }
        int ans = 0;
        while (st < n - 1 && arr[st] < arr[st + 1]) {
            ans += 1;
            st += 1;
        }
        while (st < n - 1 && arr[st] > arr[st + 1]) {
            ans += 1;
            st += 1;
        }
        System.out.println(ans);
    }
}