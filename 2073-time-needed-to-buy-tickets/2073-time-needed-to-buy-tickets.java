class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length, time = 0;

        while (true) {
            for (int i = 0; i < n; i++) {
                if(tickets[i] > 0){
                    tickets[i]--;
                    time++;
                    if(tickets[k] == 0)return time;
                }
            }
        }
        // return time;
    }
}
