# tantrum

A little bit of Fory (formerly Fury) for various libGDX-related libraries.

This lets [Fory](https://fory.apache.org) (currently 0.11.2) de/serialize objects from [libGDX](https://libgdx.com)
and several other libraries in its "tangential ecosystem." These other libraries are
[RegExodus](https://github.com/tommyettinger/RegExodus), [digital](https://github.com/tommyettinger/digital),
and [jdkgdxds](https://github.com/tommyettinger/jdkgdxds); none of these three directly depend on libGDX, but all have been
designed to be compatible with it.

This repo is modeled after [kryo-more](https://github.com/tommyettinger/kryo-more). There is a kryo-more sub-library
for an older version of [simple-graphs](https://github.com/earlygrey/simple-graphs) and the current version of
[gand](https://github.com/tommyettinger/gand), but gand mostly replaces what simple-graphs does while enabling
serialization, and gand also doesn't need any external code to be able to use Fory.
Similarly, there is a kryo-more sub-library for [cringe](https://github.com/tommyettinger/cringe) and for
[juniper](https://github.com/tommyettinger/juniper), but they aren't
needed here because any types in cringe or juniper can be read and written without
needing a Serializer.

## How to get

Each sub-library has its own version, linked to the version of the library it de/serializes.
The last component of the version is usually .0, but can be increased for bug-fixes to the same linked library version,
or if Fory itself had a (compatible) update available but the linked library did not have an update.

  - tantrum-libgdx is at version 1.13.1.12, compatible with libGDX 1.13.1
  - tantrum-digital is at version 0.8.2.12, compatible with digital 0.8.2
  - tantrum-jdkgdxds is at version 1.11.0.12, compatible with jdkgdxds 1.11.0
  - tantrum-regexodus is at version 0.1.19.12, compatible with RegExodus 0.1.19

There's also the older tantrum-juniper, which is at version 0.6.0.0, and is compatible with juniper 0.6.0.
It isn't needed if you use any more-recent versions of juniper, such as 0.6.1 or higher (current is at least 0.6.2),
since juniper uses the no-dependency-needed `Externalizable` interface that Fory can understand.

In version 1.12.1.1, tantrum-libgdx expanded to cover substantially more libGDX classes, from `Color` to
`OrientedBoundingBox`. If a class you need isn't covered, you can first read the sources here to see if writing a
serializer yourself is feasible, and of not, you can post an issue here requesting any classes that aren't present.
Some classes may not be possible to serialize reasonably, such as ones that use `private` or package-private
modifiers excessively without providing getters.

The current version of libGDX at the time of writing is 1.13.5, and version 1.13.5 works with Fury (not Fory) 0.10.2 via
tantrum-libgdx 1.13.5.8 . Version 1.13.1 of libGDX is currently preferred due to bugs in 1.13.5, so the latest version
of tantrum-libgdx is 1.13.1.10, which uses libGDX 1.13.1. If you need to use 1.13.0, which you probably won't ever need
to consider, you should use tantrum-libgdx 1.12.1.6 instead. There are no tantrum-libgdx releases tied to libGDX 1.13.0
because that release wasn't really the quality you'd want to ship anything with.

All of these sub-libraries depend on Java 8, and will work with higher versions as well. Fory is not compatible with
GWT, so no GWT info is provided here.

Gradle dependency info:

tantrum-libgdx:

```gradle
implementation "com.github.tommyettinger:tantrum-libgdx:1.13.1.12"
```

tantrum-digital:

```gradle
implementation "com.github.tommyettinger:tantrum-digital:0.8.2.12"
```

tantrum-jdkgdxds:

```gradle
implementation "com.github.tommyettinger:tantrum-jdkgdxds:1.11.0.12"
```

tantrum-regexodus:

```gradle
implementation "com.github.tommyettinger:tantrum-regexodus:0.1.19.12"
```

Most likely, you won't need this, and should use juniper 0.6.1 or newer instead:

tantrum-juniper:

```gradle
implementation "com.github.tommyettinger:tantrum-juniper:0.6.0.0"
```

Maven dependency info:

tantrum-libgdx:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-libgdx</artifactId>
  <version>1.13.1.12</version>
</dependency>
```

tantrum-digital:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-digital</artifactId>
  <version>0.8.2.12</version>
</dependency>
```

tantrum-jdkgdxds:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-jdkgdxds</artifactId>
  <version>1.11.0.12</version>
</dependency>
```

tantrum-regexodus:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-regexodus</artifactId>
  <version>0.1.19.12</version>
</dependency>
```

Most likely, you won't need this, and should use juniper 0.6.2 instead:

tantrum-juniper:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-juniper</artifactId>
  <version>0.6.0.0</version>
</dependency>
```

### GWT

GWT is not supported because Fory doesn't support it. You can use libGDX Json on GWT;
all the libraries here (except libGDX itself) are supported by [jdkgdxds-interop](https://github.com/tommyettinger/jdkgdxds_interop) with Json.

Like how they support Fory without needing externally-defined Serializers, you can just use cringe
and gand with libGDX Json natively, since they have classes that implement `Json.Serializable`.
You do need jdkgdxds-interop to serialize juniper classes to JSON, though.

## License

Apache 2.0, [see the LICENSE file](LICENSE).