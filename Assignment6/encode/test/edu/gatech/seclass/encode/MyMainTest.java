package edu.gatech.seclass.encode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class MyMainTest {
	
/*
Place all  of your tests in this class, optionally using MainTest.java as an example.
*/

    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
        System.setErr(errOrig);
    }

    // Some utilities

    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }

    private File createInputFile1() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write(" Xiangnan He");

        fileWriter.close();
        return file1;
    }

    private File createInputFile2() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("Twinkle, twinkle, little star,\n" +
                "How I wonder what you are!\n" +
                "Up above the world so high,\n" +
                "Like a diamond in the sky.");

        fileWriter.close();
        return file2;
    }

    private File createInputFile3() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("k");

        fileWriter.close();
        return file1;
    }

    private File createInputFile4() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("");

        fileWriter.close();
        return file1;
    }

    private File createInputFile5() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("5");

        fileWriter.close();
        return file1;
    }

    private File createInputFile6() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("0123456789");

        fileWriter.close();
        return file1;
    }

    private File createInputFile7() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("abc@#$");

        fileWriter.close();
        return file1;
    }

    private File createInputFile8() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("   ");

        fileWriter.close();
        return file1;
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    // test cases

    // Purpose: To check character removal "-d" when number of distinct character smaller than that in inputfile
    // Frame #: Test Case 46
    @Test
    public void encodeTest1() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-d", "xiang", inputFile1.getPath()};
        Main.main(args);

        String expected1 = "Nk";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To check if program error out if input file is empty
    // Frame #: Test Case 11
    @Test
    public void encodeTest2() throws Exception {
        File inputFile4 = createInputFile4();

        String args[] = {inputFile4.getPath()};
        Main.main(args);

        String expected4 = "";

        String actual4 = getFileContent(inputFile4.getPath());

        assertEquals("The files differ!", expected4, actual4);
    }

    // Purpose: To check when input file only contains 1 lowercase alpha character
    // Frame #: Test Case 18
    @Test
    public void encodeTest3() throws Exception {
        File inputFile3 = createInputFile3();

        String args[] = {inputFile3.getPath()};
        Main.main(args);

        String expected3 = "q";

        String actual3 = getFileContent(inputFile3.getPath());

        assertEquals("The files differ!", expected3, actual3);
    }

    // Purpose: To check when input file only contains 1 numerical character
    // Frame #: Test Case 26
    @Test
    public void encodeTest4() throws Exception {
        File inputFile5 = createInputFile5();

        String args[] = {inputFile5.getPath()};
        Main.main(args);

        String expected5 = "5";

        String actual5 = getFileContent(inputFile5.getPath());

        assertEquals("The files differ!", expected5, actual5);
    }


    // Purpose: To check if argument has dash before it, if not, throw error
    // Frame #: Test Case 1
    @Test
    public void encodeTest5() {
        File inputFile1 = createInputFile1();

        String args[] = {"r", inputFile1.getPath()}; //invalid argument
        Main.main(args);
        assertEquals("Usage: Encode  [-c int] [-d string] [-r] <filename>", errStream.toString().trim());
    }


    // Purpose: To check if shift arguement is <0, if yes, throw error
    // Frame #: Test Case 2
    @Test
    public void encodeTest6() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-c", "-2", inputFile1.getPath()};
        Main.main(args);
        assertEquals("Usage: Encode  [-c int] [-d string] [-r] <filename>", errStream.toString().trim());
    }

    // Purpose: Throw error if there is alpha character after "-c"
    // Frame #: Test Case 5
    @Test
    public void encodeTest7() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-c", "i", inputFile1.getPath()};
        Main.main(args);
        assertEquals("Usage: Encode  [-c int] [-d string] [-r] <filename>", errStream.toString().trim());
    }

    // Purpose: Throw error if numeric character after "-d"
    // Frame #: Test Case 6
    @Test
    public void encodeTest8() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-d", "3", inputFile1.getPath()};
        Main.main(args);
        assertEquals("Usage: Encode  [-c int] [-d string] [-r] <filename>", errStream.toString().trim());
    }

    // Purpose: Throw error if argument has dash followed by character other than "c", "d", "r"
    // Frame #: Test Case 10
    @Test
    public void encodeTest9() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m", "3", inputFile1.getPath()};
        Main.main(args);
        assertEquals("Usage: Encode  [-c int] [-d string] [-r] <filename>", errStream.toString().trim());
    }

    // Purpose: To check when input file size >1 and remove match "-d" string length >0
    // Frame #: Test Case 47
    @Test
    public void encodeTest10() throws Exception {
        File inputFile2 = createInputFile2();

        String args[] = {"-d", "eaot", inputFile2.getPath()};
        Main.main(args);

        String expected2 = "cotqr, cotqr, ror yx,\n"
                + "Nc O ctjx cnz eax!\n"
                + "Av hb n cxrj y nomn,\n"
                + "Roq jostj ot n yqe.";

        String actual2 = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected2, actual2);
    }

    // Purpose: To check when input file size >1 and reverse and remove match string size >0
    // Frame #: Test Case 45
    @Test
    public void encodeTest11() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-c", "2", "-d", "ax", "-r" inputFile1.getPath()};
        Main.main(args);

        String expected1 = "gJ ppipk ";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To check when remove match string contains all distinct character in input file
    // Frame #: Test Case 9
    @Test
    public void encodeTest12() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-d", "xianghemlc", inputFile1.getPath()};
        Main.main(args);

        String expected1 = "  ";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To check when input file is numeric characters with reverse and remove matches
    // Frame #: Test Case 57
    @Test
    public void encodeTest13() throws Exception {
        File inputFile6 = createInputFile6();

        String args[] = {"-c", "2", "-d", "abc", "-r" inputFile6.getPath()};
        Main.main(args);

        String expected6 = "9876543210";

        String actual6 = getFileContent(inputFile6.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }

    // Purpose: To check when input file contains special characters with reverse and remove matches
    // Frame #: Test Case 65
    @Test
    public void encodeTest14() throws Exception {
        File inputFile7 = createInputFile7();

        String args[] = {"-c", "2", "-d", "a", "-r", inputFile7.getPath()};
        Main.main(args);

        String expected7 = "$#@ed";

        String actual7 = getFileContent(inputFile7.getPath());

        assertEquals("The files differ!", expected7, actual7);
    }

    // Purpose: To check with input file is only spaces
    // Frame #: Test Case 75
    @Test
    public void encodeTest15() throws Exception {
        File inputFile8 = createInputFile8();

        String args[] = {"-c", "2", "-d", "abc", inputFile8.getPath()};
        Main.main(args);

        String expected8 = "   ";

        String actual8 = getFileContent(inputFile8.getPath());

        assertEquals("The files differ!", expected8, actual8);
    }

}
