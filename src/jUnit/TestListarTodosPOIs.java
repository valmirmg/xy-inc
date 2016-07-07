package jUnit;

import java.util.HashMap;

import org.junit.Test;

import api.POIs;
import persistence.BO;

public class TestListarTodosPOIs {

	@Test
	public void test() throws Exception {
		System.out.println("Teste pode ser feito também no Browser. Start Tomcat e no Browser entre com o endereço local:\nhttp://localhost:8080/teste-valmir/listarPOI/");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		HashMap<Integer, POIs> lista = BO.listarPOIs();
		
		for (POIs item : lista.values()) {
			
			System.out.println("Nome POI : " + item.getNomePOIs());
			System.out.println("Posição X: " + item.getpX());
			System.out.println("Posição Y: " + item.getpY());
			System.out.println("---------------------------------------");
			
		}
	}

}
