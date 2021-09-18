package dto;
import entities.Task;
import entities.TaskActivity;
import java.util.List;

public class TaskDetailDto {
	private Task task;
	private List<TaskActivity> taskActivity;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<TaskActivity> getTaskActivity() {
		return taskActivity;
	}

	public void setTaskActivity(List<TaskActivity> taskActivity) {
		this.taskActivity = taskActivity;
	}

	public static TaskDetailDto tranformForDetail(Task tt, List<TaskActivity> l) {
		TaskDetailDto tdd = new TaskDetailDto();
		tdd.setTask(tt);;
		tdd.setTaskActivity(l);
		return tdd;
	}
	

}
