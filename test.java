import java.util.*;

class test {
    private static void solve(int n) {
        while (n!=1) {
            System.out.print(n+" ");    
            if (n%2==0) n/=2;
            else n = (n*3) + 1;
        }
        System.out.print("1");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }
}
