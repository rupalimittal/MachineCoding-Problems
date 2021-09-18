package dto;
import util.Util;

public class TaskDto {

	private Long id;

	private String title;

	private String description;

	private Long sprintId;

	private Long dueDate;

	private String taskStatus;

	private String issueType;

	private Long createdBy;

	private Long assigneeId;

	public TaskDto(Long id, String title, String description, Long sprintId, Long dueDate, String taskStatus, String issueType, Long createdBy, Long assigneeId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.sprintId = sprintId;
		this.dueDate = dueDate;
		this.taskStatus = taskStatus;
		this.issueType = issueType;
		this.createdBy = createdBy;
		this.assigneeId = assigneeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public Long getDueDate() {
		return dueDate;
	}

	public void setDueDate(Long dueDate) {
		this.dueDate = dueDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public void validateForUpdate() {
		validateTaskId();
		validateForCreate();
	}
	
	public void validateForCreate() {
		validateTitle();
		validateSprintId();
		validateDueDate();
		validateTaskStatus();
		validateIssueType();
		validateCreatedBy();
		validateAssignned();
	}

	private void validateAssignned() {
		Util.validateLong(assigneeId, "Assignned Id can't be null/empty");

	}

	private void validateCreatedBy() {
		Util.validateLong(createdBy, "created by not valid");
	}

	private void validateIssueType() {
		//IssueType.validate(issueType);

	}

	private void validateTaskStatus() {
		//TaskStatus.validate(taskStatus);

	}

	private void validateDueDate() {

		Util.validateLong(dueDate, "Due date not valid");
	}

	private void validateSprintId() {
		Util.validateLong(sprintId, "Due date not valid");
	}

	private void validateTitle() {
		Util.validateString(title, "Tasj Title can't be null/empty");

	}

	public void validateForDisbale() {

		validateTaskId();
	}

	private void validateTaskId() {
		Util.validateLong(id, "Task Id can't be null");

	}


}
