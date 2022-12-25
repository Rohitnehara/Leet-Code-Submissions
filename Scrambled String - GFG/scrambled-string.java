//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashMap<String,Boolean>hm;
    static boolean isScramble(String s1,String s2)
    {
        hm = new HashMap<>();
        return solve(s1,s2);
        //code here
        
    }
    static boolean solve(String s1 , String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        if (s1.length() <= 1) return false;
         
        if(hm.containsKey(s1+"&"+s2)){
            return hm.get(s1+"&"+s2);
        }
        boolean ans =  false;
        for(int i =1;i<s1.length();i++){
            boolean val1 = solve(s1.substring(0,i),s2.substring(0,i)) 
                            && solve(s1.substring( i),s2.substring( i));
                
            boolean val2 =  solve(s1.substring(i),s2.substring(0,s2.length()-i))
                            && solve(s1.substring(0,i),s2.substring(s2.length()-i));
            if(val1 || val2){
                ans = true;
                break;
            }
        }
        hm.put(s1+"&"+s2,ans);
        return ans;
    }
}
