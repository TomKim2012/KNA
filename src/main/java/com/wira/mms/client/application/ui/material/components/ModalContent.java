package com.wira.mms.client.application.ui.material.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ModalContent extends Composite {

	private static MaterialFooterUiBinder uiBinder = GWT
			.create(MaterialFooterUiBinder.class);

	interface MaterialFooterUiBinder extends UiBinder<Widget, ModalContent> {
	}

	public ModalContent() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
