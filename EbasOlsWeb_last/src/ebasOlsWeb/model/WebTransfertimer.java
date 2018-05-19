package ebasOlsWeb.model;

import javax.persistence.Column;

public class WebTransfertimer {
	
	@Column(name="waittimesucc")
	private int	waittimesucc;// numeric(10),
	
	@Column(name="waittimefail")
	private int waittimefail;// numeric(10)

	public int getWaittimesucc() {
		return waittimesucc;
	}

	public void setWaittimesucc(int waittimesucc) {
		this.waittimesucc = waittimesucc;
	}

	public int getWaittimefail() {
		return waittimefail;
	}

	public void setWaittimefail(int waittimefail) {
		this.waittimefail = waittimefail;
	}
	
	

}
