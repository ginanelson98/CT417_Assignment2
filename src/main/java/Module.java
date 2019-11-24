import org.joda.time.DateTime;
import java.util.ArrayList;

public class Module {
    private String moduleName;
    private String id;
    private ArrayList<Student> students;
    private ArrayList<CourseProgramme> courses;
    private DateTime startDate;
    private DateTime endDate;

    //constructors
    public Module(String moduleName, ArrayList<CourseProgramme> courses, DateTime startDate) {
        this.moduleName = moduleName;
        this.courses = courses;
        this.students = new ArrayList<Student>();
        generateId();
        for (CourseProgramme course : courses) {
            this.students.addAll(course.getStudents());
        }
        setDates(startDate);
    }

    // mutators
    public void addCourse(CourseProgramme course){
        courses.add(course);
        students.addAll(course.getStudents());
    }

    public void removeCourse(CourseProgramme course){
        courses.remove(course);
        students.removeAll(course.getStudents());
    }

    //setters
    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }

    public void setCourses(ArrayList<CourseProgramme> courses){
        this.courses = courses;
        ArrayList<Student> newstudents = new ArrayList<Student>();
        for (CourseProgramme course : courses) {
            newstudents.addAll(course.getStudents());
        }
        this.students = newstudents;
    }

    private void generateId(){
        int intid = (int) (Math.random() * ((999-100)+1)) + 100;
        id = "CT" + intid;
    }

    public void setDates(DateTime startDate) {
        this.startDate = startDate;
        this. endDate = startDate.plusWeeks(12);
    }

    //getters
    public String getModuleName(){
        return moduleName;
    }

    public String getId(){
        return id;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<CourseProgramme> getCourses(){
        return courses;
    }

    public DateTime getStartDate() { return startDate; }

    public DateTime getEndDate() { return endDate; }
}
