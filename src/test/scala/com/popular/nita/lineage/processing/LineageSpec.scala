package com.popular.nita.lineage.processing

import org.scalatest.FlatSpec
import java.util.Date
import org.scalatest.matchers.ShouldMatchers

class LineageSpec extends FlatSpec with ShouldMatchers {
"A UniformElement" should
"have a width equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.width should be (2)
}
it should "have a height equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.height should be (3)
}
it should "throw an IAE if passed a negative width" in {
evaluating {
elem('x', 2,
3)
} should produce [IllegalArgumentException]
}
}{
  
  behavior of "blabla"
  it should "return 2" in {
  assert (1+1 == 3)
}
/*  behavior of "Lineage writelineage"
  val date = new Date()
  val inputFile1 = new FileDescriptor("fichero1","C:/Users/i.a.gonzalez.salas/testing","192.168.1.1")
  val inputFile2 = new FileDescriptor("fichero2","C:/Users/i.a.gonzalez.salas/testing","192.168.1.2")
  val outputFile = new FileDescriptor("fichero2","C:/Users/i.a.gonzalez.salas/testing","192.168.1.3")
  val lineage = new Lineage(Array(inputFile1,inputFile2),outputFile,"delta",(outputFile.fileName.hashCode()),date)
  lineage.writelineage(lineage1)
  it should "return empty string when no arguments are given" in {
    assert(LineageService.writelineage(lineage):Unit)
  }
  it should "return given arguments when only one is given" in {
    val date = new Date()
    val lineage1 = new lineage(Array("D","A"), "E", Array("5.5.5.5","5.5.5.5"), "C:/Users/i.a.gonzalez.salas/testing", "192.168.4.2", "C:/Users/i.a.gonzalez.salas/testing/", "feo", 1234, date)
    assert(Foo.process(lineage1) == Unit)
  }
  it should "return arguments seperated by commas when more than one argument is given" in {
    assert(Foo.process(Seq("foo", "bar")) == "foo,bar")
  }*/
}
