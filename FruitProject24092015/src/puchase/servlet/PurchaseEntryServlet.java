package puchase.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import puchase.pojo.Purchase;
import puchase.pojo.PurchaseItemDetail;
import sale.pojo.SaleItemDetail;
import master.fruitmaster.FruitMaster;
import db.manager.DBManager;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class PurchaseEntryServlet
 */
@WebServlet("/PurchaseEntryServlet")
public class PurchaseEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String reqType = request.getParameter("reqType");
		System.out.println("reqType::"+reqType);
		String resultJsonStr = "";
		if(reqType.equalsIgnoreCase("getFruitByCatagory")){

			String catagoryId = request.getParameter("catagoryId");
			DBManager obDbMgr=new DBManager();
			List<FruitMaster> fruitList= obDbMgr.getAllFruitByCatagory(catagoryId);
			System.out.println("fruitList:"+fruitList.size());
			resultJsonStr = new JSONSerializer().exclude("*.class").serialize(fruitList);
			System.out.println("resultJsonStr::"+resultJsonStr);
			response.getWriter().write(resultJsonStr);
		}
		
		if(reqType.equalsIgnoreCase("getUnitByFruit")){
			
			String fruitId = request.getParameter("fruitId");
			DBManager obDbMgr=new DBManager();
			List<FruitMaster> fruitList= obDbMgr.getFruitUnitByFruit(fruitId);
			System.out.println("fruitList:"+fruitList.size());
			resultJsonStr = new JSONSerializer().exclude("*.class").serialize(fruitList);
			System.out.println("resultJsonStr::"+resultJsonStr);
			response.getWriter().write(resultJsonStr);
		}
		if(reqType.equalsIgnoreCase("savePurchase")){
			
			System.out.println("Under Construction");
			String itemList = request.getParameter("itemsJsonStr");
			List<PurchaseItemDetail> fruitList = new ArrayList<PurchaseItemDetail>();
			fruitList = new JSONDeserializer<List<PurchaseItemDetail>>().use("values",  PurchaseItemDetail.class).deserialize(itemList);
			/*for(int i=0; i<itemList.length;i++){
				String currentItem  = itemList[i];
				PurchaseItemDetail item = new JSONDeserializer<PurchaseItemDetail>().deserialize(currentItem, PurchaseItemDetail.class);
				fruitList.add(item);
			}
			*/
			
			String purchaseDetail = request.getParameter("purchaseJsonStr");
			System.out.println("purchaseDetail:::"+purchaseDetail);
			Purchase purchase = new JSONDeserializer<Purchase>().deserialize(purchaseDetail, Purchase.class);
			purchase.setPurchaseIteamList(fruitList);
			System.out.println("from purchase: "+purchase.getPurchaseBillNo());
			String purchaseId = new DBManager().insertPurchase(purchase);
			System.out.println("purchaseId::::"+purchaseId); 
			
		
			if(purchaseId !=null && purchaseId.length()>0){
			resultJsonStr = new JSONSerializer().exclude("*.class").serialize(new String("Purchase Successfully Saved. Purchase Id:"+purchaseId));
			System.out.println("resultJsonStr::"+resultJsonStr);
			response.getWriter().write(resultJsonStr);
			}else{
				resultJsonStr = new JSONSerializer().exclude("*.class").serialize(new String("Purchase Entry Failed."));
				System.out.println("resultJsonStr::"+resultJsonStr);
				response.getWriter().write(resultJsonStr);
			}
		
			

		}
		
	}

}
