package persistence;

import java.sql.Connection;
import java.sql.Statement;

public class DAO {

	public static void inserir(String sql) throws Exception{
		
		try {
			
			ConnectionSqLite cnnSq = new ConnectionSqLite();
			Connection conn = cnnSq.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			
			conn.commit();
			st.close();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static boolean excluir(Integer id, String nomePoi) throws Exception{
		
		boolean ret = false;
		try {
			
			ConnectionSqLite cnnSq = new ConnectionSqLite();
			Connection conn = cnnSq.getConnection();
			Statement st = conn.createStatement();
			
			if (id != null && id > 0 && nomePoi.isEmpty()){
				st.executeUpdate("DELETE FROM POI WHERE ID = " + id);
				ret = true;
			}
			
			if (id != null && id>0 && !nomePoi.isEmpty()){
				st.executeUpdate("DELETE FROM POI WHERE ID = " + id + "AND NOME_POI = '" + nomePoi + "'");
				ret = true;
			}
			
			if (id == null || id < 0 && !nomePoi.isEmpty()){
				st.executeUpdate("DELETE FROM POI WHERE NOME_POI = '" + nomePoi + "'");
				ret = true;
			}
			
			conn.commit();
			st.close();
			
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}
}
