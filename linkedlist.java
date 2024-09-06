class Node{
    int val;
    Node next;
    Node(int k){
        this.val = k;
        this.next = null;
    }
}
class List{
    Node head = null;
    public void add(int k){
        Node temp = new Node(k);
        if (head==null){
            head = temp;
        }
        else{
            Node t = head;
            while (t.next!=null){
                t=t.next;
            }
            t.next = temp;
        }
    }
    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
public class linkedlist {
    public static void main(String[] args) {
        List l = new List();
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(2);
        l.add(1);
        l.display();
    }
}
