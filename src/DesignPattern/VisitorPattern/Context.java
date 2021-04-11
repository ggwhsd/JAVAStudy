package DesignPattern.VisitorPattern;

import java.util.LinkedList;
import java.util.List;

public class Context {
	private List<Element> elements = new LinkedList<Element>();
	public void attach(Element element) {
        elements.add(element);
    }
	public void detach(Element element) {
        elements.remove(element);
    }
	public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
