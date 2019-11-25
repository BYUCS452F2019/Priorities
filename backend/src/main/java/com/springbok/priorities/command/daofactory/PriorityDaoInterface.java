package com.springbok.priorities.command.daofactory;

import java.util.List;

import com.springbok.priorities.models.PriorityModel;

public interface PriorityDaoInterface {
    public Integer create(PriorityModel priority);
    public List<PriorityModel> getPrioritiesForUserID(String userID);
    public Boolean updatePriority(PriorityModel priority);
}