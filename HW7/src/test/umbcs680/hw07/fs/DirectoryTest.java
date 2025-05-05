package umbcs680.hw07.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset the singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using TestFixtureInitializer
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    @Test
    void appendChild() {
        Directory tempDir = new Directory(null, "tempDir", 0, LocalDateTime.now());
        Directory subDir = new Directory(tempDir, "docs", 0, LocalDateTime.now());
        tempDir.appendChild(subDir);

        assertEquals(1, tempDir.countChildren(), "tempDir should have 1 child.");
        assertEquals("docs", tempDir.getChildren().get(0).getName());
    }

    @Test
    void countChildren() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();

        assertEquals(2, umbcs680.countChildren(), "'umbcs680' should have 2 children (hw01, readme.md).");
        assertEquals(3, hw01.countChildren(), "'hw01' should have 3 children (src, build.xml, rm.md).");
        assertEquals(2, src.countChildren(), "'src' should have 2 children (A.java, B.java).");
    }

    @Test
    void getSubDirectories() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();

        LinkedList<Directory> umbcsSubDirs = umbcs680.getSubDirectories();
        LinkedList<Directory> hw01SubDirs = hw01.getSubDirectories();

        assertEquals(1, umbcsSubDirs.size(), "'umbcs680' should have 1 subdirectory (hw01).");
        assertEquals(1, hw01SubDirs.size(), "'hw01' should have 1 subdirectory (src).");
    }

    @Test
    void getFiles() {
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();

        LinkedList<File> hw01Files = hw01.getFiles();
        LinkedList<File> umbcsFiles = umbcs680.getFiles();

        assertEquals(1, hw01Files.size(), "'hw01' should have 1 file (build.xml).");
        assertEquals(1, umbcsFiles.size(), "'umbcs680' should have 1 file (readme.md).");
    }

    @Test
    void getTotalSize() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        int totalSize = umbcs680.getTotalSize();

        // Expected: A.java(10) + B.java(20) + build.xml(30) + readme.md(40) = 100
        assertEquals(100, totalSize, "Total size of all files should be 100.");
    }

    @Test
    void isDirectory() {
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();

        assertTrue(src.isDirectory(), "src should be a directory.");
        assertFalse(aJava.isDirectory(), "aJava should not be a directory.");
    }
}
