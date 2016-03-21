package gruppe08.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import gruppe08.shared.Person;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface RpcService extends RemoteService {
	String test() throws IllegalArgumentException;

	Person authorizeUser(String username, String password) throws IllegalArgumentException;
}
