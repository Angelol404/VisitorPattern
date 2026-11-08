package visitor;

import element.File;
import element.Directory;
import element.Element;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements Visitor {

    private String searchName;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().toLowerCase()
                .contains(searchName.toLowerCase())) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (Element element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}