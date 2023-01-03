class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");

        for (int i = 0; i < Math.max(vers1.length, vers2.length); i++) {
            int val1 = i >= vers1.length ? 0 : Integer.parseInt(vers1[i]);
            int val2 = i >= vers2.length ? 0 : Integer.parseInt(vers2[i]);
          
            if (val1 < val2)
                return -1;
            if (val2 < val1)
                return 1;
        }
        
            
        return 0;

    }
}