package jUnit;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import persistence.DAO;

public class TestExcluirRegistro {

	@Test
	public void test() throws Exception {
		
		System.out.println("Teste de excluir POIs");
		System.out.println("-----------------------");
		
		Scanner entrada = new Scanner(System.in);

        String nomePOI = "";
        String sId = "";
        Integer id = 0;
        boolean retorno = false;

        do {
        	
        	System.out.println("Informe o nome do POI: ");
            nomePOI = entrada.nextLine();
            
            if (nomePOI.equals("sair") || nomePOI.equals("SAIR")){
            	break;
            }
            
        	System.out.println("Informe o ID: ");
            sId = entrada.nextLine();
            
            if (sId.isEmpty()){
            	id = 0;
            }else{
            	id = Integer.parseInt(sId);
            }

            retorno = DAO.excluir(id, nomePOI.toString().toUpperCase());
            
            if (retorno){
            	System.out.println("Registro Excluido com Sucesso!\n");
            }else{
            	System.out.println("Registro não Excluido. \nNão foi localizado registro com esses parametros para realizar a exlusão!\n");
            }
            
			//Limpar buffer do teclado
            entrada.nextLine();
            
		}

        //Se digitar "sair" o sistema para de inserir
        while (!nomePOI.equals("sair"));
		
	}

}
