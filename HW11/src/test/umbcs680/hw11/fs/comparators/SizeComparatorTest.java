package umbcs680.hw11.fs.comparators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw11.fs.*;

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
        Collections.sort(files, new SizeComparator());

        assertEquals("A.java", files.get(0).getName()); // size: 10
        assertEquals("B.java", files.get(1).getName()); // size: 20
    }

    @Test
    void testChildrenSortedBySize_hw01() {
        LinkedList<FSElement> children = hw01.getChildren();
        Collections.sort(children, new SizeComparator());

        // Expected sizes:
        // build.xml: 30
        // rm.md (link): 0 (by design)
        // src: 10 + 20 = 30
        assertEquals("rm.md", children.get(0).getName());       // size = 0
        assertEquals("src", children.get(1).getName());   // size = 30
        assertEquals("build.xml", children.get(2).getName());         // size = 30
    }

    @Test
    void testChildrenSortedBySize_umbcs680() {
        LinkedList<FSElement> children = umbcs680.getChildren();
        Collections.sort(children, new SizeComparator());

        // Expected:
        // readme.md: 40
        // hw01: 30 (build.xml) + 30 (src) = 60
        assertEquals("readme.md", children.get(0).getName());   // size = 40
        assertEquals("hw01", children.get(1).getName());        // size = 60
    }

    @Test
    void testDirectoriesSortedBySize() {
        LinkedList<Directory> directories = new LinkedList<>();
        directories.add(src);       // size = 10 + 20 = 30
        directories.add(hw01);      // size = 30 (build.xml) + 30 (src) = 60
        directories.add(umbcs680);  // size = 60 (hw01) + 40 (readme.md) = 100

        Collections.sort(directories, new SizeComparator());

        assertEquals("src", directories.get(0).getName());       // 30
        assertEquals("hw01", directories.get(1).getName());      // 60
        assertEquals("umbcs680", directories.get(2).getName());  // 100
    }
}
