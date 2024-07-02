import java.util.*;
import java.lang.*;


public class journey{
    
    static void compute(int[][] arr, int n, int i, int j, int sum, int[] max){

        if(i==arr.length-1 && j==arr.length-1){

            sum+=arr[i][j];

            if(sum>max[0]){
                max[0]=sum;
            }

            return;
        }
            
        if(i>=j && i<arr.length && j<arr.length){
            sum+=arr[i][j];
            compute(arr,n,i+1,j,sum,max);
            compute(arr,n,i,j+1,sum,max);
        }
    }

    static void compute2(int[][] arr, int n, int i, int j, int sum, int[] max){

        if(i<0 || j<0)
            return;

        if(i==0 && j==0){

            sum+=arr[i][j];

            if(sum>max[0]){
                max[0]=sum;
            }

            return;
        }
            
        if(i<=j && (i>0 || j>0)){
            sum+=arr[i][j];
            compute2(arr,n,i-1,j,sum,max);
            compute2(arr,n,i,j-1,sum,max);
        }
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int n = in.nextInt();

        int[][] arr = new int[n][n];
        int[] max = new int[1];
        max[0]=-999999;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int res = 0;

        compute(arr,n,0,0,0,max);
       res+=max[0];
       max[0] = -99999;

        compute2(arr,n,n-1,n-1,0,max);
        res+=max[0];

        System.out.print(res);

        in.close();
    }
}