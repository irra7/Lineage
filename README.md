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

FileDescriptor: [(fileName: String, path: String, ip: String)]

| Parameter | Description | Type | Required | 
| ------------- | ------------- | ------------- | ------------- | 
| --FileName  | In this argument we keep the information of the origin files. | Array[FileDescriptor] | Required |
| --path  | In this argument we keep the information of the destination file. | FileDescriptor | Required |
| --ip  | This is the ip of the origin files. | Array[String] | Required |

Lineage: [(originFiles: Array[FileDescriptor], destinationFile: FileDescriptor, 
process: String, fileId: Int, date: Date)]

| Parameter | Description | Type | Required | 
| -------------- | ------------- | ------------- | ------------- |
| --originFiles  | In this argument we keep the information of the origin files. | Array[FileDescriptor] | Required |
| --destinationFile  | In this argument we keep the information of the destination file. | FileDescriptor | Required |
| --process  | This is process applied to the origin files. | String | Required |
| --fileId  | This is ID generated for the output file. | String | Generated |
| --date  | This is the date of the applied process to the file or files. | Date | Generated |


| Parameter | short | Description | Type | Required | 
| ------------- | ------------- | ------------- | ------------- | ------------- |
| --origin  | -o | Origin ip or name. | String | Required | 
| --source  | -s | The path where input file is. | String | Required | 
| --criteria  | -c | The criteria for the file selection. The default is name. | name or date | Optional | 
| --regex  | -r | Regular expression for input files. Only needed if name criteria is provided. | String | Required if criteria is name | 
| --compression  | -z | Specifies if the file should be compressed before sending it. Default is false | compress or uncompress | Optional | 
| --validation  | -v | Validate the file before sending it. Default is true. | validate or ignore | Optional | 
| --protocol  | -p | Origin protocol. Default is SCP. | SCP, HDFS, FILE, NFS | Optional | 
| --destination  | -d | Destination path. | String | Required | 
| --dprotocol  | -x | Destination protocol. Default is SCP. | SCP, HDFS, FILE, NFS | Optional | 
| --dvalidation  | -w | Validate the file after sending it. Default is true. | validate or ignore | Optional |
| --retries  | -a | Number of retries before giving up. Default is 3. | Positive Number | Optional |
