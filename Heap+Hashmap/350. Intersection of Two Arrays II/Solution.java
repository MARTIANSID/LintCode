class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Assume Sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();

        int n1 = 0;
        int n2 = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) {
                res.add(nums1[n1]);
                n1++;
                n2++;
            } else if (nums1[n1] < nums2[n2]) {
                n1++;
            } else {
                n2++;
            }
        }

        int[] res1 = new int[res.size()];
        int k = 0;
        for (Integer i : res) {
            res1[k++] = i;
        }
        return res1;
    }
}
