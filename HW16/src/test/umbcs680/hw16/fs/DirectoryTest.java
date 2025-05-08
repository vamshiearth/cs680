package umbcs680.hw16.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private static Directory umbcs680;
    private static Directory hw01;
    private static Directory src;
    private static File aJava;
    private static File bJava;
    private static File buildXml;
    private static File readmeMd;
    private static Link rmMd;

    @BeforeAll
    static void setUp() {
        FileSystem.resetFileSystem();
        TestFixtureInitializer.getFileSystem();

        umbcs680 = TestFixtureInitializer.getUmbcs680();
        hw01 = TestFixtureInitializer.getHw01();
        src = TestFixtureInitializer.getSrc();
        aJava = TestFixtureInitializer.getAJava();
        bJava = TestFixtureInitializer.getBJava();
        buildXml = TestFixtureInitializer.getBuildXml();
        readmeMd = TestFixtureInitializer.getReadmeMd();
        rmMd = TestFixtureInitializer.getRmMd();
    }

    @Test
    void testAppendChild() {
        Directory tempDir = new Directory(null, "temp", 0, java.time.LocalDateTime.now());
        File tempFile = new File(tempDir, "temp.txt", 5, java.time.LocalDateTime.now());

        assertEquals(0, tempDir.countChildren());
        tempDir.appendChild(tempFile);
        assertEquals(1, tempDir.countChildren());
        assertEquals(tempDir, tempFile.getParent());
    }

    @Test
    void testGetChildren() {
        LinkedList<FSElement> children = hw01.getChildren();
        assertEquals(3, children.size()); // src, build.xml, rm.md
    }

    @Test
    void testGetChildrenWithComparator() {
        LinkedList<FSElement> children = hw01.getChildren((a, b) -> b.getName().compareTo(a.getName()));
        assertEquals(3, children.size());
        assertEquals("build.xml", children.get(2).getName());
    }

    @Test
    void testGetSubDirectories() {
        LinkedList<Directory> subDirs = hw01.getSubDirectories();
        assertEquals(1, subDirs.size());
        assertEquals("src", subDirs.get(0).getName());
    }

    @Test
    void testGetSubDirectoriesWithComparator() {
        LinkedList<Directory> subDirs = umbcs680.getSubDirectories((a, b) -> b.getName().compareTo(a.getName()));
        assertEquals(1, subDirs.size());
        assertEquals("hw01", subDirs.get(0).getName());
    }

    @Test
    void testGetFiles() {
        LinkedList<File> files = src.getFiles();
        assertEquals(2, files.size()); // A.java, B.java
    }

    @Test
    void testGetFilesWithComparator() {
        LinkedList<File> files = src.getFiles((a, b) -> b.getName().compareTo(a.getName()));
        assertEquals("B.java", files.get(0).getName());
    }

    @Test
    void testGetLinks() {
        LinkedList<Link> links = hw01.getLinks();
        assertEquals(1, links.size());
        assertEquals("rm.md", links.get(0).getName());
    }

    @Test
    void testGetLinksWithComparator() {
        LinkedList<Link> links = hw01.getLinks((a, b) -> b.getName().compareTo(a.getName()));
        assertEquals("rm.md", links.get(0).getName());
    }

    @Test
    void testGetTotalSize() {
        // src = 10 + 20 = 30
        // build.xml = 30
        // readme.md = 40 (linked by rm.md but not double-counted)
        assertEquals(100, umbcs680.getTotalSize());
    }

    @Test
    void testIsDirectory() {
        assertTrue(src.isDirectory());
        assertFalse(TestFixtureInitializer.getAJava().isDirectory());
    }

    @Test
    void testCountChildren() {
        assertEquals(3, hw01.countChildren()); // src, build.xml, rm.md
    }
}
