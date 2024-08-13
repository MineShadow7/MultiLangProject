#include <jni.h>
#include <iostream>
#include "../include/Greeting.h"

extern "C" {
JNIEXPORT void JNICALL greet(JNIEnv*, jobject) {
    //std::cout << "Hello from C++ backend!" << std::endl;
    Greeting greeting;
    greeting.sayHello();
}
}