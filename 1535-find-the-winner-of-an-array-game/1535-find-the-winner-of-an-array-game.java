class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length,i=0,count=0,head=arr[0];
        
        if(k>=n){
            int max=0;
            for(int ele:arr){
                max=Math.max(max,ele);
            }
            return max;
        }
        
        //as winner is guranteed
        while(true){
            //head of the round
            if(head>arr[(i+1)%n]){
                count++;
            }else{
                count=1;
                head=arr[(i+1)%n];
            }
            i++;
            if(count==k)return head;
        }
    }
}