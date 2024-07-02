public class bufferdsa2 {
    public static void main(String[] args) {
        Node1 n4=new Node1(4, null);
        Node1 n3=new Node1(3, n4);
        Node1 n2=new Node1(2, n3);
        Node1 n1=new Node1(1, n2);

        reorderList(n1);
        print(n1);

    }

    public static void print(Node1 head) {
        if (head==null){
            return;
        }
        Node1 temp=head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }       
    }    

public static void reorderList(Node1 head) {
    Node1 [] oreder = new Node1 [50000];
    Node1 temp = head;
    int i = 0;
    while(temp != null){
        oreder[i] = temp;
        i++;
        temp = temp.next;
    }
    i-=1;
    temp = head;
    int count = 1;
    int flag = 0;
    while(count <= i){
        if(flag % 2 == 0){
            temp.next = oreder[i];
            i --;
            flag++;
        }
        else{
            temp.next = oreder[count];
            count ++;
            flag++;
        }
        temp = temp.next;
    }
    temp.next = null;
    }
}

class Node1{
    int val;
    Node1 next;
    Node1(){}
    Node1(int val){ this.val=val;}
    Node1(int val, Node1 next) {this.val=val; this.next=next;}
}

