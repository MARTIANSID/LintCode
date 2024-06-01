class Solution {

    
    // optimized the combinatrics formula

    public long sumDigitDifferences(int[] nums) {
        HashMap<Integer, Integer>[] digitDiff = new HashMap[10];

        for (int i = 0; i < 10; i++) {
            digitDiff[i] = new HashMap<>();
        }

        for (int ele : nums) {
            int index = 0;
            while (ele > 0) {
                int digit = ele % 10;
                digitDiff[index].put(digit, digitDiff[index].getOrDefault(digit, 0) + 1);
                ele /= 10;
                index++;
            }
        }
        
       

        long ans = 0;

        for (HashMap<Integer, Integer> map : digitDiff) {
            Set<Integer> keys = map.keySet();

            if (keys.size() == 0 || keys.size() == 1) continue;

            int n = keys.size();

            long temp = 0, totalFreq = 0;

            for (int key : keys) {
                int freq = map.get(key);
                totalFreq += freq;

                if (freq >= 2) {
                    temp += ((freq)*(freq-1)) / (2);
                }
            }          

            long total = ((totalFreq)*(totalFreq-1)) / 2;

            ans += (total - temp);
        }
        return ans;
    }
}

// [1,1,1,4]
// 4c2 = 4!/2!*2! = 6
// 3c2 = 3
// 6-3 = 3
