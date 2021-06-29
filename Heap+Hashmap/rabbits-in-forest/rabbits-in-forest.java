class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
            int answer=0;
          for(int i=0;i<answers.length;i++){
                  
                  if(answers[i]==0){
                          answer++;
                          continue;
                  }
                  
                    if(map.containsKey(answers[i])){
                           
                            if(map.get(answers[i])==answers[i]){
                                    map.remove(answers[i]);
                            }else{
                                    map.put(answers[i],map.get(answers[i])+1);
                            }
                         
                    }else{
                            map.put(answers[i],1);
                            answer+=answers[i]+1;
                                                              

                            
                    }    
          }
            
            
//                 for (Map.Entry mapElement : map.entrySet()) {
//             int key = (int)mapElement.getKey();
                        
//                         answer+=key*2;
        
//         }
            
            return answer;
            
            
            
            
    }
}