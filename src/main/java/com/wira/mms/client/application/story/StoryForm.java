package com.wira.mms.client.application.story;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StoryForm extends Composite {

	private static StoryFormUiBinder uiBinder = GWT
			.create(StoryFormUiBinder.class);

	interface StoryFormUiBinder extends UiBinder<Widget, StoryForm> {
	}
	
	
	public StoryForm() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

}
