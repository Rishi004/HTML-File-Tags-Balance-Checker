package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		// Replace with the path to your HTML file
		String path = "C:/Users/Rishi/OneDrive/Desktop/htmltag2.html";
		File htmlFile = new File(path);

		try {
			boolean isBalanced = MyStack.isBalanced(htmlFile);
			if (isBalanced) {
				System.out.println("The HTML file has balanced tags.");
			} else {
				System.out.println("The HTML file has unbalanced tags.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + htmlFile.getPath());
		}
	}

}
