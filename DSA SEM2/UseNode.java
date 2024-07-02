import java.util.Scanner;

public class UseNode{

    static class Node<T>{
        public T data;
        Node<T> next;

        Node(T data){
            this.data= data;
            this.next= null;
        }
    }    

        public static void print(Node<Integer> head) {
            if (head==null){
                return;
            }
            Node<Integer> temp=head;
            while(temp!=null){
                System.out.print(temp.data+ " ");
                temp=temp.next;
            }       
        }

        public static int length(Node<Integer> head) {
            if (head==null){
                return 0;
            }
            int count=0;
            Node<Integer> temp=head;
            while(temp!=null){
                // System.out.println(temp.data);
                temp=temp.next;
                count++;
            }
            return count;    
        }
        
        public static void nthNode(Node<Integer> head, int n){
            int pos=0;
            Node<Integer> temp = head;
            while(temp!=null && pos!=n){
                pos++;
                temp=temp.next;
            }
            if (temp!=null){
                System.out.println(temp.data);
            }
        }

        public static Node<Integer> input() {
            Scanner s=new Scanner(System.in);
            Node<Integer> head=null, tail=null;
            int data =s.nextInt();
            while(data!=-1){
                Node<Integer> n=new Node<Integer>(data);
                if (head==null){
                    head=n;
                    tail=n;
                }
                else{
                    tail.next=n;
                    tail=n;
                }
                data=s.nextInt();         
            }
            s.close(); 
            return head;      
        }

        public static Node<Integer> insert(Node<Integer> head, int n, int data) {
            //Method1
            //  int pos=0;
            //  Node newnode= new Node(data);
            //  if (n==0){
            //     newnode.next=head;
            //     head=newnode;
            //     return;
            //  }
            // Node temp= head;
            // while(pos<n){
            //     pos++;
            //     temp=temp.next;
            //  }
            // if (temp==null){
            //      System.out.println("position unavailable");
            //      return;
            // }
            // newnode.next=temp.next;
            // temp.next=newnode;

            //method2-recursively
            if(head == null && n>0){
                return head;
            }
            if (n==0){
                Node<Integer> newnode= new Node<Integer>(data);
                newnode.next=head;
                return newnode;
            }
            else{
                head.next=insert(head.next, n-1, data);;
                return head;
            }   
        }

        public static void add(Node<Integer> head, int info){ // to the rear
            Node<Integer> newnode= new Node<Integer>(info);
            if(head == null){
                head= newnode;
            }else{
            Node<Integer> temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
            }
            // return head;

        }

        public static Node<Integer> delete(Node<Integer> head, int n) {
            //method1
            // int pos=0;
            // if (n==0){
            //     head=null;
            //     return;
            // }
            // Node temp= head;
            // while(pos<n){
            //     pos++;
            //     temp=temp.next;
            // }
            // if (temp==null){
            //     System.out.println("position unavailable");
            //     return;
            // }
            // temp.next=temp.next.next;

            //method2-recursively

            int pos=0;
            if (head==null){
                return head;
            }
            if (pos==0){
                return head.next;
            }
            else{
                head.next=delete(head.next, n-1);
            }
            return head;    
        }

        public static Node<Integer> reversell(Node<Integer> head){
            if ( head== null || head.next==null){
                return head;
            }
            Node <Integer> head2 = reversell(head.next);
            head.next.next=head;
            head.next=null;

            return head2;
        }

        public static Node<Integer> midpoint(Node<Integer> head){
            if ( head== null || head.next==null){
                return head;
            }
            Node<Integer> one = head;
            Node<Integer> two= head;
            while (two.next!=null && two.next.next!=null){
                one=one.next;
                two=two.next.next;
            }
            return one;      
        }

        public static Node<Integer> merge(Node<Integer>head1, Node<Integer> head2){
            if (head1==null){
                return head2;
            }
            if (head2==null){
                return head1;
            }
            Node<Integer> head= null, tail=null;

            if (head1.data>head2.data){
                head= head2;
                tail=head2;
                head2=head2.next;
            }
            else{
                head=head1;
                tail=head1;
                head1=head.next;
            }

            while( head1!=null && head2!=null){
                if (head1.data>head2.data){               
                    tail.next=head2;
                    tail=tail.next;
                    head2=head2.next;
                }
                else{
                    tail.next=head1;
                    tail=tail.next;
                    head1=head.next;
                }    
            }

            while(head1!=null){
                tail.next=head1;
                tail=tail.next;
                head1=head1.next;
            }
            while(head2!=null){
                tail.next=head2;
                tail=tail.next;
                head2=head2.next;
            }
            return head;
        }

    public static void main(String[] args) {
        Node <Integer> head = new Node<Integer>(2);
        add(head, 3);
        add(head, 6);
        // print(head);
        // System.out.println();
        // Node<Integer> head2=reversell(head);
        // print(head2);
        // System.out.println();
        // System.out.println(length(head2));
        
        System.out.println(midpoint(head).data);

    }
}    