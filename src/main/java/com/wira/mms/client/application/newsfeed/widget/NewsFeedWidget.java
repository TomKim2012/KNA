package com.wira.mms.client.application.newsfeed.widget;

import gwt.material.design.client.ui.MaterialImage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NewsFeedWidget extends Composite {

	private static NewsFeedWidgetUiBinder uiBinder = GWT
			.create(NewsFeedWidgetUiBinder.class);

	interface NewsFeedWidgetUiBinder extends UiBinder<Widget, NewsFeedWidget> {
	}
	
	MaterialImage l;

	public NewsFeedWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
