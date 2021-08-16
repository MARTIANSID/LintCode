import java.util.*;
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,(a,b)->{
        
        double gold1=(double) a.value /(double) a.weight;
        double gold2=(double) b.value /(double) b.weight;
        return Double.compare(gold2,gold1);
            
        }); 
        
        double w=0;
        double value=0;
    for(int i=0;i<n;i++){
        if(w+arr[i].weight<=W){
            w+=arr[i].weight;
            value+=arr[i].value;
            if(w==W)break;
            
        }else{
        double v= (double)arr[i].value/(double)arr[i].weight;
        double rem=W-w;
        value+=v*rem;
            break;
        }
        
    }
    return value;
        
    }
}