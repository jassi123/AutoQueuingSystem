package Pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestAssigner {

	@Autowired
	RequestList requestList;

	public String assign(int driverId, int requestId) {
		for (Request request : requestList.getRequestsList()) {
			if (request.requestId == requestId && request.status == Status.Waiting) {
				request.status = Status.Ongoing;
				request.pickupByDriver = driverId;

				new Thread() {
					public void run() {
						try {
							Thread.sleep(5000);// Each ride takes 5 seconds
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						request.status = Status.Complete;
					}
				}.start();

				return "Successful";
			}
		}
		return "Request already picked-up/not-found";
	}

}
