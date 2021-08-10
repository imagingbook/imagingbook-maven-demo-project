# imagingbook-maven-demo-project

This is a minimal **[ImageJ](https://imagej.net/ImageJ1)** project that demonstrates how to use the **[imagingbook-common](https://github.com/imagingbook/imagingbook-common)** library.
It contains a single ImageJ plugin that implements the Canny edge detector on color and grayscale images. 
The project uses MAVEN for dependency management and is preconfigured for Eclipse.
This repository provides Java source code supplementing the **[Digital Image Processing](https://imagingbook.com)** books by **W. Burger & M. J. Burge**.

**To use:**
* Clone this repository. 
* The resulting project should be complete and runnable as-is:
  * Start ImageJ.
  * Open a grayscale or color image.
  * Run `Plugins` -> `imagingbook_test` -> `Color_Edges_Canny`.
* To change or add new functionality edit the Java files (ImageJ plugins) in `src/main/java`. Under Eclipse the associated `.class` files are automatically placed in the `ImageJ/plugins` directory.
* For a complete rebuild (with Maven) use `mvn clean install`.



**Additional examples:** https://github.com/imagingbook/imagingbook-plugins-all



