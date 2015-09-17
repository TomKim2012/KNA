package com.wira.mms.client.application.task;

import gwt.material.design.client.ui.MaterialAutoComplete;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TaskForm extends Composite {

	private static TaskFormUiBinder uiBinder = GWT
			.create(TaskFormUiBinder.class);

	interface TaskFormUiBinder extends UiBinder<Widget, TaskForm> {
	}

	@UiField
	MaterialAutoComplete autoCompleteUsers;

	public TaskForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
