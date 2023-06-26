class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        boolean[] visited=new boolean[n];
        PriorityQueue<Integer> left=new PriorityQueue<>();
        PriorityQueue<Integer> right=new PriorityQueue<>();
        
        int leftIndex=0,rightIndex=0,i=0;
        
        for(i=0;i<candidates;i++){
            left.add(costs[i]);
            visited[i]=true;
            
        }
        
        leftIndex=i;
        
        for(i=n-1;i>=(n-candidates);i--){
            if(!visited[i]){
                right.add(costs[i]);
                visited[i]=true;
            }
        }
        rightIndex=i;
        
        long cost=0;
        
        while(k-->0){
            int leftVal=(int)1e9;
            if(left.size()>0){
                leftVal=left.peek();
            }
            
            int rightVal=(int)1e9;
            if(right.size()>0){
                rightVal=right.peek();
            }
            
            if(leftVal<=rightVal && left.size()>0){
                cost+=left.poll();
                if(leftIndex < n && !visited[leftIndex]){
                    left.add(costs[leftIndex]);
                    visited[leftIndex]=true;
                    leftIndex++;
                }
                
            }else if(right.size()>0){
                cost+=right.poll();
                if(rightIndex >=0 && !visited[rightIndex]){
                    right.add(costs[rightIndex]);
                    visited[rightIndex]=true;
                    rightIndex--;
                }
            }
        }
        return cost;
        
    }
}