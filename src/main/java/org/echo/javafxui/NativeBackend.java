package org.echo.javafxui;

public class NativeBackend {
    static {
        try {
            // Load the shared library from a specific path
            System.load("/home/mineshadow/IdeaProjects/MultiLangProject/src/main/cpp/build/lib/libbackend.so");
        }catch (Exception e){
            System.err.println("Failed to load libbackend.so. Check if the backend src/main/cpp is built and you are using Linux system.");
        }
    }

    public native void greet();

    public void callfunc(){
        this.greet();
    }
}
