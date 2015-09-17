package com.wira.mms.client.components.stories;

import gwt.material.design.client.ui.MaterialCollapsible;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.wira.mms.client.application.ui.material.components.MaterialDataGrid;

public class StoriesView extends Composite {

	private static StoriesViewUiBinder uiBinder = GWT
			.create(StoriesViewUiBinder.class);

	interface StoriesViewUiBinder extends UiBinder<Widget, StoriesView> {
	}

	@UiField MaterialCollapsible panelStories;
	
	public StoriesView() {
		initWidget(uiBinder.createAndBindUi(this));
		//panelStories.addItem(new MaterialDataGrid());
		StoryView firstStory = new StoryView("Uhuru's visit to Kisumu");
		firstStory.setActive(true);
		panelStories.addItem(firstStory);
		panelStories.addItem(new StoryView("Kalpana Rawal Media Briefing"));
		panelStories.addItem(new StoryView("Waiguru's Media Briefing"));
		panelStories.addItem(new StoryView("IEBC Commissioners PSC Grilling"));
		panelStories.addItem(new StoryView("Mombasa ASK Show"));
		
	}

}
