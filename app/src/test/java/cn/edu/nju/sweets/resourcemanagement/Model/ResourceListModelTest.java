package cn.edu.nju.sweets.resourcemanagement.Model;

import org.junit.Test;

import cn.edu.nju.sweets.resourcemanagement.resourcelist.ResourceListModel;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ResourceListModelTest {
    ResourceListModel model = new ResourceListModel();
    @Test
    public void addition_isCorrect() {
        model.getList(curPage, pageSize);

    }
}