package umbcs680.hw11.fs.comparators;

import umbcs680.hw11.fs.FSElement;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

    /**
     * Compares two FSElements based on their creation time.
     *
     * @param a The first FSElement to be compared.
     * @param b The second FSElement to be compared.
     * @return A negative integer, zero, or a positive integer as the creation time
     *         of the first element is before, equal to, or after the creation time
     *         of the second element, respectively.
     */
    @Override
    public int compare(FSElement a, FSElement b) {
        // Compare the creation time of two FSElements
        return a.getCreationTime().compareTo(b.getCreationTime());
    }
}
