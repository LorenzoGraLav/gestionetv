package it.gestionetv.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.gestionetv.model.Televisore;


public class DB_Mock {
	
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "samsung", "galax8", 600D, 40, "SGLX"));
		LISTA_TELEVISORI.add(new Televisore(2l, "lg", "specialz", 400D, 32, "LGSP"));
		LISTA_TELEVISORI.add(new Televisore(3l, "hi-Sense", "vision", 290D, 28, "HSVS"));
		LISTA_TELEVISORI.add(new Televisore(4l, "sony", "sensitive", 230D, 24, "SOSY"));
		LISTA_TELEVISORI.add(new Televisore(5l, "acer", "spectre",  190D, 22, "ASCT"));
		LISTA_TELEVISORI.add(new Televisore(6l, "panasonic", "lightLed",  3000D, 70, "PLHT"));
		LISTA_TELEVISORI.add(new Televisore(7l, "aoc", "gamingSpecial",  770D, 38, "ACGS"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId=LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getIdTelevisore)).get().getIdTelevisore();
		return ++resultId;
	}
}
