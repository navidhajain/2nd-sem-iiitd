class DoublyLinkedList {    
    //A node class for doubly linked list
    class Node{  
        int data;  
        Node previous;  
        Node next; 
   
        public Node(int data) {  
            this.data = data; 
            this.previous=null;
            this.next = null;
        }  
    }  
    //Initially, heade and tail is set to null
    Node head, tail; 
    public int size; 
    
    DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void addNode(int data) {  
        Node newNode = new Node(data); 
        if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.previous = tail; 
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    }  

    public void nthNode(int n){
        int pos=0;
        Node temp = head;
        while(temp!=null && pos!=n){
            pos++;
            temp=temp.next;
        }
        if (temp!=null){
            System.out.println(temp.data);
        }
    }

    public void reverse()
    {
        Node temp = null;
        Node current = head;
 
        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
 
        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.previous;
        }
    }

    public void deletenth(int n) {  
        if(head == null) {  
           return;  
       }  
       else {  
           Node current = head;   
            int pos =n;   
           for(int i = 1; i < pos; i++){  
               current = current.next;  
           }   
           if(current == head) {  
               head = current.next;  
           }  
            else if(current == tail) {  
               tail = tail.previous;  
           }  
           else {  
               current.previous.next = current.next;  
               current.next.previous = current.previous;  
           }  
            current = null;  
       }  
   }  
   
//print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.data + " ");  
            current = current.next;  
        }  
    }  
}
class doublyll{
    public static void main(String[] args) {  
        //create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();  
        //Add nodes to the list  
        dl_List.addNode(10);  
        dl_List.addNode(20);  
        dl_List.addNode(30);  
        dl_List.addNode(40);  
        dl_List.addNode(50);  
   
        //print the nodes of DoublyLinkedList  
        dl_List.printNodes();  
    }  
}