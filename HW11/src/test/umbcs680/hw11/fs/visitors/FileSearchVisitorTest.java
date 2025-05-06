package umbcs680.hw11.fs.visitors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw11.fs.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        // Directories should not be returned in foundFiles
        assertEquals(0, visitor.getFoundFiles().size(), "Searching for a directory name should not return any files.");
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

