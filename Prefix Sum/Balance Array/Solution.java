public class Solution {
    class pair{
        int esum;
        int osum;
        pair(int esum,int osum){
            this.osum=osum;
            this.esum=esum;
        }
    }

    public int solve(ArrayList<Integer> a) {

        int n=a.size();
        if(n==1)return 1;
        pair[] left=new pair[n];
        pair[] right=new pair[n];
        //left
        int esum=0;
        int osum=0;

        //left
        for(int i=0;i<n;i++){
            if(i%2==0){
                    esum+=a.get(i);
                    left[i]=new pair(esum,osum);
            }else{
                osum+=a.get(i);
                left[i]=new pair(esum,osum);

            }
        }

esum=0;
osum=0;
        //right
        for(int i=n-1;i>=0;i--){

              if(i%2==0){
                    esum+=a.get(i);
                    right[i]=new pair(esum,osum);
            }else{
                osum+=a.get(i);
                right[i]=new pair(esum,osum);

            }

        }

        int ans=0;

        for(int i=0;i<n;i++){
            if(i==0){
                 pair p   =right[i+1];
               if(p.esum==p.osum)ans++;
            }else if(i==n-1){

                pair p=left[i-1];
                  if(p.esum==p.osum)ans++;

            }else{

       
             pair p1=   right[i+1];
             pair p2=left[i-1];
           int  esum1=p1.esum+p2.osum;
           int   osum1=p1.osum+p2.esum;
           if(esum1==osum1)ans++;

            }
        }

        return ans;




    }
}
