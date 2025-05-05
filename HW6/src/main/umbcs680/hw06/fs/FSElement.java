package umbcs680.hw06.fs;

import java.time.LocalDateTime;

/**
 * The FSElement class represents a generic element in the file system,
 * serving as a base class for both files and directories.
 */
public abstract class FSElement {
    // The parent directory of this element
    protected Directory parent;

    // The name of this element
    protected String name;

    // The size of this element (in bytes)
    protected int size;

    // The time this element was created
    protected LocalDateTime creationTime;

    /**
     * Constructor for the FSElement class.
     * Initializes the common properties for all file system elements.
     *
     * @param parent        The parent directory of this element.
     * @param name          The name of this element.
     * @param size          The size of this element.
     * @param creationTime  The time this element was created.
     */
    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    /**
     * Returns the parent directory of this element.
     *
     * @return The parent Directory object.
     */
    public Directory getParent() {
        return this.parent;
    }

    /**
     * Returns the name of this element.
     *
     * @return The name of this element as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the size of this element.
     *
     * @return The size of this element as an integer.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the creation time of this element.
     *
     * @return A LocalDateTime object representing the creation time.
     */
    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    /**
     * Abstract method to determine whether this element is a directory.
     * Subclasses must implement this method to specify their type.
     *
     * @return True if this element is a directory, false otherwise.
     */
    public abstract boolean isDirectory();
}
