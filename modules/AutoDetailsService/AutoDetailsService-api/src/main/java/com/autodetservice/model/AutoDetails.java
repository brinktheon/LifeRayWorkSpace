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

package com.autodetservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AutoDetails service. Represents a row in the &quot;autodetails&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsModel
 * @see com.autodetservice.model.impl.AutoDetailsImpl
 * @see com.autodetservice.model.impl.AutoDetailsModelImpl
 * @generated
 */
@ImplementationClassName("com.autodetservice.model.impl.AutoDetailsImpl")
@ProviderType
public interface AutoDetails extends AutoDetailsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.autodetservice.model.impl.AutoDetailsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AutoDetails, Long> AUTODETAIL_ID_ACCESSOR = new Accessor<AutoDetails, Long>() {
			@Override
			public Long get(AutoDetails autoDetails) {
				return autoDetails.getAutodetailId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AutoDetails> getTypeClass() {
				return AutoDetails.class;
			}
		};
}