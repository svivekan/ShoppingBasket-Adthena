name := "ShoppingBasket-Adthena"

version := "0.1"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalaTestVersion  = "2.2.5"

  Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "com.typesafe" % "config" % "1.2.1"
  )
}

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

fork in run := true
