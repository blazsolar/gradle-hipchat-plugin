package com.wefika.gradle.hipchat.dsl

import org.gradle.api.Project

/**
 * Plugin extension file. Token should always be defined.
 *
 * Created by blazsolar on 07/04/14.
 */
class HipChatPluginExtension {

    /** HipChat token to communicate with API. */
    String token;

    /**
     * FIXME: Needed for test to run
     */
    HipChatPluginExtension(Project project) {
        token = "test_token";
    }
}
