import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int m = target.length;
        List<String> ans = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if(j>=m)continue;
            if (target[j] == i) {
                ans.add("Push");
                j++;
            }else{
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}