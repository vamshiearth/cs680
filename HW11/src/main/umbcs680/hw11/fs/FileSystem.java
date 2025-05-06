package umbcs680.hw11.fs;

import java.util.LinkedList;

/**
 * Represents the file system that holds the root directories.
 * The FileSystem follows a singleton pattern to ensure that only one instance of it exists.
 */
public class FileSystem {
    // The single instance of the FileSystem (singleton pattern)
    private static FileSystem instance = null;

    // A list to hold the root directories of the file system
    private LinkedList<Directory> rootDirs;

    /**
     * Private constructor for the FileSystem class.
     * Initializes the rootDirs list to hold directories.
     */
    private FileSystem() {
        rootDirs = new LinkedList<>();  // Initialize the list of root directories
    }

    /**
     * Provides access to the single instance of the FileSystem.
     * If the instance doesn't exist, it creates one.
     *
     * @return The singleton instance of the FileSystem.
     */
    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();  // Create the instance if it doesn't exist
        }
        return instance;  // Return the singleton instance
    }

    /**
     * Gets the list of root directories in the file system.
     *
     * @return A LinkedList containing the root directories.
     */
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;  // Return the list of root directories
    }

    /**
     * Adds a root directory to the file system.
     *
     * @param rootDir The directory to be added as a root directory.
     */
    public void appendRootDir(Directory rootDir) {
        rootDirs.add(rootDir);  // Add the root directory to the list of rootDirs
    }

    public static void resetFileSystem() {
        instance = null;
    }


}
