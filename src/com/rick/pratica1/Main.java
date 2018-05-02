package com.rick.pratica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Exercicio1.main(args);
		Exercicio2.main(args);
		Exercicio3.main(args);
		
		String ex1 = new File("").getAbsolutePath()+"/arquivos/exercicio1.txt";
		String ex2 = new File("").getAbsolutePath()+"/arquivos/exercicio2.txt";
		String ex3 = new File("").getAbsolutePath()+"/arquivos/exercicio3.txt";
		String teste = new File("").getAbsolutePath()+"/arquivos/teste.txt";
		
		BufferedWriter principal = new BufferedWriter(new FileWriter(teste));
		principal.write("QUESTÂO 1:");
		escreve(ex1, principal);
		principal.write("---------------\n");
		
		principal.write("QUESTÂO 2:");
		escreve(ex2, principal);
		principal.write("---------------\n");
		
		principal.write("QUESTÂO 3:");
		escreve(ex3, principal);
		principal.write("---------------");
		
		principal.close();
	}
	
	public static void escreve(String path, BufferedWriter bw) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				bw.write(linha);
			} else {
				break;
			}
			linha = br.readLine();
			bw.newLine();
		}
		br.close();
	}

}
