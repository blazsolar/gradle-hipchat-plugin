# Gradle HipChat plugin

Gradle plugin that allows you to send to send messages to HipChat.

[ ![Download](https://api.bintray.com/packages/blazsolar/maven/gradle-hipchat-plugin/images/download.png) ](https://bintray.com/blazsolar/maven/gradle-hipchat-plugin/_latestVersion)
[![Build Status](https://travis-ci.org/blazsolar/gradle-hipchat-plugin.svg?branch=develop)](https://travis-ci.org/blazsolar/gradle-hipchat-plugin)

## Usage

## Apply plugin

### Gradle 2.1 and later
    plugins {
        id "com.github.blazsolar.hipchat" version "<version>"
    }
    
### Gradle 2.0 or older
    buildscript {
        repositories {
            jcentral()
        }
        dependencies {
            classpath 'com.github.blazsolar.gradle:gradle-hipchat-plugin:<version>'
        }
    }

    apply plugin: 'hipchat'

### Configuration
    hipchat {
        token = "<HipChat token>"
    }

### Add task
    task messageTask(type: com.github.blazsolar.gradle.hipchat.tasks.SendMessageTask) {
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
