import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class priorityq{
public static void main(String[] args) throws IOException {
		
		int num, arr[];
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		input.nextLine();
		arr = new int[num];
		String s[] = input.nextLine().split(" ");
		for (int i = 0 ; i < s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		heap maxPQ = new heap(num);
		
	}
}

// class heap{
	public int[] arr;
    public int size;
    public int id;
    public int capacity;

    heap(int cap){
    	arr = new int[cap+1];
    	size =0;
    	capacity = cap;
    	//Min heap
    	//Arrays.fill(arr, Integer.MAX_VALUE);
    	//Max heap
    	Arrays.fill(arr, 0);
    }
    public int parent(int pos) { return pos / 2; }
    public int leftChild(int pos) { return (2 * pos); }
    public int rightChild(int pos){ return (2 * pos) + 1;}

    public void swap(int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapify(int i){
    	if(i> size/2 ){
    		return;
    	}
    	if(arr[i] < arr[leftChild(i)] || arr[i] < arr[rightChild(i)]){
    		if(arr[leftChild(i)] > arr[rightChild(i)]){
    			swap(i, leftChild(i));
    			heapify(leftChild(i));
    		}
    		else{
    			swap(i, rightChild(i));
    			heapify(rightChild(i));
    		}
    	}
    }

    public void add(int element)
    {
        arr[size++] = element;
        int current = size-1;
        while (arr[current] > arr[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int poll()
    {
        int popped = arr[0];
        arr[0] = arr[--size];
        arr[size] = 0;
        heapify(0);
        return popped;
    }

    public int peek(){
    	return arr[0];
    }


  

}


// class Reader {
//     static BufferedReader reader;
//     static StringTokenizer tokenizer;

//     /** call this method to initialize reader for InputStream */
//     static void init(InputStream input) {
//         reader = new BufferedReader(
//                      new InputStreamReader(input) );
//         tokenizer = new StringTokenizer("");
//     }

//     /** get next word */
//     static String next() throws IOException {
//         while ( ! tokenizer.hasMoreTokens() ) {
            
//             tokenizer = new StringTokenizer(
//                    reader.readLine() );
//         }
//         return tokenizer.nextToken();
//     }
//     static String nextLine() throws IOException {
//     return reader.readLine();
//     }

//     static int nextInt() throws IOException {
//         return Integer.parseInt( next() );
//     }
	
//     static double nextDouble() throws IOException {
//         return Double.parseDouble( next() );
//     }
// }
