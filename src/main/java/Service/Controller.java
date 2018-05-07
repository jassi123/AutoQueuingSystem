package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Pojos.Dashboard;
import Pojos.DashboardCreator;
import Pojos.Request;
import Pojos.RequestAssigner;
import Pojos.RequestList;

@RequestMapping("/AutoQueuingSystem")
@ResponseBody
@RestController
public class Controller {

	@Autowired
	RequestList requestList;

	@Autowired
	DashboardCreator dashboardCreator;

	@Autowired
	RequestAssigner requestAssigner;

	// http://localhost:8080/createRequest?custId=
	@RequestMapping("/createRequest")
	public String createRequest(@RequestParam(value = "custId") String custId) {
		try {
			Request request = new Request(Integer.parseInt(custId));
			requestList.addRequest(request);
			return "Successful";
		} catch (Exception e) {
			return "Invalid CustId";
		}
	}

	// http://localhost:8080/AutoQueuingSystem/dashboard
	@RequestMapping("/dashboard")
	public Dashboard dashboard() {
		return dashboardCreator.giveRequestStatus();
	}

	// http://localhost:8080/pickRequest?driverId=1&requestId=0
	@RequestMapping("/pickRequest")
	public String driverAPI(@RequestParam(value = "driverId") int driverId,
			@RequestParam(value = "requestId") int requestId) {
		return requestAssigner.assign(driverId, requestId);
	}

	// http://localhost:8080/AutoQueuingSystem/viewRequests
	@RequestMapping("/viewRequests")
	public RequestList viewRequests() {
		return requestList;
	}

}