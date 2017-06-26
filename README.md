## Example of simple Scala-Maven project

This project includes a simple skeleton that allows to run some sample application based on scala and build with maven.

### What should I do now?

You can just build the package

    mvn clean package

But if you prefer you can also check if code has a proper style

    mvn clean verify

Once you get the code compiled, you can go to the target dir and run the sample with 

    java -jar example-0.0.1-SNAPSHOT.jar <arguments>

For instance 

    java -jar example-0.0.1-SNAPSHOT.jar foo bar
    11:08:09.616 [main] INFO scala.App - Hello World!
    11:08:09.789 [main] INFO scala.App - Concatenated arguments = foo,bar
    
## What are the command line parameters?
 ipOrigin: String, source: String, ipDestiny: String, destiny: String, process: String, files: String, fileId: Int, date: Date
| Parameter | Description | Type | Required | 
| ------------- | ------------- | ------------- | ------------- | ------------- |
| --originFileNames  | These are the names of the origin files. | Array[String] | Required |
| --destinationFileName  | This is the name of the destination file. | String | Required |
| --sourceFilesIp  | This is the ip of the origin files. | Array[String] | Required |
| --source  | This is the path of the origin file. | String | Required |
| --ipDestiny  | This is the ip of the destination file. | String | Required |
| --destiny  |  This is the path of the destination file. | String | Required |
| --process  | This is process applied to the origin files. | String | Required |
| --fileId  | This is ID generated for the file. | String | Required |
| --date  | This is the date of the applied process to the file or files. | Date | Generated |


