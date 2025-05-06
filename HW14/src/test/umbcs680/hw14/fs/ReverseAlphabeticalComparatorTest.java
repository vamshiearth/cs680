package umbcs680.hw14.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw14.fs.*;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseAlphabeticalComparatorTest {

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
    void testGetChildrenSorted_umbcs680() {
        LinkedList<FSElement> children = umbcs680.getChildren();
        children.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("readme.md", children.get(0).getName());
        assertEquals("hw01", children.get(1).getName());
    }

    @Test
    void testGetChildrenSorted_hw01() {
        LinkedList<FSElement> children = hw01.getChildren();
        children.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("src", children.get(0).getName());
        assertEquals("rm.md", children.get(1).getName());
        assertEquals("build.xml", children.get(2).getName());
    }

    @Test
    void testGetChildrenSorted_src() {
        LinkedList<FSElement> children = src.getChildren();
        children.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("B.java", children.get(0).getName());
        assertEquals("A.java", children.get(1).getName());
    }

    @Test
    void testGetFilesSorted_hw01() {
        LinkedList<File> files = hw01.getFiles();
        files.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("build.xml", files.get(0).getName());
    }

    @Test
    void testGetFilesSorted_src() {
        LinkedList<File> files = src.getFiles();
        files.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("B.java", files.get(0).getName());
        assertEquals("A.java", files.get(1).getName());
    }

    @Test
    void testGetSubDirectoriesSorted_hw01() {
        LinkedList<Directory> subDirs = hw01.getSubDirectories();
        subDirs.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("src", subDirs.get(0).getName());
    }

    @Test
    void testGetLinksSorted_hw01() {
        LinkedList<Link> links = hw01.getLinks();
        links.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));

        assertEquals("rm.md", links.get(0).getName());
    }
}
