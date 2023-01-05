package hello.core.lifecycle;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    /**
     * 의존 관계 주입이 끝날 때 호출되는 메서드이다.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    /**
     * 빈 소멸 전에 호출되는 메서드이다.
     */
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
