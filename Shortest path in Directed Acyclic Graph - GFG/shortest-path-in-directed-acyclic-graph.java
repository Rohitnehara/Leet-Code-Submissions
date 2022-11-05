//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
     class Pair{
        int node;
        int wt;
        Pair(int  node,int wt){
            this.node = node;
            this.wt= wt;
        }
    }
    public void topoSort(int node,ArrayList<ArrayList<Pair>> graph,Stack<Integer> st ,boolean []vis){
        vis[node]=true;
        for(Pair p : graph.get(node)){
            int pNode = p.node;
            if(vis[pNode]==false){
                topoSort(pNode,graph,st,vis);
            }
        }
        st.add(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i =0;i<N;i++){
		    graph.add(new ArrayList<Pair>());
		}
		for(int i =0;i<M;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    graph.get(u).add(new Pair(v,wt));
		}
		Stack <Integer> st = new Stack <>();
		boolean []vis = new boolean[N];
		for(int i =0;i<N;i++){
		    if(vis[i]==false){
		        topoSort(i,graph,st,vis);
		    }
		}
	//	System.out.println(st);
		int [] dist  = new int [N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		while(st.size()>0){
		    int node = st.pop();
		    for(Pair p : graph.get(node)){
		        int n =p.node;
		        int wt = p.wt;
		        long curWt=(long)dist[node]+(long)wt;
		        if(curWt <dist[n]){
		           dist[n]=(int)curWt;
		        }
		    }
		}
		for(int i =0;i<N;i++){
		    if(Math.abs(dist[i])==Integer.MAX_VALUE){
		        dist[i]=-1;
		    }
		}
		return dist;
	}
}