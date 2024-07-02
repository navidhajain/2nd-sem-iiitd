import java.util.*;

public class lab3dsa {
    public static void main(String[] args) {
        // Scanner s=new Scanner(System.in);
        // int k=s.nextInt();
        // int bk=s.nextInt();
        // int n=s.nextInt();
        // // int n = s.nextInt();
        // int[] arr=new int[n];
        // String space1= s.nextLine();
        // for(int i = 0; i < n; i++){
        //     arr[i] = s.nextInt();  
        // }
        int[] arr={4, 6, 2, 3, 1, 5, 7};
        int k=2;
        int bk=6;
        System.out.println(btransactions(arr, k, bk));
    }

    public static int btransactions(int[] arr, int k, int bk) {
        if (k==0) {
            return arr.length;
        }
        int ratio=bk/k;
        if (ratio>=arr.length) {
            return arr.length;
        }
        for (int i = 0; i < ratio; i++) {
            int maxind=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[maxind]) {
                    maxind= j;
                }
            }
            int temp = arr[maxind];   
            arr[maxind] = arr[i];  
            arr[i] = temp; 
        }
        return getsub(arr);

    }

    public static int getsub(int[] arr) {
        int count=0, i=0;
        for ( i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {
                return count;
            }
            count++;
        }
        // if (i==arr.length-1 && arr[-2]<arr[arr.length-1]) {
            
        // }
        return count+1;
    }


}
