package os;

public class resource_allocation {
    public static void main(String[] args){
        String A="1.7";
        String B="2.1";
         String[] version1=A.split("\\.");
        String[] version2=B.split("\\.");
       
      
        for(int i=0;i<version1.length;i++){
            if(i<version2.length){
               int x= Integer.parseInt(version1[i]);
               int y=Integer.parseInt(version2[i]);
               if(x>y)System.out.println(1);
               if(y>x)System.out.println(-1);
            }else{
                System.out.println(1);
            }
        }
        if(version1.length==version2.length)System.out.println(0);
        else System.out.println(-1);
    }

}
