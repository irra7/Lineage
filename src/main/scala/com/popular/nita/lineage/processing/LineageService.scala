package com.popular.nita.lineage.processing

import java.io.FileInputStream
import java.io.FileOutputStream
import com.google.gson.Gson
import java.io.IOException
import java.util.Date

object LineageService {

  /*example of how to introduce a lineage   
val lineage1 = new Lineage(Array(inputFile1,inputFile2),outputFile,"delta",(outputFile.fileName.hashCode()),date)*/
  
  case class FileDescriptor(fileName: String, path: String, ip: String)
  case class Lineage(originFiles: Array[FileDescriptor], destinationFile: FileDescriptor, process: String, fileId: Int, date: Date) {
    //-----------------metodo1
    def writelineage(l: Lineage) {
      var in = None: Option[FileInputStream]
      var out = None: Option[FileOutputStream]
      //varios ficheros de origen
      val filedest = l.destinationFile.fileName
      try {

        //the second argument allows to append chars into the file
        //out = Some(new FileOutputStream(path donde guardar los ficheros .log +destinationFile.fileName+".log", true))
        out = Some(new FileOutputStream(s"C:/Users/i.a.gonzalez.salas/testing/$filedest.log", true))

        //writes the json lineage to the new logfile.(only applicated if destination file distinc to origin file name)

        l.originFiles.foreach { o => if (o.fileName != filedest) saveLineageForFile(out, o.fileName) }
        for (i <- 0 until l.originFiles.length) {
          if (l.originFiles(i).fileName == filedest) {
            //out = Some(new FileOutputStream(path donde guardar los ficheros .log +destinationFile.fileName+".log", true))
            out = Some(new FileOutputStream(s"C:/Users/i.a.gonzalez.salas/testing/$filedest.log", true))
            val linj = new Gson
            out.get.write(" \r\n".getBytes)
            linj.toJson(l).foreach(out.get.write(_))
            out.get.write(" \r\n".getBytes)
            if (out.isDefined) out.get.close
          }
        }

      } catch {
        case e: IOException => e.printStackTrace
      } finally {
        if (in.isDefined) in.get.close
        if (l.originFiles(0).fileName != filedest) {
          if (out.isDefined) out.get.close
        }
      }
    }
    //-----------------metodo2
    def saveLineageForFile(out: Option[FileOutputStream], fileName: String) {
      //val in = Some(new FileOutputStream(path donde estan los ficheros .log +fileName+".log", true))
      val in = Some(new FileInputStream(s"C:/Users/i.a.gonzalez.salas/testing/$fileName.log"))
      var c = 0
      while ({ c = in.get.read; c != -1 }) {
        out.get.write(c)
      }
      out.get.write(" \r\n".getBytes)
      if (in.isDefined) in.get.close
    }
    //-----------------endofme
  }

}
    
  