package com.wira.mms.client.application.task;

import gwt.material.design.client.custom.MaterialSuggestionOracle;
import gwt.material.design.client.ui.MaterialAutoComplete;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;

public class TaskForm extends Composite {

	private static TaskFormUiBinder uiBinder = GWT
			.create(TaskFormUiBinder.class);

	interface TaskFormUiBinder extends UiBinder<Widget, TaskForm> {
	}

	@UiField
	MaterialAutoComplete autoCompleteUsers;
//	MaterialSuggestionOracle suggestions = new MaterialSuggestionOracle(){
//		public void requestSuggestions(Request request, Callback callback) {
//			suggestions.add("Yunalis Mat Zara'ai", new Image(
//					"http://b.vimeocdn.com/ps/339/488/3394886_300.jpg"));
//			suggestions.add("Marjorie Matias", new Image(
//					"http://lorempixel.com/50/50/people?1"));
//			suggestions.add("Zenaida Ringor", new Image(
//					"http://lorempixel.com/50/50/people?8"));
//			suggestions.add("Hanna Matias", new Image(
//					"http://lorempixel.com/50/50/people?2"));
//			new Response(suggestions);
//			callback.onSuggestionsReady(request, response);
//		};
//	};

	public TaskForm() {
		initWidget(uiBinder.createAndBindUi(this));
//		Suggestion suggestion = new 
//		suggestions.add("Yunalis Mat Zara'ai", new Image(
//				"http://b.vimeocdn.com/ps/339/488/3394886_300.jpg"));
//		suggestions.add("Marjorie Matias", new Image(
//				"http://lorempixel.com/50/50/people?1"));
//		suggestions.add("Zenaida Ringor", new Image(
//				"http://lorempixel.com/50/50/people?8"));
//		suggestions.add("Hanna Matias", new Image(
//				"http://lorempixel.com/50/50/people?2"));

//		autoCompleteUsers.setSuggestions(getSimpleSuggestions());
	}

//	private MaterialSuggestionOracle getSimpleSuggestions() {
//		return suggestions;
//	}

}
