scalaVersion := "3.5.1-RC2"

scalacOptions += "-deprecation"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

libraryDependencies += guice

enablePlugins(PlayScala)

disablePlugins(PlayLayoutPlugin)
