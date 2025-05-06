package umbcs680.hw11.fs.comparators;

import umbcs680.hw11.fs.FSElement;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    /**
     * Compares two FSElements in reverse alphabetical order based on their name.
     *
     * @param a The first FSElement to compare.
     * @param b The second FSElement to compare.
     * @return A positive integer if a's name is before b's name, 0 if they are equal,
     *         or a negative integer if a's name is after b's name.
     */
    @Override
    public int compare(FSElement a, FSElement b) {
        return b.getName().compareToIgnoreCase(a.getName());
    }
}
