package gruppe08.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import gruppe08.client.logik.Controller;
import gruppe08.client.rpc.RpcService;
import gruppe08.client.rpc.RpcServiceAsync;
import gruppe08.client.ui.ContentPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PortalenV2s implements EntryPoint {

	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ContentPanel content = new ContentPanel();
		RootLayoutPanel.get().add(content);
		RpcServiceAsync rpcService = GWT.create(RpcService.class);
		new Controller(content, rpcService);
	}
}