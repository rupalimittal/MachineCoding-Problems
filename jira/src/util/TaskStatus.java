package util;


public enum TaskStatus {
	TO_DO, DONE, IN_PROGRESS, PENDING;

	/*public static void validate(String taskStatus) {
		boolean validEnum = EnumUtils.isValidEnum(TaskStatus.class, taskStatus);
		if (validEnum == false) {
			throw new IllegalArgumentException("Task Status not valid");
		}

	}*/

}
