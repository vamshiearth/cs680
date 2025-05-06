package umbcs680.hw11.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset the singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using the test fixture
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    /**
     * Test the isDirectory method to verify directory vs. file identification.
     */
    @Test
    void isDirectory() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();
        Link rmMd = TestFixtureInitializer.getRmMd();

        // Directory checks
        assertTrue(umbcs680.isDirectory(), "'umbcs680' should be a directory.");
        assertTrue(hw01.isDirectory(), "'hw01' should be a directory.");
        assertTrue(src.isDirectory(), "'src' should be a directory.");

        // File checks
        assertFalse(aJava.isDirectory(), "'A.java' should not be a directory.");
        assertFalse(bJava.isDirectory(), "'B.java' should not be a directory.");
        assertFalse(buildXml.isDirectory(), "'build.xml' should not be a directory.");
        assertFalse(readmeMd.isDirectory(), "'readme.md' should not be a directory.");
        assertFalse(rmMd.isDirectory(), "'rm.md' (link) should not be a directory.");
    }
}
