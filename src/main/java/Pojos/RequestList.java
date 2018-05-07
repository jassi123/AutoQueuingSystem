package Pojos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RequestList {

	private List<Request> requestsList = new ArrayList<Request>();

	public List<Request> getRequestsList() {
		return requestsList;
	}

	public void addRequest(Request request) {
		requestsList.add(request);
	}

}
