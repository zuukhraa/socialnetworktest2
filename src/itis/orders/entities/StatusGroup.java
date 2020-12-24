package itis.orders.entities;

import java.util.Arrays;
import java.util.List;

public enum StatusGroup {

	IN_PROGRESS(Arrays.asList(Status.NEW, Status.CONFIRMED), "В процессе"), FINAL(Arrays.asList(Status.DELIVERED, Status.CANCELLED), "Финальные");
	private List<Status> statuses;

	private String title;

	private StatusGroup(List<Status> statuses, String title) {
		this.statuses = statuses;
		this.title = title;
	}
}
