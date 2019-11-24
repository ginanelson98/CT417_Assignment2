import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CourseProgrammeTest {
    Student s1;
    Student s2;
    Student s3;

    String s1name;
    String s2name;
    String s3name;

    DateTime s1dob;
    DateTime s2dob;
    DateTime s3dob;

    CourseProgramme c1;
    CourseProgramme c2;

    String c1name;
    String c2name;

    ArrayList<Student> c1students;
    ArrayList<Student> c2students;

    DateTime c1start;
    DateTime c2start;

    Module m1;
    Module m2;

    String m1name;
    String m2name;

    ArrayList<CourseProgramme> m1courses;
    ArrayList<CourseProgramme> m2courses;

    DateTime m1start;
    DateTime m2start;

    @Before
    public void setUp() {
        s1name = "Anna";
        s1dob = new DateTime(1998, 1, 2, 0, 0, 0, 0);
        s1 = new Student(s1name, s1dob);

        s2name = "Ben";
        s2dob = new DateTime(1997, 3, 4, 0, 0, 0, 0);
        s2 = new Student(s2name, s2dob);

        s3name = "Conor";
        s3dob = new DateTime(1996, 5, 6, 0, 0, 0, 0);
        s3 = new Student(s3name, s3dob);

        c1name = "Engineering";
        c1students = new ArrayList<Student>();
        c1students.add(s1);
        c1start = new DateTime(2019, 9, 1, 0, 0, 0, 0);
        c1 = new CourseProgramme(c1name, c1students, c1start);

        c2name = "Computer Science";
        c2students = new ArrayList<Student>();
        c2students.add(s2);
        c2students.add(s3);
        c2start = new DateTime(2019, 1, 9, 0, 0, 0, 0);
        c2 = new CourseProgramme(c2name, c2students, c2start);

        m1name = "Digital Systems";
        m1courses = new ArrayList<CourseProgramme>();
        m1courses.add(c1);
        m1start = new DateTime(2018, 9, 1, 0,0,0,0);
        m1 = new Module(m1name, m1courses, m1start);

        m2name = "Software Engineering";
        m2courses = new ArrayList<CourseProgramme>();
        m2courses.add(c1);
        m2start = new DateTime(2019, 9, 1, 0,0,0,0);
        m2 = new Module(m2name, m2courses, m2start);
    }

    @After
    public void tearDown() {
        s1name = null; s1dob = null; s1 = null;
        s2name = null; s2dob = null; s2 = null;
        s3name = null; s3dob = null; s3 = null;
        c1 = null; c1name = null; c1students = null; c1start = null;
        c2 = null; c2name = null; c2students = null; c2start = null;
        m1 = null; m1name = null; m1start = null; m1courses = null;
        m2 = null; m2name = null; m2start = null; m2courses = null;
    }

    @Test
    public void testAddStudent() {
        c1.addStudent(s2);
        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.add(s1);
        studentsArr.add(s2);
        assertEquals(studentsArr, c1.getStudents());
    }

    @Test
    public void testRemoveStudent() {
        c2.removeStudent(s2);
        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.add(s3);
        assertEquals(studentsArr, c2.getStudents());
    }

    @Test
    public void testModules() {
        ArrayList<Module> modsArr = new ArrayList<Module>();
        modsArr.add(m1);
        modsArr.add(m2);
        c1.addModule(m1);
        c1.addModule(m2);
        assertEquals(modsArr, c1.getModules());

        modsArr.remove(m2);
        c1.removeModule(m2);
        assertEquals(modsArr, c1.getModules());

        modsArr.add(m2);
        c1.setModules(modsArr);
        assertEquals(modsArr, c1.getModules());
    }

    @Test
    public void testCourseName() {
        assertEquals(c1name, c1.getCourseName());

        c1name = "Data Analytics";
        c1.setCourseName(c1name);
        assertEquals(c1name, c1.getCourseName());
    }

    @Test
    public void testSetStudents() {
        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.add(s1);
        studentsArr.add(s2);
        c1.setStudents(studentsArr);
        assertEquals(studentsArr, c1.getStudents());
    }

    @Test
    public void testDates() {
        assertEquals(c1start, c1.getStartDate());
        assertEquals(c1start.plusYears(4), c1.getEndDate());
    }
}