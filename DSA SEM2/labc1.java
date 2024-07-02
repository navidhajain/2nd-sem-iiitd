import java.util.*;

public class labc1 {
    public static void main(String[] args) {
        // Scanner s= new Scanner(System.in);
        // int n=s.nextInt();
        // String space= s.nextLine();
        // int[] arr=new int[n];
        // for(int i = 0; i < n; i++){
        //     arr[i] = s.nextInt();  
        // }
        int[] arr1={4, 5, 8, 9, 10, 12};
        int[] arr2={6, 8, 9, 11, 12, 14, 15};
        // int n=5;
        // int alpha=inversions(arr, n-1);
        // System.out.println(inttochar(alpha));
        int[] ans=new int[7];
        int[] ans2=vaccine(arr1, arr2, 0, ans, 0);
        for (int i : ans2) {
            System.out.print(i);
        }
    }

    public static int[] vaccine(int[] vacc, int[] people, int pindex, int[] ans, int vindex) {
        if (pindex==people.length || people.length==0 || vacc.length==0) {
            return ans;
        }
        int count=0;
        for (int i = vindex; i < vacc.length; i++) {
            if (vacc[i]<people[pindex]) {
                vindex++;
            }else{
                count++;
            }
        }
        ans[pindex]=count;
        return vaccine(vacc, people, pindex+1, ans, vindex);
    }



    public static int inversions(int[] arr, int index) {
        if (index==0) {
            return 0;  
        }
        int count=0;
        for (int i = index+1; i < arr.length; i++) {
            if(arr[index]>arr[i]){
                count++;
            }
        }
        return count+(inversions(arr, index-1));
    }

    public static char inttochar(int n) {

        int mod= n%26;
        char c=(char)(mod+97);
        return c;
        
    }
    
}
