import com.sun.org.apache.xpath.internal.operations.Mod;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student s1;
    String s1name;
    DateTime s1dob;

    CourseProgramme c1;
    String c1name;
    ArrayList<Student> c1students;
    DateTime c1start;

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

        c1name = "Engineering";
        c1students = new ArrayList<Student>();
        c1students.add(s1);
        c1start = new DateTime(2019, 9, 1, 0, 0, 0, 0);
        c1 = new CourseProgramme(c1name, c1students, c1start);

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
        c1 = null; c1name = null; c1students = null; c1start = null;
        m1 = null; m1name = null; m1start = null; m1courses = null;
        m2 = null; m2name = null; m2start = null; m2courses = null;
    }

    @Test
    public void testGenerateId() {
        assertTrue(10000000 <= s1.getID() && 19999999 > s1.getID());
    }

    @Test
    public void testSetName() {
        assertEquals(s1name, s1.getName());
        s1name = "Aaron";
        s1.setName(s1name);
        assertEquals(s1name, s1.getName());
    }

    @Test
    public void testSetDob() {
        assertEquals(s1dob, s1.getDob());
        DateTime cur;
        cur = DateTime.now();
        assertEquals(21, s1.getAge());
    }

    @Test
    public void testSetId() {
        s1.setId(16332886);
        assertEquals(16332886, s1.getID());
    }

    @Test
    public void testSetCourse() {
        s1.setCourse(c1);
        assertEquals(c1, s1.getCourse());
    }

    @Test
    public void testSetModules() {
        ArrayList<Module> modsArr = new ArrayList<Module>();
        modsArr.add(m1);
        modsArr.add(m2);
        s1.setModules(modsArr);
        assertEquals(modsArr, s1.getModules());
    }

    @Test
    public void testGetUsername() {
        assertEquals(s1name+"21", s1.getUsername());
    }
}