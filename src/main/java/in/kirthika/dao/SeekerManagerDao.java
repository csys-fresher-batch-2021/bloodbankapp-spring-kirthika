package in.kirthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import in.kirthika.model.SeekerDetail;
import in.kirthika.model.SeekerStatusDetail;
import in.kirthika.util.ConnectionUtil;

public class SeekerManagerDao {
	private static final List<SeekerDetail> seekerList = new ArrayList<>();
	private static final List<SeekerStatusDetail> seekerStatusList = new ArrayList<>();
	private static final Map<String, String> seekerNumberList = new HashMap<>();
	private static final String DONOR_NAME = "donor_name";
	private static final String DONOR_PLACE = "donor_place";
	private static final String DONOR_NUMBER = "donor_number";
	private static final String DONOR_BLOOD = "donor_blood";
	private static final String SEEKER_BLOOD = "seeker_blood";
	private static final String SEEKER_NAME = "seeker_name";
	private static final String SEEKER_MOBILENUMBER = "seeker_number";
	private static final String SEEKER_AGE = "seeker_age";
	private static final String SEEKER_PLACE = "seeker_place";
	private static final String SEEKER_DATE = "seeker_date";
	private static final String SEEKER_GENDER = "seeker_gender";
	private static final String SEEKER_STATUS = "seeker_status";
	private static final String INSERT_SEEKER_DATA_QUERY = "insert into seeker_detail (seeker_blood,seeker_name,seeker_number,seeker_age,seeker_place,seeker_date,seeker_gender,seeker_status) values (?,?,?,?,?,?,?,?)";
	private static final String DISPLAY_ALL_DATA_QUERY = "select * from seeker_detail where seeker_status='Pending'";
	private static final String UPDATE_SEEKER_DATA_QUERY = "update seeker_detail set seeker_status='Approved' where seeker_number=? and seeker_name=?";
	private static final String SEEKER_RESULT = "select d.donor_name,d.donor_place,d.donor_number,d.donor_blood from donor_detail d,seeker_detail s\r\n"
			+ "where  seeker_number=? and seeker_name=? and seeker_status='Approved' and (d.donor_blood=s.seeker_blood)";
	private static final String SEEKER_NUMBER = "select * from seeker_detail where seeker_number=? and seeker_name=?";

	/*
	 * function to add seeker detail
	 */
	public boolean save(SeekerDetail detail) throws ClassNotFoundException, SQLException {
		boolean isValid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = INSERT_SEEKER_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, detail.getBloodGroup());
			pst.setString(2, detail.getName());
			pst.setLong(3, detail.getMobileNumber());
			pst.setInt(4, detail.getAge());
			pst.setString(5, detail.getPlace());
			pst.setObject(6, detail.getDate());
			pst.setString(7, detail.getGender());
			pst.setString(8, "Pending");
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
	 * function to display seeker list
	 */
	public List<SeekerDetail> displayAllList() throws ClassNotFoundException, SQLException {
		seekerList.clear();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = DISPLAY_ALL_DATA_QUERY;

			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String seekerBlood = rs.getString(SEEKER_BLOOD);
				String seekerName = rs.getString(SEEKER_NAME);
				Long seekerNumber = rs.getLong(SEEKER_MOBILENUMBER);
				int seekerAge = rs.getInt(SEEKER_AGE);
				String seekerPlace = rs.getString(SEEKER_PLACE);
				LocalDate seekerDate = LocalDate.parse(rs.getString(SEEKER_DATE));
				String seekerGender = rs.getString(SEEKER_GENDER);
				String seekerStatus = rs.getString(SEEKER_STATUS);

				SeekerDetail detail = new SeekerDetail(seekerBlood, seekerName, seekerNumber, seekerAge, seekerPlace,
						seekerDate, seekerGender, seekerStatus);
				seekerList.add(detail);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {

			ConnectionUtil.close(pst, connection);
		}
		return seekerList;

	}

	/*
	 * function to display seeker request list
	 */
	public void approveSeeker(Long seekerNum, String name) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			String sql = UPDATE_SEEKER_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			String num = String.valueOf(seekerNum);
			pst.setString(1, num);
			pst.setString(2, name);
			pst.executeUpdate();

			seekerList.clear();
			displayAllList();
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}

		ConnectionUtil.close(pst, connection);

	}

	/*
	 * function to display the approved seeker list
	 */

	public boolean seekerStatus(SeekerDetail detail) throws ClassNotFoundException, SQLException {

		boolean isValid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = SEEKER_RESULT;
			pst = connection.prepareStatement(sql);
			String num = String.valueOf(detail.getMobileNumber());
			pst.setString(1, num);
			pst.setString(2, detail.getName());
			ResultSet rs = pst.executeQuery();

			seekerStatusList.clear();
			while (rs.next()) {

				String donorName = rs.getString(DONOR_NAME);
				String donorPlace = rs.getString(DONOR_PLACE);
				Long donorNumber = rs.getLong(DONOR_NUMBER);
				String seekerBlood = rs.getString(DONOR_BLOOD);

				SeekerStatusDetail status = new SeekerStatusDetail(donorName, donorPlace, donorNumber, seekerBlood);
				seekerStatusList.add(status);
				isValid = true;

			}
		} catch (Exception e) {
			e.getMessage();
		}
		ConnectionUtil.close(pst, connection);

		return isValid;
	}

	/*
	 * function to display seeker status
	 */

	public Map<String, String> seekerNumber(Long number, String name) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = SEEKER_NUMBER;
			pst = connection.prepareStatement(sql);
			String num = String.valueOf(number);
			pst.setString(1, num);
			pst.setString(2, name);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String seekerNumber = rs.getString(SEEKER_MOBILENUMBER);
				String seekerName = rs.getString(SEEKER_NAME);
				seekerNumberList.put(seekerNumber, seekerName);

			}
		} catch (Exception e) {
			e.getMessage();
		}
		ConnectionUtil.close(pst, connection);
		return seekerNumberList;
	}

	public Map<String, String> seekerDetail() {
		return seekerNumberList;
	}

	public List<SeekerStatusDetail> display() {
		return seekerStatusList;
	}

}
