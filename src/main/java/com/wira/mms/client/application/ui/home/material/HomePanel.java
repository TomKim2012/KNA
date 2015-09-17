package com.wira.mms.client.application.ui.home.material;

import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModal.TYPE;
import gwt.material.design.client.ui.MaterialNavBar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.wira.mms.client.application.story.StoryForm;
import com.wira.mms.client.application.task.TaskForm;

public class HomePanel extends Composite {

	private static HomePanelUiBinder uiBinder = GWT
			.create(HomePanelUiBinder.class);

	interface HomePanelUiBinder extends UiBinder<Widget, HomePanel> {
	}
	
	
	public HomePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("aStory")
	void onCreateStory(ClickEvent e) {
		StoryForm storyForm = new StoryForm();
		MaterialModal.showModal(storyForm, TYPE.FIXED_FOOTER,false);
	}

	@UiHandler("aTask")
	void onCreateTask(ClickEvent e) {
		TaskForm taskForm = new TaskForm();
		MaterialModal.showModal(taskForm, TYPE.FIXED_FOOTER,false);
	}

}