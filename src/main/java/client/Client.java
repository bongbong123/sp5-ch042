package client;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
public class Client implements InitializingBean, DisposableBean {
    private String host;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Clinet.afterPropertiesSet() 실행");
    }

    public void send() {
        System.out.println("Clinet.send() to "+ host);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Clinet.destroy() 실행");
    }
}
