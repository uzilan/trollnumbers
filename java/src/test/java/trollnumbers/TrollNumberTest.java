package trollnumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static trollnumbers.TrollNumber.lots;
import static trollnumbers.TrollNumber.many;
import static trollnumbers.TrollNumber.one;
import static trollnumbers.TrollNumber.parse;
import static trollnumbers.TrollNumber.three;
import static trollnumbers.TrollNumber.two;

public class TrollNumberTest {

    @Test
    public void constants_should_have_correct_value() {
        assertEquals(1, one.getValue());
        assertEquals(2, two.getValue());
        assertEquals(3, three.getValue());
        assertEquals(4, many.getValue());
        assertEquals(16, lots.getValue());
    }

    @Test
    public void constants_should_have_correct_toString() {
        assertEquals("one", one.toString());
        assertEquals("two", two.toString());
        assertEquals("three", three.toString());
        assertEquals("many", many.toString());
        assertEquals("lots", lots.toString());
    }

    @Test
    public void parse_should_give_correct_value() {
        assertEquals(1, parse("one").getValue());
        assertEquals(2, parse("two").getValue());
        assertEquals(3, parse("three").getValue());
        assertEquals(4, parse("many").getValue());
        assertEquals(16, parse("lots").getValue());
    }

    @Test
    public void parse_wrong_stuff_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            parse("Foo");
        });
    }

    @Test
    public void parse_complex_numbers_should_give_correct_toString() {
        assertEquals("many-one", parse("many-one").toString());
        assertEquals("many-many", parse("many-many").toString());
        assertEquals("many-many-three", parse("many-many-three").toString());
    }

    @Test
    public void parse_complex_number_should_result_in_a_correct_value() {
        assertEquals(6, parse("many-two").getValue());
        assertEquals(11, parse("many-many-three").getValue());
        assertEquals(many.getValue(), parse("many").getValue());
        assertEquals(lots.getValue(), parse("many-many-many-many").getValue());
        assertEquals(lots.getValue(), parse("lots").getValue());
    }

    @Test
    public void parse_too_big_number_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            parse("many-many-many-many-many-two");
        });
    }
}
