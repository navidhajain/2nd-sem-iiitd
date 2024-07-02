import java.util.*;
import java.lang.*;

// import java.lang.*;

public class lab4dsa {
    static long sales;
    public static void main(String[] args) {
        int n, d;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        d = scanner.nextInt();

        int[] g = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }


        scanner.close();
        sales = 0;
        sales(n, d, g, c);
        System.out.println(sales);
    }
    

    // public static void summersale(int[] prod, int[] cust, int d) {
    //     int i=0;
    //     while (i<prod.length) {
    //         if (prod[i]<cust) {
                
    //         }
    //     }
    // }

    // public static void sortarray(int arr1[], int[] arr2, int n) {
    //     for (int i = 1; i < n; ++i) {
    //         int a = arr1[i];
    //         int b = arr2[i];
    //         int j = i - 1;

    //         while (j >= 0 && arr1[j] > a) {
    //             arr1[j + 1] = arr1[j];
    //             arr2[j + 1] = arr2[j];

    //             j--;
    //         }

    //         arr1[j + 1] = a;
    //         arr2[j + 1] = b;
    //     }
    // }

    // public static void mergesort(int[] arr) {
	// 	int mid= arr.length/2; //find the mid point
	// 	if (arr.length>1){ 
	// 		int[] left= new int[mid]; // create the smaller 
	// 		int[] right= new int[arr.length-mid];
	// 		for ( int i=0; i<mid; i++){	
    //             left[i]=arr[i];	
    //         }
	// 		for (int i=mid; i<arr.length; i++){ 
    //             right[mid-i]=arr[i];
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
	// 		}

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quicksort(int[] arr, int big, int small) {
        int left, right, pivot;
        if(big >= small) { //base case
            return;
        }
        left = big;
        right = small;

        pivot = arr[(big +small) /2]; //middle element

        while(left <= right) { //actual sorting
            while(arr[left] < pivot){ //looks for bigger than pivot
                 left++;}
            while(arr[right] > pivot) {
                right--;}
            if(left <= right) {
                swap(arr,left,right);
                left++;
                right--;
            }		
        }

        quicksort(arr, big, right);
        quicksort(arr, left, small);
        }

    public static void sales(int n, int d, int[] g, int[] c) {
        quicksort(c, 0, n-1);
        quicksort(g, 0, n-1);
        for (int i = n - 1; i >= 0 && d > 0; i--) {
            if (2 * g[i] >= c[i] && g[i] < c[i]) {
                g[i] *= 2;
                d--;
            }
        }
        for (int i = 0; i < n; i++) {
            sales += Math.min(g[i], c[i]);
        }
    }
}

    // public static int summersale(int[] prods, int[] customer) {
    //     int[] sortedprod=new int[prods.length];
    //     for (int i = 0; i < prods.length; i++) {
    //         sortedprod[i]=prods[i];
    //     }

    //     sortedprod=mergesort(sortedprod);
    // }

    
