val nexus = "http://build.26lights.net/nexus/content/repositories/"

resolvers in ThisBuild ++= Seq(
  "26Lights public releases" at nexus + "public-releases",
  "26Lights public snapshots"  at nexus + "public-snapshots"
)

publishTo in ThisBuild := {
  val isSnapshot = version.value.contains("-SNAPSHOT")
  val (name, url) = if (isSnapshot)
    ("snapshots", nexus + "public-snapshots")
  else
    ("releases", nexus + "public-releases")
  Some(name at url)
}

credentials in ThisBuild += Credentials(Path.userHome / ".ivy2" / ".credentials")

