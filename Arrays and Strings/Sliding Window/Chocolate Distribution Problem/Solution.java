class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        
    long ei=m-2,si=0;
        long min=(int)1e9;
        
        while(ei<n){
            ei++;
            if(ei<n)
            min=Math.min(min,a.get((int)ei)-a.get((int)si));
            si++;
        }
        return min;
    }
}