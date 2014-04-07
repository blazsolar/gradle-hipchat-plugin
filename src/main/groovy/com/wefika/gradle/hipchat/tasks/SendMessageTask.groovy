/*
 * Copyright 2014 Blaž Šolar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wefika.gradle.hipchat.tasks

import com.github.hipchat.api.HipChat
import com.github.hipchat.api.Room
import com.github.hipchat.api.UserId
import com.github.hipchat.api.messages.Message
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
/**
 * Task that sends message to HipChat api.
 *
 * Created by blazsolar on 07/04/14.
 */
class SendMessageTask extends DefaultTask {

    /** HipChat room id to with message should be sent */
    @Input
    String roomId;

    /** Message to sent */
    @Input
    String message;

    /** Id of user by whom message will be sent */
    @Input
    String userId;

    /**
     * Name of user to be displayed in HipChat. If <code>null</code> User name will be fetched
     * from HipChat.
     */
    String userName;

    /** Weather or not to notify users in room of this message. <code>true</code> by default. */
    boolean notify = true;

    /** Color of message in HipChat. Yellow by default */
    Message.Color color = Message.Color.YELLOW

    /** Sends message to HipChat */
    @TaskAction
    public void send() {

        HipChat hipChat = new HipChat(project.hipchat.token);

        if (userName == null) {
            userName = hipChat.getUser(UserId.create(userId)).getName();
        }

        UserId user = UserId.create(userId, userName);

        Room room = Room.create(roomId, hipChat);
        if(!room.sendMessage(message, user, notify, color)) {
            new IOException("HipChat message failed");
        }

    }

}
