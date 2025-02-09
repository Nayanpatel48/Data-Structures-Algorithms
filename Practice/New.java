package Practice;
import java.util.*;

public class New {
    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> distinctValues = new HashSet<>(); // Single HashSet
        int[] ans = new int[queries.length];

        for (int i=0;i<=limit;i++){
            hashMap.put(i,-1);
        }

        for (int i=0;i<queries.length;i++){
            hashMap.put(queries[i][0], queries[i][1]);

            for (int value : hashMap.values()){
                if (value != -1){
                    distinctValues.add(value);
                }
            }

            System.out.println(distinctValues);

            ans[i] = distinctValues.size();
            distinctValues.clear();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0,1},{1,2},{2,2},{3,4},{4,5}
//                {1,4},{2,5},{1,3},{3,4}
        };
        System.out.println(Arrays.toString(queryResults(4, arr)));
    }
}