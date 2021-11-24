class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int m=bookings.length;
        int[] temp=new int[n+1];
        
        for(int[] book:bookings){
            temp[book[0]]+=book[2];
            if(book[1]+1<temp.length)
                temp[book[1]+1]-=book[2];
        }
        
        int[] ans=new int[n];
        int sum=0;
        for(int i=1;i<temp.length;i++){
            
            sum+=temp[i];
            ans[i-1]=sum;
        }
        return ans;
        
    }
}