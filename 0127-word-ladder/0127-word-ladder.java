class Solution {
    class Pair{
        String s;
        int t ;
        Pair(String s,int t){
            this.s =s;
            this.t=t;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        HashSet<String> hmAdded = new HashSet<>();
        for(String ss :wordList){
            dict.add(ss);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(q.size()>0){
            Pair p = q.remove();
            String s =p.s;
            if(s.equals(endWord)){
                return p.t;
            }
            StringBuilder sb = new StringBuilder(s);
            
            for(int i =0;i<s.length();i++){
                sb = new StringBuilder(s);
                for(char ch ='a';ch<='z';ch++){
                    sb.replace(i,i+1,ch+"");
                    if(dict.contains(sb.toString()) && !hmAdded.contains(sb.toString())){
                        hmAdded.add(sb.toString());
                        q.add(new Pair(sb.toString(),p.t+1));
                    }
                }
            }
        }
        return 0;
    }
}