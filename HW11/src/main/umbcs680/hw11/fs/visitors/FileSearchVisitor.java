package umbcs680.hw11.fs.visitors;

import umbcs680.hw11.fs.Directory;
import umbcs680.hw11.fs.FSVisitor;
import umbcs680.hw11.fs.File;
import umbcs680.hw11.fs.Link;

import java.util.LinkedList;

/**
 * FileSearchVisitor is a concrete implementation of the FSVisitor interface.
 * This visitor searches for files with a specific name in a file system structure.
 * It collects all the files that match the given name into a list.
 */
public class FileSearchVisitor implements FSVisitor {
    private String fileName;  // The name of the file to search for
    private LinkedList<File> foundFiles = new LinkedList<>();  // List to store files matching the search criteria

    /**
     * Constructor for FileSearchVisitor.
     * Initializes the visitor with the name of the file to search for.
     *
     * @param fileName The name of the file to search for in the file system.
     */
    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;  // Set the target file name
    }

    /**
     * Visit method for File elements.
     * If the file name matches the target file name, it is added to the list of found files.
     *
     * @param file The file element being visited.
     */
    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {  // Check if the file name matches
            foundFiles.add(file);  // Add the file to the list of found files
        }
    }

    /**
     * Visit method for Directory elements.
     * This method does nothing, as we are only interested in files with the specific name.
     *
     * @param directory The directory element being visited.
     */
    @Override
    public void visit(Directory directory) {
        // No specific action needed for directories
    }

    /**
     * Visit method for Link elements.
     * This method does nothing, as we are only interested in files with the specific name.
     *
     * @param link The link element being visited.
     */
    @Override
    public void visit(Link link) {
        // No specific action needed for links
    }

    /**
     * Get the list of files that were found during the search.
     *
     * @return A LinkedList containing all the files that matched the target file name.
     */
    public LinkedList<File> getFoundFiles() {
        return foundFiles;  // Return the list of found files
    }
}
