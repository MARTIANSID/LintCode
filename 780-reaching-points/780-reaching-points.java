class Solution {
    
    /*
    reduce both in normal form 
    this will work
    why 
    
    lets say (x,y) arrives at - > (a,b)
    and (p,q) arrives at. -> (a,b)
    they both arrive at (a,b) after doing reverse operations
    
    now from (a,b) we can form (p,q) and (x,y)
    therefore both (x,y) and (p,q) are equivalent
    
    but the problem is we cant convert sx and sy in normal form because we cannot apply reverse operations on sx and sy
    
    therefore if we can convert tx and ty to sx and sy then only we can return true
    
    */ 
    
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        if(tx<sx || ty<sy)return false;
        
        while(tx>=sx && ty>=sy){
            if(tx==sx && ty==sy)return true;
            if(tx==0 || ty==0)return false;
            
            if(tx>ty){
                if(tx==sx)return false;
                int ele=tx%ty;
                if(ele<sx){
                    int e=sx%ty;
                    if(e==ele){
                        tx=sx;
                    }else{
                        return false;
                    }
                }else{
                    tx=ele;
                }
            }else{
                if(ty==sy)return false;
                int ele=ty%tx;
                if(ele<sy){
                    int e=sy%tx;
                    if(e==ele){
                        ty=sy;
                    }else{
                        return false;
                    }
                }else{
                    ty=ele;
                }
            }
        }
        
         return false;
        
    }
}

 /*
 
 (9,19)->(9,10) 
 
 (9,1) -> (1,1)
 
*/
