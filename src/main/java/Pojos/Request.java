package Pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

	private static DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
	private static AtomicLong idCounter = new AtomicLong();

	@JsonProperty
	long requestId;
	@JsonProperty
	int customerId;
	@JsonProperty
	String timeOfRequest;
	@JsonProperty
	Status status;
	@JsonProperty
	int pickupByDriver;

	public Request(int customerId) {
		super();
		requestId = idCounter.getAndIncrement();
		this.customerId = customerId;
		timeOfRequest = new Date().toString();
		status = Status.Waiting;
		pickupByDriver = -1;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", customerId=" + customerId + ", requestCreationTime="
				+ timeOfRequest + ", status=" + status + ", pickupByDriver=" + pickupByDriver + "]";
	}

}
