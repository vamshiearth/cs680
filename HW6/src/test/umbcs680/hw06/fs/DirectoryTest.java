package umbcs680.hw06.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using custom fixture
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after all tests
    }

    @Test
    void appendChild() {
        Directory tempDir = new Directory(null, "tempDir", 0, LocalDateTime.now());
        Directory childDir = new Directory(tempDir, "child", 0, LocalDateTime.now());
        tempDir.appendChild(childDir);
        assertEquals(1, tempDir.countChildren(), "tempDir should have 1 child");
    }

    @Test
    void countChildren() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();

        assertEquals(2, umbcs680.countChildren(), "'umbcs680' should have 2 children (hw01, readme.md)");
        assertEquals(2, hw01.countChildren(), "'hw01' should have 2 children (src, build.xml)");
        assertEquals(2, src.countChildren(), "'src' should have 2 children (A.java, B.java)");
    }

    @Test
    void getSubDirectories() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        LinkedList<Directory> subDirs = umbcs680.getSubDirectories();
        assertEquals(1, subDirs.size(), "umbcs680 should have 1 subdirectory (hw01)");
    }

    @Test
    void getFiles() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        LinkedList<File> files = umbcs680.getFiles();
        assertEquals(1, files.size(), "umbcs680 should have 1 file (readme.md)");
    }

    @Test
    void getTotalSize() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        assertEquals(250, umbcs680.getTotalSize(), "Total size should match all nested files (A.java + B.java + build.xml + readme.md)");
    }

    @Test
    void isDirectory() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        File aJava = TestFixtureInitializer.getAJava();

        assertTrue(umbcs680.isDirectory(), "umbcs680 should be a directory");
        assertFalse(aJava.isDirectory(), "aJava should be a file");
    }
}
