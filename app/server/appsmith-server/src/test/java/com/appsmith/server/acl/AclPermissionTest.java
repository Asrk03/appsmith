package com.appsmith.server.acl;

import com.appsmith.server.domains.ActionCollection;
import com.appsmith.server.domains.Application;
import com.appsmith.server.domains.NewAction;
import com.appsmith.server.domains.NewPage;
import com.appsmith.server.domains.Theme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class AclPermissionTest {

    @Test
    void testIsPermissionForEntity() {
        assertThat(AclPermission.isPermissionForEntity(AclPermission.READ_APPLICATIONS, Application.class))
                .isTrue();
        assertThat(AclPermission.isPermissionForEntity(AclPermission.READ_APPLICATIONS, Theme.class))
                .isFalse();

        // Assert that NewAction related Permission should return True, when checked against NewAction and Action
        // Collection.
        assertThat(AclPermission.isPermissionForEntity(AclPermission.MANAGE_ACTIONS, NewAction.class))
                .isTrue();
        assertThat(AclPermission.isPermissionForEntity(AclPermission.MANAGE_ACTIONS, ActionCollection.class))
                .isTrue();

        assertThat(AclPermission.isPermissionForEntity(AclPermission.MANAGE_PAGES, NewPage.class))
                .isTrue();
    }
}
