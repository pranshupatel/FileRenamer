# Bulk File Manager


### 1. Choose Files
![Colour Block Logo](/1.png)
### 2. View files in Preview
![Colour Block Logo](/2.png)
### 3. Choose a common file name and type into textbox.
![Colour Block Logo](/3.png)
### 4. View the new changes
![Colour Block Logo](/4.png)
### 5. Rename all files with one click!
![Colour Block Logo](/5.png)
# Bulk File Manager
A GUI application that makes it easy for users to rename files in bulk.
### Prerequisites
* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Any newer Java version will work 
* [Eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-12/R/eclipse-inst-win64.exe) - IDE 
* Install JavaFx by going on ```Help -> Eclipse Marketplace -> Search 'javafx' -> Download e(fx)clipse 3.6.0```
* [SceneBuilder](https://gluonhq.com/products/scene-builder/)
* Set location of SceneBuilder in Eclipse  
	```Window => Preferences => JavaFX => Browse Scenebuilder executable => Find wherever SceneBuilder.exe is stored and select it.```
### Using SceneBuilder
1. Open SceneBuilder (make sure the location of it was set check above).
2. Go to ```File => Open``` and open ```Main.fxml``` from FileRenamer repo
3. Add any layouts, etc and save. Eclipse will auto update Main.fxml
4. If you want buttons or any other controls to have actions, highlight them,
go in the "Properties" tab on right, and name the control id accordingly (with proper format like "btnSelect").
5. After naming them, add a method in ```MainController.java``` that will perform the action. Set the "OnAction"
   menu tab to the corresponding method in the "Code" section of button.
6. Add the control as an attribute/variable (same name as id) for MainController class 
   and make sure you put @FXML on top (see class).
### Contributing
1. On the main project page, select the Fork button on the top right of the page. This will create a copy of the project on your own account.
2. Clone it ```git clone https://github.com/pranshupatel/FileRenamer.git```
3. Create your feature branch ```git checkout -b my-feature```
4. Commit your changes ```git commit -m 'added xyz'```
5. Push your changes ```git push origin my-feature```
6. Submit pull request
## Authors
* **Pranshu Patel** - [pranshupatel](https://github.com/pranshupatel)
