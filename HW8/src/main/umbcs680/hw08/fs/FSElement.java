package umbcs680.hw08.fs;

import java.time.LocalDateTime;

/**
 * Represents a generic file system element, which can be a file or a directory.
 * This is an abstract class that serves as the base class for File and Directory.
 */
public abstract class FSElement {
    // The parent directory of the file system element
    protected Directory parent;

    // The name of the file system element (either a file or directory)
    protected String name;

    // The size of the file system element (only meaningful for files)
    protected int size;

    // The creation time of the file system element
    protected LocalDateTime creationTime;

    /**
     * Constructor for FSElement.
     * Initializes the parent, name, size, and creation time for the element.
     *
     * @param parent The parent directory of this element.
     * @param name The name of the file system element.
     * @param size The size of the element (only relevant for files).
     * @param creationTime The creation time of the element.
     */
    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    /**
     * Returns the parent directory of this file system element.
     *
     * @return The parent directory.
     */
    public Directory getParent() {
        return this.parent;
    }

    /**
     * Returns the name of this file system element.
     *
     * @return The name of the element.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Abstract method to get the total size of the element.
     * This will be implemented by subclasses like Directory and File.
     *
     * @return The total size of the element (e.g., size of a file or the cumulative size of a directory and its contents).
     */
    public abstract int getTotalSize();

    /**
     * Returns the size of the file system element.
     * For directories, this size represents the size of the directory itself (without its contents).
     *
     * @return The size of the element.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the creation time of this file system element.
     *
     * @return The creation time of the element.
     */
    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    /**
     * Abstract method to check if this element is a directory.
     * Subclasses (Directory and File) will provide their own implementations.
     *
     * @return true if this element is a directory, false otherwise.
     */
    public abstract boolean isDirectory();




    public abstract void accept(FSVisitor v);
}
