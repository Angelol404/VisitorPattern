package visitor;

import element.File;
import element.Directory;

public class SizeCalculatorVisitor implements Visitor {

    private double totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (element.Element element : directory.getElements()) {
            element.accept(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}