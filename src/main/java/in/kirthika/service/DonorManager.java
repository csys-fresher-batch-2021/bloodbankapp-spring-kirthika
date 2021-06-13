package in.kirthika.service;

import in.kirthika.dao.DonorManagerDao;
import in.kirthika.model.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DonorManager {

	private DonorManagerDao managerDao = new DonorManagerDao();

	public boolean addDonor(DonorDetail detail) throws ClassNotFoundException, SQLException {

		boolean isValid = managerDao.save(detail);
		if (!isValid) {
			managerDao.displayIndividual(String.valueOf(detail.getMobileNumber()), detail.getName());
		}
		return isValid;
	}

	public void deleteDonor(Long donorNum, String donorName) {
		try {

			managerDao.deleteDonor(donorNum, donorName);
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
	}

	public boolean donorSearch(String donorBlood, String donorPlace) {
		boolean isValid = true;
		try {
			managerDao.searchList(donorBlood, donorPlace);
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
			isValid = false;
		}
		return isValid;
	}

	public void filterBlood(String blood) {
		try {
			managerDao.filterBlood(blood);

		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}
	}
	
	public Map<String,Integer> stockCount(DonorDetail detail) {
		return(managerDao.stockCount(detail));
		
	}

	public List<DonorDetail> displayDonorList() {
		return (managerDao.allDonorList());
	}

	public List<DonorDetail> displaySearchDonorList() {
		return (managerDao.allSearchDonorList());
	}

	public List<DonorDetail> filterList() {
		return (managerDao.displayFilterList());
	}
	public Map<String,Integer> stockList(){
		return(managerDao.stockList());
	}


}
