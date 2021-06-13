package in.kirthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.kirthika.model.DonorDetail;
import in.kirthika.util.ConnectionUtil;

public class DonorManagerDao {

	private static final List<DonorDetail> taskList = new ArrayList<>();
	private static final List<DonorDetail> donorSearch = new ArrayList<>();
	private static final List<DonorDetail> filterList = new ArrayList<>();
	private static final Map<String,Integer> stockList = new HashMap<>();
	private static final Map<String, String> donorCheckList = new HashMap<>();
	private static final String DONOR_BLOOD = "donor_blood";
	private static final String DONOR_NAME = "donor_name";
	private static final String DONOR_MOBILENUMBER = "donor_number";
	private static final String DONOR_AGE = "donor_age";
	private static final String DONOR_PLACE = "donor_place";
	private static final String INSERT_DONOR_DATA_QUERY = "insert into donor_detail (donor_blood,donor_name,donor_number,donor_age,donor_place) values (?,?,?,?,?)";
	private static final String DISPLAY_ALL_DATA_QUERY = "select * from donor_detail";
	private static final String SEARCH_DONOR_DATA_QUERY = "select * from donor_detail where donor_blood=? and donor_place=?";
	private static final String DELETE_DONOR_DATA_QUERY = "delete from donor_detail where donor_number=? and donor_name=?";
	private static final String DISPLAY_INDIVIDUAL_DATA_QUERY = "select * from donor_detail where donor_number=? and donor_name=?";
	private static final String FILTER_DONOR_NAME = "select * from donor_detail where donor_blood like ?";
	private static final String DONOR_CHECK = "select * from donor_detail where donor_number=? and donor_name=?";
	private static final String STOCK_COUNT="select donor_blood,count(donor_blood) as count from donor_detail where donor_place=? group by donor_blood";
	static {
		try {
			displayAllList();
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}
	}
	/*
	 * function to add donor in database
	 */

	public boolean save(DonorDetail detail) throws ClassNotFoundException, SQLException {
		boolean isValid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = INSERT_DONOR_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, detail.getBloodGroup());
			pst.setString(2, detail.getName());
			pst.setLong(3, detail.getMobileNumber());
			pst.setInt(4, detail.getAge());
			pst.setString(5, detail.getPlace());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			isValid = true;
			e.getMessage();
		} finally {

			ConnectionUtil.close(pst, connection);
		}
		return isValid;
	}

	/*
	 * function to display all donor list
	 */
	public static List<DonorDetail> displayAllList() throws ClassNotFoundException, SQLException {
	
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = DISPLAY_ALL_DATA_QUERY;

			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String donorBlood = rs.getString(DONOR_BLOOD);
				String donorName = rs.getString(DONOR_NAME);
				Long donorNumber = rs.getLong(DONOR_MOBILENUMBER);
				int donorAge = rs.getInt(DONOR_AGE);
				String donorPlace = rs.getString(DONOR_PLACE);

				DonorDetail detail = new DonorDetail(donorBlood, donorName, donorNumber, donorAge, donorPlace);
				taskList.add(detail);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {

			ConnectionUtil.close(pst, connection);
		}
		return taskList;

	}

	/*
	 * function to search donor based on blood and place
	 */
	public List<DonorDetail> searchList(String donorBlood, String donorPlace)
			throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			donorSearch.clear();
			String sql = SEARCH_DONOR_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, donorBlood);
			pst.setString(2, donorPlace);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String donorBlood1 = rs.getString(DONOR_BLOOD);
				String donorName = rs.getString(DONOR_NAME);
				Long donorNumber = rs.getLong(DONOR_MOBILENUMBER);
				int donorAge = rs.getInt(DONOR_AGE);
				String donorPlace1 = rs.getString(DONOR_PLACE);

				DonorDetail detail = new DonorDetail(donorBlood1, donorName, donorNumber, donorAge, donorPlace1);
				donorSearch.add(detail);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return donorSearch;
	}

	/*
	 * function to delete donor from the list
	 */

	public void deleteDonor(Long donorNum, String donorName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			String sql = DELETE_DONOR_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			String num = String.valueOf(donorNum);
			pst.setString(1, num);
			pst.setString(2, donorName);
			pst.executeUpdate();

			taskList.clear();
			displayAllList();
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}

		ConnectionUtil.close(pst, connection);

	}

	public List<DonorDetail> displayIndividual(String donorNum, String name)
			throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();

			String sql = DISPLAY_INDIVIDUAL_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, donorNum);
			pst.setString(2, name);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String donorBlood = rs.getString(DONOR_BLOOD);
				String donorName = rs.getString(DONOR_NAME);
				Long donorNumber = rs.getLong(DONOR_MOBILENUMBER);
				int donorAge = rs.getInt(DONOR_AGE);
				String donorPlace = rs.getString(DONOR_PLACE);

				DonorDetail detail = new DonorDetail(donorBlood, donorName, donorNumber, donorAge, donorPlace);
				taskList.add(detail);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}

		finally {

			ConnectionUtil.close(pst, connection);
		}
		return taskList;

	}
	/*
	 * function to filter donor based on blood group
	 */

	public void filterBlood(String filterDonorBlood) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		filterList.clear();
		try {

			connection = ConnectionUtil.getConnection();

			String sql = FILTER_DONOR_NAME;

			pst = connection.prepareStatement(sql);

			pst.setString(1, filterDonorBlood + "%");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String donorBlood1 = rs.getString(DONOR_BLOOD);
				String donorName = rs.getString(DONOR_NAME);
				Long donorNumber = rs.getLong(DONOR_MOBILENUMBER);
				int donorAge = rs.getInt(DONOR_AGE);
				String donorPlace1 = rs.getString(DONOR_PLACE);

				DonorDetail detail = new DonorDetail(donorBlood1, donorName, donorNumber, donorAge, donorPlace1);
				filterList.add(detail);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}

		ConnectionUtil.close(pst, connection);

	}

	public Map<String, String> donorExistCheck(String number, String name) throws ClassNotFoundException, SQLException {
		
		
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = DONOR_CHECK;
			pst = connection.prepareStatement(sql);
			pst.setString(1, number);
			pst.setString(2, name);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String donorNumber = rs.getString(DONOR_MOBILENUMBER);
				String donorName = rs.getString(DONOR_NAME);
				donorCheckList.put(donorNumber, donorName);

			}
		} catch (Exception e) {
			e.getMessage();
		}
		ConnectionUtil.close(pst, connection);
		return donorCheckList;
	}
	
	public Map<String,Integer> stockCount(DonorDetail detail) {
	
		
		Connection connection = null;
		PreparedStatement pst = null;
	    stockList.clear();
		try {

			connection = ConnectionUtil.getConnection();
			String sql =STOCK_COUNT;
			pst = connection.prepareStatement(sql);
			pst.setString(1, detail.getPlace());
			
		    ResultSet rs= pst.executeQuery();

			while (rs.next()) {
				String blood = rs.getString(DONOR_BLOOD);
				Integer number = rs.getInt("count");
				stockList.put(blood,number);
				
			
			}
            
		}
		catch (Exception e) {
			e.getMessage();
		}
		ConnectionUtil.close(pst, connection);
		return stockList;
		
		
	}

	/*
	 * function to return all donor List
	 */
	public List<DonorDetail> allDonorList() {
		return taskList;
	}

	/*
	 * function to return donor search list
	 */
	public List<DonorDetail> allSearchDonorList() {
		return donorSearch;
	}

	/*
	 * function to return donor filter list
	 */
	public List<DonorDetail> displayFilterList() {
		return filterList;
	}

	public Map<String, String> donorCheckList() {
		return donorCheckList;
	}
   
	public Map<String,Integer> stockList() {
		return stockList;
	}
}
