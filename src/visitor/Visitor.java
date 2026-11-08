package visitor;

import element.File;
import element.Directory;

public interface Visitor {

    void visitFile(File file);

    void visitDirectory(Directory directory);

}