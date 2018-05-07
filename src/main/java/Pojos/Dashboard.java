package Pojos;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

	private List<Request> waitingRequestsList = new ArrayList<Request>();
	private List<Request> ongoingRequestsList = new ArrayList<Request>();
	private List<Request> completedRequestsList = new ArrayList<Request>();

	public List<Request> getWaitingRequestsList() {
		return waitingRequestsList;
	}

	public List<Request> getOngoingRequestsList() {
		return ongoingRequestsList;
	}

	public List<Request> getCompletedRequestsList() {
		return completedRequestsList;
	}

	public void addWaitingRequest(Request request) {
		waitingRequestsList.add(request);
	}

	public void addOngoingRequest(Request request) {
		ongoingRequestsList.add(request);
	}

	public void addCompletedRequest(Request request) {
		completedRequestsList.add(request);
	}

}
