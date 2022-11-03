class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> rev = new ArrayList<>();
        for(int i =0; i<graph.length;i++){
           rev.add(new ArrayList<>());
        }
        for(int i =0; i<graph.length;i++){
            for(int j =0;j<graph[i].length;j++){
                rev.get(graph[i][j]).add(i);
            }
        }
        int [] inorder = new int [graph.length];
        for(int i =0;i<graph.length;i++){
            for(int it : rev.get(i)){
                inorder[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<graph.length;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        while(q.size()>0){
            int curNode= q.remove();
            ans.add(curNode);
            for(int it :rev.get(curNode)){
                inorder[it]--;
                if(inorder[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}