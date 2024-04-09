class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length, time = 0;
        
        
        for(int i = 0; i < n; i++){
            
            if(tickets[i] >= tickets[k]){
                if(i > k){
                    time += tickets[k]-1;
                } else {
                    time += tickets[k];
                }
                
            } else {
                   time += tickets[i];
            }
        }
        
        return time;
      
        // return time;
    }
}

// k = 24
// val = 5
// [  .... ,k,      ]
// 5+1+1+1