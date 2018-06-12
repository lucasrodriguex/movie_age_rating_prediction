package agerate.resultClasses;

import java.io.File;
import agerate.classes.ReadFolderToChange;

public class ChangeFilesNames {
	public static void main(String[] args) {

		final File folder = new File("C:/Users/Rian.Rian/Documents/GitHub/rtavares/data_amount/result/pt_br");
		ReadFolderToChange.listFilesForFolder(folder);
	}
}