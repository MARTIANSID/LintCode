class Solution {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();

        List<int[]> colSum = new ArrayList<>();

        for (int i = 0; i < colsum.length; i++) {
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = colsum[i];
            colSum.add(temp);
            firstRow.add(0);
            secondRow.add(0);
        }

        Collections.sort(
            colSum,
            (a, b) -> {
                return b[1] - a[1];
            }
        );

        for (int[] e : colSum) {
            int ele = e[1];
            int index = e[0];
            if (ele == 1) {
                if (upper > 0) {
                    firstRow.set(index, 1);
                    upper--;
                } else {
                    if (lower == 0) return new ArrayList<>();
                    secondRow.set(index, 1);
                    lower--;
                }
            } else if (ele == 2) {
             if (lower == 0 || upper == 0) return new ArrayList<>();
                firstRow.set(index, 1);
                secondRow.set(index, 1);
                upper--;
                lower--;
            }
        
        }
        
        if(lower!=0 || upper!=0)return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(firstRow);
        ans.add(secondRow);
        return ans;
    }
}
