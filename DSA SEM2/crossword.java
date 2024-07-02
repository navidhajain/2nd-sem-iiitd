import java.util.*;

public class crossword{

    public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here
        if (vidx==words.length){
            print(arr);
            return ;
        }

        String word=words[vidx];
        for(int i =0; i<arr.length; i++){
            for (int j =0; j<arr.length; j++){
                if (arr[i][j]=='-' || arr[i][j]==word.charAt(0)){
                    if(canhorizon(arr, word, i, j)){
                        boolean[] wedid=placehori(arr, word, i, j);
                        solution(arr, words, vidx+1);
                        unplacehori(arr, word, wedid, i, j);
                    }
                    if(canverti(arr, word, i, j)){
                        boolean[] wedid=placeverti(arr, word, i, j);
                        solution(arr, words, vidx+1);
                        unplaceverti(arr, word, wedid, i, j);
                    }
                }
            }
        }

	}

    public static boolean canhorizon(char[][] arr, String word, int i, int j){
        if (j-1>=0 && arr[i][j-1]!='+' ){
            return false;
        } else if(j+word.length()<= arr[0].length && arr[i][j+word.length()] !='+' ){
            return false;
        }
        for (int k=0; k< word.length(); k++){
            if (j+k>arr.length){
                return false;
            }
            if (arr[i][k+j]=='-'|| arr[i][k]==word.charAt(k)){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }

    public static boolean canverti(char[][] arr, String word, int i, int j){
        if (i-1>=0 && arr[i-1][j]!='+' ){
            return false;
        } else if(i+word.length()<= arr[0].length && arr[i+word.length()][j] !='+' ){
            return false;
        }
        for (int k=0; k< word.length(); k++){
            if (i+k>arr.length){
                return false;
            }
            if (arr[i+k][j]=='-'||arr[k][j]==word.charAt(k)){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }

    public static boolean[] placehori(char[][] arr, String word, int i, int j){
        boolean[] wedid=new boolean[word.length()];
        for(int k=0; k<word.length(); k++){
            if(arr[i][k+j]=='-'){
                arr[i][k+j]=word.charAt(k);
                wedid[k]=true;
            }
        }
        return wedid;
    }

    public static boolean[] placeverti(char[][] arr, String word, int i, int j){
        boolean[] wedid=new boolean[word.length()];
        for(int k=0; k<word.length(); k++){
            if(arr[i+k][j]=='-'){
                arr[i+k][j]=word.charAt(k);
                wedid[k]=true;
            }
        }
        return wedid;
    }

    public static void unplacehori(char[][] arr, String word, boolean[] wedid, int i, int j){
        for(int k=0; k<word.length(); k++){
            if(wedid[k]){
                arr[i][k+j]='-';
            }
        }

    }

    public static void unplaceverti(char[][] arr, String word, boolean[] wedid, int i, int j){
        for(int k=0; k<word.length(); k++){
            if(wedid[k]){
                arr[i+k][j]='-';
            }
        }

    }

	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        scn.close();

	}
}