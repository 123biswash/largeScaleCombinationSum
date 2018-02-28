
import java.util.*;

public class check {
	

	 public static List<List<Integer>> combinationSum2(int[] cand, int target) {
      Arrays.sort(cand);
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> path = new ArrayList<Integer>();
      dfs_com(cand, 0, target, path, res);
      return res;
    }
    
    static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k = 0; k < cand.length; k++) {
        		list.add(cand[k]);
        }
        
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), list.indexOf(cand[i]));
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }
    
	 public static void main(String[] args)
		{
			int numArr[]= {1,2,3,4,5,6,7,8};
//			List<int[]> list = Arrays.asList(numArr);
			int target=14;
			List<List<Integer>> output = new ArrayList<List<Integer>>();
			output = combinationSum2 (numArr, target);
			
			String result = "";
			for(int i = 0; i < output.size(); i++){
			for(int j = 0; j < output.get(i).size(); j++){
              result += output.get(i).get(j);
			}
             // System.out.println();
			result += "\n";
			}
      System.out.println(result);
		}
}
