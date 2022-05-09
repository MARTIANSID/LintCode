class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        List<String> ans=new ArrayList<>();
        
        findAllCombinations(ans,"",map,digits,0);
        
        return ans;
        
    }
    public void findAllCombinations(List<String> ans,String asf,HashMap<Character,String> map,String digits,int index){
        if(index == digits.length()){
            if(!asf.equals(""))
            ans.add(asf);
            return;
        }   
        char ch=digits.charAt(index);
        String mapping=map.get(ch);
        
        for(int i=0;i<mapping.length();i++){
            findAllCombinations(ans,asf+mapping.charAt(i),map,digits,index+1);
        }
        
    }
}