import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        System.out.println(dq.peekLast());
    }
}