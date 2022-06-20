class Solution {

    /*
    Greedy logic - > get frequency of each character
    
    with even frequency character we can always form a palindrome
    problem arise with odd freq character 
    observation - > we can add odd characters in even freq ch palindromes  
    
    
    observation - > if number of palindromes are more than the k value then what??
    
    there is no way to form k palindrome string 
    
    
    */
    public boolean canConstruct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Set<Character> set = map.keySet();

        int odd = 0, even = 0;
        for (char ch : set) {
            int ele = map.get(ch);
            if (ele % 2 == 0) {
                even += (ele);
            } else {
                even += (ele -1);
                odd++;
            }
        }
        
        if (odd > k) return false;
        if (odd + (even) >= k) return true;
        return false;
    }
}
