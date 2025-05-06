package umbcs680.hw14.fs.visitors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw14.fs.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    private static Directory root;

    @BeforeAll
    static void setup() {
        FileSystem.resetFileSystem(); // Reset singleton
        root = TestFixtureInitializer.getFileSystem().getRootDirs().get(0); // umbcs680
    }

    @Test
    void visit_dir_count() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);

        long dirCount = visitor.getFiles().stream()
                .filter(FSElement::isDirectory)
                .count();

        assertEquals(0, dirCount, "No directories should be collected.");
    }

    @Test
    void visit_file_count() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);

        LinkedList<File> files = visitor.getFiles();
        assertEquals(4, files.size(), "There should be 4 files collected.");

        // Get expected file references from the fixture
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();

        assertTrue(files.contains(aJava), "Should contain A.java");
        assertTrue(files.contains(bJava), "Should contain B.java");
        assertTrue(files.contains(buildXml), "Should contain build.xml");
        assertTrue(files.contains(readmeMd), "Should contain readme.md");
    }

    @Test
    void visit_link_count() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);

        // This is more of a sanity check — links should not appear in the file list.
        boolean containsLink = visitor.getFiles().stream()
                .anyMatch(f -> f.getName().equals("rm.md"));

        assertFalse(containsLink, "Links (e.g., rm.md) should not be collected.");
    }
}

//contains