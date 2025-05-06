package umbcs680.hw11.fs.comparators;

import umbcs680.hw11.fs.FSElement;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {

    /**
     * Compares two FSElements based on their total size.
     *
     * @param a The first FSElement to be compared.
     * @param b The second FSElement to be compared.
     * @return A negative integer, zero, or a positive integer as the total size
     *         of the first element is less than, equal to, or greater than the
     *         total size of the second element.
     */
    @Override
    public int compare(FSElement a, FSElement b) {
        return Integer.compare(a.getTotalSize(), b.getTotalSize());
    }
}
