# imagingbook-maven-demo-project

This is a minimal **[ImageJ](https://imagej.net/ImageJ1)** project which demonstrates how to use the **[imagingbook-common](https://github.com/imagingbook/imagingbook-public)** library and associated ImageJ plugins.
The project uses MAVEN for dependency management and is preconfigured for Eclipse.
This repository provides Java source code supplementing the **[Digital Image Processing](https://imagingbook.com)** books by **W. Burger & M. J. Burge**.

This project contains the **Java sources** for two ImageJ demo plugins:
1. a plugin for testing the `imagingbook` installation,
2. a plugin that implements the Canny edge detector on color and grayscale images.

In addition, the project imports the plugins package `plugins_tools`
as a Maven dependency (specified in `pom.xml`). 
The associated JAR file is placed in the `ImageJ/plugins` directory.



## How to use (out of the box)

* Clone this repository. The resulting project should be complete and runnable as-is (no Maven build necessary):
  * Start **ImageJ** by double-clicking `ImageJ/ImageJ.exe` (Win) or launching `ij.jar` (Mac).
  * Run `Plugins` &#10140; `Demo_Plugins` &#10140; `Check_Install`.
  * Open a grayscale or color image.
  * Run `Plugins` &#10140; `imagingbook_test` &#10140; `Canny_Edges`. 
* To change or add new functionality edit the Java files (ImageJ plugins) in `src/main/java`. 
  Under Eclipse the associated `.class` files are automatically updated and placed in the `ImageJ/plugins` directory.
* **Note** that the test plugins are inside the Java package `Demo_Plugins`, which makes them automatically appear inside
  the sub-menu `Demo Plugins` (underscores are replaced by blanks) in ImageJ's `Plugins` menu.
  If you create your own plugin files make sure that each plugin name
  **contains at least one underscore** (package names without underscores are fine)!
  You may also define ImageJ plugins in Java's `default` package (i.e., one level higher), which then show at the menu's top-level.
  Also note that ImageJ ignores plugins that are nested deeper than one package level!
  However, other Java source files (e.g., for private library classes used by plugins) may be nested at deeper levels.
  

## How to use with Maven

* For a complete rebuild (with Maven) use `mvn clean install`. Note that this will clear the `ImageJ/plugins`
  directory, since this is the configured output directory.
* If additional libraries are needed, add them to the dependencies in `pom.xml` and rebuild the project.

## Using non-Maven libraries

* If additional libraries are required that are *not* available via Maven, place
  the associated JAR files in `ImageJ/jars`. This directory is in ImageJ's library path
  but is not cleared by a Maven rebuild. 


**See also:** https://github.com/imagingbook/imagingbook-plugins-all

**Main repository:** [**imagingbook-public**](https://github.com/imagingbook/imagingbook-public)



