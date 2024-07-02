import java.util.Stack;
import java.util.Scanner;
import java.util.*;

public class bufferendsemdsa {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int  k = in.nextInt();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u = in.nextInt();
            int v = in.nextInt();

            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] reachable = new boolean[n];
        boolean[] isLanding = new boolean[n];
        boolean[] visited=  new boolean[n];
        int[] num_ships = new int[n];

        for(int i=0;i<k;i++){
            isLanding[in.nextInt()-1]=true;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(isLanding[i]){
                    dfs(adj, stack, reachable, visited,i, isLanding, num_ships);
                    reachable = new boolean[n];
                    visited = new boolean[n];
                }
            }
        }

        int counter = 0;

        for(int i=0;i<reachable.length;i++){
            if(num_ships[i]!=0){
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] reachable, boolean[] visited, int source, boolean[] isLanding, int[] num_ships){
        if(isLanding[source]==true){
            while(!stack.isEmpty()){
                int x = stack.pop();
                num_ships[x]+=1;
                reachable[x] = true;
            }
        }
        visited[source] = true;
        for(int v:adj.get(source)){
            if(!visited[v]){
                 stack.add(v);
                 dfs(adj,stack,reachable, visited,v, isLanding, num_ships);
                 if(stack.size()>0)
                    stack.pop();
            }
        }
    }
}