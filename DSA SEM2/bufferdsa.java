import java.util.*;

class Stack{

    class Node{
    int data;       
    Node next;    
}
 
    Node top=null;
    int size;
 
    Stack() {
        this.top = null;
        this.size=0;
    }
 
    public void push(int x){
        Node node = new Node();  
        node.data = x;
        node.next = top;
        top = node;
        size++;
    }
    public boolean isEmpty() {
        return top == null;
    }
 
    public int peek()
    {
        if (!isEmpty()) {
            return top.data;
        }
        else {            
            return -1;
        }
    }

    public void pop()        
    {
        if (top == null)
        {
            return;
        } 
        
        top = top.next;
        size--;
    }
}

public class bufferdsa {
    // static int maxArea = 0;
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int[] heights=new int[n];
        String space=s.nextLine();
        for (int i = 0; i < n; i++) {
            heights[i]=s.nextInt();
        }
        System.out.println(garden(heights));
    }

    public static int garden(int[] heights) {
        
        int n = heights.length;
        Stack st = new Stack();
        int maxArea = 0;
        
        for(int i = 0; i <= n; i++) {
            
            int h = i == n ? 0 : heights[i];
            while(!st.isEmpty() && h <= heights[st.peek()]) {              
                int top = st.peek();
                st.pop();
                
                maxArea = Math.max(maxArea, heights[top]*(st.size == 0 ? i : i - 1 - st.peek()));
            }
            st.push(i);
        }
        return maxArea;
    }

    // public static int garden(int[] heights) {        
    //      int value = heights[0];
    //      boolean same = true;
    //      for(int i=0;i<heights.length;i++){
    //          if(heights[i]!=value){
    //              same = false;
    //              break;
    //          }             
    //      }        
    //     if(same){
    //         return value * heights.length;
    //     }      
        
    //     for(int i=0;i<heights.length;i++){
    //          int bars = 0;
    //          int myHeight = heights[i];     
            
    //         for(int k=i-1;k>=0;k--){
    //          int height = heights[k];
    //          if(height>=myHeight){
    //                  bars++;
    //              }else{
    //                  break;
    //              }
    //         }
          
    //       for(int k=i;k<heights.length;k++){
    //             int height = heights[k];
    //          if(height>=myHeight){
    //                  bars++;
    //              }else{
    //                  break;
    //              }
    //       }
            
    //          int area = bars>0 ? myHeight * bars : myHeight;
    //          if(area>=maxArea){
    //              maxArea = area;
    //          }
    //     }
        
    //   return maxArea;
    // }
}    
