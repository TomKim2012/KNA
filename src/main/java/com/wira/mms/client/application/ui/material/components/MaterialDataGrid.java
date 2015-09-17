package com.wira.mms.client.application.ui.material.components;

import gwt.material.design.client.custom.MaterialButtonCell;
import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.custom.MaterialImageCell;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialToast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
import com.wira.mms.client.utils.DateUtils;

public class MaterialDataGrid extends Composite {

	private static MaterialDataGridUiBinder uiBinder = GWT
			.create(MaterialDataGridUiBinder.class);

	interface MaterialDataGridUiBinder extends
			UiBinder<Widget, MaterialDataGrid> {
	}

	private List<Task> orders = new ArrayList<Task>();

	private DataGrid<Task> dataGrid;
	private ListDataProvider<Task> TaskProvider;
	private ListHandler<Task> sortDataHandler;
	private final ProvidesKey<Task> KEY_PROVIDER = new ProvidesKey<Task>() {

		@Override
		public Object getKey(Task item) {
			return item.getId();
		}
	};

	private final SelectionModel<Task> selectionModel = new MultiSelectionModel<Task>(
			KEY_PROVIDER);

	private Task Task;

	@UiField
	SimplePanel gridPanel, pagerPanel;

	public MaterialDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		setGrid();
	}

	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		refreshData();
	}

	private void refreshData() {
		TaskProvider.setList(new ArrayList<Task>());
		getAllTask();
	}

	private DataGrid<Task> createDatagrid() {

		this.sortDataHandler = new ListHandler<Task>(new ArrayList<Task>());
		// CHECKBOX
		Column<Task, Boolean> checkColumn = new Column<Task, Boolean>(
				new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(Task object) {
				boolean value = selectionModel.isSelected(object);

				return value;
			}
		};

		FieldUpdater<Task, Boolean> checkColumnFU = new FieldUpdater<Task, Boolean>() {

			@Override
			public void update(int index, Task object, Boolean value) {
				selectionModel.setSelected(object, value);
			}
		};
		checkColumn.setFieldUpdater(checkColumnFU);

		// IMAGE
		Column<Task, MaterialImage> imageProfile = new Column<Task, MaterialImage>(
				new MaterialImageCell()) {
			@Override
			public MaterialImage getValue(Task object) {

				MaterialImage img = new MaterialImage();
				img.setUrl(object.getUserPicUrl());
				img.setWidth("40px");
				img.setHeight("40px");
				// SET IMAGE TO CIRCLE
				img.setType("circle");
				return img;
			}

		};

		// USER
		TextColumn<Task> colUser = new TextColumn<Task>() {
			@Override
			public String getValue(Task object) {

				return object.getUser();
			}
		};
		colUser.setSortable(true);
		sortDataHandler.setComparator(colUser, new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {

				return o1.getUser().compareTo(o2.getUser());
			}
		});

		// ITEM NAME
		TextColumn<Task> colName = new TextColumn<Task>() {
			@Override
			public String getValue(Task object) {

				return object.getTaskName();
			}
		};
		colName.setSortable(true);
		sortDataHandler.setComparator(colName, new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {

				return o1.getTaskName().compareTo(o2.getTaskName());
			}
		});

		// PRICE
		TextColumn<Task> dateAssigned = new TextColumn<Task>() {
			@Override
			public String getValue(Task object) {

				return "1 hr ago";
			}
		};

		// ACTION BUTTON
		Column<Task, MaterialButton> showLogBtnColumn = new Column<Task, MaterialButton>(
				new MaterialButtonCell()) {
			@Override
			public MaterialButton getValue(Task object) {

				MaterialButton mb = new MaterialButton("Show log", "blue",
						"light");
				mb.setIcon("mdi-action-polymer");
				mb.setIconPosition("left");
				mb.getElement().getStyle()
						.setProperty("display", "inline-flex");
				return mb;
			}

		};

		showLogBtnColumn
				.setFieldUpdater(new FieldUpdater<Task, MaterialButton>() {

					@Override
					public void update(int index, Task object,
							MaterialButton value) {
						MaterialToast.alert(object.getTaskName());
					}
				});

		final DataGrid<Task> dataGrid = new DataGrid<Task>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "75vh");

		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, "50px");
		dataGrid.addColumn(imageProfile, "Picture");
		dataGrid.setColumnWidth(imageProfile, "50px");
		dataGrid.addColumn(colUser, "Name");
		dataGrid.addColumn(colName, "Task Name");
		dataGrid.addColumn(dateAssigned, "Assignment Date");

		dataGrid.setStyleName("responsive-table");

		SimplePager.Resources pagerResources = GWT
				.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER,
				pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);

		TaskProvider = new ListDataProvider<Task>();
		TaskProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;

	}

	private void getAllTask() {
		orders.add(new Task(1, "Jackson Kalweo",
				"http://b.vimeocdn.com/ps/339/488/3394886_300.jpg",
				"Photography", new Date(), new Date()));
		orders.add(new Task(1, "Marti Muthige",
				"http://lorempixel.com/50/50/people?1", "Video", new Date(),
				new Date()));
		orders.add(new Task(1, "Xenia", "http://lorempixel.com/50/50/people?8",
				"Audio", new Date(), new Date()));
		orders.add(new Task(1, "Alexander Ochieng",
				"http://lorempixel.com/50/50/people?2", "Article", new Date(),
				new Date()));
		TaskProvider.setList(orders);
		sortDataHandler.setList(TaskProvider.getList());
	}

	public Task getTask() {
		return Task;
	}

	public void setTask(Task Task) {
		this.Task = Task;
	}

}