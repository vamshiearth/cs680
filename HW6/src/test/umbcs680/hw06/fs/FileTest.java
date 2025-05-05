import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw06.fs.Directory;
import umbcs680.hw06.fs.File;
import umbcs680.hw06.fs.FileSystem;
import umbcs680.hw06.fs.TestFixtureInitializer;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset the singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using TestFixtureInitializer
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    /**
     * Test the isDirectory method to verify whether a file or directory is correctly identified as a directory.
     */
    @Test
    void isDirectory() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();

        // Test for Directory objects - should return true
        assertTrue(umbcs680.isDirectory(), "'umbcs680' should be a directory.");
        assertTrue(src.isDirectory(), "'src' should be a directory.");

        // Test for File object - should return false
        assertFalse(aJava.isDirectory(), "'A.java' should not be a directory.");
    }
}
