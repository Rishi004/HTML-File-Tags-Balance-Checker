package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bridges.base.SLelement;

public class MyStack<E> implements StackInterface<E> {
	private SLelement<E> top;
	private int size;

	public MyStack() {
		top = null;
		size = 0;
	}

	public void push(E newEntry) {
		SLelement<E> newElement = new SLelement<>(newEntry, top);
		top = newElement;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		E topEntry = top.getValue();
		top = top.getNext();
		size--;
		return topEntry;
	}

	public E peek() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		return top.getValue();
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public static boolean isBalanced(File webpage) throws FileNotFoundException {
		MyStack<String> tagStack = new MyStack<>();
		Scanner scanner = new Scanner(webpage);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			int index = line.indexOf('<');
			while (index != -1) {
				int endIndex = line.indexOf('>', index);
				if (endIndex != -1) {
					String tag = line.substring(index + 1, endIndex);
					if (tag.startsWith("/")) {
						if (tagStack.isEmpty()) {
							return false; // unbalanced tag
						}
						String openingTag = tagStack.pop();
						if (!tag.substring(1).equals(openingTag)) {
							return false; // unbalanced tag
						}
					} else {
						tagStack.push(tag);
					}
					index = line.indexOf('<', endIndex);
				} else {
					break;
				}
			}
		}
		scanner.close();
		return tagStack.isEmpty(); // return true if all tags are balanced
	}
}
