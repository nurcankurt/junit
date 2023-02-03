import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void InvalidInputTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outstream));
        String input = "xyz";
        App.handleInput(input);
        String actual = outstream.toString();
        String expected = "Invalid input!";
        assertEquals(expected,actual);

    }

    @Test
    public void ValidInputTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        String input = "help";
        App.handleInput(input);
        String actual = outstream.toString();
        String expected = "";
        assertEquals(expected,actual);
    }
  /*  @Test
    public void QuitTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        App.Commands.quit();
        String actual = outstream.toString();
        String expected = "Goodbye!";
        Assertions.assertEquals(expected,actual);
    }*/


}
