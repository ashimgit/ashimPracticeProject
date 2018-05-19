package ebasOlsWeb.dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import ebasOlsWeb.model.WebCntDecn;
import ebasOlsWeb.model.WebCntSmry;
import ebasOlsWeb.model.WebTransferStatus;
import ebasOlsWeb.model.WebVisitor;

public class DataDaoImpl implements DataDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getVesselList() throws Exception {
		session = sessionFactory.openSession();
		List vesselList=new ArrayList();
		try{
			Criteria cr = session.createCriteria(WebCntSmry.class);
			ProjectionList p1=Projections.projectionList();
			p1.add(Projections.distinct(Projections.property("ves_name")));//our wanted column
			p1.add(Projections.property("vcn"));
			cr.setProjection(p1);

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				Object ob[] = (Object[])it.next();
				List vcn=new ArrayList();
				//System.out.println(ob[0]+","+ob[1]);
				vcn.add(ob[0].toString());
				vcn.add(ob[1].toString());

				vesselList.add(vcn);

			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(vesselList);

		return vesselList;

	}

	@Override
	public List<String> getContainerDetails(String vcn,String tradeType) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		List cntSmry=new ArrayList();
		//System.out.println(vcn);
		try{

			Criteria cr = session.createCriteria(WebCntSmry.class);
			cr.add(Restrictions.eq("vcn", vcn));
			cr.add(Restrictions.eq("purpose_cd", tradeType));

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				//WebCntSmry ob = (WebCntSmry)it.next();
				//cntSmry.add(ob);
				WebCntSmry ob = (WebCntSmry)it.next();
				List cnt=new ArrayList();
				cnt.add(ob.getMlo_cd());
				cnt.add(ob.getL20_cnt());
				cnt.add(ob.getL40_cnt());
				cnt.add(ob.getL45_cnt());
				cnt.add(ob.getLto_cnt());
				cnt.add(ob.getE20_cnt());
				cnt.add(ob.getE40_cnt());
				cnt.add(ob.getE45_cnt());
				cnt.add(ob.getEto_cnt());
				cnt.add(ob.getTot_cnt());
				cnt.add(ob.getTot_teus());
				cnt.add(ob.getTot_grwt());


				cntSmry.add(cnt);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(cntSmry);

		return cntSmry;
	}
	
	
	@Override
	public List<String> getVesselCntList() throws Exception {
		session = sessionFactory.openSession();
		List vesselList=new ArrayList();
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			ProjectionList p1=Projections.projectionList();
			p1.add(Projections.property("ves_name"));
			p1.add(Projections.distinct(Projections.property("vcn")));
			cr.setProjection(p1);

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				Object ob[] = (Object[])it.next();
				List vcn=new ArrayList();
				//System.out.println(ob[0]+","+ob[1]);
				vcn.add(ob[0].toString());
				vcn.add(ob[1].toString());

				vesselList.add(vcn);

			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(vesselList);

		return vesselList;

	}

	
	@Override
	public List<String> getContainerCntDetails(String vcn,String tradeType,String mloname) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		
		List cntOprn=new ArrayList();
		String trade = null, mode = null, in_dt = null, out_dt = null;
		String iso_cd = null, oprn_port_cd = null, orgn_port_cd = null;
		//System.out.println(vcn);
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			if(mloname == ""){
				cr.add(Restrictions.eq("vcn", vcn));
				cr.add(Restrictions.eq("purpose_cd", tradeType));
			}
			else{
				cr.add(Restrictions.eq("vcn", vcn));
				cr.add(Restrictions.eq("purpose_cd", tradeType));
				cr.add(Restrictions.eq("mlo_name", mloname));
			}
			

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				//WebcntOprn ob = (WebcntOprn)it.next();
				//cntOprn.add(ob);
				WebCntDecn ob = (WebCntDecn)it.next();
				List cnt=new ArrayList();
				
				 trade = ob.getPurpose_cd();
				if (trade.equals("I")){
					trade = "Import";
					 mode = ob.getOut_mode();
				}else if (trade.equals("E")){					
					trade = "Export";
					mode = ob.getIn_mode();
				}else if (trade.equals("S")){
					trade = "Stock";
					mode = ob.getIn_mode();
				}else {
					trade = "Other";
					mode = ob.getIn_mode();
				}
				if (mode.equals("V"))
					mode = "Road";
				else if (mode.equals("R"))
					mode = "Rail";
				else if (mode.equals("S"))
					mode = "Vessel";
				else
					 mode ="Other";
				iso_cd = ob.getIso_cd();
				oprn_port_cd = ob.getOprn_port_cd();
				orgn_port_cd = ob.getOrgn_port_cd();
				if((ob.getIn_dt()) != null){
					String in_dt1 = (ob.getIn_dt()).toString();
					
					in_dt = in_dt1.substring(8,10);
					in_dt = in_dt+"/"+in_dt1.substring(5,7)+"/"+in_dt1.substring(0,4);
					//System.out.println(in_dt);
					
					
				}
					
				if((ob.getOut_dt()) != null){
					String out_dt1 = (ob.getOut_dt()).toString();
					out_dt = out_dt1.substring(8,10);
					out_dt = out_dt+"/"+out_dt1.substring(5,7)+"/"+out_dt1.substring(0,4);
				}
					

				cnt.add(ob.getMlo_cd());
				//cnt.add(ob.getMlo_name());
				cnt.add(ob.getCnt_no());
				cnt.add(trade);
				cnt.add(iso_cd);
				cnt.add(ob.getCnt_size());
				cnt.add(ob.getLndc_status());
				cnt.add(ob.getTare_wt());
				cnt.add(ob.getGross_wt());
				cnt.add(oprn_port_cd);
				cnt.add(orgn_port_cd);
				cnt.add(mode);
				cnt.add(in_dt != null ? in_dt : "");
				cnt.add(out_dt != null ? out_dt : "");
				cnt.add(ob.getRemarks());

				cntOprn.add(cnt);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(cntOprn);

		return cntOprn;
	}
	
	
	@Override
	public List<String> getCntAgent(String vcn) throws Exception {
		session = sessionFactory.openSession();
		List vesselList=new ArrayList();
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			ProjectionList p1=Projections.projectionList();
			//p1.add(Projections.distinct(Projections.property("vcn")));
			p1.add(Projections.distinct(Projections.property("mlo_name")));
			cr.add(Restrictions.eq("vcn", vcn));
			cr.setProjection(p1);

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				String ob = it.next().toString();
				List mlo=new ArrayList();
				//System.out.println(ob[0]+","+ob[1]);
				mlo.add(ob);
				

				vesselList.add(mlo);

			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(vesselList);

		return vesselList;

	}
	
	@Override
	public List<String> getCntTrackList() throws Exception {
		session = sessionFactory.openSession();
		List cntList=new ArrayList();
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			ProjectionList p1=Projections.projectionList();
 			p1.add(Projections.distinct(Projections.property("mlo_name")));//our wanted column
			//p1.add(Projections.property("vcn"));
			cr.setProjection(p1);

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				String ob = it.next().toString();
				List mlo=new ArrayList();
				//System.out.println(ob[0]+","+ob[1]);
				mlo.add(ob);
				

				cntList.add(mlo);

			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(vesselList);

		return cntList;

	}
	
	
	@Override
	public List<String> getContainerTrack(String mloname,String vessel,String trade) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		String out_dt= null,out_dt1 = null,in_dt1= null,in_dt= null;
		List cntOprn=new ArrayList();
		
		//System.out.println(vcn);
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			if(vessel == "" && trade ==""){
				cr.add(Restrictions.eq("mlo_name", mloname));
				
			}
			else if(vessel == "" && trade !=""){
				
				cr.add(Restrictions.eq("mlo_name", mloname));
				cr.add(Restrictions.eq("purpose_cd", trade));
			}
			else if(vessel != "" && trade ==""){
				
				cr.add(Restrictions.eq("mlo_name", mloname));
				cr.add(Restrictions.eq("ves_name", vessel));
			}
			else{
				cr.add(Restrictions.eq("mlo_name", mloname));
				cr.add(Restrictions.eq("purpose_cd", trade));
				cr.add(Restrictions.eq("ves_name", vessel));
			}
			

			List l=cr.list();
			
			 

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				WebCntDecn ob = (WebCntDecn)it.next();
				List cnt=new ArrayList();
				
				trade = ob.getPurpose_cd();
				if (trade.equals("I")){
					trade = "Import";
				}else if (trade.equals("E")){					
					trade = "Export";
				}else if (trade.equals("S")){
					trade = "Stock";
				}else {
					trade = "Other";
				}
				
				if((ob.getIn_dt()) != null){
					in_dt1 = (ob.getIn_dt()).toString();
					
					in_dt = in_dt1.substring(8,10);
					in_dt = in_dt+"/"+in_dt1.substring(5,7)+"/"+in_dt1.substring(0,4);
					//System.out.println(in_dt);
					
					
				}
					
				if((ob.getOut_dt()) != null){
					out_dt1 = (ob.getOut_dt()).toString();
					out_dt = out_dt1.substring(8,10);
					out_dt = out_dt+"/"+out_dt1.substring(5,7)+"/"+out_dt1.substring(0,4);
				}
				
				cnt.add(ob.getVcn());
				cnt.add(ob.getVes_name());
				cnt.add(trade);
				cnt.add(ob.getCnt_no());
				cnt.add(ob.getCnt_size());
				cnt.add(ob.getLndc_status());
				cnt.add(in_dt != null ? in_dt : "");
				cnt.add(out_dt != null ? out_dt : "");
				cnt.add(ob.getRemarks());

				cntOprn.add(cnt);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(cntOprn);

		return cntOprn;
	}

	
	
	@Override
	public List<String> getVesselTrack(String mlo) throws Exception {
		session = sessionFactory.openSession();
		List vesselList=new ArrayList();
		try{
			Criteria cr = session.createCriteria(WebCntDecn.class);
			
			ProjectionList p1=Projections.projectionList();
			p1.add(Projections.distinct(Projections.property("ves_name")));//our wanted column
			p1.add(Projections.property("vcn"));
			cr.add(Restrictions.eq("mlo_name", mlo));
			cr.add(Restrictions.isNotNull("in_dt") );
			cr.setProjection(p1);

			List l=cr.list();

			Iterator it=l.iterator();

			while(it.hasNext())
			{
				//String ob = it.next().toString();
				Object ob[] = (Object[])it.next();
				List vcn=new ArrayList();
				//System.out.println(ob[0]+","+ob[1]);
				//mlo.add(ob);
				vcn.add(ob[0].toString());
				vcn.add(ob[1].toString());

				vesselList.add(vcn);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return vesselList;
	}

}
