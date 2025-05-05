package umbcs680.hw06.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    private static FileSystem fileSystem;
    private static Directory umbcs680;
    private static Directory hw01;
    private static Directory src;
    private static File aJava;
    private static File bJava;
    private static File buildXml;
    private static File readmeMd;

    static {
        FileSystem.resetFileSystem(); // Reset singleton
        fileSystem = FileSystem.getFileSystem();

        // Create directories
        umbcs680 = new Directory(null, "umbcs680", 0, LocalDateTime.now());
        hw01 = new Directory(umbcs680, "hw01", 0, LocalDateTime.now());
        src = new Directory(hw01, "src", 0, LocalDateTime.now());

        // Create files
        aJava = new File(src, "A.java", 50, LocalDateTime.now());
        bJava = new File(src, "B.java", 70, LocalDateTime.now());
        buildXml = new File(hw01, "build.xml", 30, LocalDateTime.now());
        readmeMd = new File(umbcs680, "readme.md", 100, LocalDateTime.now());

        // Build the hierarchy
        umbcs680.appendChild(hw01);
        umbcs680.appendChild(readmeMd);

        hw01.appendChild(src);
        hw01.appendChild(buildXml);

        src.appendChild(aJava);
        src.appendChild(bJava);

        // Register root
        fileSystem.appendRootDir(umbcs680);
    }

    // Getters (optional if needed elsewhere)
    public static FileSystem getFileSystem() {
        return fileSystem;
    }

    public static Directory getUmbcs680() {
        return umbcs680;
    }

    public static Directory getHw01() {
        return hw01;
    }

    public static Directory getSrc() {
        return src;
    }

    public static File getAJava() {
        return aJava;
    }

    public static File getBJava() {
        return bJava;
    }

    public static File getBuildXml() {
        return buildXml;
    }

    public static File getReadmeMd() {
        return readmeMd;
    }
}
