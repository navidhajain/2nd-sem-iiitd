import java.util.*;

public class ll2lab {
    Node head;

    // class Node{
    //     public int data;
    //     Node next;
    //     // Node head;

    //     Node(int data){
    //         this.data= data;
    //         this.next= null;
    //     }
    // }

    public void print() {
        if (head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }       
    }

    public void insert(int n, int data){
        //create new node.
        Node node = new Node(data);
       
        if (this.head == null) {
            if (n != 0) {
                return;
            } else { 
                this.head = node;
            }
        }

        if (head != null && n == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < n) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }

            i++;
        }

        node.next = current;
        previous.next= node;
    }

    public void add(int info){ // to the rear
        Node newnode= new Node(info);
        if(head == null){
            head= newnode;
        }else{
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        }
        // return head;
    }

    public void delete(int n) {
        if (head == null){
          return;}

        Node temp = head;

        if (n == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < n - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;

        temp.next = next;   
        }

    public static void main(String[] args) {
        ll2lab seq= new ll2lab();
        Scanner s= new Scanner(System.in);
        int nosq=s.nextInt();
        String waste=s.nextLine();
        for (int i = 0; i < nosq; i++) {
            int q= s.nextInt();
            if (q==1) {
                int data=s.nextInt();
                seq.add(data);
            }
            if (q==2) {
                int pos=s.nextInt();
                seq.delete(pos-1);
            }
            if (q==3) {
                seq.print();
            }
            if (q==4) {
                int b=s.nextInt();
                int a=s.nextInt();
                seq.insert(a-1, b);
            }
            waste=s.nextLine();
        }

    }
}
