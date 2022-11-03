class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer> > graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] ed : prerequisites){
            graph.get(ed[1]).add(ed[0]);
        }
        int []indegree =new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int it : graph.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            int curNode = q.remove();
            ans.add(curNode);
            for(int it : graph.get(curNode)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(ans.size()!=numCourses) return false;
        return true;
    }
}