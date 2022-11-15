//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr,n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    static class UF {
    int cc;
    int[] parents;
    UF(int cc) {
      this.cc = cc;
      parents = new int[cc];
      Arrays.fill(parents, -1);
    }

    int findPar(int x) {
      if (parents[x] == -1) { return x; }
      return parents[x] = findPar(parents[x]);
    }

    void conn(int x, int y) {
      int parX = findPar(x), parY = findPar(y);
      if (parX != parY) {
        parents[parX] = parY;
        cc--;
      }
    }
  }

    int maxRemove(int[][] stones,int N) {
        //Code here
        Map<Integer, List<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>();
    int n = stones.length;
    UF uf = new UF(n);
    for (int i = 0; i < n; i++) {
      int row = stones[i][0], col = stones[i][1];
      rowMap.putIfAbsent(row, new ArrayList<>());
      rowMap.get(row).add(i);
      colMap.putIfAbsent(col, new ArrayList<>());
      colMap.get(col).add(i);
    }
    for (int i = 0; i < n; i++) {
      int u = stones[i][0], v = stones[i][1];
      for (int node: rowMap.get(u)) {
        uf.conn(i, node);
      }
      for (int node: colMap.get(v)) {
        uf.conn(i, node);
      }
    }
    return n - uf.cc;
  }
    }
