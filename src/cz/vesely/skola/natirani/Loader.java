package cz.vesely.skola.natirani;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {

	public static List<String> loadLines(File in) throws IOException {
		// try with resource automatically closes 
		try (BufferedReader reader = createBufferedReader(in)) {
			List<String> lines = new ArrayList<>();
			while (true) {
				String line = reader.readLine();
				if (line == null) break;
				lines.add(line);
			}
			return lines;
		}
	}

	private static BufferedReader createBufferedReader(File in) throws IOException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(in)));
	}

}
