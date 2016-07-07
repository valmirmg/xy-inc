package persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import api.POIs;

public class BO {
	
	public static HashMap<Integer, POIs> listarPOIs() throws Exception{
		
		HashMap<Integer, POIs> poiMap = new HashMap<Integer, POIs>();
		try {
			
			ConnectionSqLite cnnSq = new ConnectionSqLite();
			Connection conn = cnnSq.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM POI");
			
			while ( rs.next() ) {
				POIs p = new POIs();
				p.setNomePOIs(rs.getString("NOME_POI"));
				p.setpX(rs.getInt("POI_X"));
				p.setpY(rs.getInt("POI_Y"));
				poiMap.put(p.getpX(), p);
		      }
			
			rs.close();
			st.close();
			
		} catch (Exception e) {
			throw e;
		}
		
		return (HashMap<Integer, POIs>) poiMap;
	}

	
	public static HashMap<Integer, POIs> localizarPOIsPorAproximacao(int P_X, int P_Y, int dMax) throws Exception{
		
		HashMap<Integer, POIs> poiMap = new HashMap<Integer, POIs>();
		String sql = "";
		try {
			
			ConnectionSqLite cnnSq = new ConnectionSqLite();
			Connection conn = cnnSq.getConnection();
			Statement st = conn.createStatement();
			sql = "SELECT * FROM POI WHERE (ABS(POI_X - " + P_X + ")" + " + ABS(POI_Y - " + P_Y + ")) <= " + dMax ;
			ResultSet rs = st.executeQuery(sql);
													
			while ( rs.next() ) {
				POIs p = new POIs();
				p.setNomePOIs(rs.getString("NOME_POI"));
				p.setpX(rs.getInt("POI_X"));
				p.setpY(rs.getInt("POI_Y"));
				poiMap.put(p.getpX(), p);
		      }
			
			rs.close();
			st.close();
			
		} catch (Exception e) {
			throw e;
		}
		
		return (HashMap<Integer, POIs>) poiMap;
	}
}
