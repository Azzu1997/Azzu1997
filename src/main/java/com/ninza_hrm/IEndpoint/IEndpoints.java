package com.ninza_hrm.IEndpoint;

public interface IEndpoints 
{
public String AddPROJ1="/addProject";
public String AddEmp="/employees";
public String Countproject="/count-projects";
public String getallprojects="/projects";
public String getprojbyproID="/getProjectByProjectId";
public String Searchproject="/project";
public String updateprojectput="/project/{projectId}";
public String delete="/project/{projectId}";
public String projectspaginated="/project/{projectId}";

}
