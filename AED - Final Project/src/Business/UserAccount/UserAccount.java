/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.Employee.User;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Mugdha
 */
public class UserAccount {
  
    private String username;
    private String password;
    private Employee employee;
    private User user;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }   
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

     public Employee getEmployee() {
        return employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }    

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public int getNumberOfResolvedIssues(){
        int count = 0;
        for(WorkRequest req :workQueue.getWorkRequestList()){
            if(req.getStatus().equalsIgnoreCase("Resolved")){
                count++;
            }
        }
        return count;
    }
    
     public int getNumberOfUnResolvedIssues(){
        int count = 0;
        int total = workQueue.getWorkRequestList().size();
        for(WorkRequest req :workQueue.getWorkRequestList()){
            if(req.getStatus().equalsIgnoreCase("Resolved")){
                count++;
            }
        }
        return (total-count);
    }
     
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
}
