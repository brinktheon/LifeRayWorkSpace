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

package com.personservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PersonDetails service. Represents a row in the &quot;persondetails&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetailsModel
 * @see com.personservice.model.impl.PersonDetailsImpl
 * @see com.personservice.model.impl.PersonDetailsModelImpl
 * @generated
 */
@ImplementationClassName("com.personservice.model.impl.PersonDetailsImpl")
@ProviderType
public interface PersonDetails extends PersonDetailsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.personservice.model.impl.PersonDetailsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PersonDetails, Long> PERSON_DETAIL_ID_ACCESSOR = new Accessor<PersonDetails, Long>() {
			@Override
			public Long get(PersonDetails personDetails) {
				return personDetails.getPersonDetailId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PersonDetails> getTypeClass() {
				return PersonDetails.class;
			}
		};
}