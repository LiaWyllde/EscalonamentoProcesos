package controller;

import java.util.Iterator;

import moderl.estrutura.grafo.Grafo;

public class Controller {
	
	public static void main(String[] Args) {
		
		String[] processes = {"A", "B", "C", "D", "E", "F"};
		
		Grafo frafo = new Grafo(processes);
		frafo.vizualizar();
		System.out.println("\n");
		frafo.dependencias("A", "D", false);
		frafo.dependencias("B", "A", false);
		frafo.dependencias("B", "C", false);
		frafo.dependencias("C", "D", false);
		frafo.dependencias("C", "E", false);
		frafo.dependencias("E", "F", false);
		
		var miau = frafo.ordemSegura();

		System.out.println("\n");
		frafo.vizualizar();
		
		 for (String CHATICE : miau) {
			 System.out.println(CHATICE);
		 }
		
	}
}
