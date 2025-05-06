package umbcs680.hw08.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @BeforeAll
    static void setUpFS() {
        FileSystem.resetFileSystem(); // Reset the singleton
        TestFixtureInitializer.getFileSystem(); // Initialize using the test fixture
    }

    @AfterAll
    static void tearDownFS() {
        FileSystem.resetFileSystem(); // Clean up after tests
    }


    private String[] fileToStringArray(File f) {
        return new String[] {
                f.getName(),
                String.valueOf(f.getSize()),
                f.getCreationTime().toString()
        };
    }

    @Test
    void testEqualityCheckImplementationFile() {
        FileSystem fileSystem = TestFixtureInitializer.getFileSystem();
        File readme = fileSystem.getRootDirs().get(0).getFiles().get(0);
        File build = fileSystem.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0);
        File ajava = fileSystem.getRootDirs().getFirst().getSubDirectories().get(0).getSubDirectories().get(0).getFiles().get(0);
        File bjava = fileSystem.getRootDirs().getFirst().getSubDirectories().get(0).getSubDirectories().get(0).getFiles().get(1);

        // Use actual objects to construct "expected"
        File expectedReadme = new File(readme.getParent(), readme.getName(), readme.getSize(), readme.getCreationTime());
        File expectedBuild = new File(build.getParent(), build.getName(), build.getSize(), build.getCreationTime());
        File expectedAjava = new File(ajava.getParent(), ajava.getName(), ajava.getSize(), ajava.getCreationTime());
        File expectedBjava = new File(bjava.getParent(), bjava.getName(), bjava.getSize(), bjava.getCreationTime());

        assertArrayEquals(fileToStringArray(expectedReadme), fileToStringArray(readme));
        assertArrayEquals(fileToStringArray(expectedBuild), fileToStringArray(build));
        assertArrayEquals(fileToStringArray(expectedAjava), fileToStringArray(ajava));
        assertArrayEquals(fileToStringArray(expectedBjava), fileToStringArray(bjava));
    }


    /**
     * Test the isDirectory method to verify directory vs. file identification.
     */
    @Test
    void isDirectory() {
        Directory umbcs680 = TestFixtureInitializer.getUmbcs680();
        Directory hw01 = TestFixtureInitializer.getHw01();
        Directory src = TestFixtureInitializer.getSrc();
        File aJava = TestFixtureInitializer.getAJava();
        File bJava = TestFixtureInitializer.getBJava();
        File buildXml = TestFixtureInitializer.getBuildXml();
        File readmeMd = TestFixtureInitializer.getReadmeMd();
        Link rmMd = TestFixtureInitializer.getRmMd();

        // Directory checks
        assertTrue(umbcs680.isDirectory(), "'umbcs680' should be a directory.");
        assertTrue(hw01.isDirectory(), "'hw01' should be a directory.");
        assertTrue(src.isDirectory(), "'src' should be a directory.");

        // File checks
        assertFalse(aJava.isDirectory(), "'A.java' should not be a directory.");
        assertFalse(bJava.isDirectory(), "'B.java' should not be a directory.");
        assertFalse(buildXml.isDirectory(), "'build.xml' should not be a directory.");
        assertFalse(readmeMd.isDirectory(), "'readme.md' should not be a directory.");
        assertFalse(rmMd.isDirectory(), "'rm.md' (link) should not be a directory.");
    }

}
