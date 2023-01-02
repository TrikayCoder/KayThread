# TrikayDev.KayThread
## UPDATE VERSION
## 1.1.0
-Now, Thread will "real" has itseft ID)

### 1.0.2
-Fix bug (Now, kayFinish will be called after kayRun finish it'self)

## NEXT FEATURE
-Synchronize any number of threads
## Getting Started
How to
To get a Git project into your build: #Version: [![](https://jitpack.io/v/TrikayCoder/KayThread.svg)](https://jitpack.io/#TrikayCoder/KayThread)
[![](https://jitpack.io/v/TrikayCoder/TrikayDev.KayThread.svg)](https://jitpack.io/#TrikayCoder/TrikayDev.KayThread)

Step 1. Add the JitPack repository to your build file<br>

Gradle
  ```sh
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
Maven
 ```sh
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
 
Step 2. Add the dependency<br>

Gradle
```sh
dependencies {
	        implementation 'com.github.TrikayCoder:TrikayDev.KayThread:#Version'
	}
```
Maven
 ```sh
 <dependency>
	    <groupId>com.github.TrikayCoder</groupId>
	    <artifactId>TrikayDev.KayThread</artifactId>
	    <version>#Version</version>
	</dependency>
 ```

## How to use
TrikayDev.KayThread: is a Java class that allows you to create and control threads easily. It provides the following methods:

kayRun():
This method should contain the logic that you want to run in the background. It will be called automatically when you start a new thread using the start() method.

kayFinish(int id):
This method will be called when the thread with the specified ID has finished running.

kayStop():
This method will stop the current thread immediately.

kayStop(int id):
This method will stop the thread with the specified ID immediately.

start(KayThreadInterface kayThreadInterface):
This method will start a new thread and execute the kayRun() method. It returns the ID of the new thread.

## Example
```sh
TrikayDev.KayThread kayThread = new TrikayDev.KayThread();
//EACH "ID" is a Thread
int ID = kayThread.start(new KayThreadInterface() {
             @Override
             public void kayRun() {
                 // Your background logic goes here
             }

             @Override
             public void kayFinish(int i) {
		 // Your code to be executed when the thread with ID "id" finishes goes here
             }
         });
	 
int ID_01 = kayThread.start(new KayThreadInterface() {
             @Override
             public void kayRun() {
                 // Your background logic goes here
             }

             @Override
             public void kayFinish(int i) {
		 // Your code to be executed when the thread with ID "id" finishes goes here
             }
         });
	 
int ID_02 = kayThread.start(new KayThreadInterface() {
             @Override
             public void kayRun() {
                 // Your background logic goes here
             }

             @Override
             public void kayFinish(int i) {
		 // Your code to be executed when the thread with ID "id" finishes goes here
             }
         });
//Finish any Thread with it ID
kayThread.kayStop(ID);
 ```
 
