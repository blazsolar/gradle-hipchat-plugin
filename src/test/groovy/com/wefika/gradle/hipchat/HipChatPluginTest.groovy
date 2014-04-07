package com.wefika.gradle.hipchat

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
/**
 * Created by blazsolar on 07/04/14.
 */
class HipChatPluginTest {

    @Test
    public void testAddPlugin() {
        Project project = ProjectBuilder.builder().build();
        project.apply plugin: 'hipchat'
    }

}
