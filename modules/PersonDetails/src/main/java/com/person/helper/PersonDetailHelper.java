package com.person.helper;

import java.util.Collections;
import java.util.List;


import com.personservice.model.PersonDetails;
import com.personservice.service.PersonDetailsLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.person.portlet.PersonDetailsPortlet;

public class PersonDetailHelper {
	
private static Log logger =  LogFactoryUtil.getLog(PersonDetailsPortlet.class);
	
	public static List<PersonDetails> getPersons(int age, String firstName, boolean isAndOperator) throws SystemException {
		List<PersonDetails> personDetailsList = Collections.emptyList();
		
		DynamicQuery dynamicQuery = PersonDetailsLocalServiceUtil.dynamicQuery();
		
		Junction junction = null;
		
		 
		if (isAndOperator) {
			junction = RestrictionsFactoryUtil.conjunction();
		} else {
			junction = RestrictionsFactoryUtil.disjunction();
		}
		if (Validator.isDigit(age + "") || age > 0) {
			junction.add(PropertyFactoryUtil.forName("Age").eq(Integer.valueOf(age)));
		}
		if (!Validator.isBlank(firstName)) {
			junction.add(PropertyFactoryUtil.forName("FirstName").like(StringPool.PERCENT + HtmlUtil.escape(firstName) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			personDetailsList = PersonDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		
//		logger.info("Year: " + age + " AND " + "Model: " + firstName);
		return personDetailsList;

	}
	
	public static List<PersonDetails> getPersonsByKeyWord(String keywords) throws SystemException {
		List<PersonDetails> personDetailsList = Collections.emptyList();
		
		final Junction junction = RestrictionsFactoryUtil.disjunction();
		
		DynamicQuery dynamicQuery = PersonDetailsLocalServiceUtil.dynamicQuery();
		
		if (Validator.isDigit(keywords)) {
			junction.add(PropertyFactoryUtil.forName("Age").eq(Integer.valueOf(keywords)));
		} 
		else {
			junction.add(PropertyFactoryUtil.forName("FirstName").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			personDetailsList = PersonDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		
		return personDetailsList;
	}

}
