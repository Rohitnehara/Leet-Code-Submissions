class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count =0;
        boolean [] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                bfs(isConnected,i,vis);
                count++;
            }
               
        }
        return count;
    }
    public void bfs(int [][] graph,int node,boolean [] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node]=true;
        while(q.size()>0){
            int crNode = q.remove();
            for(int i =0;i<graph.length;i++){
                 if(graph[crNode][i]==1 && vis[i]==false){
                vis[i]=true;
                q.add(i);
            }
            }
           
        }
    }
}