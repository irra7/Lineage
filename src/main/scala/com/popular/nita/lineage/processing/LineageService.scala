package com.popular.nita.lineage.processing

import java.io.FileInputStream
import java.io.FileOutputStream
import com.google.gson.Gson
import java.io.IOException
import java.util.Date

object LineageService {

  //metodo borrado de los ficheros
  //probar en un entorno de prueba
  def delete(file: File) {
  if (file.isDirectory) 
    Option(file.listFiles).map(_.toList).getOrElse(Nil).foreach(delete(_))
  file.delete
}
  
  def writelineage(l: Lineage) {
      var in = None: Option[FileInputStream]
      var out = None: Option[FileOutputStream]
      val filedest = l.destinationFile.fileName
      try {

        //the second argument allows to append chars into the file
        out = Some(new FileOutputStream(s"C:/Users/i.a.gonzalez.salas/testing/$filedest.log", true))

        //writes the json lineage to the new logfile.(only applicated if destination file distinc to origin file name)

        l.originFiles.foreach { o => if (o.fileName != filedest) saveLineageForFile(out, o.fileName) }
        for (i <- 0 until l.originFiles.length) {
          if (l.originFiles(i).fileName == filedest) {
            out = Some(new FileOutputStream(s"C:/Users/i.a.gonzalez.salas/testing/$filedest.log", true))
            val linj = new Gson
            out.get.write(" \r\n".getBytes)
            linj.toJson(l).foreach(out.get.write(_))
            if (out.isDefined) out.get.close
            val filetemp = New File(s"C:/Users/i.a.gonzalez.salas/testing/$l.originFiles(i)fileName.log")
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
    private def saveLineageForFile(out: Option[FileOutputStream], fileName: String) {
      val in = Some(new FileInputStream(s"C:/Users/i.a.gonzalez.salas/testing/$fileName.log"))
      out.get.write(" \r\n".getBytes)
      var c = 0
      while ({ c = in.get.read; c != -1 }) {
        out.get.write(c)
      }
      if (in.isDefined) in.get.close

    }
    
  case class FileDescriptor(fileName: String, path: String, ip: String)
  case class Lineage(originFiles: Array[FileDescriptor], destinationFile: FileDescriptor, process: String, fileId: Int, date:Date = new Date())
}