package dto;
import util.Util;

public class SprintDto {

	private Long id;
	private String name;

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

	public void validateForCreate() {
		validateName();

	}

	public SprintDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	private void validateName() {
		Util.validateString("Name", "Sprint Name can't be null/empty");

	}
}
