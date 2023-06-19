//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
        public int compareTo(Pair o){
            return this.end-o.end;
        }
        @Override
        public String toString(){
            return   "("+this.start+" "+this.end+")";
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Pair>li =new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new Pair(start[i],end[i]));
        }
        Collections.sort(li);
        int endT=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            Pair p=li.get(i);
            if(p.start>endT){
                cnt++;
                endT=Math.max(endT,p.end);
            }
        }
        return cnt;
    }
}
