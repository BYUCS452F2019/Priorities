package com.springbok.priorities.daofactory;

import java.util.List;

import com.springbok.priorities.models.PriorityModel;

public interface PriorityDaoInterface {
    public Integer create(PriorityModel priority);
    public List<PriorityModel> getPrioritiesForUserID(Double userID);
    public Boolean updatePriority(PriorityModel priority);
}