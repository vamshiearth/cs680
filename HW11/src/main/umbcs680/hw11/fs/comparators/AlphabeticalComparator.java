package umbcs680.hw11.fs.comparators;

import umbcs680.hw11.fs.FSElement;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

    /**
     * Compares two FSElements alphabetically based on their name.
     * The comparison is case-insensitive.
     *
     * @param a The first FSElement to be compared.
     * @param b The second FSElement to be compared.
     * @return A negative integer, zero, or a positive integer as the first
     *         element's name is lexicographically less than, equal to, or
     *         greater than the second element's name (case-insensitive).
     */
    @Override
    public int compare(FSElement a, FSElement b) {
        // Compare the names of two FSElements ignoring case
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
