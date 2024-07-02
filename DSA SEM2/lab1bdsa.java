import java.util.*;

public class lab1bdsa{
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr=new int[n];
        String spcae= s.nextLine();
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();  
        }
        tojump(arr);

    }

    public static void tojump(int[] arr) {
        int[] dp =new int[arr.length];
        dp[arr.length-1]=0;

        for (int i = arr.length-2; i >=0; i--) {
            int steps=arr[i];

            int min= Integer.MAX_VALUE;
            for (int j = 1; j <=steps && i+j<arr.length; j++) {
                if(dp[i+j]!=0 && dp[i+j]<min){
                    min=dp[i+j];
                }
            }

            if (min!= Integer.MAX_VALUE){
                dp[i]=min+1;
            }
            
        }
    }

    public static int minimumjumps(int[] arr, int start, int goal, int[] temp) {
        if (start == goal - 1) { // base case
            return 0;
        }
        if (start >= goal || arr[start] == 0) {
            return Integer.MAX_VALUE; // invalid case
        }
        if (temp[start] != 0) {
            return temp[start];
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i <= start + arr[start]; i++) {
            int nofjumps = minimumjumps(arr, i, goal, temp);

            if (nofjumps != Integer.MAX_VALUE) {
                if (nofjumps + 1 < min) {
                    min = nofjumps + 1;
                }
            }
        }
        temp[start] = min;
        return temp[start];
    }

    public static int minimumjumps(int[] arr, int start, int goal, int min){
        if (start == goal){ // base case
            return 0;
        }
        if (arr[start] == 0){
            return 0; //invalid case
        }
 
        // int min = Integer.MAX_VALUE;
        for (int i = start + 1; i <= goal && i <= start+arr[start]; i++) {
            int nofjumps = minimumjumps(arr, i, goal, min);

            if (nofjumps +1 > 0 ){
                int j1=nofjumps+1;

                if (j1 < min) {
                    min = j1;
                }
        }
    }
        return min;
    }

}    