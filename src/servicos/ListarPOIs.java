package servicos;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import api.POIs;
import persistence.BO;

@Path("/listarPOI")
public class ListarPOIs {

	
	@GET
	@Produces("text/xml")
	public List<POIs> getBandas() throws Exception {
		return new ArrayList<POIs>(BO.listarPOIs().values());
	}
	
	@Path("{id}")
	@GET
	@Produces("text/xml")
	public POIs getBanda(@PathParam("id") int id) throws Exception {
		return BO.listarPOIs().get(id);
	}
	
	
	/*
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String adicionaBanda(Banda banda) {
		banda.setId(bandasMap.size() + 1);
		bandasMap.put(banda.getId(), banda);
		return banda.getNome() + " adicionado.";
	}

	@Path("{id}")
	@PUT
	@Consumes("text/xml")
	@Produces("text/plain")
	public String atualizaBanda(Banda banda, @PathParam("id") int id) {
		Banda atual = bandasMap.get(id);
		atual.setNome(banda.getNome());
		atual.setAnoDeFormacao(banda.getAnoDeFormacao());
		return banda.getNome() + " atualizada.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeBanda(@PathParam("id") int id) {
		bandasMap.remove(id);
		return "Banda removida.";
	}
	
	*/
}
