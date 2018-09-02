package com.autodetservice.comparator;

import com.autodetservice.model.AutoDetails;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AutoDetailComparator extends OrderByComparator<AutoDetails>{
	
	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC = "AutoDetails.Model ASC";

	public static final String ORDER_BY_DESC = "AutoDetails.Model DESC";

	public static final String[] ORDER_BY_FIELDS = {"Model"};
	
	
	private final boolean _ascending;
	
	
	public AutoDetailComparator() {
		this(false);
	}

	public AutoDetailComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	
	@Override
	public int compare(AutoDetails value1, AutoDetails value2) {
		String model1 = value1.getModel();
		String model2 = value2.getModel();
		
		int value = model1.compareTo(model2);

		if (_ascending) {
			return value;
		}
		else {
		  return -value;
		}
	}
	
	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
	
	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

}
