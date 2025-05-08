package umbcs680.hw16.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.parent = this;
        }
    }

    public LinkedList<FSElement> getChildren() {
        return getChildren(Comparator.comparing(FSElement::getName, String::compareToIgnoreCase));
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> sortedChildren = new LinkedList<>(children);
        Collections.sort(sortedChildren, comparator);
        return sortedChildren;
    }

    public LinkedList<Directory> getSubDirectories() {
        return getSubDirectories(Comparator.comparing(FSElement::getName, String::compareToIgnoreCase));
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> subDirs = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Directory) {
                subDirs.add((Directory) e);
            }
        }
        Collections.sort(subDirs, comparator);
        return subDirs;
    }

    public LinkedList<File> getFiles() {
        return getFiles(Comparator.comparing(FSElement::getName, String::compareToIgnoreCase));
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof File) {
                files.add((File) e);
            }
        }
        Collections.sort(files, comparator);
        return files;
    }

    public LinkedList<Link> getLinks() {
        return getLinks(Comparator.comparing(FSElement::getName, String::compareToIgnoreCase));
    }

    public LinkedList<Link> getLinks(Comparator<FSElement> comparator) {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement e : children) {
            if (e instanceof Link) {
                links.add((Link) e);
            }
        }
        Collections.sort(links, comparator);
        return links;
    }

    @Override
    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : children) {
            totalSize += element.getTotalSize(); // Recursively accumulates file sizes
        }
        return totalSize;
    }


    @Override
    public boolean isDirectory() {
        return true;
    }

    public int countChildren() {
        return children.size();
    }
}
