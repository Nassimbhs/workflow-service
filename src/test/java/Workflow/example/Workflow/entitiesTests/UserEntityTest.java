package workflow.example.workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.GroupeUser;
import workflow.example.workflow.entity.Role;
import workflow.example.workflow.entity.Tache;
import workflow.example.workflow.entity.User;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class UserEntityTest {

    @Test
    void testUserEqualsAndHashCode() {
        User user1 = new User("username1", "email1@example.com", "password1");
        User user2 = new User("username2", "email2@example.com", "password2");

        Assertions.assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testUserTachesRelationship() {
        User user = new User();
        Tache tache1 = new Tache();
        Tache tache2 = new Tache();

        user.getTaches().add(tache1);
        user.getTaches().add(tache2);

        Assertions.assertEquals(2, user.getTaches().size());
        Assertions.assertTrue(user.getTaches().contains(tache1));
        Assertions.assertTrue(user.getTaches().contains(tache2));
    }

    @Test
    void testUserGroupsRelationship() {
        User user = new User();
        GroupeUser groupeUser1 = new GroupeUser();
        GroupeUser groupeUser2 = new GroupeUser();

        user.getGroups().add(groupeUser1);
        user.getGroups().add(groupeUser2);

        Assertions.assertEquals(2, user.getGroups().size());
        Assertions.assertTrue(user.getGroups().contains(groupeUser1));
        Assertions.assertTrue(user.getGroups().contains(groupeUser2));
    }

    @Test
    void testUserConstructor() {
        User user = new User("username", "email@example.com", "password");

        Assertions.assertEquals("username", user.getUsername());
        Assertions.assertEquals("email@example.com", user.getEmail());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    void testUserRoles() {
        User user = new User();
        Role role1 = new Role();
        Role role2 = new Role();

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);

        user.setRoles(roles);

        Assertions.assertEquals(2, user.getRoles().size());
        Assertions.assertTrue(user.getRoles().contains(role1));
        Assertions.assertTrue(user.getRoles().contains(role2));
    }

    @Test
    void testUserNotEquals() {
        User user1 = new User("username1", "email1@example.com", "password1");
        User user2 = new User("username2", "email2@example.com", "password2");

        Assertions.assertNotEquals(user1, user2);
    }

    @Test
    void testToString() {
        User user = new User("testUser", "test@example.com", "password");

        Assertions.assertNotNull(user.toString());
    }

    @Test
    void testEquals() {
        User user1 = new User("user1", "user1@example.com", "password");
        user1.setId(1L);

        User user2 = new User("user2", "user2@example.com", "password");
        user2.setId(1L);

        User user3 = new User("user3", "user3@example.com", "password");
        user3.setId(2L);

        Assertions.assertEquals(user1, user2);
        Assertions.assertNotEquals(user1, user3);
    }

}
