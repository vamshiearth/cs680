package umbcs680.hw11.fs;

import java.time.LocalDateTime;

/**
 * Represents a file in the file system.
 * A file has a size and a creation time, but it does not contain any other elements (like directories).
 */
public class File extends FSElement {

    /**
     * Constructs a File object.
     *
     * @param parent       The parent directory of this file.
     * @param name         The name of the file.
     * @param size         The size of the file.
     * @param creationTime The creation time of the file.
     */
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime); // Call the parent class (FSElement) constructor
    }

    /**
     * Returns the total size of the file.
     * For files, the total size is the same as the size of the file itself.
     *
     * @return The size of the file.
     */
    @Override
    public int getTotalSize() {
        return getSize();  // For files, the total size is the same as the size of the file itself
    }

    /**
     * Indicates whether this element is a directory.
     *
     * @return Always returns false for a File object, as files are not directories.
     */
    @Override
    public boolean isDirectory() {
        return false;  // Files are not directories
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
