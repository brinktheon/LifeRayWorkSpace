package com.personservice.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.personservice.model.PersonDetails;

public class PersonDetailComparatorByAge extends OrderByComparator<PersonDetails>{
	
	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC = "PersonDetails.Age ASC";

	public static final String ORDER_BY_DESC = "PersonDetails.Age DESC";

	public static final String[] ORDER_BY_FIELDS = {"Age"};
	
	
	private final boolean _ascending;
	
	
	public PersonDetailComparatorByAge() {
		this(false);
	}

	public PersonDetailComparatorByAge(boolean ascending) {
		_ascending = ascending;
	}
	
	
	@Override
	public int compare(PersonDetails value1, PersonDetails value2) {
		Integer age1 = value1.getAge();
		Integer age2 = value2.getAge();
		
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
