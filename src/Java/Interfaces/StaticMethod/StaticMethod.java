package Java.Interfaces.StaticMethod;

//Static Method and Instance Variable

public class StaticMethod {

    int score; //Instance variable
    static int staticScore = 500; //static variable
    
    void setScore(int score){
        this.score = score;
    }

    static void printStaticScore(){
        System.out.println(staticScore);
        //System.out.println(score); //not allowed
    }

    public static void main(String[] args) {
        StaticMethod sm = new StaticMethod();
        sm.setScore(100);
        System.out.println(sm.score); //call to instance variable

        System.out.println(StaticMethod.staticScore); //call to static variable

        sm.printStaticScore(); // this works but gives warning 

    }
    
}
