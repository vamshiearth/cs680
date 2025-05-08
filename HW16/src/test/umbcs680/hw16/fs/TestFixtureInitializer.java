package umbcs680.hw16.fs;

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
    private static Link rmMd;

    static {
        FileSystem.resetFileSystem();
        fileSystem = FileSystem.getFileSystem();

        // Create Directories
        umbcs680 = new Directory(null, "umbcs680", 0, LocalDateTime.now());
        hw01 = new Directory(umbcs680, "hw01", 0, LocalDateTime.now());
        src = new Directory(hw01, "src", 0, LocalDateTime.now());

        // Create Files
        aJava = new File(src, "A.java", 10, LocalDateTime.now());
        bJava = new File(src, "B.java", 20, LocalDateTime.now());
        buildXml = new File(hw01, "build.xml", 30, LocalDateTime.now());
        readmeMd = new File(umbcs680, "readme.md", 40, LocalDateTime.now());

        // Create Link
        rmMd = new Link(hw01, "rm.md", LocalDateTime.now(), readmeMd);

        // Build hierarchy
        src.appendChild(aJava);
        src.appendChild(bJava);

        hw01.appendChild(src);
        hw01.appendChild(buildXml);
        hw01.appendChild(rmMd);

        umbcs680.appendChild(hw01);
        umbcs680.appendChild(readmeMd);

        // Add to root of file system
        fileSystem.appendRootDir(umbcs680);
    }

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

    public static Link getRmMd() {
        return rmMd;
    }
}
