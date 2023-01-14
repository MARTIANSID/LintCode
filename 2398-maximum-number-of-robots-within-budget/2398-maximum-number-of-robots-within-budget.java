import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    int n = chargeTimes.length;
    int si = 0, ei = 0, ans = 0;
    long sum = 0;
    Deque<Integer> deq = new ArrayDeque<>();

    while (ei < n) {
      sum += runningCosts[ei];
      while (deq.size() > 0 && chargeTimes[deq.peekLast()] < chargeTimes[ei])
        deq.removeLast();
      deq.add(ei++);
      int max = chargeTimes[deq.peekFirst()];
      long cost = max + (ei - si) * sum;
      while (cost > budget && si<ei) {
        sum -= runningCosts[si];
        if (si == deq.peekFirst())
          deq.removeFirst();
        if(deq.size()>0){
            cost=chargeTimes[deq.peekFirst()]+(ei-si)*sum;
        }else{
            cost=0;
        }
        si++;
      }
      ans = Math.max(ans, ei - si);
    }
    return ans;
  }
}