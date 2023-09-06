//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    
    class itemComparator implements Comparator<Item>
    {
        @Override
        public int compare(Item a, Item b) 
        {
            double r1 = (double)(a.value) / (double)(a.weight); 
            double r2 = (double)(b.value) / (double)(b.weight); 
            if(r1 < r2) return 1; 
            else if(r1 > r2) return -1; 
            else return 0; 
        }
    }
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        // Your code here
        double W=w*1.0;
        Arrays.sort(arr,new itemComparator());
        
        double ans=0;
        
        double cur=0;
        for(Item i:arr){
            double cW=i.weight;
            if(cW+cur<=W){
                cur+=cW;
                ans+=i.value;
            }else{
                double rem=W-cur;
                ans+=(i.value/cW)*rem;
                break;
            }
        }
        return ans;
    }
}