package com.test;

import com.darkprograms.speech.translator.GoogleTranslate;

public class TransalteTest {

	public static void main(String[] args) {
		try {
		System.out.println(GoogleTranslate.translate("en", "晚上好"));
		}catch (Exception e) {
			System.out.println("Tests");
		}
	}
}
