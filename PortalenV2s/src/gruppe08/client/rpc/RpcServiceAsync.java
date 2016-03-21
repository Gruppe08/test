package gruppe08.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import gruppe08.shared.Person;

public interface RpcServiceAsync {
	void test(AsyncCallback<String> asyncCallback);
	void authorizeUser(String username, String password, AsyncCallback<Person> asyncCallback) throws IllegalArgumentException;
}
