package com.personservice.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.personservice.model.PersonDetails;

public class PersonDetailComparatorByFirstName extends OrderByComparator<PersonDetails>{
	
	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC = "PersonDetails.FirstName ASC";

	public static final String ORDER_BY_DESC = "PersonDetails.FirstName DESC";

	public static final String[] ORDER_BY_FIELDS = {"FirstName"};
	
	
	private final boolean _ascending;
	
	
	public PersonDetailComparatorByFirstName() {
		this(false);
	}

	public PersonDetailComparatorByFirstName(boolean ascending) {
		_ascending = ascending;
	}
	
	
	@Override
	public int compare(PersonDetails value1, PersonDetails value2) {
		String age1 = value1.getFirstName();
		String age2 = value2.getFirstName();
		
		int value = age1.compareTo(age2);

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
