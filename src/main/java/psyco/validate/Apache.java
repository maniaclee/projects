package psyco.validate;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;


/**
 * Created by lipeng on 15/8/14.
 */
public class Apache {


    public void apacheValidate(List<String> list) {
        notNull(list, "null value");
        notEmpty(list, "empty value");
        System.out.println(list);
    }

    @Test
    public void test() {
        List<String> l = null;
        l = Lists.newLinkedList();
        l = Lists.newArrayList("fuck", "you");
        apacheValidate(l);
    }

}

