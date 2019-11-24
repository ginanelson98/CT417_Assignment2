import org.joda.time.DateTime;
import java.util.ArrayList;

public class CourseProgramme {
    private String courseName;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private DateTime startDate;
    private DateTime endDate;

    // Constructors
    public CourseProgramme(String courseName, ArrayList<Student> students, DateTime startDate) {
        this.courseName = courseName;
        this.students = students;
        setDates(startDate);
        modules = new ArrayList<Module>();
    }
    
    // Mutators
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
    
    public void addModule(Module module){
        modules.add(module);
    }

    public void removeModule(Module module){
        modules.remove(module);
    }

    // Setters
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setDates(DateTime startDate) {
        this.startDate = startDate;
        this. endDate = startDate.plusYears(4);
    }

    // Getters
    public String getCourseName(){ return courseName; }

    public ArrayList<Module> getModules() { return modules; }

    public ArrayList<Student> getStudents() { return students; }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }
}
