package agerate.mainClasses;

import java.io.File;
import java.util.ArrayList;

import agerate.classes.Film;

public class ReadFileByFile2 {
	
	@SuppressWarnings({"rawtypes"})
	public static ArrayList fileByfile(String folder) {
		/* Creating variables */
		String directory = folder;
		ArrayList <Film> moviesObjects = new ArrayList<Film>();
		String title = "";

// 		String directory = "C:/Users/Rian.Rian/Documents/GitHub/rtavares/filme";
//		String directory = "C:/Users/Rian.Rian/Documents/GitHub/rtavares/filme";
		
		/* Extracting information */
		final File folder1 = new File(directory);

		File[] files = folder1.listFiles();
		for (File item : files) {
				Film movie = new Film();
				title = item.getName();
				title = title.replaceAll(".txt", "");
				title = title.trim();
				
				movie.setName(title);
				movie.setAge("0");
				moviesObjects.add(movie);
		}
		
//		for(int i = 0; i < moviesObjects.size(); i++) {
//			System.out.println(moviesObjects.get(i).getName());
//		}
		System.out.println("terminou 2");
		return moviesObjects;
	}
}
