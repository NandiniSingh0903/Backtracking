import java.util.ArrayList;
import java.util.List;

public class LeetcodePermutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), nums);
        return list;
    }

    private static void helper(List<List<Integer>> list, List<Integer> temp, int [] nums){
        if(temp.size()== nums.length){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i])){
                    continue;
                }

                temp.add(nums[i]);
                helper(list, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String args[]){
        int nums[] = {1,2,3};
        System.out.println(permute(nums));
    }
}