package element;

import visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

public class Directory implements Element {

    private String name;
    private List<Element> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Element> getElements() {
        return List.copyOf(elements);
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDirectory(this);
    }
}