package ebasOlsWeb.services;

import java.util.List;

import ebasOlsWeb.model.WebCntSmry;

public interface DataServices {

	
	public List<String> getVesselList() throws Exception;

	public List<String> getContainerDetails(String vcn,String tradeType) throws Exception;
	
	public List<String> getVesselCntList() throws Exception;
	
	public List<String> getContainerCntDetails(String vcn,String tradeType,String mloname) throws Exception;
	
	public List<String> getCntAgent(String vcn) throws Exception;
	
	public List<String> getCntTrackList() throws Exception;
	
	public List<String> getContainerTrack(String mloname,String vessel,String trade) throws Exception;
	
	public List<String> getVesselTrack(String vcn) throws Exception;
	
	
}
