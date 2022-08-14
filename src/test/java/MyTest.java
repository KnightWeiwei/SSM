import com.knight.pojo.ConfirmNum;

import com.knight.service.confirmNumService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test

    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        confirmNumService confirmNumServiceImpl = (confirmNumService) context.getBean("confirmNumServiceImpl");
        for (ConfirmNum user1 : confirmNumServiceImpl.AllConfirmNum()) {
            System.out.println("ss"+user1);
        }
    }
}
