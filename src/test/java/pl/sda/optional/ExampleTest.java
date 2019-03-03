package pl.sda.optional;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Optional;

public class ExampleTest {


    @Test
    public void whenCreateEmptyOptional_thenReturnFalse(){
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull(){
        String name = "testowa wartosc";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[testowa wartosc]", opt.toString());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenErrorOnCreate_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.of(name);
    }

    @Test
    public void givenNull_whenCreateNullable_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }

    @Test
    public void givenOptional_whenIfPresentOk_thenCorrect(){

        Optional<String> name = Optional.of("Maciej");

        name.ifPresent(n -> System.out.println("Witaj: " + n));

        if(name.isPresent()) {
            System.out.println("Witaj: " + name);
        }
    }

    @Test(expected = IllegalArgumentException)
    public void whenOrElseWorks_thenCorrect(){
        String name = null;
        String nameGood = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);

        Optional<String> opt = Optional.of("Wartosc");
        opt.get();
        System.out.println(opt);

    }

}