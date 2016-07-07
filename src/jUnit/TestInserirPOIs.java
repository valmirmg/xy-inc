package jUnit;

import java.util.Scanner;

import org.junit.Test;

import persistence.DAO;


public class TestInserirPOIs {

	@Test
	public void test() throws Exception {
		
		
		System.out.println("Teste de insert de POIs");
		System.out.println("-----------------------");
		
		Scanner entrada = new Scanner(System.in);

        String nomePOI;
        Integer px = 0;
        Integer py = 0;
        String sql;

        do {
        	sql = "";
        	
            System.out.println("Informe o nome do POI: ");
            nomePOI = entrada.nextLine();
            
            if (nomePOI.equals("sair") || nomePOI.equals("SAIR")){
            	break;
            }

            System.out.println("Informe a posição X: ");
            px = entrada.nextInt();

            System.out.println("Informe a posição Y: ");
            py = entrada.nextInt();

            if (px < 0 || py < 0){
            	System.out.println("Entre somente com números positivos para as Posições X e Y.\nNúmeros negativos serão bloqueados.");
            	break;
            }
            
            sql = "INSERT INTO POI VALUES((SELECT MAX(ID)+1 FROM POI), '" + nomePOI + "'," + px + "," + py + ")";
            DAO.inserir(sql.toString().toUpperCase());
            
            System.out.println("Registro Inserido com Sucesso!\n");
            
			//Limpar buffer do teclado
            entrada.nextLine();
            
		}

        //Se digitar "sair" o sistema para de inserir
        while (!nomePOI.equals("sair"));
		
	}

}
