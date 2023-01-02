# KayThread
## Getting Started
How to
To get a Git project into your build: #Version: 
[![](https://jitpack.io/v/TrikayCoder/KayThread.svg)](https://jitpack.io/#TrikayCoder/KayThread)

Step 1. Add the JitPack repository to your build file
  ```sh
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
Step 2. Add the dependency
```sh
dependencies {
	        implementation 'com.github.TrikayCoder:KayThread:#Version'
	}
```

## How to use
KayThread: is a Java class that allows you to create and control threads easily. It provides the following methods:

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
public class MyThread implements KayThreadInterface {
  @Override
  public void kayRun() {
    // Your background logic goes here
  }

  @Override
  public void kayFinish(int id) {
    // Your code to be executed when the thread with ID "id" finishes goes here
  }
}

KayThread thread = new KayThread();
thread.start(new MyThread());
 ```
 
