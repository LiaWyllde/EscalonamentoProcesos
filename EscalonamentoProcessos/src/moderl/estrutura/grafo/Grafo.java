package moderl.estrutura.grafo;

import java.util.*;

public class Grafo {
	
	private String[] processes;
	private HashMap<String, ArrayList<String>> controll = new HashMap<>();
	
	public Grafo(String[] process) {
		this.processes = process;
		for (String processo : processes) {
			controll.put(processo, new ArrayList<>());
		} 
	}
	
	public Grafo() {
	}
	
	public void add(String process) {
		if (!controll.containsKey(process)) {
			controll.put(process, new ArrayList<>());
		}
	}
	
	public void dependencias(String origem, String dependente, boolean dupla) {
		if (!controll.containsKey(origem)) {
			add(origem);
		}
		getControll().get(origem).add(dependente);
		if (dupla) {
			getControll().get(dependente).add(origem);
		}
		if (!controll.containsKey(dependente)) {
			add(dependente);
		}
	}
	
	public HashMap<String, ArrayList<String>> getControll() {
		return controll;
	}
	
	public void removeProcesso(String key) {
		getControll().remove(key);
	}
	
	public void removeDependencia(String key, String dependencia) {
		getControll().get(key).remove(dependencia);
	}
	
	public void visualizar() {
		for(String processo : getControll().keySet()) {
			System.out.println(processo + " dependencias: " + getControll().get(processo));
		}
	}
	
	public String[] ordemSegura() {
		int i = 0;
		String[] processosExecutados = new String[controll.size()];
		var hash = controll;
		int idiota = controll.size();
		int k = 0;
		
		while(idiota != 0) {
			for (String processo : controll.keySet()) {
				if (hash.get(processo).size() == 0 && (!Arrays.asList(processosExecutados).contains(processo))) {
					processosExecutados[i] = processo;
					++i;
				} 
				if (Arrays.asList(processosExecutados).contains(processo)) {
					for (String p : hash.keySet()) {
						if (hash.get(p).contains(processo)) {
							hash.get(p).remove(processo);
						}
					}
				} 
			}
			idiota--;
		}
		return processosExecutados;
	}
}
