//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair {
        int prev;
        int curr;
        Pair(int prev,int curr){
            this.prev=prev;
            this.curr=curr;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean []vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(detectCycle(adj,i,vis))
            return true;
            }
            
        }
        return false;
    }
    public boolean detectCycle( ArrayList<ArrayList<Integer>> adj,int node,boolean []vis){
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(-1,node));
        vis[node]=true;
        while(q.size()>0){
            Pair curP = q.remove();
            for(int conNodes : adj.get(curP.curr )){
                if(vis[conNodes]==false){
                    q.add(new Pair(curP.curr,conNodes));
                    vis[conNodes]=true;
                } else{
                    if(curP.prev !=conNodes){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}