package com.wira.mms.client.components.stories;

import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialLink;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wira.mms.client.application.ui.material.components.MaterialDataGrid;

public class StoryView extends Composite {

	private static StoryViewUiBinder uiBinder = GWT
			.create(StoryViewUiBinder.class);

	interface StoryViewUiBinder extends UiBinder<Widget, StoryView> {
	}

	@UiField MaterialCollapsibleItem container;
	@UiField MaterialLink panelHeading;
	@UiField HTMLPanel panelContent;
	
	public StoryView() {
		initWidget(uiBinder.createAndBindUi(this));
		//container.addContent(new MaterialDataGrid());
		panelContent.add(new MaterialDataGrid());
	}
	
	public StoryView(String storyName) {
		this();
		panelHeading.setText(storyName);
	}

	public void setActive(boolean isActive) {
		if(isActive){
			panelHeading.addStyleName("active");
		}else{
			panelHeading.removeStyleName("active");
		}
	}

}
