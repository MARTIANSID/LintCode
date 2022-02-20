class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        if(finalSum%2==1)return new ArrayList<>();
        
        List<Long> ans=new ArrayList<>();
        
        long sum=0,lastOtherValue=0;
        
        for(long i=2;i<=finalSum;i+=2){
            long otherValue=(finalSum-(sum+i));
            if(i>=otherValue)break;
            sum+=i;
            ans.add(i);
            lastOtherValue=otherValue;
        }
        if(ans.size()!=0&&lastOtherValue!=0)
        ans.add(lastOtherValue);
        
        if(ans.size()==0)ans.add(finalSum);
        
        
        return ans;
        
    }
}