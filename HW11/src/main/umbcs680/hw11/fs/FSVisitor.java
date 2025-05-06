package umbcs680.hw11.fs;

/**
 * FSVisitor is an interface that defines the operations to be performed on file system elements
 * using the Visitor design pattern. The purpose of this pattern is to allow different operations
 * to be performed on elements (such as files, directories, or links) of the file system without
 * modifying their classes.
 */
public interface FSVisitor {

    /**
     * Visits a file element and performs some operation on it.
     * This method will be called when a `File` element is encountered during traversal.
     *
     * @param file The file element to visit.
     */
    void visit(File file);

    /**
     * Visits a directory element and performs some operation on it.
     * This method will be called when a `Directory` element is encountered during traversal.
     *
     * @param directory The directory element to visit.
     */
    void visit(Directory directory);

    /**
     * Visits a link element and performs some operation on it.
     * This method will be called when a `Link` element is encountered during traversal.
     *
     * @param link The link element to visit.
     */
    void visit(Link link);
}
