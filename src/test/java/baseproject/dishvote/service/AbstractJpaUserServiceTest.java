package baseproject.dishvote.service;

import baseproject.dishvote.model.Role;
import baseproject.dishvote.model.User;
import baseproject.dishvote.repository.JpaUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;

abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest {

    @Autowired
    private JpaUtil jpaUtil;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        jpaUtil.clear2ndLevelHibernateCache();
    }

    @Test
    public void testValidation() throws Exception {
        validateRootCause(() -> service.create(new User(null, "  ", "  ","mail@yandex.ru", "password", Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "User","  ", "password", Role.ROLE_USER)), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new User(null, "User", "User","mail@yandex.ru", "  ", Role.ROLE_USER)), ConstraintViolationException.class);
        //       validateRootCause(() -> service.create(new User(null, "User", "User","mail@yandex.ru", "password", Collections.emptySet()), ConstraintViolationException.class);
        //       validateRootCause(() -> service.create(new User(null, "User", "User","mail@yandex.ru", "password", Collections.emptySet())), ConstraintViolationException.class);
    }
}