package baseproject.dishvote;

import baseproject.dishvote.model.User;
import baseproject.dishvote.model.Role;

import baseproject.dishvote.web.AdminUsersRestController;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
            appCtx.load("spring/spring-app.xml", "spring/mock.xml");
            appCtx.refresh();

            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminUsersRestController adminUserController = appCtx.getBean(AdminUsersRestController.class);
            adminUserController.createWithLocationUser(new User(null, "userName", "userName","email@mail.ru", "password", Role.ROLE_ADMIN));
            System.out.println();
        }
    }
}