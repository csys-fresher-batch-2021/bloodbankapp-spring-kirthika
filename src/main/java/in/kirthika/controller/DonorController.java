package in.kirthika.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;

@RestController
public class DonorController {
	
    @GetMapping("/DisplayDonorjson")
	public List<DonorDetail> getAllDonor() {
    	
    	DonorManager donor = new DonorManager();
		List<DonorDetail> donorList = donor.displayDonorList();
		return donorList;
    }

}
