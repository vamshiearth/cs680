import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw06.fs.Directory;
import umbcs680.hw06.fs.File;
import umbcs680.hw06.fs.FileSystem;
import umbcs680.hw06.fs.TestFixtureInitializer;

import static org.junit.jupiter.api.Assertions.*;

class FSElementTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem();
        TestFixtureInitializer.getFileSystem();
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem();
    }

    /**
     * Test the getParent method to ensure that a file or directory correctly reports its parent.
     */
    @Test
    void getParent() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();

        // File parent checks
        assertEquals(src, aJava.getParent(), "'A.java' should have 'src' as its parent.");
        assertEquals(src, bJava.getParent(), "'B.java' should have 'src' as its parent.");

        // Directory parent checks
        assertEquals(umbcs680, hw01.getParent(), "'hw01' should have 'umbcs680' as its parent.");
        assertEquals(hw01, src.getParent(), "'src' should have 'hw01' as its parent.");

        // Root directory should have no parent
        assertNull(umbcs680.getParent(), "'umbcs680' should have no parent.");
    }

    /**
     * Test the getName method to verify that files and directories return the correct names.
     */
    @Test
    void getName() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();

        // File name checks
        assertEquals("A.java", aJava.getName());
        assertEquals("B.java", bJava.getName());

        // Directory name checks
        assertEquals("umbcs680", umbcs680.getName());
        assertEquals("hw01", hw01.getName());
        assertEquals("src", src.getName());
    }

    /**
     * Test the getTotalSize method to verify directory sizes are computed correctly.
     */
    @Test
    void testGetTotalSize() {
        Directory src = TestFixtureInitializer.getSrc();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();

        // Total size of src = A.java + B.java = 50 + 70 = 120
        assertEquals(120, src.getTotalSize(), "'src' should have a total size of 120.");

        // Total size of hw01 = src (120) + build.xml (30) = 150
        assertEquals(150, hw01.getTotalSize(), "'hw01' should have a total size of 150.");

        // Total size of umbcs680 = hw01 (150) + readme.md (100) = 250
        assertEquals(250, umbcs680.getTotalSize(), "'umbcs680' should have a total size of 250.");
    }

    /**
     * Test the getCreationTime method to ensure all elements have valid timestamps.
     */
    @Test
    void getCreationTime() {
        File aJava = TestFixtureInitializer.getAJava();
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();

        assertNotNull(aJava.getCreationTime(), "'A.java' should have a creation time.");
        assertNotNull(umbcs680.getCreationTime(), "'umbcs680' should have a creation time.");
    }

    /**
     * Test the isDirectory method for both files and directories.
     */
    @Test
    void isDirectory() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();

        assertTrue(umbcs680.isDirectory(), "'umbcs680' should be a directory.");
        assertTrue(src.isDirectory(), "'src' should be a directory.");
        assertFalse(aJava.isDirectory(), "'A.java' should not be a directory.");
    }
}
