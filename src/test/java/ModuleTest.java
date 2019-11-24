import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ModuleTest {
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
    Module m3;

    String m1name;
    String m2name;
    String m3name;

    ArrayList<CourseProgramme> m1courses;
    ArrayList<CourseProgramme> m2courses;
    ArrayList<CourseProgramme> m3courses;

    DateTime m1start;
    DateTime m2start;
    DateTime m3start;

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
        c1start = new DateTime(2016, 9, 1, 0, 0, 0, 0);
        c1 = new CourseProgramme(c1name, c1students, c1start);

        c2name = "Computer Science";
        c2students = new ArrayList<Student>();
        c2students.add(s3);
        c2start = new DateTime(2016, 9, 1, 0, 0, 0, 0);
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

        m3name = "Computer Algorithms";
        m3courses = new ArrayList<CourseProgramme>();
        m3courses.add(c2);
        m3start = new DateTime(2020, 1, 9, 0,0,0,0);
        m3 = new Module(m3name, m3courses, m3start);
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
        m3 = null; m3name = null; m3start = null; m3courses = null;
    }

    @Test
    public void testSetStudents() {
        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.addAll(c1.getStudents());
        studentsArr.addAll(c2.getStudents());
        m1.setStudents(studentsArr);
        assertEquals(studentsArr, m1.getStudents());
    }

    @Test
    public void testAddCourse() {
        m2.addCourse(c2);

        ArrayList<CourseProgramme> coursesArr = new ArrayList<CourseProgramme>();
        coursesArr.add(c1);
        coursesArr.add(c2);
        assertEquals(coursesArr, m2.getCourses());

        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.addAll(c1.getStudents());
        studentsArr.addAll(c2.getStudents());
        assertEquals(studentsArr, m2.getStudents());
    }

    @Test
    public void testRemoveCourse() {
        m2.removeCourse(c2);

        ArrayList<CourseProgramme> coursesArr = new ArrayList<CourseProgramme>();
        coursesArr.add(c1);
        assertEquals(coursesArr, m2.getCourses());

        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.addAll(c1.getStudents());
        assertEquals(studentsArr, m2.getStudents());
    }

    @Test
    public void testSetCourse() {
        ArrayList<CourseProgramme> coursesArr = new ArrayList<CourseProgramme>();
        coursesArr.add(c1);
        coursesArr.add(c2);
        m2.setCourses(coursesArr);
        assertEquals(coursesArr, m2.getCourses());

        ArrayList<Student> studentsArr = new ArrayList<Student>();
        studentsArr.addAll(c1.getStudents());
        studentsArr.addAll(c2.getStudents());
        assertEquals(studentsArr, m2.getStudents());
    }

    @Test
    public void testModuleName() {
        assertEquals(m1name, m1.getModuleName());

        m1name = "Java Programming";
        m1.setModuleName(m1name);
        assertEquals(m1name, m1.getModuleName());
    }

    @Test
    public void testIdGeneration() {
        assertTrue(m2.getId().length() == 5 && m2.getId().contains("CT"));
    }

    @Test
    public void testDates() {
        assertEquals(m1start, m1.getStartDate());
        assertEquals(m1start.plusWeeks(12), m1.getEndDate());
    }
}