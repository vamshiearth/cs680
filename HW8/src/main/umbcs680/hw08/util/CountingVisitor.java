package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.FSVisitor;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.Link;

/**
 * CountingVisitor is a concrete implementation of the FSVisitor interface that counts the number of
 * files, directories, and links in a file system structure.
 * This visitor is used to traverse a file system and collect counts of different types of file system elements.
 */
public class CountingVisitor implements FSVisitor {

    // Count the number of files, directories, and links
    private int fileCount = 0;
    private int dirCount = 0;
    private int linkCount = 0;

    /**
     * Visit method for File elements.
     * Increments the file count each time a file is visited.
     *
     * @param file The file element being visited.
     */
    @Override
    public void visit(File file) {
        fileCount++;  // Increment the file count whenever a File is visited
    }

    /**
     * Visit method for Directory elements.
     * Increments the directory count each time a directory is visited.
     *
     * @param directory The directory element being visited.
     */
    @Override
    public void visit(Directory directory) {
        dirCount++;  // Increment the directory count whenever a Directory is visited
    }

    /**
     * Visit method for Link elements.
     * Increments the link count each time a link is visited.
     *
     * @param link The link element being visited.
     */
    @Override
    public void visit(Link link) {
        linkCount++;  // Increment the link count whenever a Link is visited
    }

    /**
     * Get the total count of files visited.
     *
     * @return The number of files visited.
     */
    public int getFileCount() {
        return fileCount;
    }

    /**
     * Get the total count of directories visited.
     *
     * @return The number of directories visited.
     */
    public int getDirCount() {
        return dirCount;
    }

    /**
     * Get the total count of links visited.
     *
     * @return The number of links visited.
     */
    public int getLinkCount() {
        return linkCount;
    }
}
