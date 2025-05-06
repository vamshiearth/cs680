package umbcs680.hw11.fs.visitors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw11.fs.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingVisitorTest {

    private static Directory root;

    @BeforeAll
    static void setup() {
        FileSystem.resetFileSystem(); // Ensure clean singleton
        root = TestFixtureInitializer.getFileSystem().getRootDirs().get(0); // "umbcs680"
    }

    @Test
    void visit_dir_count() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(3, visitor.getDirCount(), "There should be 3 directories (umbcs680, hw01, src).");
    }

    @Test
    void visit_file_count() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(4, visitor.getFileCount(), "There should be 4 files (A.java, B.java, build.xml, readme.md).");
    }

    @Test
    void visit_link_count() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(1, visitor.getLinkCount(), "There should be 1 link (rm.md).");
    }
}
