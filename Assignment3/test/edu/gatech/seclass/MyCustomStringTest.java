package test.edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.edu.gatech.seclass.MyCustomStringInterface;
import src.edu.gatech.seclass.MyCustomString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        //test complex string with space and punctuation
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        //empty string
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        //test null
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        //test simple numbers
        mycustomstring.setString("123");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        //test complicated strings with punctuations
        mycustomstring.setString(" 1abc2def3ghi 4, lmn5");
        assertEquals(5, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        //test complex string without punctuations
        mycustomstring.setString("My numbers are 11 and 9");
        assertEquals(2, mycustomstring.countNumbers());
    }
    @Test
    public void testCountNumbers7() {
        //test space only
        mycustomstring.setString(" ");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testRotateCharacters1() {
        //test complex strings with punctuations with right = true
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("2341!! !3y,Hl3t 5 p't 5ume 0161ds it thns 5ir1nt!1161!", mycustomstring.rotateCharacters(4, false));
    }

    @Test
    public void testRotateCharacters2() {
        //test complex string with right = false
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("4123 !!!,H3yt l3p'5 5ut  0me1d16its hn t5is ntr116!11!", mycustomstring.rotateCharacters(4, true));
    }

    @Test
    public void testRotateCharacters3() {
        //test shorter string with right = true
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("ehll o09 ,yb e2", mycustomstring.rotateCharacters(2, true));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters4() {
        //test longer numbers only
        mycustomstring.setString("1234567890");
        assertEquals("4123856709", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters5() {
        //test strings with space and punctuation with right = false
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("ehll o09 ,yb e2", mycustomstring.rotateCharacters(2, false));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters6() {
        //test longer number with right = false
        mycustomstring.setString("1234567890");
        assertEquals("2341678509", mycustomstring.rotateCharacters(4, false));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters7() {
        //test different ending number of digits with right = false
        mycustomstring.setString("12345678901");
        assertEquals("23416785019", mycustomstring.rotateCharacters(4, false));
        //fail("Not yet implemented");
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters8() {
        //test different ending numbers with right = true
        mycustomstring.setString("12345678901");
        assertEquals("41238567190", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters9() {
        //test numbers < n with right = true
        mycustomstring.setString("123");
        assertEquals("312", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters10() {
        //test single number
        mycustomstring.setString("1");
        assertEquals("1", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters11() {
        //test single number with 1 letter
        mycustomstring.setString("1m");
        assertEquals("m1", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
    }

    @Test
    public void testRotateCharacters12() {
        //test single letter with single space and number
        mycustomstring.setString(" 1m");
        assertEquals("m 1", mycustomstring.rotateCharacters(4, true));
        //fail("Not yet implemented");
    }


    @Test
    public void testConvertLettersToDigitsInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(18, 30);
        assertEquals("H3y, l3t'5 put 50m5 416120,19 9,14 20his 5tr1n6!11!!", mycustomstring.getString());
    }

    @Test(expected = NullPointerException.class)
    public void testConvertLettersToDigitsInSubstring2() {
        MyCustomString string = new MyCustomString();
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }

    @Test
    public void testConvertLettersToDigitsInSubstring3() {

        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(0,0);
        assertEquals("83y, l3t'5 put 50me D161ts in this 5tr1n6!11!!", mycustomstring.getString());
    }

    @Test
    public void testConvertLettersToDigitsInSubstring4() {
        mycustomstring.setString(null);
        mycustomstring.convertLettersToDigitsInSubstring(0,0);
        assertEquals(null, mycustomstring.getString());
    }

    @Test
    public void testConvertLettersToDigitsInSubstring5() {

        mycustomstring.setString("");
        mycustomstring.convertLettersToDigitsInSubstring(0,0);
        assertEquals("", mycustomstring.getString());
        //fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring7() {
        mycustomstring.setString(" ");
        mycustomstring.convertLettersToDigitsInSubstring(0,0);
        assertEquals(" ", mycustomstring.getString());
        //fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring8() {
        mycustomstring.setString("Dog");
        mycustomstring.convertLettersToDigitsInSubstring(0,2);
        assertEquals("4,15,7", mycustomstring.getString());
        //fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring9() {
        mycustomstring.setString("3 Cats.");
        mycustomstring.convertLettersToDigitsInSubstring(0,6);
        assertEquals("3 3,1,20,19.", mycustomstring.getString());
        //fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring10() {
        mycustomstring.setString(" c c c c ");
        mycustomstring.convertLettersToDigitsInSubstring(0,8);
        assertEquals(" 3 3 3 3 ", mycustomstring.getString());
        //fail("Not yet implemented");
    }

}
