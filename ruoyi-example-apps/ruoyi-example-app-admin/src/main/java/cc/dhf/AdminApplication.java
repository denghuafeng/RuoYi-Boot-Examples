package cc.dhf;

import org.dromara.boot.context.RuoYiApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * Admin启动程序
 */
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.addInitializers(new RuoYiApplicationContextInitializer());
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Admin启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
