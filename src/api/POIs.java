package api;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class POIs {

	private String nomePOIs;
	private int pX;
	private int pY;
	
	public String getNomePOIs() {
		return nomePOIs;
	}
	public void setNomePOIs(String nomePOIs) {
		this.nomePOIs = nomePOIs;
	}
	public int getpX() {
		return pX;
	}
	public void setpX(int pX) {
		this.pX = pX;
	}
	public int getpY() {
		return pY;
	}
	public void setpY(int pY) {
		this.pY = pY;
	}

	
}
