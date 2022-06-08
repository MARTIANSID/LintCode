/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Integer> map;
    public int getImportance(List<Employee> employees, int id) {
        
        map=new HashMap<>();
        int index=0;
        for(Employee e:employees){
            map.put(e.id,index++);
        }
        
        return dfs(employees,id);
    }
    
    public int dfs(List<Employee> emp,int id){
        
        int count=0;
        for(int sub: emp.get(map.get(id)).subordinates){
            count+=dfs(emp,sub);
        }
        return count+emp.get(map.get(id)).importance;
    }
}