package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puolue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PuolueID;
	private String Nimi;
	private String Lyhenne;
	private String Kuvaus;
	private String Kuva;
	
	public Puolue(int puolueID, String nimi, String lyhenne, String kuvaus, String kuva) {
		super();
		this.PuolueID = puolueID;
		this.Nimi = nimi;
		this.Lyhenne = lyhenne;
		this.Kuvaus = kuvaus;
		this.Kuva = kuva;
	}
	
	public Puolue() {
		
		
	}

	public int getPuolueID() {
		return PuolueID;
	}

	public void setPuolueID(int puolueID) {
		this.PuolueID = puolueID;
	}

	public String getNimi() {
		return Nimi;
	}

	public void setNimi(String nimi) {
		this.Nimi = nimi;
	}

	public String getLyhenne() {
		return Lyhenne;
	}

	public void setLyhenne(String lyhenne) {
		this.Lyhenne = lyhenne;
	}

	public String getKuvaus() {
		return Kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.Kuvaus = kuvaus;
	}

	public String getKuva() {
		return Kuva;
	}

	public void setKuva(String kuva) {
		Kuva = kuva;
	}
}