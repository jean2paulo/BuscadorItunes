rootProject.name = "MusicLibrary"
include(
    ":app",
    ":core",
    ":commons",
    ":favorite",
    ":playlist",
    ":playlist:ui",
    ":playlist:domain",
    ":playlist:data",
    ":music",
    ":music:detail",
    ":search",
)
include(":search:ui")
include(":search:domain")
include(":search:data")
include(":favorite:ui")
include(":favorite:domain")
include(":favorite:data")
include(":music:data")
include(":music:domain")
include(":music:ui")
