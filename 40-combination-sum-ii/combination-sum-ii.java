public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
       helper(candidates,0,target,new ArrayList<>(),result);
       return result;
    }

    void helper(int[] candidates, int index, int target,List<Integer> current, List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index ;i <candidates.length;i++) {
            if(candidates[i]>target) break;
            if(i>index && candidates[i]==candidates[i-1]) continue;
            current.add(candidates[i]);
            helper(candidates,i+1,target-candidates[i],current,result);
            current.remove(current.size() - 1); 
        }
    }
}