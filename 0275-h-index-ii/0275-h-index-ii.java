class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;

        int si = 0, ei = n - 1, max = 0;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            int cnt = (n - mid);

            if (cnt >= citations[mid]) {
                si = mid + 1;
            } else {
                max = Math.max(max, cnt);
                ei = mid - 1;
            }
        }

        if (ei < 0) {
            return citations.length;
        }

        return Math.max(max, citations[ei]);
    }
}
// [0,1,3,5,6]
// si = 0
// ei = 4
// mid = 2
//     ei
