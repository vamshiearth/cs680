package umbcs680.hw14.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw14.fs.*;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest {

    private static Directory umbcs680;
    private static Directory hw01;
    private static Directory src;

    private static File aJava, bJava, buildXml, readmeMd;
    private static Link rmMd;

    @BeforeAll
    static void setUp() {
        FileSystem.resetFileSystem();
        FileSystem fs = TestFixtureInitializer.getFileSystem();

        umbcs680 = TestFixtureInitializer.getUmbcs680();
        hw01 = TestFixtureInitializer.getHw01();
        src = TestFixtureInitializer.getSrc();

        aJava = TestFixtureInitializer.getAJava();
        bJava = TestFixtureInitializer.getBJava();
        buildXml = TestFixtureInitializer.getBuildXml();
        readmeMd = TestFixtureInitializer.getReadmeMd();
        rmMd = TestFixtureInitializer.getRmMd();
    }

    @AfterAll
    static void tearDown() {
        FileSystem.resetFileSystem();
    }

    @Test
    void testChildrenSortedByTimestamp_hw01() {
        LinkedList<FSElement> children = hw01.getChildren();
        children.sort((a, b) -> a.getCreationTime().compareTo(b.getCreationTime()));

        assertEquals(3, children.size());
        assertTrue(children.get(0).getCreationTime().compareTo(children.get(1).getCreationTime()) <= 0);
        assertTrue(children.get(1).getCreationTime().compareTo(children.get(2).getCreationTime()) <= 0);
    }

    @Test
    void testFilesSortedByTimestamp_src() {
        LinkedList<File> files = src.getFiles();
        files.sort((a, b) -> a.getCreationTime().compareTo(b.getCreationTime()));

        assertEquals(2, files.size());
        assertTrue(files.get(0).getCreationTime().compareTo(files.get(1).getCreationTime()) <= 0);
    }

    @Test
    void testDirectoriesSortedByTimestamp() {
        LinkedList<Directory> dirs = new LinkedList<>();
        dirs.add(src);
        dirs.add(hw01);
        dirs.add(umbcs680);

        dirs.sort((a, b) -> a.getCreationTime().compareTo(b.getCreationTime()));

        assertEquals(3, dirs.size());
        assertTrue(dirs.get(0).getCreationTime().compareTo(dirs.get(1).getCreationTime()) <= 0);
        assertTrue(dirs.get(1).getCreationTime().compareTo(dirs.get(2).getCreationTime()) <= 0);
    }

    @Test
    void testLinkTimestampComparison() {
        LinkedList<Link> links = new LinkedList<>();
        links.add(rmMd);
        links.sort((a, b) -> a.getCreationTime().compareTo(b.getCreationTime()));

        assertEquals("rm.md", links.get(0).getName());
    }

    @Test
    void testMixedFSElementComparison() {
        LinkedList<FSElement> elements = new LinkedList<>();
        elements.add(readmeMd);
        elements.add(buildXml);
        elements.add(aJava);
        elements.add(bJava);

        elements.sort((a, b) -> a.getCreationTime().compareTo(b.getCreationTime()));

        assertEquals(4, elements.size());
        assertTrue(elements.get(0).getCreationTime().compareTo(elements.get(1).getCreationTime()) <= 0);
        assertTrue(elements.get(1).getCreationTime().compareTo(elements.get(2).getCreationTime()) <= 0);
        assertTrue(elements.get(2).getCreationTime().compareTo(elements.get(3).getCreationTime()) <= 0);
    }
}
