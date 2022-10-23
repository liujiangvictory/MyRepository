package jihe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-06-19 9:27
 * @FilePath: TextDome  ==> OOMDemo
 */
public class OOMDemo {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
