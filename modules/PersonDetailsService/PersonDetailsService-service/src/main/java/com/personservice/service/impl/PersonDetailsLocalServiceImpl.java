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

package com.personservice.service.impl;

import java.util.List;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.personservice.model.PersonDetails;
import com.personservice.service.base.PersonDetailsLocalServiceBaseImpl;

/**
 * The implementation of the person details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.personservice.service.PersonDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetailsLocalServiceBaseImpl
 * @see com.personservice.service.PersonDetailsLocalServiceUtil
 */
public class PersonDetailsLocalServiceImpl
	extends PersonDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.personservice.service.PersonDetailsLocalServiceUtil} to access the person details local service.
	 */
	
	public List<PersonDetails> findAll() {
		return personDetailsPersistence.findAll();
	}
	
	public List<PersonDetails> findByComparator(int start, int end,
			OrderByComparator<PersonDetails> orderByComparator){
		
		return personDetailsPersistence.findAll(start, end, orderByComparator, false);
	}
}