import org.joda.time.DateTime;
import org.joda.time.Period;
import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private DateTime dob;
    private int id;
    private String username;
    private CourseProgramme course;
    private ArrayList<Module> modules;

    // Constructors
    public Student(String name, DateTime dob) {
        this.name = name;
        setDob(dob);
        generateId();
    }

    public void generateId(){
        id = (int) (Math.random() * ((19999999 - 10000000) +1)) +10000000;
    }

    // Setters
    public void setName(String name){ this.name = name; }

    public void setDob(DateTime dob) {
        this.dob = dob;
        calculateAge();
    }

    private void calculateAge(){
        DateTime currentDT;
        currentDT = DateTime.now();
        Period period = new Period(currentDT, dob);
        age = Math.abs(period.getYears());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(CourseProgramme course) {
        this.course = course;
    }

    public void setModules(ArrayList<Module> modules){
        this.modules = modules;
    }

    // Getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public DateTime getDob(){
        return dob;
    }

    public int getID(){
        return id;
    }

    public CourseProgramme getCourse(){
        return course;
    }

    public ArrayList<Module> getModules(){
        return modules;
    }

    public String getUsername(){
        username = name + age;
        return username;
    }
}
