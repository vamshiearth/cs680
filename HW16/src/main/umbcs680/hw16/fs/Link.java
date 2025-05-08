package umbcs680.hw16.fs;

import java.time.LocalDateTime;

/**
 * Represents a symbolic link in the file system.
 * A Link does not have its own size but points to another FSElement (could be a file or directory).
 */
public class Link extends FSElement {
    // The target of the link (the FSElement it points to)
    private FSElement target;

    /**
     * Constructor for creating a Link.
     * The size of the link is set to 0 because the link itself does not store data, only points to another element.
     *
     * @param parent The parent directory of the link.
     * @param name The name of the link.
     * @param creationTime The creation time of the link.
     * @param target The FSElement that the link points to (can be a file or directory).
     */
    public Link(Directory parent, String name, LocalDateTime creationTime, FSElement target) {
        super(parent, name, 0, creationTime); // Link has size 0, as it only points to another element
        this.target = target;  // Set the target of the link
    }

    /**
     * Returns the target element that the link points to.
     *
     * @return The target FSElement (could be a file or directory).
     */
    public FSElement getTarget() {
        return this.target;
    }

    /**
     * Returns the total size of the link, which is the size of the target element it points to.
     *
     * @return The size of the target element (the linked file or directory).
     */
    @Override
    public int getTotalSize() {
        return 0;  // The total size is the same as the target's size
    }

    /**
     * Returns the size of the link, which is the size of the target element.
     *
     * @return The size of the target element.
     */
    @Override
    public int getSize() {
        return target.getSize();  // Return the size of the target element
    }

    /**
     * Returns whether the target element is a directory or not.
     *
     * @return true if the target element is a directory, false otherwise.
     */
    @Override
    public boolean isDirectory() {
        return target.isDirectory();  // The link is considered a directory if the target is a directory
    }
}
