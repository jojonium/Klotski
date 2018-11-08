package klotski.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import klotski.model.Board;

public class SaveController {
	final Board b;
	final Path p;
	
	/**
	 * Basic constructor
	 * @param app the view application
	 * @param b the model board
	 */
	public SaveController(Board b, Path p) {
		this.b = b;
		this.p = p;
	}
	
	/**
	 * Saves the state of the board to a text file at the given path
	 * @return true if successful save, false otherwise
	 */
	public boolean save() {
		// Convert the string to a byte array.
	    String s = b.toString();
	    byte data[] = s.getBytes();

	    try (OutputStream out = new BufferedOutputStream(
	    		Files.newOutputStream(p))) {
	      out.write(data, 0, data.length);
	    } catch (IOException e) {
	      System.err.println(e);
	      return false;
	    }
	    return true;
	}
}
