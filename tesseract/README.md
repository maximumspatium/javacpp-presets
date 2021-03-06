JavaCPP Presets for Tesseract
=============================

Introduction
------------
This directory contains the JavaCPP Presets module for:

 * Tesseract 3.0.3-rc1  https://code.google.com/p/tesseract-ocr/

Please refer to the parent README.md file for more detailed information about the JavaCPP Presets.


Documentation
-------------
Java API documentation is available here:

 * http://bytedeco.org/javacpp-presets/tesseract/apidocs/


Sample Usage
------------
Here is a simple example of Tesseract ported to Java from this C++ source file and for this data:

 * https://code.google.com/p/tesseract-ocr/wiki/APIExample
 * https://code.google.com/p/tesseract-ocr/downloads/list

We can use [Maven 3](http://maven.apache.org/) to download and install automatically all the class files as well as the native binaries. To run this sample code, after creating the `pom.xml` and `src/main/java/BasicExample.java` source files below, simply execute on the command line:
```bash
 $ mvn package exec:java -Dexec.mainClass=BasicExample -Dexec.args="path/to/image/file"
```

### The `pom.xml` build file
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.bytedeco.javacpp-presets.tesseract</groupId>
    <artifactId>BasicExample</artifactId>
    <version>1.0</version>
    <dependencies>
        <dependency>
            <groupId>org.bytedeco.javacpp-presets</groupId>
            <artifactId>tesseract</artifactId>
            <version>3.03-rc1-1.0</version>
        </dependency>
    </dependencies>
</project>
```

### The `src/main/java/BasicExample.java` source file
```java
import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;

public class BasicExample {
    public static void main(String[] args) {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(null, "eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead(args.length > 0 ? args[0] : "/usr/src/tesseract-3.02/phototest.tif");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        System.out.println("OCR output:\n" + outText.getString());

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }
}
```
