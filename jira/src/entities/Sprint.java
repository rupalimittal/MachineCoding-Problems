package entities;

import dto.SprintDto;

public class Sprint {

	private Long id;

	private String name;

	private Long createdAt;

	private Long createdBy;

	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static Sprint tranformForCreate(SprintDto task, Long ct, Long userId) {
		Sprint s = new Sprint();
		s.setActive(true);
		s.setCreatedAt(ct);
		s.setCreatedBy(userId);
		s.setName(task.getName());
		s.setId(task.getId());
		return s;
	}

}