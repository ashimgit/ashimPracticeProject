package ebasOlsWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ebasOlsWeb.dao.DataDao;
import ebasOlsWeb.model.WebCntSmry;




public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public List<String> getVesselList() throws Exception {
		
		return dataDao.getVesselList();
	}
	
	@Override
	public List<String> getContainerDetails(String vcn,String tradeType) throws Exception{
		
		return dataDao.getContainerDetails(vcn,tradeType);
	}
	
	@Override
	public List<String> getVesselCntList() throws Exception {
		
		return dataDao.getVesselList();
	}
	
	@Override
	public List<String> getContainerCntDetails(String vcn,String tradeType,String mloname) throws Exception{
		
		return dataDao.getContainerCntDetails(vcn,tradeType,mloname);
	}
	
	@Override
	public List<String> getCntAgent(String vcn) throws Exception{
		
		return dataDao.getCntAgent(vcn);
	}
	
	@Override
	public List<String> getCntTrackList() throws Exception {
		
		return dataDao.getCntTrackList();
	}
	
	@Override
	public List<String> getContainerTrack(String mloname,String vessel,String trade) throws Exception{
		
		return dataDao.getContainerTrack(mloname,vessel,trade);
	}
	
    public List<String> getVesselTrack(String vcn) throws Exception{
		
		return dataDao.getVesselTrack(vcn);
	}

}
