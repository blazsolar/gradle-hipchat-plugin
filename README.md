# Gradle HipChat plugin

Gradle plugin that allows you to send to send messages to HipChat.

## Usage

### jHipChat
Gradle HipChat plugin is using `jHipChat`library to communicate with `HipChat` api. Since `jHipChat`
is not in maven central repository you will have to add it to your local maven repo.

    git checkout git@github.com:campnic/jHipChat.git
    cd jHipChat
    mvn -Dmaven.test.skip=true install

This will install `jHipChat` library to your local maven repository without running test. If you want
to run test before installing to maven repo just execute `mvn install` command. But you will have to
set hipchat token, room id and user id for tests to run successfully.

### Dependencies
    buildscript {
        repositories {
            mavenCentral()
        }
        dependencies {
            classpath 'com.wefika.gradle:gradle-hipchat-plugin:0.1.0'
        }
    }

### Apply plugin
    apply plugin: 'java'
    apply plugin: 'hipchat'

Java plugin has to be added so we can add `jHipChat` from local maven repo

### jHipChat dependencies
    repositories {
        mavenLocal()
    }

    dependencies {
        compile 'com.github.hipchat:jHipchat:0.0.1-SNAPSHOT'
    }

### Configuration
    hipchat {
        token = "<HipChat token>"
    }

### Import task
    import com.wefika.gradle.hipchat.tasks.SendMessageTask

### Add task
    task messageTask(type: SendMessageTask) {
        roomId = "<HipChat room id>"
        userId = "<HipChat user id>"
        message = "<Message>"
        userName = "<User name to display>"
        color = <Color of message>
    }

If `userName` is not set task will fetch actual username from HipChat API. In this case api token
has to have admin permissions.

By default color is set to yellow

## License
	Copyright 2014 Blaž Šolar

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
