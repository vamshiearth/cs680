package umbcs680.hw11.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset singleton
        TestFixtureInitializer.getFileSystem(); // Initialize fixture
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    /**
     * Test the getRootDirs method to verify the root directory is correctly returned.
     */
    @Test
    void testGetRootDirs() {
        List<Directory> rootDirs = FileSystem.getFileSystem().getRootDirs();
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();

        assertEquals(1, rootDirs.size(), "FileSystem should contain one root directory.");
        assertEquals("anotherDrive", rootDirs.get(0).getName(), "The root directory name should be 'umbcs680'.");

    }

    /**
     * Test the appendRootDir method to verify new root directories can be added.
     */
    @Test
    void testAppendRootDir() {
        Directory anotherRoot = new Directory(null, "anotherDrive", 0, LocalDateTime.now());
        FileSystem.getFileSystem().appendRootDir(anotherRoot);

        List<Directory> rootDirs = FileSystem.getFileSystem().getRootDirs();
        assertTrue(rootDirs.stream().anyMatch(d -> d.getName().equals("anotherDrive")),
                "'anotherDrive' should be added to the root directories.");
    }

    /**
     * Test singleton property of FileSystem.
     */
    @Test
    void testGetFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2, "FileSystem should follow singleton pattern.");
    }

    /**
     * Test the directory hierarchy matches the test fixture.
     */
    @Test
    void testDirectoryStructure() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();
        Link rmMd = TestFixtureInitializer.getRmMd();

        // umbcs680
        assertEquals(2, umbcs680.countChildren(), "'umbcs680' should have 2 children.");
        assertTrue(umbcs680.getChildren().contains(hw01), "'umbcs680' should contain 'hw01'.");
        assertTrue(umbcs680.getChildren().contains(readmeMd), "'umbcs680' should contain 'readme.md'.");

        // hw01
        assertEquals(3, hw01.countChildren(), "'hw01' should have 3 children.");
        assertTrue(hw01.getChildren().contains(src), "'hw01' should contain 'src'.");
        assertTrue(hw01.getChildren().contains(buildXml), "'hw01' should contain 'build.xml'.");
        assertTrue(hw01.getChildren().contains(rmMd), "'hw01' should contain 'rm.md'.");

        // src
        assertEquals(2, src.countChildren(), "'src' should have 2 children.");
        assertTrue(src.getChildren().contains(aJava), "'src' should contain 'A.java'.");
        assertTrue(src.getChildren().contains(bJava), "'src' should contain 'B.java'.");
    }

    /**
     * Test that the link resolves to the correct target file.
     */
    @Test
    void testLinkResolution() {
        Link rmMd = TestFixtureInitializer.getRmMd();
        File readmeMd = TestFixtureInitializer.getReadmeMd();
        assertEquals(readmeMd, rmMd.getTarget(), "'rm.md' should point to 'readme.md'.");
    }

    /**
     * Test individual file sizes.
     */
    @Test
    void testFileSize() {
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();

        assertEquals(10, aJava.getSize(), "'A.java' should be 10 bytes.");
        assertEquals(20, bJava.getSize(), "'B.java' should be 20 bytes.");
        assertEquals(30, buildXml.getSize(), "'build.xml' should be 30 bytes.");
        assertEquals(40, readmeMd.getSize(), "'readme.md' should be 40 bytes.");
    }
}
