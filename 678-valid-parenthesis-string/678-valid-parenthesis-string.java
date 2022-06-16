class Solution {

    /*
    idea - we try to balance ( with ) first because any extra star can be converted into a empty string

 dry run on this->"*(()*)))" 
 
 now there can be some  edge cases like  **( ,so after iteration if the size of the opening bracket is greater than zero then try to match  ( with * which occur after the (
 
 if we are not able to match ) with any ( or star then we are sure that the string is not balanced

https://www.youtube.com/watch?v=KuE_Cn3xhxI  */
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> star = new Stack<>(), open = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (open.size() > 0) open.pop();  //first match with (
                else if (star.size() > 0) star.pop(); // if no ( are their try to balance it with *
                else return false; 
            } else if (ch == '*') {
                star.push(i);
            } else {
                open.push(i);
            }
        }
        
        //if after iteration some open brackets remain eg-> (()* ,match ( with stars coming after (
        
        
        while(open.size()>0){
            
            if(star.size()==0)return false;
            
            if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }
            else return false;
        }
        return true;
        
    }
}
