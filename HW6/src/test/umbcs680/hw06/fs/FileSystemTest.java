import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw06.fs.Directory;
import umbcs680.hw06.fs.File;
import umbcs680.hw06.fs.FileSystem;
import umbcs680.hw06.fs.TestFixtureInitializer;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset the singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using the fixture
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }

    @Test
    void testGetRootDirs() {
        List<Directory> rootDirs = FileSystem.getFileSystem().getRootDirs();
        assertEquals(1, rootDirs.size(), "There should be exactly one root directory.");
        assertEquals("anotherDrive", rootDirs.get(0).getName(), "The root directory should be 'umbcs680'.");
        //In test testAppendRootDir we created another root
    }

    @Test
    void testAppendRootDir() {
        Directory anotherDrive = new Directory(null, "anotherDrive", 0, LocalDateTime.now());
        FileSystem.getFileSystem().appendRootDir(anotherDrive);

        List<Directory> rootDirs = FileSystem.getFileSystem().getRootDirs();
        assertTrue(rootDirs.stream().anyMatch(dir -> "anotherDrive".equals(dir.getName())),
                "Root directory list should contain 'anotherDrive'.");
    }

    @Test
    void testGetFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2, "FileSystem should be a singleton.");
    }

    @Test
    void testDirectoryStructure() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();

        // umbcs680 should have 2 children: hw01 and readme.md
        assertEquals(2, umbcs680.countChildren(), "'umbcs680' should have 2 children.");
        assertTrue(umbcs680.getChildren().contains(hw01), "'umbcs680' should contain 'hw01'.");
        assertTrue(umbcs680.getChildren().contains(readmeMd), "'umbcs680' should contain 'readme.md'.");

        // hw01 should have 2 children: src and build.xml
        assertEquals(2, hw01.countChildren(), "'hw01' should have 2 children.");
        assertTrue(hw01.getChildren().contains(src), "'hw01' should contain 'src'.");
        assertTrue(hw01.getChildren().contains(buildXml), "'hw01' should contain 'build.xml'.");

        // src should have 2 children: A.java and B.java
        assertEquals(2, src.countChildren(), "'src' should have 2 children.");
        assertTrue(src.getChildren().contains(aJava), "'src' should contain 'A.java'.");
        assertTrue(src.getChildren().contains(bJava), "'src' should contain 'B.java'.");
    }

    @Test
    void testFileSize() {
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();

        assertEquals(50, aJava.getSize(), "'A.java' should have size 50.");
        assertEquals(70, bJava.getSize(), "'B.java' should have size 70.");
    }
}
