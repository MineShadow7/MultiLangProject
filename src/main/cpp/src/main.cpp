#include <jni.h>
#include <iostream>
#include "../include/Greeting.h"

extern "C" {
JNIEXPORT void JNICALL Java_org_echo_javafxui_NativeBackend_greet(JNIEnv*, jobject) {
    //std::cout << "Hello from C++ backend!" << std::endl;
    Greeting greeting;
    greeting.sayHello();
}
}