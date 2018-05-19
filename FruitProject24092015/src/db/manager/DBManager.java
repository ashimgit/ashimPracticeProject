package db.manager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import puchase.pojo.Purchase;
import puchase.pojo.PurchaseItemDetail;
import sale.pojo.Sale;
import sale.pojo.SaleItemDetail;
import stockTransfer.pojo.Stock;
import master.fruitmaster.FruitMaster;
import customer.Customer;
import customer.account.CAccount;
import db.connection.DBConnection;

public class DBManager {

	public String getPasswordByUsername(String username) {

		String password = "";
		Connection con = null;
		try {
			String query = "select * from user_master where username=?";
			con = db.connection.DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				password = rs.getString(1);
			}
			System.out.println(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return password;
	}

	public String setCustomerDetails(Customer customer, String sType) { // here
																			// customer
																			// may
																			// be
																			// customer/godown/supplier
																			// etc
		String flag ="";
		Connection con = null;
		try {
			CallableStatement cs = null;
			con = db.connection.DBConnection.getConnection();
			if (sType.equals("customer")) {
				cs = con.prepareCall("{call insert_customer_details(?,?,?,?,?,?)}");
			}
			if (sType.equals("supplier")) {
				cs = con.prepareCall("{call insert_supplier_details(?,?,?,?,?,?)}");
			}
			if (sType.equals("godown")) {
				cs = con.prepareCall("{call insert_godown_details(?,?,?,?,?,?)}");
			}
			// CallableStatement cs =
			// con.prepareCall("{call insert_customer_details(?,?,?,?,?,?)}");
			cs.setString(1, customer.getCustomerName());
			cs.setString(2, customer.getCustomerAddress1());
			cs.setString(3, customer.getCustomerAddress2());
			cs.setString(4, customer.getCustomerphoneNo1());
			cs.setString(5, customer.getCustomerphoneNo2());
			cs.registerOutParameter(6, java.sql.Types.VARCHAR);
			int t = cs.executeUpdate();
			if (t > 0) {
				System.out.println(t + "*******");
				String customerCode = cs.getString(6);
				System.out.println("Customercode::" + customerCode);
				con.commit();
				flag = customerCode;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return flag;
	}

	public String insertFruitMaster(FruitMaster fruit, String insertType) {
		String fruitCode = "";
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = db.connection.DBConnection.getConnection();
			cs = con.prepareCall("{call insert_fruit_master(?,?,?,?,?,?,?,?)}");
			cs.setInt(1, fruit.getMainCatId());
			cs.setString(2, fruit.getMainCatName());
			cs.setString(3, fruit.getMainCatDesc());
			cs.setString(4, fruit.getFruitName());
			cs.setString(5, fruit.getFruitDesc());
			cs.setString(6, fruit.getFruitUnit());
			cs.setString(7, insertType);
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);
			int flag = cs.executeUpdate();
			if (flag>0) {
				fruitCode = cs.getString(8);
				con.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return fruitCode;
	}

	// get fruit catagory

	public List<String[]> getAllFruitCatagory() {
		List<String[]> fruitCatagoryList = new ArrayList<String[]>();
		Connection con = null;
		ResultSet rs = null;
		String[] catagory;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "select catId,catName from fruitcatagory";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				catagory = new String[2];
				catagory[0] = rs.getString(1);
				catagory[1] = rs.getString(2);
				fruitCatagoryList.add(catagory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return fruitCatagoryList;
	}

	// get fruit name by catagory

	public List<String[]> getAllFruitNameByCatagory(String catId) {
		List<String[]> fruitNameList = new ArrayList<String[]>();
		Connection con = null;
		ResultSet rs = null;
		String[] fruitName;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT * FROM fruit WHERE catId='" + catId + "'";
			PreparedStatement ps = con.prepareStatement(q1);
			rs = ps.executeQuery();
			while (rs.next()) {
				fruitName = new String[3];
				fruitName[0] = rs.getString(1);
				fruitName[1] = rs.getString(2);
				fruitName[2] = rs.getString(4);
				fruitNameList.add(fruitName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return fruitNameList;
	}

	// get fruit name and rate by catagory

	public List<Map<String, String>> getAllFruitNameAndRateByCatagory(
			String catId) {
		// List<String[]> fruitDetailsList = new ArrayList<String[]>();
		Connection con = null;
		ResultSet rs = null;
		Map<String, String> fruitDetails;
		List<Map<String, String>> fruitDetailsList = new ArrayList<Map<String, String>>();
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT fruit.fruitId, fruit.fName, fruitdailysellrate.sell_rate FROM fruitshopdb.fruit INNER JOIN fruitshopdb.fruitdailysellrate ON (fruit.fruitId = fruitdailysellrate.fruitId) WHERE (fruit.catId = "
					+ catId + ")";
			PreparedStatement ps = con.prepareStatement(q1);
			rs = ps.executeQuery();
			while (rs.next()) {
				fruitDetails = new HashMap<String, String>();
				fruitDetails.put("fruitId", rs.getString(1));
				fruitDetails.put("fruitName", rs.getString(2));
				fruitDetails.put("fruitSaleRate", rs.getString(3));
				fruitDetailsList.add(fruitDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return fruitDetailsList;
	}

	// save purchase

	public String insertPurchase(Purchase purchase) {
		String purchaseNo = "";
		String godownNo = purchase.getGoDownNo();
		List<PurchaseItemDetail> purchaseItemList = new ArrayList<PurchaseItemDetail>();
		purchaseItemList = purchase.getPurchaseIteamList();
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = db.connection.DBConnection.getConnection();
			cs = con.prepareCall("{call insert_purchse_details(?,?,?,?,?)}");
			cs.setString(1, purchase.getPurchaseDate());
			cs.setString(2, purchase.getSupplierNo());
			cs.setString(3, purchase.getPurchaseBillNo());
			cs.setDouble(4, purchase.getTotalPurchaseAmount());
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			int flag = cs.executeUpdate();
			if (flag > 0) {
				purchaseNo = cs.getString(5);
				System.out.println("purchaseNo::" + purchaseNo);
			}
			cs.close();
			int count = 0;
			if (purchaseNo.length() > 0 && godownNo != null) {
				for (int i = 0; i < purchaseItemList.size(); i++) {
					PurchaseItemDetail newItem = new PurchaseItemDetail();
					newItem = (PurchaseItemDetail) purchaseItemList.get(i);
					cs = con.prepareCall("{call insert_purchse_item_details(?,?,?,?,?,?)}");
					cs.setString(1, newItem.getFruitId());
					cs.setString(2, newItem.getQuantity());
					cs.setDouble(3, newItem.getPurchaseItemRate());
					cs.setDouble(4, newItem.getPurchaseItemTotal());
					cs.setString(5, purchaseNo);
					cs.setString(6, godownNo);
					int flag1 = cs.executeUpdate();
					if (flag1 > 0) {
						count++;
					}
				}
			}
			System.out.println("count::" + count);
			if (purchaseItemList.size() == count) {
				System.out.println("Save...");
				con.commit();
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return purchaseNo;
	}

	// save Sale

	public String insertSale(Sale sale) {
		String saleNo = "";
		List<SaleItemDetail> saleItemList = new ArrayList<SaleItemDetail>();
		saleItemList = sale.getSaleIteamList();
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = db.connection.DBConnection.getConnection();
			cs = con.prepareCall("{call insert_sale_details(?,?,?,?,?,?,?,?)}");
			cs.setString(1, sale.getSaleDate());
			cs.setString(2, sale.getCustomerNo());
			cs.setDouble(3, sale.getGrossAmount());
			cs.setDouble(4, sale.getDiscountAmount());
			cs.setDouble(5, sale.getTaxAmount());
			cs.setDouble(6, sale.getNetAmount());
			cs.setDouble(7, sale.getCustomerpaidAmount());
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);
			int flag = cs.executeUpdate();
			if (flag > 0) {
				saleNo = cs.getString(8);
				System.out.println("saleNo::" + saleNo);
			}
			cs.close();
			int count = 0;
			if (saleNo.length() > 0) {
				for (int i = 0; i < saleItemList.size(); i++) {
					SaleItemDetail newItem = new SaleItemDetail();
					newItem = (SaleItemDetail) saleItemList.get(i);
					cs = con.prepareCall("{call insert_sale_item_details(?,?,?,?,?,?,?,?)}");
					cs.setString(1, newItem.getFruitId());
					cs.setString(2, newItem.getQuantity());
					cs.setDouble(3, newItem.getSaleItemRate());
					cs.setDouble(4, newItem.getSaleIteamTotal());
					cs.setString(5, saleNo);
					cs.setString(6, sale.getGodownId());
					cs.setString(7, newItem.getTagId());
					cs.setDouble(8, newItem.getSaleItemDiscount());
					int flag1 = cs.executeUpdate();
					if (flag1 > 0) {
						count++;
					}
				}
			}

			if (saleItemList.size() == count) {
				con.commit();
				System.out.println("save...");
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return saleNo;
	}

	public boolean setFruitRateByFruitId(String fruitId, Double fruitRate) {
		boolean flag = false;
		Connection con = null;
		int r = 0;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "UPDATE fruitdailysellrate SET sell_rate=" + fruitRate
					+ " WHERE fruitId='" + fruitId + "'";
			PreparedStatement ps = con.prepareStatement(q1);
			r = ps.executeUpdate();

			if (r > 0) {
				con.commit();
				flag = true;
				ps.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return flag;
	}

	// get fruit name by catagory 2
	/* ################## get fruit name by catagory 2 ######################## */
	public List<FruitMaster> getAllFruitByCatagory(String catagoryId) {
		List<FruitMaster> fruitNameList = new ArrayList<FruitMaster>();
		Connection con = null;
		ResultSet rs = null;
		FruitMaster fruitName;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT * FROM fruit WHERE catId='" + catagoryId + "'";
			PreparedStatement ps = con.prepareStatement(q1);
			rs = ps.executeQuery();
			while (rs.next()) {
				fruitName = new FruitMaster();
				fruitName.setFruitId(rs.getString(1));
				fruitName.setFruitName(rs.getString(2));
				fruitName.setFruitDesc(rs.getString(3));
				fruitName.setFruitUnit(rs.getString(4));

				fruitNameList.add(fruitName);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return fruitNameList;
	}

	/*
	 * ################## END of get fruit name by catagory 2
	 * ########################
	 */

	public List<Customer> getAllSuppier() {
		List<Customer> supplierList = new ArrayList<Customer>();
		Connection con = null;
		ResultSet rs = null;
		Customer customer;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "select sId, sName from supplier";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				supplierList.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return supplierList;
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		ResultSet rs = null;
		Customer customer;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT * FROM customer ORDER BY cName ASC";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerphoneNo1(rs.getString(5));
				customerList.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return customerList;
	}

	public List<Customer> getAllGoDown() {
		List<Customer> doDownList = new ArrayList<Customer>();
		Connection con = null;
		ResultSet rs = null;
		Customer customer;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT gId,gName FROM godown";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				doDownList.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return doDownList;
	}

	public List<FruitMaster> getFruitUnitByFruit(String fruitId) {
		List<FruitMaster> fruitUnitList = new ArrayList<FruitMaster>();
		Connection con = null;
		ResultSet rs = null;
		FruitMaster fruit;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT fruitId,unit,fName FROM fruit WHERE fruitId='"
					+ fruitId + "'";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				fruit = new FruitMaster();
				fruit.setFruitId(rs.getString(1));
				fruit.setFruitUnit(rs.getString(2));
				fruit.setFruitName(rs.getString(3));
				fruitUnitList.add(fruit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return fruitUnitList;
	}

	public List<SaleItemDetail> getFruitDetailsByFruitId(String fruitId) {
		List<SaleItemDetail> fruitUnitList = new ArrayList<SaleItemDetail>();
		Connection con = null;
		ResultSet rs = null;
		SaleItemDetail fruit;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT fruit.fruitId, fruit.unit, fruitdailysellrate.sell_rate, onshopstock.quantity FROM  fruitshopdb.fruit  INNER JOIN fruitshopdb.fruitdailysellrate ON (fruit.fruitId = fruitdailysellrate.fruitId) INNER JOIN fruitshopdb.onshopstock ON (fruitdailysellrate.fruitId = onshopstock.fruitId) WHERE fruit.fruitId='"
					+ fruitId + "'";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				fruit = new SaleItemDetail();
				fruit.setFruitId(rs.getString(1));
				fruit.setSaleUnit(rs.getString(2));
				fruit.setSaleItemRate(rs.getDouble(3));
				fruit.setQuantity(rs.getString(4));
				fruitUnitList.add(fruit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return fruitUnitList;
	}

	// new update getFruitDetailsByFruitId function below

	public List<SaleItemDetail> getFruitDetails(String fruitId) {
		List<SaleItemDetail> fruitUnitList = new ArrayList<SaleItemDetail>();
		Connection con = null;
		ResultSet rs = null;
		SaleItemDetail fruit;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "SELECT * FROM onshopstock WHERE fruitId='" + fruitId
					+ "'";
			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				fruit = new SaleItemDetail();
				fruit.setTagId(rs.getString(1));
				fruit.setFruitId(rs.getString(2));
				fruit.setSaleUnit(rs.getString(4));
				fruit.setQuantity(rs.getString(3));
				fruitUnitList.add(fruit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return fruitUnitList;
	}

	public List<SaleItemDetail> getFruitDetailsByFruitIdAndGodown(
			String fruitId, String goDownId) {
		List<SaleItemDetail> fruitUnitList = new ArrayList<SaleItemDetail>();
		Connection con = null;
		ResultSet rs = null;
		SaleItemDetail fruit;
		try {
			con = db.connection.DBConnection.getConnection();
			String q1 = "";
			if (goDownId.equalsIgnoreCase("OnShop")) {

				q1 = "select * from onshopstock WHERE fruitId='" + fruitId
						+ "'";
			} else {

				q1 = "select * from godownstock WHERE fruitId='" + fruitId
						+ "' and gId='" + goDownId + "'";
			}

			PreparedStatement pst = con.prepareStatement(q1);
			rs = pst.executeQuery();
			while (rs.next()) {
				fruit = new SaleItemDetail();
				fruit.setFruitId(rs.getString("fruitId"));
				fruit.setSaleUnit(rs.getString("unit"));
				// fruit.setSaleItemRate(rs.getDouble(""));
				fruit.setQuantity(rs.getString("quantity"));
				fruit.setTagId(rs.getString("tagId"));
				fruitUnitList.add(fruit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return fruitUnitList;
	}

	public boolean updateStocktransfer(List<SaleItemDetail> itemList,
			String fromGodown, String toGodown) {
		boolean flag = false;
		Connection con = null;
		int count = 0;
		try {
			for (int i = 0; i < itemList.size(); i++) {
				try {
					SaleItemDetail item = itemList.get(i);
					CallableStatement cs = null;
					con = db.connection.DBConnection.getConnection();
					cs = con.prepareCall("{call stock_transfer(?,?,?,?,?,?)}");
					cs.setString(1, item.getFruitId());
					cs.setString(2, item.getQuantity());
					cs.setDouble(3, item.getSaleIteamTotal());
					cs.setString(4, fromGodown);
					cs.setString(5, toGodown);
					cs.setString(6, item.getTagId());
					int t = cs.executeUpdate();
					count += t;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (itemList.size() == count) {
				con.commit();
				flag = true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return flag;
	}

	public Sale getSaleDetailsBySaleId(String saleId) {
		Sale sale = new Sale();
		List<SaleItemDetail> itemList = new ArrayList<SaleItemDetail>();
		sale.setSaleNo(saleId);
		Connection con = db.connection.DBConnection.getConnection();
		try {
			String q1 = "Select * from sales where saleId='" + saleId + "'";
			PreparedStatement p1 = con.prepareStatement(q1);
			ResultSet r1 = p1.executeQuery();
			while (r1.next()) {
				sale.setSaleDate(r1.getString("saleDate"));
				sale.setCustomerNo(r1.getString("cId"));
				sale.setTaxAmount(r1.getDouble("tax"));
				sale.setNetAmount(r1.getDouble("netAmt"));
				sale.setGrossAmount(r1.getDouble("grossAmt"));
				sale.setDiscountAmount(r1.getDouble("discount"));
				// sale.setCustomerpaidAmount(r1.getDouble(""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String q2 = "Select * from saledetail where saleId='" + saleId
					+ "'";
			PreparedStatement p2 = con.prepareStatement(q2);
			ResultSet r2 = p2.executeQuery();
			while (r2.next()) {
				SaleItemDetail item = new SaleItemDetail();
				item.setFruitId(r2.getString("fruitId"));
				item.setQuantity(r2.getString("quantity"));
				item.setSaleUnit(r2.getString("unit"));
				item.setSaleItemDiscount(r2.getDouble("saleItemDiscount"));
				item.setSaleItemRate(r2.getDouble("saleRate"));
				item.setSaleIteamTotal(r2.getDouble("saleItemAmt"));
				item.setTagId(r2.getString("tagId"));

				itemList.add(item);
			}
			sale.setSaleIteamList(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sale;
	}

	public Customer getCustomerDetailsByCustomerId(String customerId) {
		Customer customer = new Customer();
		Connection con = db.connection.DBConnection.getConnection();
		try {
			String q1 = "Select * from customer where cId='" + customerId + "'";
			PreparedStatement ps = con.prepareStatement(q1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomerName(rs.getString("cName"));
				customer.setCustomerphoneNo1(rs.getString("cPh1"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public Double getCustomerPaidAmountBySale(String saleId) {
		Double paidAmt = new Double(0.00);
		Connection con = db.connection.DBConnection.getConnection();
		try {
			String q1 = "SELECT paidAmt FROM customeraccount WHERE saleId='"
					+ saleId + "'";
			PreparedStatement ps = con.prepareStatement(q1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				paidAmt = rs.getDouble("paidAmt");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return paidAmt;
	}

	public List<CAccount> getCustomerAccountDetailsByDate(String customerId,
			String toDate, String fromDate) {

		List<CAccount> account = new ArrayList<CAccount>();

		Connection con = db.connection.DBConnection.getConnection();
		try {
			String query = "SELECT * FROM customeraccount WHERE cId='"
					+ customerId + "' AND saleDate >= '" + fromDate
					+ "' AND saleDate <= '" + toDate + "' AND STATUS='F'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CAccount acc = new CAccount();
				acc.setSaleId(rs.getString("saleId"));
				acc.setSaleDate(rs.getString("saleDate"));
				acc.setSaleAmt(rs.getDouble("billAmt"));
				acc.setPaidAmt(rs.getDouble("paidAmt"));
				account.add(acc);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}

	
	public List<CAccount> getCustomerAllAccountDetailsByDate(String customerId,
			String toDate, String fromDate) {

		List<CAccount> account = new ArrayList<CAccount>();

		Connection con = db.connection.DBConnection.getConnection();
		try {
			String query = "SELECT * FROM customeraccount WHERE cId='"
					+ customerId + "' AND saleDate >= '" + fromDate
					+ "' AND saleDate <= '" + toDate + "'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CAccount acc = new CAccount();
				acc.setSaleId(rs.getString("saleId"));
				acc.setSaleDate(rs.getString("saleDate"));
				acc.setSaleAmt(rs.getDouble("billAmt"));
				acc.setPaidAmt(rs.getDouble("paidAmt"));
				acc.setStatus(rs.getString("status"));
				account.add(acc);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}
	
	public List<CAccount> getCustomerAllAccountPaymentDetailsByDate(List<CAccount> accountDetails, String customerId,
			String toDate, String fromDate) {

		List<CAccount> account = accountDetails;

		Connection con = db.connection.DBConnection.getConnection();
		try {
			String query = "SELECT * FROM TRANSACTION WHERE trans_ref='"
					+ customerId + "' AND trans_date >= '" + fromDate
					+ "' AND trans_date <= '" + toDate + "'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CAccount acc = new CAccount();
				acc.setSaleId(rs.getString("trans_id"));
				acc.setSaleDate(rs.getString("trans_date"));
				acc.setSaleAmt(0.00);
				acc.setPaidAmt(rs.getDouble("trans_amount"));
				acc.setStatus(rs.getString("remarks"));
				account.add(acc);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}
	
	public boolean saveCustomerAccountDetails(String customerId,
			String fromDate, String toDate, Double paidAmt) {
		boolean flag = false;
		String query = "{CALL update_customer_account(?,?,?,?)}";
		try {
			Connection con = db.connection.DBConnection.getConnection();
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, customerId);
			cs.setString(2, fromDate);
			cs.setString(3, toDate);
			cs.setDouble(4, paidAmt);
			int f = cs.executeUpdate();
			if (f>0) {
				con.commit();
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public CAccount getPreviousAccountDue(String customerId) {

		CAccount acc = new CAccount();

		Connection con = db.connection.DBConnection.getConnection();
		try {
			String query = "SELECT * FROM customerbalance WHERE cId='"+customerId+"'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				acc.setSaleId("Prev Due");
				acc.setSaleDate(rs.getString("updated_on"));
				acc.setSaleAmt(rs.getDouble("balance"));
				acc.setPaidAmt(0.00);
				acc.setStatus("Due after adjustment");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return acc;
	}
	
	public List<Stock> getCurrentStock(String godownId){
		
		List<Stock> itemList = new ArrayList<Stock>();
		String query = "";
		Connection con = db.connection.DBConnection.getConnection();
		try {
			if(godownId.equalsIgnoreCase("OnShop")){
				query = "SELECT fruit.fName, onshopstock.* FROM fruitshopdb.onshopstock INNER JOIN fruitshopdb.fruit ON (onshopstock.fruitId = fruit.fruitId) ORDER BY onshopstock.fruitId asc";
			}else{
				query = "SELECT fruit.fName, godownstock.* FROM  fruitshopdb.godownstock INNER JOIN fruitshopdb.fruit ON (godownstock.fruitId = fruit.fruitId) WHERE gId='"+godownId+"' ORDER BY fruitId asc";
			}
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Stock item = new Stock();
				
				item.setTagId(rs.getString("tagId"));
				item.setFruitId(rs.getString("fruitId"));
				item.setFruitName(rs.getString("fName"));
				item.setQuantity(rs.getString("quantity"));
				item.setUnit(rs.getString("unit"));
				itemList.add(item);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return itemList;
	}
	
	public int getNoOfBoxByCustomerId(String customerId){
		int noOfBox = 0;
		Connection con = db.connection.DBConnection.getConnection();
		String query="select no_of_boxs from customer_vs_boxs where cid='"+customerId+"'";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				noOfBox=rs.getInt("no_of_boxs");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return noOfBox;
	}
	
	public boolean saveBoxByCustomer(String noOfBox, String customerId, String operation){
		boolean flag = false;
		String query = "";
		if(operation.equalsIgnoreCase("send")){
			query="update customer_vs_boxs set no_Of_boxs = no_Of_boxs +"+noOfBox+" where cid='"+customerId+"'";
		}
		if(operation.equalsIgnoreCase("receive")){
			query="update customer_vs_boxs set no_Of_boxs = no_Of_boxs -"+noOfBox+" where cid='"+customerId+"'";
		}
		
		Connection con = db.connection.DBConnection.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			int r = ps.executeUpdate();
			if(r>0){
				con.commit();
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

}// endofclass
