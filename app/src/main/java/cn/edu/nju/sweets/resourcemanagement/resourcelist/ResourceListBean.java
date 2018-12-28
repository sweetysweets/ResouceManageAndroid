package cn.edu.nju.sweets.resourcemanagement.resourcelist;
import java.util.List;

/**
 * Auto-generated: 2018-12-26 9:47:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ResourceListBean {

    private List<Rows> rows;
    private int results;
    private boolean hasError;
    public void setRows(List<Rows> rows) {
         this.rows = rows;
     }
     public List<Rows> getRows() {
         return rows;
     }

    public void setResults(int results) {
         this.results = results;
     }
     public int getResults() {
         return results;
     }

    public void setHasError(boolean hasError) {
         this.hasError = hasError;
     }
     public boolean getHasError() {
         return hasError;
     }

    @Override
    public String toString() {
        return "ResourceListBean{" +
                "rows=" + rows.toString() +
                ", results=" + results +
                ", hasError=" + hasError +
                '}';
    }
}