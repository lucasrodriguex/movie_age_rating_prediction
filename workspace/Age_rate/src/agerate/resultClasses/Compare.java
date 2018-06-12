package agerate.resultClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import agerate.classes.Film;
import agerate.mainClasses.ReadFileByFile;
import agerate.mainClasses.ReadFileByFile2;

public class Compare {

	@SuppressWarnings({"unused", "unchecked"})
	public static void main(String[] args) throws FileNotFoundException {
		// variables
		String folder = "C:/Users/RianTavaresBrumAlves/Documents/Projetos/rtavares/filme";
		String folder2 = "C:/Users/RianTavaresBrumAlves/Documents/Projetos/rtavares/data_amount/subtitles";
		ArrayList<Film> movieSubtitles = new ArrayList<Film>();
		ArrayList<Film> movieAge = new ArrayList<Film>();
		int count = 0;
//		movieAge = ReadFileByFile.fileByfile(folder);
		movieSubtitles = ReadFileByFile2.fileByfile(folder2);
//		
//		
		for (int i = 0; i < movieAge.size(); i++) {
			for (int j = 0; j < movieSubtitles.size(); j++) {
				if ((movieSubtitles.get(j).getName().toLowerCase()).equals(movieAge.get(i).getName().toLowerCase())) {
					count = count + 1;
					System.out.println(movieSubtitles.get(j).getName());
//					final File rs = new File(folder2 + "/" + movieSubtitles.get(j).getName().toLowerCase() + ".txt");
//					Scanner entireFileText = new Scanner(new File(rs.toString()));
//					String text = "Titulo: " + movieAge.get(i).getName() + "\n Classificacao Indicativa: " + movieAge.get(i).getAge() + "\n";
//					FileOutputStream fs = new FileOutputStream(folder2 + "/" + movieSubtitles.get(j).getName().toLowerCase() + ".txt");
					
//					try {
//						fs.write((text + entireFileText).getBytes());
//						entireFileText.close();
//						fs.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		}
		System.out.println(count);
	}

}
