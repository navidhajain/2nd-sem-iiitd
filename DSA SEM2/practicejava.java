import java.util.*;

public class practicejava {
    public static void main(String[] args) {
        int[][] arr= new int[8][8];
        int[][] ans=new int[8][8];
        nqueens(arr, 0, ans);

    }

    public static boolean issafe(int[][] arr, int i, int j) {
        int len=arr.length;
        
        for(int x=i+1, y=j+1; x<len && y<len; x++, y++){
            if(arr[x][y]==1){
                return false;
            }
        }
        for(int x=i-1, y=j-1; x<len && y>=0; x--, y--){
            if(arr[x][y]==1){
                return false;
            }
        }
        for(int x=i+1, y=j-1; x<len && y>=0; x++, y--){
            if(arr[x][y]==1){
                return false;
            }
        }
        for(int x=i-1, y=j+1; x>=0 && y<len; x--, y++){
            if(arr[x][y]==1){
                return false;
            }
        }
        for (int k = i+1; k < arr.length; k++) {
            if (arr[k][j]==1) {
                return false;
            }
        }
        return true;

    }

    public static int[][] nqueens(int[][] arr, int i, int[][] ans) {
        int len=arr.length;
        if (i==len){
            
            return ans;
        }
        for (int j = 0; j <len; j++) {
            if (issafe(arr, i, j)) {
                arr[i][j]=1;
                arr=nqueens(arr, i+1, ans);
                arr[i][j]=0;
            }
        }
        return arr;
        
    }

     
    
      
}
