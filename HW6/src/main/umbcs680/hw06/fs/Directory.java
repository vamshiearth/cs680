package umbcs680.hw06.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * The Directory class represents a folder in the file system.
 * It extends the FSElement class and can contain other FSElements
 * such as Files or other Directories.
 */
public class Directory extends FSElement {
    // A list to store the child elements (files and subdirectories) of this directory.
    private LinkedList<FSElement> children;

    /**
     * Constructor for the Directory class.
     *
     * @param parent        The parent directory of this directory.
     * @param name          The name of the directory.
     * @param size          The size of the directory (usually 0, since size is derived from its contents).
     * @param creationTime  The time the directory was created.
     */
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.children = new LinkedList<>();
    }

    /**
     * Returns the list of child elements in this directory.
     *
     * @return A LinkedList of FSElement objects representing the children.
     */
    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    /**
     * Adds a new child element (file or directory) to this directory.
     *
     * @param child The child element to add.
     */
    public void appendChild(FSElement child) {
        this.children.add(child);
        child.parent = this; // Set the parent of the child to this directory.
    }

    /**
     * Returns the count of child elements in this directory.
     *
     * @return The number of child elements.
     */
    public int countChildren() {
        return this.children.size();
    }

    /**
     * Returns a list of subdirectories contained in this directory.
     *
     * @return A LinkedList of Directory objects.
     */
    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof Directory) {
                subDirs.add((Directory) element);
            }
        }
        return subDirs;
    }

    /**
     * Returns a list of files contained in this directory.
     *
     * @return A LinkedList of File objects.
     */
    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof File) {
                files.add((File) element);
            }
        }
        return files;
    }

    /**
     * Calculates the total size of this directory.
     * The size includes the sizes of all files and subdirectories recursively.
     *
     * @return The total size of the directory.
     */
    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : this.getChildren()) {
            if (element instanceof File) {
                totalSize += element.getSize(); // Add size of files
            } else if (element instanceof Directory) {
                totalSize += ((Directory) element).getTotalSize(); // Add size of subdirectories
            }
        }
        return totalSize;
    }

    /**
     * Overrides the getSize method to return the total size of the directory.
     *
     * @return The total size of the directory.
     */
    public int getSize() {
        return getTotalSize(); // Delegate to the method that calculates total size
    }

    /**
     * Determines whether this element is a directory.
     *
     * @return True, since this is a Directory.
     */
    @Override
    public boolean isDirectory() {
        return true;
    }
}
