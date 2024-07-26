class Solution {
    
    class Interval {
        int start;
        int end;
        
        int cnt = 0;
        
        Interval(int start, int end, int cnt ) {
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }
    }
    
    int n;
    
    int actualSearchSpace;
    
    List<Interval> intervals;
    
    
    
    public Solution(int n, int[] blacklist) {
        
        this.intervals = new ArrayList<>();
        
        int m = blacklist.length;
        
        this.n = n;        
      
        Arrays.sort(blacklist);
        
        this.actualSearchSpace = n - m;
        
        
        int lowerbound = 0;
        
        int cnt = 0;
        
        for(int i = 0; i < m; i++) {
            int ele = blacklist[i];
            
            if(lowerbound  != ele) {
                intervals.add(new Interval(lowerbound,ele-1,cnt));
            }
            cnt += (ele - lowerbound);
    
            lowerbound = ele + 1;
            
            
        }
        
        if(lowerbound <= n -1) {
            intervals.add(new Interval(lowerbound, n - 1,cnt));
        }
        
        // for(Interval i : intervals) {
        //     System.out.println("start ->" + i.start + " end ->" + i.end + "count ->" + i.cnt);
        // }
    }
    
    
    // log(search space)
    public int pick() {
        int index = (int) (Math.random() * (actualSearchSpace));
        
        Interval interval = intervals.get(searchGroup(index));
        
        
        
        int start = interval.start, end = interval.end;
        
        
        return ((int) (Math.random() * (end - start + 1)) + start);
        
    }
    
    public int searchGroup(int index) {
        
        int si = 0, ei = intervals.size() - 1;
        
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            Interval interval = intervals.get(mid);
            
            if(interval.cnt > index) {
                ei = mid - 1;
                
            } else {
                si = mid + 1;
            }
        }
        return ei;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */



// range = [0,10^9]


// 0 <= blacklist[i] < n
// blacklist length = 10^5

// search space = 10^9 - 10^5 = log(10^5 * (10^4 - 1))
   
    
//  7 - 3 = 4 
// 2,3,5
    
  
// (0-1) - > 2/4 * 1/2 = 1/4
// (4) - > 1/4 * 1 = 1/4
// (6) - > 2/4 * 1/2 = 1/4

// [2,3,5]

// (0,1), (4-4),
    
// [(0-1, 0),(4, 2),(6, 3)]

//

// rand(3) - > 3
    
// [2,3,5]
// [2 - > 2, 3 - > 2, 5 - > 3]


    







