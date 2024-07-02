// import javax.imageio.spi.ImageReaderSpi;
import java.util.*;

public class Pattern1 {
	public static void mergesort(int[] arr) {
		int mid= arr.length/2; //find the mid point
		if (arr.length>1){ 
			int[] left= new int[mid]; // create the smaller 
			int[] right= new int[arr.length-mid];
			for ( int i=0; i<mid; i++){	
                left[i]=arr[i];	
            }
			for (int i=0; i<right.length; i++){ 
                right[i]=arr[i+mid];
            }
			mergesort(left);
			mergesort(right);			
			int a=0, b=0, c=0;
			while(a<left.length && b<right.length){
				if(left[a]<=right[b]){ 
					arr[c]=left[a]; 
					a++;}
				else{
					arr[c]=right[b];
					b++; }	

				c++;}
			while (a<left.length ) {
				arr[c]=left[a];
				a++;
				c++;
			}	
			while ( b<right.length ) {
				arr[c]=right[b];
				b++;
				c++;
			}										
		}
    }

	public static int[] quicksort(int arr[], int si, int ei) {
		if (si>=ei){ return arr;}
		int pivot= arr[si];
		int count = 0;
		for (int i=si+1; i<arr.length; i++ ){
			if (arr[i]<=pivot)  {count++;}
		}
		int pi=count+si;
		arr[si]=arr[pi];
		arr[pi]=pivot;
		
		int i=si, j=ei;
		while (i<j) {
			while (i<ei && arr[i]<pivot){i++;}
			while (arr[j]>pivot){j--;}
			if (j<=i){
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i++;
				j--;
			} 
		}
		quicksort(arr, si, pi-1);
		quicksort(arr, pi+1, ei);
		return arr;
		}
	public static int[] insertionsort(int arr[]){
		for (int i=1; i<arr.length; i++){
			int key=arr[i];
			int j=i-1;
			while (j>=0 && arr[j]>arr[key]){
			arr[j+1]=arr[j];
			j=j-1;}
			arr[j]=arr[key];
		}
		return arr;
	}	

	public static int[] bubblesort(int[] arr) {
		for(int i=0; i<arr.length-1; i++){
			for (int j=i; j<arr.length-i-1; j++){
				if ( arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
		
	}

	public static int subarray() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++){
			int sum = 0;
			a[i] = in.nextInt();
			for (int j = i; j >= 0; j--){
				sum += a[j];
				if (sum < 0)
					count++;
			}
		}
		in.close();
		System.out.println(count);
		return count;
	}

	public static int ArrList() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>(n);
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            a.add(i, new ArrayList<String>(Arrays.asList(s.split("\\s"))));
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x <= a.size() && y < a.get(x-1).size() && y >= 0) {
                System.out.println(a.get(x-1).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
		sc.close();
		return 1;
		
	}

	public static String[] helpForKeypad(int n){
		if(n<=1 || n>10){
			System.exit(0);
		}

		if (n==2){
			String[] ans={"a", "b", "c"};
			return ans;
		}
		if (n==3){
			String[] ans={"d", "e", "f"};
			return ans;
		}
		if (n==4){
			String[] ans={"g", "h", "i"};
			return ans;
		}
		if (n==5){
			String[] ans={"j", "k", "l"};
			return ans;
		}
		if (n==6){
			String[] ans={"m", "n", "o"};
			return ans;
		}
		if (n==7){
			String[] ans={"p", "q", "r", "s"};
			return ans;
		}
		if (n==8){
			String[] ans={"t", "u", "v"};
			return ans;
		}
		else{	
			String[] ans={"w", "x", "y", "z"};
			return ans;		
		}
			
	}

	public static String[] keypad(int num){
		if (num==0){
			String[] ans={""};
			return ans;
	}
		String[] smallnumarray= keypad(num/10);
		String[] seq=helpForKeypad(num%10);
		String[] ans= new String[seq.length*smallnumarray.length];
		int k=0;
		for (int i=0; i<seq.length; i++){
			for (int j=0; j<smallnumarray.length; j++){
				ans[k]= smallnumarray[j]+seq[i];
				k++;
			}

		}
		return ans;
	}

	public static String balancedbrackets(String s){
		int n = -1;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0){
			return "YES";}
		else {
			return "NO";}
	}

	private static boolean isSafe(int mat[][], int visited[][], int x, int y) {
		int m= mat.length;
		int n= mat[0].length;
        return !(mat[x][y] == 0 || visited[x][y] != 0 ||  x<0 || y<0 || x>m || y>n  );
    }
 
    public static int findShortestPath(int mat[][], int visited[][], int i, int j, int x, int y, int min_dist, int dist)
    {
        // if the destination is found, update `min_dist`
        if (i == x && j == y) {
            return Integer.min(dist, min_dist);
        }
 
        // set `(i, j)` cell as visited
        visited[i][j] = 1;
 
        // go to the bottom cell
        if (isSafe(mat, visited, i + 1, j))
        {
            min_dist = findShortestPath(mat, visited, i + 1, j, x, y,  min_dist, dist + 1);
        }
 
        // go to the right cell
        if (isSafe(mat, visited, i, j + 1))
        {
            min_dist = findShortestPath(mat, visited, i, j + 1, x, y,min_dist, dist + 1);
        }
 
        // go to the top cell
        if (isSafe(mat, visited, i - 1, j))
        {
            min_dist = findShortestPath(mat, visited, i - 1, j, x, y, min_dist, dist + 1);
        }
 
        // go to the left cell
        if (isSafe(mat, visited, i, j - 1))
        {
            min_dist = findShortestPath(mat, visited, i, j - 1, x, y, min_dist, dist + 1);
        }
 
        // backtrack: remove `(i, j)` from the visited matrix
        visited[i][j] = 0;
 p
 \\\	         return min_dist;
    }

	public static void powersetsum(int[] arr, int sum, int goal, int index, String subset){
        if(index==arr.length){
            if(sum==goal){
                System.out.println(subset);
            }
            return;
        }
        powersetsum(arr, sum+arr[index], goal, index+1, subset+ arr[index]);
        powersetsum(arr, sum, goal, index+1, subset);
    }

	public static boolean knight(int[][] arr, int i, int j, int m, int n, int k, int moves) {
        if (i<0 || i>=m || j<0 || j>= n || moves>k ){
            return false;
        } 
        if (k==moves && i==m && j==n){
            return true;
        }
        boolean ans1 = knight(arr, i-2, j+1, m, n, k, moves+1); // topright
        boolean ans2 = knight(arr, i-2, j-1, m, n, k, moves+1); //topleft
        boolean ans3 = knight(arr, i+1, j+2, m, n, k, moves+1); //rightup
        boolean ans4 = knight(arr, i-1, j+2, m, n, k, moves+1); //rightdown
        boolean ans5 = knight(arr, i+2, j+1, m, n, k, moves+1); //down right
        boolean ans6 = knight(arr, i+2, j-1, m, n, k, moves+1); //down left
        boolean ans7 = knight(arr, i-1, j-2, m, n, k, moves+1); //leftup
        boolean ans8 = knight(arr, i+1, j-2, m, n, k, moves+1); //leftdown

        return (ans1 || ans2 || ans3|| ans4|| ans5|| ans6|| ans7|| ans8) ;
    }

	public static int[] banmay(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (st.size()>0 && st.peek()<arr[i] ) {
                st.pop();
            }
            st.push(arr[i]);
            ans[i]=st.size();
        }
        return ans;

    }
			
    public static void main(String[] args){
        // System.out.println((pwr(2, 3)));
		
			
		}
	
}
 