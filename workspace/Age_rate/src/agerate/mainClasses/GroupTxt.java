package agerate.mainClasses;

import agerate.classes.Film;
import agerate.classes.ReadFolder;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupTxt {

	public static void main(String[] args) {
		final List<Film> filteredFilms = getMatchedFilms();
		final List<File> fileNames = getResourceFolderFiles("/subtitles");

		filteredFilms.forEach(film -> {
			try {
				copyFileToFolder(film);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		System.out.println(filteredFilms);

	}

	private static void copyFileToFolder(final Film film) throws IOException {
		final String sourceFile = film.getName().toLowerCase() + ".txt";
		final Path inputPath = Paths.get(GroupTxt.class.getClassLoader().getResource(sourceFile).getPath());
		final Path destination = Paths.get("/tmp/"+ film.getAge() + File.separator + sourceFile);
		try {
			Files.copy(inputPath, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw e;
		}
	}

	private static List<File> getResourceFolderFiles (final String folder) {
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		final URL url = loader.getResource(folder);
		final String path = url.getPath();
		return Arrays.asList(new File(path).listFiles());
	}

	public static String getFileNameWithoutExtension(final String fileName) {
		return fileName.replaceFirst("[.][^.]+$", "");
	}

	private static List<Film> getMatchedFilms() {
		final List<Film> filmsWithAge = new ArrayList<>();

		//le o arquivo de filmes
		final InputStream resource = GroupTxt.class.getResourceAsStream("/filmesAge.txt");
		final List<String> filmes = new BufferedReader(new InputStreamReader(resource)).lines().collect(Collectors.toList());

		//cria uma lista de objetos Film a partir do arquivo lido
		filmes.forEach(filme -> {
			String[] dados = filme.split("@");
			filmsWithAge.add(new Film(dados[0], dados[1]));
		});

		//pega a lista de arquivos
		final List<String> fileNames = new ArrayList<>();
		getResourceFolderFiles("subtitles").stream().forEach(file ->
				fileNames.add(getFileNameWithoutExtension(file.getName())));

		//compara a lista de filmes com a lista de arquivos e gera uma lista com os matches
		return filmsWithAge.stream().filter(
				film -> fileNames.stream()
				.anyMatch(name -> film.getName().equalsIgnoreCase(name)))
				.collect(Collectors.toList());
	}
}
