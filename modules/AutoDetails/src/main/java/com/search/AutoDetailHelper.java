package com.search;

import java.util.Collections;


import java.util.List;


import com.autodetservice.model.impl.AutoDetailsImpl;
import com.autodetails.portlet.AutoDetailsPortlet;
import com.autodetservice.model.AutoDetails;
import com.autodetservice.service.AutoDetailsLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class AutoDetailHelper {
	
	private static Log logger =  LogFactoryUtil.getLog(AutoDetailsPortlet.class);
	
	public static List<AutoDetails> getEmployee(int year, String model, boolean isAndOperator) throws SystemException {
		List<AutoDetails> autoDetailsList = Collections.emptyList();
		
		DynamicQuery dynamicQuery = AutoDetailsLocalServiceUtil.dynamicQuery();
		
		Junction junction = null;
		
		 
		if (isAndOperator) {
			junction = RestrictionsFactoryUtil.conjunction();
		} else {
			junction = RestrictionsFactoryUtil.disjunction();
		}
		if (Validator.isDigit(year + "") || year > 0) {
			junction.add(PropertyFactoryUtil.forName("Year").eq(Integer.valueOf(year)));
		}
		if (!Validator.isBlank(model)) {
			junction.add(PropertyFactoryUtil.forName("Model").like(StringPool.PERCENT + HtmlUtil.escape(model) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			autoDetailsList = AutoDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		
		logger.info("Year: " + year + " AND " + "Model: " + model);
		return autoDetailsList;

	}
	
	public static List<AutoDetails> getEmployeeByKeyWord(String keywords) throws SystemException {
		List<AutoDetails> autoDetailsList = Collections.emptyList();
		
		final Junction junction = RestrictionsFactoryUtil.disjunction();
		
		DynamicQuery dynamicQuery = AutoDetailsLocalServiceUtil.dynamicQuery();

//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AutoDetails.class, PortalClassLoaderUtil.getClassLoader());
		
		if (Validator.isDigit(keywords)) {
			junction.add(PropertyFactoryUtil.forName("Year").eq(Integer.valueOf(keywords)));
		} 
		else {
			junction.add(PropertyFactoryUtil.forName("Model").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		}
		dynamicQuery.add(junction);
		try {
			autoDetailsList = AutoDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		
		return autoDetailsList;
	}
}
