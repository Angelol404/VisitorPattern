package element;

import visitor.Visitor;

public interface Element {

    void accept(Visitor visitor);

}