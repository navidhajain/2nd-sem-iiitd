class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Cqueue{
    Node front, rear;

    Cqueue(){
        this.front=null;
        this.rear=null;
    }

    public void enqueue(int data) {
        Node temp=new Node(data);
        
        if (front==null) {
            front=temp;
            rear=temp;
        }else{
            rear.next=temp;
        }

        rear=temp;
        rear.next=front;
    }

    public int dequeue(){
        int data;
        if (front==null) {
            return -1;
        }
        if (front== rear) {
            data=front.data;
            front=null;
            rear=null;
        }
        else{
            // System.out.println(front.data);
            data= front.data;
            rear.next=front.next;
            front=front.next;
            // System.out.println(front.data);
        }
        return data;
    }

    public void display() {
        Node temp=front;
        while (temp.next!=front) {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}

public class cqusingll {
    public static void main(String[] args) {
        Cqueue cq=new Cqueue();
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.display();
        System.out.println( cq.dequeue());
        cq.display();
    }

}
