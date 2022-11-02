//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
     class Pair{
        String s;
        int t ;
        Pair(String s,int t){
            this.s =s;
            this.t=t;
        }
    }
    public int wordLadderLength(String beginWord, String endWord, String[] wordList)
    {
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