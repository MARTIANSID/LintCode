import java.util.ArrayList;
import java.util.List;

class fat{


    class student{
        String name;
        List<String> sportsEnrolled;
        int age;

        student(String name,int age){
            this.name=name;
            this.age=age;
            this.sportsEnrolled=new ArrayList<>();
        }
        
        public void addSport(String sportname){
            this.sportsEnrolled.add(sportname);
        }

        public int countOfSports(){
            return this.sportsEnrolled.size();
        }
    }

    public static void main(String[] args){

        List<student> above15=new ArrayList<>();

        above15.add(new student("harsh",20));
        above15.add(new student("sid",45));
        List<student> cricketOnly=new ArrayList<>();



    }



}