package umbcs680.hw08.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw08.fs.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    private static Directory root;

    @BeforeAll
    static void setup() {
        FileSystem.resetFileSystem();
        root = TestFixtureInitializer.getFileSystem().getRootDirs().get(0); // umbcs680
    }

    @Test
    void visit_dir_count() {
        FileSearchVisitor visitor = new FileSearchVisitor("hw01");
        root.accept(visitor);
        // Directories should not be matched
        assertEquals(0, visitor.getFoundFiles().size(), "Directories should not be matched.");
    }

    @Test
    void visit_file_count() {
        FileSearchVisitor visitor = new FileSearchVisitor("A.java");
        root.accept(visitor);
        LinkedList<File> found = visitor.getFoundFiles();

        assertEquals(1, found.size(), "Should find one file named 'A.java'.");
        assertEquals("A.java", found.get(0).getName());
    }

    @Test
    void visit_link_count() {
        FileSearchVisitor visitor = new FileSearchVisitor("rm.md"); // rm.md is a Link, not a File
        root.accept(visitor);
        assertEquals(0, visitor.getFoundFiles().size(), "Links should not be matched as files.");
    }
}
