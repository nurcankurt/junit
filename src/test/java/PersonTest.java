import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void setBirthDateTest(){
        assertThrows(IllegalArgumentException.class, () -> {new Person("Nurcan","Kurt", LocalDate.parse("2025-01-01"));});
    }
    /*@Test
     public void isUnder18Test(){
         Person person = new Person("Sema","Altinisik", LocalDate.parse("2010-01-01"));
         assertFalse(person.isUnderAge());
     }
    @Test
    public void isAbove18Test(){
        Person person = new Person("Sema","Altinisik", LocalDate.parse("2004-01-01"));
        assertTrue(person.isUnderAge());
    }*/
    @ParameterizedTest
    @CsvSource(value = {
            "Sema,Altinisik,2006-01-01",
            "Nurcan,Kurt,2016-02-29",
            "Zeynep,Yilmaz,2018-02-03"
    })
    public void isUnder18Test(String name,String surname,String date){
        assertFalse(new Person(name,surname,LocalDate.parse(date)).isUnderAge());
    }
    @ParameterizedTest
    @CsvSource(value = {
            "Sema,Altinisik,2005-01-01",
            "Nurcan,Kurt,2001-01-01",
            "Zeynep,Yilmaz,1999-02-03"
    })
    public void isAbove18Test(String name,String surname,String date){
        assertTrue(new Person(name,surname,LocalDate.parse(date)).isUnderAge());
    }
    @Test
    public void setNameTest(){
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, () -> { person.setFirstName("a");});
    }

}
