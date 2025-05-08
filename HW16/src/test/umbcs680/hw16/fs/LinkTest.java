package umbcs680.hw16.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

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
     * Test that the link correctly references its target file.
     */
    @Test
    void getTarget() {
        Link rmMd = TestFixtureInitializer.getRmMd();
        File readmeMd = TestFixtureInitializer.getReadmeMd();

        assertSame(readmeMd, rmMd.getTarget(), "'rm.md' should point to 'readme.md'.");
    }

    /**
     * Test that the link's size equals the size of its target.
     */
    @Test
    void getSize() {
        Link rmMd = TestFixtureInitializer.getRmMd();
        File readmeMd = TestFixtureInitializer.getReadmeMd();

        assertEquals(readmeMd.getSize(), rmMd.getSize(),
                "'rm.md' should report the same size as its target, 'readme.md'.");
        assertEquals(40, rmMd.getSize(), "'rm.md' size should be 40 bytes.");
    }

    /**
     * Test that the link is not considered a directory.
     */
    @Test
    void isDirectory() {
        Link rmMd = TestFixtureInitializer.getRmMd();

        assertFalse(rmMd.isDirectory(), "'rm.md' should not be a directory.");
    }
}
