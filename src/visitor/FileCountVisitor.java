package visitor;

import element.File;
import element.Directory;
import element.Element;

public class FileCountVisitor implements Visitor {

    private int fileCount = 0;

    @Override
    public void visitFile(File file) {
        fileCount++;
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (Element element : directory.getElements()) {
            element.accept(this);
        }
    }

    public int getFileCount() {
        return fileCount;
    }
}