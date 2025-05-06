package umbcs680.hw14.fs.visitors;

import umbcs680.hw14.fs.Directory;
import umbcs680.hw14.fs.FSVisitor;
import umbcs680.hw14.fs.File;
import umbcs680.hw14.fs.Link;

import java.util.LinkedList;

/**
 * FileCrawlingVisitor is a concrete implementation of the FSVisitor interface.
 * This visitor collects all the File elements from a file system structure into a list.
 * It does not process directories or links specifically.
 */
public class FileCrawlingVisitor implements FSVisitor {
    // LinkedList to store files found during the traversal
    private LinkedList<File> files = new LinkedList<>();

    /**
     * Visit method for File elements.
     * Adds the file to the list of files.
     *
     * @param file The file element being visited.
     */
    @Override
    public void visit(File file) {
        files.add(file);  // Add the file to the list of files
    }

    /**
     * Visit method for Directory elements.
     * This method does nothing, as we are not interested in directories for this visitor.
     *
     * @param directory The directory element being visited.
     */
    @Override
    public void visit(Directory directory) {
        // No specific action needed for directories
    }

    /**
     * Visit method for Link elements.
     * This method does nothing, as we are not interested in links for this visitor.
     *
     * @param link The link element being visited.
     */
    @Override
    public void visit(Link link) {
        // No specific action needed for links
    }

    /**
     * Get the list of files collected by the visitor.
     *
     * @return A LinkedList containing all the files visited.
     */
    public LinkedList<File> getFiles() {
        return files;  // Return the list of files collected during the traversal
    }
}
