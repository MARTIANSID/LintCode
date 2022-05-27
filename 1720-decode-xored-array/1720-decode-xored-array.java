class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] result=new int[encoded.length+1];
        result[0]=first;
        
        int index=1;
        for(int ele:encoded){
            result[index++]=first^ele;
            first=result[index-1];
        }
        return result;
    }
}