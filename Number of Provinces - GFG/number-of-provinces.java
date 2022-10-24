//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean [] vis = new boolean [V];
        int count=0;
        for(int i =0;i<V;i++){
            if(!vis[i]){
                bfs(adj,i,vis);
                count++;
            }
        }
        return count;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[]vis){
        Queue<Integer> q = new  LinkedList<>();
        q.add(node);
        vis[node]=true;
        while(q.size()>0){
            int curNode = q.remove();
            for(int i =0;i<adj.size();i++){
                if(adj.get(curNode).get(i)==1 && !vis[i]){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }
};