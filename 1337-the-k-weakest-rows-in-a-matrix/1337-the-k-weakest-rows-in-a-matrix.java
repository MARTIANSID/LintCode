class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[] rowVal = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                if(rowVal[a] == rowVal[b])return a-b;
                return rowVal[a] - rowVal[b];
            }
        );

        for (int i = 0; i < n; i++) {
            int k1 = findOcurrence(mat[i], true);
            int k2= findOcurrence(mat[i], false);
            if(k1!=-1)
            rowVal[i] = k2 - k1 + 1;
            
            pq.add(i);
        }
        int[] ans = new int[k];
        int index = 0;
        while (k-- > 0) {
            ans[index++] = pq.poll();
        }
        return ans;
    }

    public int findOcurrence(int[] arr, boolean flag) {
        int si = 0, ei = arr.length - 1;

        int n = arr.length;

        boolean found = false;  
        
        int target=1;
        
        while (si <= ei) {
            int mid = (ei + si) / 2;
            if (arr[mid] > target) {
                si = mid + 1;
            } else if (arr[mid] < target) {
                ei = mid - 1;
            } else {
                found = true;
                if (flag) {
                    if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                        ei = mid - 1;
                    } else {
                        si = mid;
                        break;
                    }
                } else {
                    if (mid +1 <n && arr[mid+1] == arr[mid]) {
                        si=mid+1;
                    } else {
                        si = mid;
                        break;
                    }
                }
            }
        }
        if(!found)return -1;
        return si;
    }
}
