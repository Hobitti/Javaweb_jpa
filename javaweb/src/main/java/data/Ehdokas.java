package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ehdokas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EhdokasID")
	private int id;
	
	@Column(name = "Nimi")
	private String nimi;
	
	@Column(name = "KuntaID")
	private int kunta;
	
	@Column(name = "Slogan")
	private String slogan;
	
	@Column(name = "PuolueID")
	private int puolue;
	
	@Column(name = "Kuvaus")
	private String kuvaus;
//	private String kuntaS;
//	private String puolueS;

	public Ehdokas(int id, String nimi, int kuntaId, String slogan, int puolue, String kuvaus) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kunta = kuntaId;
		this.slogan = slogan;
		this.puolue = puolue;
		this.kuvaus = kuvaus;
	}
	
	public Ehdokas() {
	// todo	
	}
	
	public String getKuvaus() {
		return kuvaus;
	}
	
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public int getKunta() {
		return kunta;
	}
	
	public void setKunta(int kunta) {
		this.kunta = kunta;
	}
	
//	public String getKuntaS() {
//		return kuntaS;
//	}
//	
//	public void setKuntaS(String kuntaS) {
//		this.kuntaS = kuntaS;
//	}
	
	public String getSlogan() {
		return slogan;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public int getPuolue() {
		return puolue;
	}
	
	public void setPuolue(int puolue) {
		this.puolue = puolue;
	}
	
//	public String getPuolueS() {
//		return puolueS;
//	}
//	
//	public void setPuolueS(String puolueS) {
//		this.puolueS = puolueS;
//	}

}