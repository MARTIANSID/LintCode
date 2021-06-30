class Solution
{ 
    public int findPairs(int arr[],int n) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum=arr[i]+arr[j];
                if(map.containsKey(sum)){
                  return 1;
                }else{
                  map.put(sum,1);
                }
            }
        }
        return 0;
    }
}

//to store the values make class pair and store it in the hashmap
