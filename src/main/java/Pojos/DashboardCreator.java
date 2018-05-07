package Pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardCreator {

	@Autowired
	RequestList requestList;

	public Dashboard giveRequestStatus() {
		Dashboard dashboard = new Dashboard();
		for (Request request : requestList.getRequestsList()) {
			switch (request.status) {
			case Waiting:
				dashboard.addWaitingRequest(request);
				break;
			case Ongoing:
				dashboard.addOngoingRequest(request);
				break;
			case Complete:
				dashboard.addCompletedRequest(request);
				break;
			}
		}
		return dashboard;
	}

}
