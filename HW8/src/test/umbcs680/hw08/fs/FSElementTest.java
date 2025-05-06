package umbcs680.hw08.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FSElementTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset singleton
        TestFixtureInitializer.getFileSystem(); // Initialize structure
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    /**
     * Test the getParent method for files, directories, and root.
     */
    @Test
    void getParent() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();
        Link rmMd = TestFixtureInitializer.getRmMd();

        // Files
        assertEquals(src, aJava.getParent(), "'A.java' should have 'src' as its parent.");
        assertEquals(src, bJava.getParent(), "'B.java' should have 'src' as its parent.");
        assertEquals(hw01, buildXml.getParent(), "'build.xml' should have 'hw01' as its parent.");
        assertEquals(umbcs680, readmeMd.getParent(), "'readme.md' should have 'umbcs680' as its parent.");

        // Directories
        assertEquals(hw01, src.getParent(), "'src' should have 'hw01' as its parent.");
        assertEquals(umbcs680, hw01.getParent(), "'hw01' should have 'umbcs680' as its parent.");

        // Link
        assertEquals(hw01, rmMd.getParent(), "'rm.md' should have 'hw01' as its parent.");

        // Root
        assertNull(umbcs680.getParent(), "'umbcs680' is the root and should have no parent.");
    }

    /**
     * Test the getName method for correct naming.
     */
    @Test
    void getName() {
        assertEquals("umbcs680", TestFixtureInitializer.getUmbcs680().getName());
        assertEquals("hw01", TestFixtureInitializer.getHw01().getName());
        assertEquals("src", TestFixtureInitializer.getSrc().getName());
        assertEquals("A.java", TestFixtureInitializer.getAJava().getName());
        assertEquals("B.java", TestFixtureInitializer.getBJava().getName());
        assertEquals("build.xml", TestFixtureInitializer.getBuildXml().getName());
        assertEquals("readme.md", TestFixtureInitializer.getReadmeMd().getName());
        assertEquals("rm.md", TestFixtureInitializer.getRmMd().getName());
    }

    /**
     * Test getTotalSize on a directory tree.
     */
    @Test
    void testGetTotalSize() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();

        // Expected total: A.java (10) + B.java (20) + build.xml (30) + readme.md (40) = 100
        assertEquals(100, umbcs680.getTotalSize(), "'umbcs680' total size should be 100.");
    }

    /**
     * Test creation time is set for elements.
     */
    @Test
    void getCreationTime() {
        assertNotNull(TestFixtureInitializer.getAJava().getCreationTime(), "'A.java' should have a creation time.");
        assertNotNull(TestFixtureInitializer.getUmbcs680().getCreationTime(), "'umbcs680' should have a creation time.");
    }

    /**
     * Test isDirectory identification.
     */
    @Test
    void isDirectory() {
        assertTrue(TestFixtureInitializer.getUmbcs680().isDirectory(), "'umbcs680' should be a directory.");
        assertTrue(TestFixtureInitializer.getHw01().isDirectory(), "'hw01' should be a directory.");
        assertTrue(TestFixtureInitializer.getSrc().isDirectory(), "'src' should be a directory.");
        assertFalse(TestFixtureInitializer.getAJava().isDirectory(), "'A.java' should not be a directory.");
        assertFalse(TestFixtureInitializer.getRmMd().isDirectory(), "'rm.md' should not be a directory.");
    }

}
