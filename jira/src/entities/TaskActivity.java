package entities;

import util.TaskStatus;

public class TaskActivity {

	private Long id;
	private Task task;
	private TaskStatus status;
	private String comment;
	private Long createdAt;
	private Long createdBy;
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public static TaskActivity createNewFromTask(Task t) {
		TaskActivity ta = new TaskActivity();
		ta.setActive(true);
		ta.setComment(t.getTitle());
		ta.setStatus(t.getCurrentStatus());
		ta.setCreatedAt(t.getCreatedAt());
		ta.setCreatedBy(t.getCreatedBy());
		ta.setTask(t);
		return ta;
	}

}