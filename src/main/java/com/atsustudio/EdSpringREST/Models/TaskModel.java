package com.atsustudio.EdSpringREST.Models;

import com.atsustudio.EdSpringREST.Entity.TaskEntity;
import com.atsustudio.EdSpringREST.Enums.TaskStatus;

import java.util.List;


public class TaskModel {

    private Long id;
    private String title;
    private String statusString;



    public static TaskModel toModel(TaskEntity taskEntity){
        TaskModel model = new TaskModel();

        model.set_id(taskEntity.get_id());
        model.set_title(taskEntity.get_title());
        model.set_statusString(taskEntity.get_status());

        return model;
    }

    public void set_id(Long _id) {
        this.id = _id;
    }

    public void set_title(String _title) {
        this.title = _title;
    }


    public void set_statusString(TaskStatus _status) {
        this.statusString = _status.name();
    }



    public Long get_id() {
        return id;
    }

    public String get_title() {
        return title;
    }


    public String get_statusString() {
        return statusString;
    }


    public TaskModel() {
    }
}
