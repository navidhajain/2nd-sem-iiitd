

public class practice2 {

    static Node head;

    class Node{
        
        public int data;
        public Node next;
        public Node prev;
        public Node ter;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public void print() {
        if (head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }   
        System.out.println();    
    }

    public Node getTail(Node head)
    {
        while(head.next!=null)
            head=head.next;
        return head;
    }

    public Node sort() {
        Node temp =head;
        while(temp!=null)
        {
            if(temp.ter!=null)
            {
                Node tail=getTail(temp.ter);
                if(temp.next!=null)
                temp.next.prev=tail;
                tail.next=temp.next;
                temp.next=temp.ter;
                temp.ter.prev=temp;
                temp.ter=null;
            }
            temp=temp.next;
        }        
        return head;
        
    }

    // public void sort(){
    //     Node temp1=head;
    //     System.out.println(head.data);
    //     // int count = 0;
    //     while (temp1!=null) {
    //         // System.out.println(Integer.toString(count++));
    //         if(temp1.ter!=null){
    //             Node temp2=temp1.ter;
    //             System.out.println("t2 " +temp2.data);
    //             System.out.println("t1next " + temp1.next.data);
    //             while (temp2.ter.ter != null) {
    //                 temp2=temp2.ter;
    //             }
                
    //             System.out.println(temp2.ter.data);
    //             temp2.next.prev=temp2.ter;
    //             temp2.ter.next=temp2.next;
    //             temp2.next=temp2.ter;
    //             temp2.ter.prev=temp2;
    //             System.out.println("tnext "+ temp2.next.data);
    //             temp2.ter=null;
    //             // if (temp2.prev == null) System.out.println("d " + temp2.data);
    //             // temp2=temp2.prev;
    //             while(temp2!=temp1){
    //                 Node temp3= temp2;
    //                 Node temp4=temp2.prev;
    //                 while (temp3.next!=null) {
    //                     temp3=temp3.next;
    //                 }
    //                 temp4.next.prev=temp3;
    //                 temp3.next=temp4.next;
    //                 temp4.next=temp2;
    //                 temp2.prev=temp4;

    //                 temp2=temp2.prev;
    //             }                
    //             // System.out.println(temp2.next.data);
    //             // System.out.println("  " + temp1.next.data);                               
    //         }            
    //         temp1=temp1.next;
    //     }
    // }
    public static void main(String[] args) {
        practice2 dll2= new practice2();
        Node node1= dll2.new Node(1);
        head = node1;
        Node node2= dll2.new Node(2);
        // node1.next=node2;
        Node node3= dll2.new Node(3);
        Node node4= dll2.new Node(4);
        Node node5= dll2.new Node(5);
        Node node6= dll2.new Node(6);
        // node2.prev=node1;
        node1.ter=node4;
        // node2.next=node3;
        // node3.prev=node2;
        node4.next=node5;
        node4.ter=node6;
        node5.prev=node4;
        node4.prev=node1;
        node6.prev=node4;
        dll2.print();
        dll2.sort();
        dll2.print();

        
        

        // Scanner s  = new Scanner(System.in);
        // int n = s.nextInt();
        // int[] arr=new int[n];
        // String space1= s.nextLine();
        // for(int i = 0; i < n; i++){
        //     arr[i] = s.nextInt();  
        // }
        // space1= s.nextLine();
        // int size=0;
        // int q=s.nextInt();
        // for (int i = 0; i < q; i++) {
        //     space1= s.nextLine();
        //     size=s.nextInt();
        //     clothes(arr, size);
        // }
        // int[] arr= {4, 3, 1, 5, 2};
        // int n= arr.length;
        // mergesort(arr);
        
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }

        // int[] arr={2, 2, 4, 5, 5};
        // clothes(arr, 6);
    }
}    
    // public static void mergesort(int[] arr) {
	// 	int mid= arr.length/2; //find the mid point
	// 	if (arr.length>1){ 
	// 		int[] left= new int[mid]; // create the smaller 
	// 		int[] right= new int[arr.length-mid];
	// 		for ( int i=0; i<mid; i++){	
    //             left[i]=arr[i];	
    //         }
	// 		for (int i=0; i<right.length; i++){ 
    //             right[i]=arr[i+mid];
    //         }

	// 		mergesort(left);
	// 		mergesort(right);
			
	// 		int a=0, b=0, c=0;
	// 		while(a<left.length && b<right.length){

	// 			if(left[a]<=right[b]){ 
	// 				arr[c]=left[a]; 
	// 				a++;}
	// 			else{
	// 				arr[c]=right[b];
	// 				b++; }	

	// 			c++;}

	// 		while (a<left.length ) {
	// 			arr[c]=left[a];
	// 			a++;
	// 			c++;
	// 		}	

	// 		while ( b<right.length ) {
	// 			arr[c]=right[b];
	// 			b++;
	// 			c++;
	// 		}									
	// 	}
    // }

    // public static void quicksort(int[] arr, int big, int small) {
    //     int left, right, pivot;
    //     if(big >= small) { //base case
    //         return;
    //     }
    //     left = big;
    //     right = small;

    //     pivot = arr[(big +small) /2]; //middle element

    //     while(left <= right) { //actual sorting
    //         while(arr[left] < pivot){
    //              left++;}
    //         while(arr[right] > pivot) {
    //             right--;}
    //         if(left <= right) {
                
    //             int temp = arr[right];
    //             arr[right] = arr[left];
    //             arr[left] = temp;
    //             left++;
    //             right--;
    //         }		
    //     }

    //     quicksort(arr, big, right);
    //     quicksort(arr, left, small);
    //     }

    


