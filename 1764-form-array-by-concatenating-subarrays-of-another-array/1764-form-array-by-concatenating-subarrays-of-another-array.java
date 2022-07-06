class Solution {
    LinkedList<Integer> nos = new LinkedList<>();

    public boolean kmp(int[] group) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int ele : nos) {
            list.add(ele);
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
                    int index = i - len - 1;
                    for (int j = 0; j <= index; j++) {
                        nos.removeFirst();
                    }
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
        for (int ele : nums) {
            nos.add(ele);
        }

        for (int[] g : groups) {
            if (!kmp(g)) return false;
        }
        return true;
    }
}
