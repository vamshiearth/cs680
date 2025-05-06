package umbcs680.hw11.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Represents a directory in the file system. A directory can contain other directories and files.
 */
public class Directory extends FSElement {
    // List to hold the children of this directory (both files and subdirectories)
    private LinkedList<FSElement> children;

    /**
     * Constructs a Directory object.
     *
     * @param parent       The parent directory of this directory (can be null for root directories).
     * @param name         The name of the directory.
     * @param size         The size of the directory (usually 0, as the size is determined by its contents).
     * @param creationTime The creation time of the directory.
     */
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.children = new LinkedList<>();
    }

    /**
     * Returns the list of children (files and directories) contained in this directory.
     *
     * @return A LinkedList of FSElements (children of this directory).
     */
    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    /**
     * Appends a child (file or directory) to this directory.
     *
     * @param child The FSElement to be added as a child of this directory.
     */
    public void appendChild(FSElement child) {
        if (!this.children.contains(child)) { // Prevent duplicates
            this.children.add(child);
            child.parent = this;
        }
    }

    /**
     * Counts the number of direct children (files and directories) of this directory.
     *
     * @return The count of children.
     */
    public int countChildren() {
        return this.children.size();
    }

    /**
     * Retrieves all subdirectories contained in this directory.
     *
     * @return A LinkedList of subdirectories.
     */
    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof Directory) { // Check if the element is a directory
                subDirs.add((Directory) element);
            }
        }
        return subDirs;
    }

    /**
     * Retrieves all files contained in this directory.
     *
     * @return A LinkedList of files.
     */
    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof File) { // Check if the element is a file
                files.add((File) element);
            }
        }
        return files;
    }

    /**
     * Calculates the total size of this directory, including the sizes of all its children
     * (both files and subdirectories).
     *
     * @return The total size of the directory.
     */
    @Override
    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : this.getChildren()) {
            totalSize += element.getTotalSize(); // Let polymorphism handle it correctly
        }
        return totalSize;
    }


    /**
     * Returns the size of the directory, which is equal to the total size of its contents.
     *
     * @return The total size of the directory.
     */
    @Override
    public int getSize() {
        return getTotalSize(); // Use the getTotalSize method for size calculation
    }

    /**
     * Indicates whether this element is a directory.
     *
     * @return Always returns true for a Directory object.
     */
    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement child : this.children){
            child.accept(v);
        }

    }


    /**
     * Retrieves all symbolic links contained in this directory.
     *
     * @return A LinkedList of links.
     */
    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof Link) {
                links.add((Link) element);
            }
        }
        return links;
    }

}
