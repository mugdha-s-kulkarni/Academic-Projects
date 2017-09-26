/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mugdha
 */
public class HelpDeskWorkRequest extends WorkRequest {
//   private String customerMsg;
//   private String empMsg;
   private Date reportDate;
   private Date resolveDate;
   private int reqId;
   private static int count;
   
   
   private ArrayList<String> conversation;
   private ArrayList<String> name;
  
   
   public HelpDeskWorkRequest(){
       
      conversation = new ArrayList<>();
      name = new ArrayList<>();
      count++;
      reqId = count;
       
   }

    public ArrayList<String> getName() {
        return name;
    }
   
    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public ArrayList<String> getConversation() {
        return conversation;
    }

   
   
   
}
