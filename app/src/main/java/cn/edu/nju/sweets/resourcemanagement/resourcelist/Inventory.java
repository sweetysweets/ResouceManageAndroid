package cn.edu.nju.sweets.resourcemanagement.resourcelist;
import java.io.Serializable;
import java.util.Date;

/**
 * Auto-generated: 2018-12-26 9:47:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Inventory implements Serializable {

    private String inventoryTaskName;
    private String inventoryMan;
    private Date inventoryTime;
    private String inventoryResult;
    private String inventoryComment;
    private String id;
    public void setInventoryTaskName(String inventoryTaskName) {
         this.inventoryTaskName = inventoryTaskName;
     }
     public String getInventoryTaskName() {
         return inventoryTaskName;
     }

    public void setInventoryMan(String inventoryMan) {
         this.inventoryMan = inventoryMan;
     }
     public String getInventoryMan() {
         return inventoryMan;
     }

    public void setInventoryTime(Date inventoryTime) {
         this.inventoryTime = inventoryTime;
     }
     public Date getInventoryTime() {
         return inventoryTime;
     }

    public void setInventoryResult(String inventoryResult) {
         this.inventoryResult = inventoryResult;
     }
     public String getInventoryResult() {
         return inventoryResult;
     }

    public void setInventoryComment(String inventoryComment) {
         this.inventoryComment = inventoryComment;
     }
     public String getInventoryComment() {
         return inventoryComment;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryTaskName='" + inventoryTaskName + '\'' +
                ", inventoryMan='" + inventoryMan + '\'' +
                ", inventoryTime=" + inventoryTime +
                ", inventoryResult='" + inventoryResult + '\'' +
                ", inventoryComment='" + inventoryComment + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}