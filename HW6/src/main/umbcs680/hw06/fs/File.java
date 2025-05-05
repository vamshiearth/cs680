package umbcs680.hw06.fs;

import java.time.LocalDateTime;

/**
 * The File class represents a file in the file system.
 * It extends the FSElement class and is a leaf node in the file system hierarchy,
 * meaning it cannot contain other elements.
 */
public class File extends FSElement {

    /**
     * Constructor for the File class.
     *
     * @param parent        The parent directory of this file.
     * @param name          The name of the file.
     * @param size          The size of the file.
     * @param creationTime  The time the file was created.
     */
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    /**
     * Overrides the isDirectory method to indicate that this is a file, not a directory.
     *
     * @return False, since this is not a directory.
     */
    @Override
    public boolean isDirectory() {
        return false;
    }
}
