package org.echo.javafxui;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class JNAClasspathLoader {
    public static String loadLibraryFromClasspath(String libraryName) {
        try {
            // Load the library from the classpath
            InputStream inputStream = JNAClasspathLoader.class.getResourceAsStream("/native/" + libraryName);
            if (inputStream == null) {
                System.err.println("Native library not found in classpath: /native/" + libraryName);
                throw new RuntimeException("Native library not found in classpath: /native/" + libraryName);
            } else {
                System.out.println("Native library found in classpath: /native/" + libraryName);
            }

            // Create a temporary file to hold the library
            File tempFile = File.createTempFile("lib", ".so");
            tempFile.deleteOnExit();

            // Copy the library to the temporary file
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Print the path of the temporary file
            System.out.println("Temporary file path: " + tempFile.getAbsolutePath());

            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native library", e);
        }
    }
    /*
    public static void main(String[] args) {
        // Load the library from the classpath and get the full path
        String libraryPath = loadLibraryFromClasspath("libbackend.so");

        // Call the greet function using the full path
        BackendLibrary backendLibrary = Native.load(libraryPath, BackendLibrary.class);
        backendLibrary.greet();
    }
     */
}

interface BackendLibrary extends Library {
    void greet();
}