package entities;


import dto.TaskDto;
import util.IssueType;
import util.TaskStatus;

public class Task {
	private Long id;
	private String title;
	private String description;
	private Long dueDate;
	private Long assigneeId;
	private TaskStatus currentStatus;
	private IssueType issueType;
	private Long createdAt;
	private Long createdBy;
	private Boolean isActive;
	private Sprint sprint;

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
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

	public Long getDueDate() {
		return dueDate;
	}

	public void setDueDate(Long dueDate) {
		this.dueDate = dueDate;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public TaskStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(TaskStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
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

	public void transformForCreation(TaskDto taskdto, Long ct, Long userId, Sprint sprint) {
		this.setActive(true);
		this.setAssigneeId(taskdto.getAssigneeId());
		this.setCreatedAt(ct);
		this.setCreatedBy(userId);
		this.setCurrentStatus(TaskStatus.valueOf(taskdto.getTaskStatus()));
		this.setDescription(taskdto.getDescription());
		this.setDueDate(taskdto.getDueDate());
		this.setIssueType(IssueType.valueOf(taskdto.getIssueType()));
		//Long sprintId = taskdto.getSprintId();
		//TODO
		//SprintService sprintService = new SprintService();
		//System.out.println(taskdto.getSprintId());
		//Sprint sprint =sprintService.get(1L);
		//System.out.println(sprint.getName());
		this.setSprint(sprint);
		this.setTitle(taskdto.getTitle());
	}

	public void transformForUpdate(TaskDto taskdto, Long ct, Long userId) {
		this.setAssigneeId(taskdto.getAssigneeId());
		this.setCurrentStatus(TaskStatus.valueOf(taskdto.getTaskStatus()));
		this.setDescription(taskdto.getDescription());
		this.setDueDate(taskdto.getDueDate());
		this.setIssueType(IssueType.valueOf(taskdto.getIssueType()));
		this.setTitle(taskdto.getTitle());
	}

}