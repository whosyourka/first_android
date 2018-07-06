package first.person.com.katekit.githubpersonfirst;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        String test = "dsfsdf\n";

        String test1 = (!test.contains("\n")) ? test : test.substring(0, test.indexOf("\n"));

        assertEquals(test,test1+"\n");



    }



    @Test
    public void addition_isCorrect1() throws Exception {
        assertEquals(4, 2 + 2);

        String test = "dsfsdf";

        String test1 = (!test.contains("\n")) ? test : test.substring(0, test.indexOf("\n"));

        assertEquals(test,test1);

    }
}
