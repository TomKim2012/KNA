package com.wira.mms.client.application.newsfeed;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class NewsFeedView extends ViewImpl implements NewsFeedPresenter.MyView {
	interface Binder extends UiBinder<Widget, NewsFeedView> {
	}

//	@UiField
//	SimplePanel main;

	@Inject
	NewsFeedView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}