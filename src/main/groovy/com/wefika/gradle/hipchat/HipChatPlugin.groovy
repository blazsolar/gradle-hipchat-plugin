package com.wefika.gradle.hipchat
import com.wefika.gradle.hipchat.dsl.HipChatPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
/**
 * Created by blazsolar on 07/04/14.
 */
class HipChatPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.create("hipchat", HipChatPluginExtension, project);

    }
}
