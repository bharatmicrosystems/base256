package org.ga.base256;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException
    {
    	String encodedString = Base256.base256Encode(FileUtils.readFileToByteArray(new File("src/test/resources/img.jpg")));
		byte[] decodedString = Base256.base256Decode(encodedString);
		FileUtils.writeByteArrayToFile(new File("src/test/resources/img_out.jpg"), decodedString);
        assertTrue("Check if input and output files are equal", FileUtils.contentEquals(new File("src/test/resources/img.jpg"), new File("src/test/resources/img_out.jpg")));
    }
}
