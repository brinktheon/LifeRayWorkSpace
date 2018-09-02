/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.autodetservice.service.impl;

import java.util.List;

import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;


import com.autodetservice.model.AutoDetails;
import com.autodetservice.model.impl.AutoDetailsModelImpl;
import com.autodetservice.service.base.AutoDetailsLocalServiceBaseImpl;
import com.liferay.portal.kernel.util.OrderByComparator;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the auto details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.autodetservice.service.AutoDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsLocalServiceBaseImpl
 * @see com.autodetservice.service.AutoDetailsLocalServiceUtil
 */
@ProviderType
public class AutoDetailsLocalServiceImpl extends AutoDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.autodetservice.service.AutoDetailsLocalServiceUtil} to access the auto details local service.
	 */
	
	public List<AutoDetails> findAll() {
		return this.autoDetailsPersistence.findAll();
	}
	
	public List<AutoDetails> getEntries(
			long userId, String model, int start, int end,
			OrderByComparator<AutoDetails> obc) {

			return autoDetailsPersistence.findByM_U(userId, model, start, end, obc);
	}
	
	public List<AutoDetails> getByM_U(
			long userId, String model) {

			return autoDetailsPersistence.findByM_U(userId, model);
	}
	
	public List<AutoDetails> getBY_U(
			long userId, int year) {

			return autoDetailsPersistence.findByY_U(userId, year);
	}
	
	public List<AutoDetails> findSomething(int start, int end,
			OrderByComparator<AutoDetails> orderByComparator){
		
		return autoDetailsPersistence.findAll(start, end, orderByComparator, false);
	}
	
	public List<AutoDetails> lastFind(int start, int end){
		
		return autoDetailsPersistence.findAll(
				start, 
				end,  
				OrderByComparatorFactoryUtil.create(AutoDetailsModelImpl.TABLE_NAME, "Model", "asc"), 
				false
				);
	}

	@Override
	public List<AutoDetails> findSomething(int start, int end, OrderByComparator<AutoDetails> orderByComparator,
			boolean retrieveFromCache) {
		// TODO Auto-generated method stub
		return null;
	}
}








