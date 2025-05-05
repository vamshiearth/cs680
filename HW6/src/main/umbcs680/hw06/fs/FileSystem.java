package umbcs680.hw06.fs;

import java.util.LinkedList;

/**
 * The FileSystem class implements a singleton pattern to represent
 * the overall file system. It maintains a list of root directories
 * as the entry points to the file system.
 */
public class FileSystem {
    // Singleton instance of the FileSystem
    private static FileSystem instance = null;

    // List of root directories in the file system
    private LinkedList<Directory> rootDirs;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the list of root directories.
     */
    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    /**
     * Provides access to the single instance of the FileSystem.
     * Implements lazy initialization to create the instance only when needed.
     *
     * @return The singleton instance of the FileSystem.
     */
    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    /**
     * Returns the list of root directories in the file system.
     *
     * @return A LinkedList of Directory objects representing the root directories.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    /**
     * Adds a new root directory to the file system.
     *
     * @param rootDir The Directory object to be added as a root directory.
     */
    public void appendRootDir(Directory rootDir) {
        rootDirs.add(rootDir); // Add the directory to the list of root directories
    }

    public static void resetFileSystem() {
        instance = null;
    }
}
