package cmsc256;

public interface StackInterface<E> {
	/**
	 * Adds a new entry to the top of this stack.
	 * 
	 * @param newEntry an object to be added to the stack.
	 */
	public void push(E newEntry);

	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return the object at the top of the stack.
	 * @throws java.util.EmptyStackException if the stack is empty.
	 */
	public E pop();

	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return the object at the top of the stack.
	 * @throws java.util.EmptyStackException if the stack is empty.
	 */
	public E peek();

	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty();

	/** Removes all entries from this stack. */
	public void clear();
}
