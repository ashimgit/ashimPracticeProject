package gst.resnovae.dao;

import java.util.List;

import gst.resnovae.bean.MasParty;


public interface MasUserDao {
	public int insertMasParty(MasParty users);
	public List<String> productMaster();
}
