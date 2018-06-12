package agerate.classes;

import java.io.File;

public class ReadFolderToChange {
	static File fileEntry = new File("");
	
	public static void listFilesForFolder(final File folder) {

		String name = "";
		String entry = "";
		for (final File next : folder.listFiles()) {

			if (next.isDirectory()) {
				listFilesForFolder(next);

			} else {
				
				//parsing name
					name = next.getName();
					if (name.contains("_")) {
						name = name.replaceAll("[^A-Za-z\\s]", " ").replaceAll("\\s+", " ");
						name = name.replaceAll("txt", "");
						name = name.trim();
					}
				//parsing fileEntry
					entry = fileEntry.getName();
					if (entry.contains("_")) {
						entry = entry.replaceAll("[^A-Za-z\\s]", " ").replaceAll("\\s+", " ");
						entry = entry.replaceAll("txt", "");
						entry = entry.trim();
					}
				if (!(name.equals(entry))) {
						File txt = new File(
								"C:/Users/Rian.Rian/Documents/GitHub/rtavares/data_amount/subtitles/" + name + ".txt");
						next.renameTo(txt);
						System.out.println(name);
				} else {
					//do nothing
				}
			}
			fileEntry = next;
		}

	}
}
