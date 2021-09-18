import dto.SprintDto;
import dto.TaskDetailDto;
import dto.TaskDto;
import entities.Sprint;
import entities.Task;
import service.impl.SprintService;
import service.impl.TaskService;
import util.TaskStatus;

import java.util.List;
import java.util.Map;

public class DriverClass {
    public static void main(String[] args)
    {
        SprintService sprintService = SprintService.getInstance();
        SprintDto sprint1 = sprintService.newSprint(1L,"sprint 1");
        //SprintDto sprint2 = sprintService.newSprint(2L,"sprint 2");

        Sprint sp = sprintService.createSprint(sprint1);
        Sprint sp1 = sprintService.get(1L);

        System.out.println("===test==="+sp1.getId());

        TaskService taskService = TaskService.getInstance();
        TaskDto taskdto = taskService.newTask(1L,"test task","iam testing jira task",1L,2L,"IN_PROGRESS","BUG",2L,3L);

        Task task = taskService.createTask(taskdto,sprintService.get(taskdto.getSprintId()));
        Task taskUpdated = taskService.updateTask(taskdto);
        Boolean b = taskService.disableTask(taskdto);
        TaskDetailDto taskDetailDto = taskService.getTaskDetail(1L);


        Map<TaskStatus, List<Task>> dashboard =  taskService.getDashboard(1L);


        //List<Task> tt = taskService.getDelayTask(1L);

        List<Task>  ttt = taskService.getAssignTask(1L);
        //List<Task>  tttt =  taskService.getDisableTask(1L);
    }


    }








