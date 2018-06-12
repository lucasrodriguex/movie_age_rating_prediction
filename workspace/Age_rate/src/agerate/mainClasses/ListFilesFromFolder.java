package agerate.mainClasses;

import java.io.File;
import agerate.classes.ReadFolder;

public class ListFilesFromFolder {

	public static void main(String[] args) {
		final File folder = new File("C:/Users/Rian.Rian/Documents/GitHub/rtavares/filme/[1]filmessoltos");
		ReadFolder.listFilesForFolder(folder);
	}
}
