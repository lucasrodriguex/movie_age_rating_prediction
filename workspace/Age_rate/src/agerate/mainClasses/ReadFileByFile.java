package agerate.mainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import agerate.classes.Film;

public class ReadFileByFile {

	@SuppressWarnings({ "rawtypes", "resource" })
	public static ArrayList fileByfile(String folder) throws FileNotFoundException {
		/* Creating variables */
		String quebraLinha = System.getProperty("line.separator");
		String textoQueSeraEscrito = "";
		FileWriter filmesAge;
		String directory = folder;
		ArrayList<Film> moviesObjects = new ArrayList<Film>();
		String data = "";
		String title = "";
		String age = "";
		int flag = 0;
		String toFindName = "<h1 style=\"margin-bottom: 5px\">";
		String daleteName = "<h1 style=\"margin-bottom: 5px\">";
		String toFindAge = "<li class=\"meu_both\"><i class=\"icon ico-family\"></i><div class=\"serie_separacao\"><strong>Classificação:</strong></div>";
		String deleteAge = "<li class=\"meu_both\"><i class=\"icon ico-family\"></i><div class=\"serie_separacao\"><strong>Classificação:</strong></div>";
		int count = 0;
		
		/* Extracting information */
		final File folder1 = new File(directory);

		File[] files = folder1.listFiles();
		for (File item : files) {
			count = count + 1;
			Film movie = new Film();
			//System.out.println("Dentro do for: ");
			Scanner entireFileText = new Scanner(new File(item.toString()));
			// .useDelimiter("\\A").next();

			while (entireFileText.hasNextLine()) {
//				flag = flag + 1;
				data = entireFileText.nextLine();
				// System.out.println("ENQUANTO TEM LINHA");
				if (data.contains(toFindAge)) {
					//System.out.println("Tenho classificacao");
					age = data.substring(0, data.indexOf("</li>"));
					age = age.replace(deleteAge, "").trim();
				}
				
				if (data.contains(toFindName)) {
					//System.out.println(data);

					if (data.indexOf("</h1>") == -1) {
						break;
					} else {
						title = data.substring(0, data.indexOf("</h1>"));
						title = title.replace(daleteName, "").trim();
					}
				}
//				
			}
			
			System.out.println(count);
			textoQueSeraEscrito = textoQueSeraEscrito + quebraLinha + title+" idade:"+age;
//			System.out.println(textoQueSeraEscrito);
//			movie.setName(title);
//			movie.setAge(age);
//			moviesObjects.add(movie);
//			System.out.println("Title:" + title);
//			System.out.println("Age:" + age);
//			System.out.println("\n");
		}
		
		try {
			filmesAge = new FileWriter(new File("C:/Users/RianTavaresBrumAlves/Documents/Projetos/rtavares/filmesAge.txt"));
			filmesAge.write(textoQueSeraEscrito);
			filmesAge.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total: "+ count);
//		for (int i = 0; i < moviesObjects.size(); i++) {
//			System.out.println(moviesObjects.get(i).getName() + "     Age: " + moviesObjects.get(i).getAge());
//		}
		// <h1 style="margin-bottom: 5px">
		// System.out.println(entireFileText);
		System.out.println("terminou 1");

		return moviesObjects;

	}
}
