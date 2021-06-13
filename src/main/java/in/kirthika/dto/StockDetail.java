package in.kirthika.dto;

import java.util.HashMap;
import java.util.Map;

public class StockDetail {
	private Map<String,Integer> stockCount=new HashMap<>();

	public Map<String, Integer> getStockCount() {
		return stockCount;
	}

	public StockDetail(Map<String, Integer> stockCount) {
		super();
		this.stockCount = stockCount;
	}

}
