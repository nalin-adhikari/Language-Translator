/**
 * 
 */
package com.ml.langtranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

/**
 * @author Nalin Adhikari
 * @since October, 2016
 *
 */
public class Translator {

	private static LanguageTranslator service;
	private static String USERNAME = "d49b0d74-3266-4132-8c17-c37fd001fc09";
	private static String PASSWORD = "k7xNegNHFqDx";

	static {
		service = new LanguageTranslator();
		service.setUsernameAndPassword(USERNAME, PASSWORD);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;

		greeting();

		do {
			System.out.print("ENGILSH > ");
			s = br.readLine();

			System.out.println("SPANISH > " + translate(s));

		} while (s != "bye");

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	private static String translate(String s) {

		TranslationResult translationResult = service.translate("hello", Language.ENGLISH, Language.SPANISH).execute();
		
		if (translationResult.getFirstTranslation() != null) {
			return translationResult.getFirstTranslation();
		} else {
			System.out.println("Got null result.");
			return "Sorry, I did not understand.";
		}
	}

	private static void greeting() {
		System.out.println("\n\nWELCOME TO LANGUAGE TRANSLATOR");
		System.out.println("\n\nType bye to exit.\n\n");
	}

}
