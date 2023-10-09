package study.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) //질문 필요, exclude를 주지 않았을시 login페이지가 default페이지가 되는 원인
public class MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

}
