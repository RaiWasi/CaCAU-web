package com.airbus.alten.cacau.presentation.ui.manager;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class CaCAUApplicationNavigatorManager extends Navigator {

	private static final long serialVersionUID = -5332791040464109479L;

	public CaCAUApplicationNavigatorManager(UI ui, SingleComponentContainer container) {
		super(ui, container);
	}

	private static CaCAUApplicationNavigatorManager getNavigatorManager() {

		UI ui = UI.getCurrent();
		Navigator navigatorManager = ui.getNavigator();

		return (CaCAUApplicationNavigatorManager) navigatorManager;
	}

	public static void navigate(String path) {

		try {
			CaCAUApplicationNavigatorManager.getNavigatorManager().navigateTo(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void navigateTo(String viewName) {

		if (viewName.isEmpty() || viewName == null)
			viewName = "";
		
		super.navigateTo(viewName);
	}
}
