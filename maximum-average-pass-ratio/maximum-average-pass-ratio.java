class Solution {
        class pair{
                int pass;
                int total;
                double ratio;
                double change;
                pair(int pass,int total,double ratio,double change){
                        this.pass=pass;
                        this.total=total;
                        this.ratio=ratio;
                        this.change=change;
                }
        }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
       PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
               return Double.compare(b.change,a.change);
       });
            
            
            for(int i=0;i<classes.length;i++){
                    int pass=classes[i][0];
                    int total=classes[i][1];
                    double ratio=(double)((double)pass/(double)total);
                                      
               

                   
                    double change=((double)pass+1)/((double)total+1)-ratio;
                    
                    pq.add(new pair(pass,total,ratio,change));

            }
            
            while(extraStudents-->0){
                  pair p=  pq.poll();
                  int pass=p.pass;
                  pass+=1;
                  int total=p.total;
                   total+=1;
                                       


                                    double ratio=(double)((double)pass/(double)total);

                  
                                      double change=((double)pass+1)/((double)total+1)-ratio;

                   pq.add(new pair(pass,total,ratio,change));
            }
            
         double ans=0;
           int size=classes.length;
          
           
            while(pq.size()!=0){
                 pair p=   pq.poll();
                   ans+=p.ratio;
                   // System.out.println(p.ratio);
            }
            
            ans=ans/size;
            
            return ans;
            
            
            
    }
}