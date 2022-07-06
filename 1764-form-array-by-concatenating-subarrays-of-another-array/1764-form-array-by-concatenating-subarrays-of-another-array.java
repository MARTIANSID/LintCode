class Solution {
   
    int index=0;
    public boolean kmp(int[] group,int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=index;i<nums.length;i++) {
            list.add(nums[i]);
        }
        list.addFirst(-(int) 1e9);
        for (int i = group.length - 1; i >= 0; i--) {
            list.addFirst(group[i]);
        }
        

        int[] lps = new int[list.size()];
        int i = 1, len = 0;
        while (i < list.size()) {
            if (Integer.compare(list.get(i), list.get(len)) == 0) {
                len++;
                if (len == group.length) {
                    index=(i-len-1)+1;
                    return true;
                }
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public boolean canChoose(int[][] groups, int[] nums) {
      

        for (int[] g : groups) {
            if (!kmp(g,nums)) return false;
        }
        return true;
    }
}
