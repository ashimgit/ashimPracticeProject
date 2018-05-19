package ebasOlsWeb.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ebasOlsWeb.services.DataServices;


@Controller
@RequestMapping("/ebasOls")
public class EbasOlsController {

	@Autowired
	DataServices dataServices;

	@RequestMapping(value = "/getVessel", method = RequestMethod.GET)
	public @ResponseBody 
	List getVessel() {
		//System.out.println("gggg");

		List vesselList = null;
		try {
			vesselList = dataServices.getVesselList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vesselList;
	}

	@RequestMapping(value = "/getContainer", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List getContainer(@RequestBody String[] vc) {
		//System.out.println("getContainer" +vc[0]);
		String[] vcn= (vc[0].split("\\,"));
		//System.out.println("Here "+vcn[1]+" "+vc[1]);

		List containerList = null;
		try {
			containerList = dataServices.getContainerDetails(vcn[1],vc[1]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return containerList;
	}

	@RequestMapping(value = "/getVesselCnt", method = RequestMethod.GET)
	public @ResponseBody 
	List getVesselCnt() {
		//System.out.println("gggg");

		List vesselList = null;
		try {
			vesselList = dataServices.getVesselCntList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vesselList;
	}

	@RequestMapping(value = "/getContainerCnt", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List getContainerCnt(@RequestBody String[] vc) {
		String[] vcn= (vc[0].split("\\,"));
		List containerList = null;
		try {
			containerList = dataServices.getContainerCntDetails(vcn[1],vc[1],vc[2]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return containerList;
	}


	@RequestMapping(value = "/getCntAgent", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List getCntAgent(@RequestBody String[] vc) {
		String[] vcn= (vc[0].split("\\,"));//separate vcn and ves name
		
		List containerList = null;
		try {
			containerList = dataServices.getCntAgent(vcn[1]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return containerList;
	}


	@RequestMapping(value = "/getCntTrack", method = RequestMethod.GET)
	public @ResponseBody 
	List getCntTrack() {
		//System.out.println("gggg");

		List vesselList = null;
		try {
			vesselList = dataServices.getCntTrackList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vesselList;
	}

	
	
	@RequestMapping(value = "/getContainerTrack", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List getContainerTrack(@RequestBody String[] vc) {
		String[] vcn= (vc[1].split("\\,"));//separate vcn and ves name

		List containerList = null;
		try {
			containerList = dataServices.getContainerTrack(vc[0],vcn[0],vc[2]);

		} catch (Exception e) {
			e.getMessage();
		}

		return containerList;
	}
	
	@RequestMapping(value = "/getVesselTrack", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List getVesselTrack(@RequestBody String[] vc) {
		//String[] vcn= (vc[0].split("\\,"));//separate vcn and ves name
		
		List containerList = null;
		try {
			containerList = dataServices.getVesselTrack(vc[0]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return containerList;
	}




}
