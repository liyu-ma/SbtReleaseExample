import sbtrelease.Version
import sbtrelease.ReleasePlugin.autoImport.ReleaseKeys._
import sbtrelease.ReleaseStateTransformations._

name := "SbtReleaseExample"

version := "1.0"

scalaVersion := "2.12.1"

val releaseSettings = Seq(
  publish := { },
  releaseNextVersion in ThisBuild := { ver => Version(ver).map(_.bumpBugfix.string).getOrElse("Error") },
  releaseProcess in ThisBuild := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest
    //  setReleaseVersion,
    //  commitReleaseVersion,
    //  tagRelease,
    //  publishArtifacts,                       // : ReleaseStep, checks whether `publishTo` is properly set up
    //  setNextVersion
    //  commitNextVersion,
    //  pushChanges                             // : ReleaseStep, also checks that an upstream branch is properly configured
  )
)

lazy val root = project.in(file(".")).settings(
  Seq(
    name := "SbtReleaseExample"
  )
)