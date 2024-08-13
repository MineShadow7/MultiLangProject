cmake_minimum_required(VERSION 3.28)
project(untitled)

set(CMAKE_CXX_STANDARD 17)

# Find JDK and include JNI headers
find_package(Java REQUIRED)
include_directories("/usr/lib/jvm/java-17-openjdk-amd64/include")
include_directories("/usr/lib/jvm/java-17-openjdk-amd64/include/linux")

add_library(backend SHARED src/main.cpp
        src/Greeting.cpp
        include/Greeting.h)

# Link against JNI
target_link_libraries(backend ${Java_LIBRARIES})

# Optionally, set the output directory for the shared library
set_target_properties(backend PROPERTIES
        LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib
)