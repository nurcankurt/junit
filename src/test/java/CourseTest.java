import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    @Test
    public void ConstructorTest(){
        Course course = new Course(10,"SENG");
        assertEquals("SENG",course.getCourseName());
        assertEquals(10,course.getMAX_STUDENTS());
    }

    @Test
    public void AddStudent(){
        Course course = new Course(1,"SENG");
        LocalDate dt = LocalDate.parse("2001-01-01");
        assertTrue(course.addStudent(new Person("Nurcan","Kurt",dt)));
    }

    @Test
    public void NotAddStudent(){
        Course course = new Course(1,"SENG");
        course.addStudent(new Person("Sema","Altinisik",LocalDate.parse("2001-01-01")));
        assertFalse(course.addStudent(new Person("Nurcan","Kurt",LocalDate.parse("2001-01-01"))));
    }

    @Test
    public void SetMaxTest(){
        Course course = new Course(10,"SENG");
        course.setMAX_STUDENTS(15);
        assertThat(15,is(course.getMAX_STUDENTS()));

    }
    @Test
    public void studentsInCourseTest(){
        Course course = new Course(4,"SENG303");
        course.addStudent(new Person("Sema","Altinisik",LocalDate.parse("2001-01-01")));
        course.addStudent(new Person("Nurcan","Kurt",LocalDate.parse("2001-01-01")));
        course.addStudent(new Person("sena","demir",LocalDate.parse("2000-02-02")));
        assertThat(3,is(course.studentsInCourse()));
    }

    @Test
    public void SetMaxIllegalExceptionTest(){
        Course course = new Course(10,"SENG");
        assertThrows(IllegalArgumentException.class, () -> {course.setMAX_STUDENTS(-20);});

    }
    @Test
    public void StudentCopyTest(){
        Course course = new Course(2,"SENG303");
        course.addStudent(new Person("can","berk",LocalDate.parse("2000-01-01")));
        course.addStudent(new Person("sena","demir",LocalDate.parse("2000-02-02")));
        List<Person> copyList = course.getStudentsCopy();
        assertThat(copyList,hasItems(
                new Person("can","berk",LocalDate.parse("2000-01-01")),
                new Person("sena","demir",LocalDate.parse("2000-02-02"))
                ));
    }
    @Test
    public void CourseCopyTest(){
        Course course = new Course(3,"SENG303");
        course.addStudent(new Person("can","berk",LocalDate.parse("2000-01-01")));
        course.addStudent(new Person("sena","demir",LocalDate.parse("2000-02-02")));
        Course copied = course.copyOf();
        assertEquals("SENG303",copied.getCourseName());
        assertEquals(3,copied.getMAX_STUDENTS());
        assertThat(copied.getStudents(),hasItems(
                new Person("can","berk",LocalDate.parse("2000-01-01")),
                new Person("sena","demir",LocalDate.parse("2000-02-02"))
        ));
    }




}
