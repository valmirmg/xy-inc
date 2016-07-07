package jUnit;

import java.util.HashMap;
import java.util.Scanner;

import org.junit.Test;

import api.POIs;
import persistence.BO;

public class TestListarPOIsPorAproximacao {

	@Test
	public void test() throws Exception {
		
		
		System.out.println("Teste Localização por aproximação");
		System.out.println("-----------------------");
		
		Scanner entrada = new Scanner(System.in);
		
		//DADOS DE ENTRADA
		int px = 0;
		int py = 0;
		int dMax = 0;
		
		
		System.out.println("Informe posição X: ");
        px = entrada.nextInt();
        
        System.out.println("Informe posição Y: ");
        py = entrada.nextInt();
        
        System.out.println("Informe a distância maxíma de aproximação: ");
        dMax = entrada.nextInt();
		
		HashMap<Integer, POIs> lista = BO.localizarPOIsPorAproximacao(px, py, dMax);
		
		for (POIs item : lista.values()) {
			
			System.out.println("Nome POI : " + item.getNomePOIs());
			System.out.println("Posição X: " + item.getpX());
			System.out.println("Posição Y: " + item.getpY());
			System.out.println("---------------------------------------");
			
		}
		
	}

}
