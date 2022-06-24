class Solution {

    public boolean isPossible(int[] target) {
        int n = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return b - a;
            }
        );
        long sum = 0;

        for (int ele : target) {
            sum += (ele);
            if (ele != 1) {
                pq.add(ele);
            }
        }
        
        if(pq.size()==1 && n==1)return false;
        
        while (pq.size() > 0) {
            int maxEle=pq.poll();
            long remainingSum=sum-maxEle;
            sum=remainingSum;
            if(remainingSum>=maxEle)return false;
            long mod=maxEle%remainingSum;
            if(mod==0)mod+=(remainingSum);
            sum+=mod;
            if(mod!=1)pq.add((int)mod);
        }
        return true;
    }
}
/*



[8,7]
[1,1]=2
[1,2]=3
[3,2]=5
[3,5]=8
[8,5]
*/
