package umbcs680.hw14.fs;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw14.fs.*;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeComparatorTest {

    private static Directory umbcs680;
    private static Directory hw01;
    private static Directory src;

    @BeforeAll
    static void setUp() {
        FileSystem.resetFileSystem();
        FileSystem fs = TestFixtureInitializer.getFileSystem();
        umbcs680 = TestFixtureInitializer.getUmbcs680();
        hw01 = TestFixtureInitializer.getHw01();
        src = TestFixtureInitializer.getSrc();
    }

    @AfterAll
    static void tearDown() {
        FileSystem.resetFileSystem();
    }

    @Test
    void testFilesSortedBySize_src() {
        LinkedList<File> files = src.getFiles();
        files.sort((a, b) -> Integer.compare(a.getTotalSize(), b.getTotalSize()));

        assertEquals("A.java", files.get(0).getName()); // size: 10
        assertEquals("B.java", files.get(1).getName()); // size: 20
    }

    @Test
    void testChildrenSortedBySize_hw01() {
        LinkedList<FSElement> children = hw01.getChildren();
        children.sort((a, b) -> Integer.compare(a.getTotalSize(), b.getTotalSize()));

        // Expected sizes:
        // rm.md (link): 0
        // src: 30 (10 + 20)
        // build.xml: 30
        assertEquals("rm.md", children.get(0).getName());        // size = 0
        assertEquals("src", children.get(1).getName());          // size = 30
        assertEquals("build.xml", children.get(2).getName());    // size = 30
    }

    @Test
    void testChildrenSortedBySize_umbcs680() {
        LinkedList<FSElement> children = umbcs680.getChildren();
        children.sort((a, b) -> Integer.compare(a.getTotalSize(), b.getTotalSize()));

        // readme.md: 40, hw01: 60
        assertEquals("readme.md", children.get(0).getName());   // size = 40
        assertEquals("hw01", children.get(1).getName());        // size = 60
    }

    @Test
    void testDirectoriesSortedBySize() {
        LinkedList<Directory> directories = new LinkedList<>();
        directories.add(src);       // size = 30
        directories.add(hw01);      // size = 60
        directories.add(umbcs680);  // size = 100

        directories.sort((a, b) -> Integer.compare(a.getTotalSize(), b.getTotalSize()));

        assertEquals("src", directories.get(0).getName());       // 30
        assertEquals("hw01", directories.get(1).getName());      // 60
        assertEquals("umbcs680", directories.get(2).getName());  // 100
    }
}
