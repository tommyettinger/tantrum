# tantrum

A little bit of Fury for various libGDX-related libraries.

This lets [Fury](https://fury.apache.org) (currently 0.7.1) de/serialize objects from [libGDX](https://libgdx.com) and several
other libraries in its "tangential ecosystem." These other libraries are
[RegExodus](https://github.com/tommyettinger/RegExodus), [digital](https://github.com/tommyettinger/digital),
and [jdkgdxds](https://github.com/tommyettinger/jdkgdxds); none of these three directly depend on libGDX, but all have been
designed to be compatible with it.

This repo is modeled after [kryo-more](https://github.com/tommyettinger/kryo-more). There is a kryo-more sub-library
for an older version of [simple-graphs](https://github.com/earlygrey/simple-graphs) and the current version of
[gand](https://github.com/tommyettinger/gand), but gand mostly replaces what simple-graphs does while enabling
serialization, and gand also doesn't need any external code to be able to use Fury.
Similarly, there is a kryo-more sub-library for [cringe](https://github.com/tommyettinger/cringe) and for
[juniper](https://github.com/tommyettinger/juniper), but they aren't
needed here because any types in cringe or juniper can be read and written without
needing a Serializer.

## How to get

Each sub-library has its own version, linked to the version of the library it de/serializes.
The last component of the version is usually .0, but can be increased for bug-fixes to the same linked library version,
or if Fury itself had a (compatible) update available but the linked library did not have an update.

  - tantrum-libgdx is at version 1.12.1.3, compatible with libGDX 1.12.1
  - tantrum-digital is at version 0.5.1.4, compatible with digital 0.5.1
  - tantrum-jdkgdxds is at version 1.6.4.4, compatible with jdkgdxds 1.6.4
    - (Versions 1.6.2.1 and 1.6.2.2 were skipped so that all the subproject versions have the same last component
      to mean they use the same Fury version; so were 1.6.3.0 through 1.6.3.2 for the same reason.)
  - tantrum-regexodus is at version 0.1.16.4, compatible with RegExodus 0.1.16

There's also the older tantrum-juniper, which is at version 0.6.0.0, and is compatible with juniper 0.6.0.
It isn't needed if you use any more-recent versions of juniper, such as 0.6.1 or higher, since juniper uses
the no-dependency-needed `Externalizable` interface that Fury can understand.

In version 1.12.1.1, tantrum-libgdx expanded to cover substantially more libGDX classes, from `Color` to
`OrientedBoundingBox`. If a class you need isn't covered, you can first read the sources here to see if writing a
serializer yourself is feasible, and of not, you can post an issue here requesting any classes that aren't present.
Some classes may not be possible to serialize reasonably, such as ones that use `private` or package-private
modifiers excessively without providing getters.

All of these sub-libraries depend on Java 8, and will work with higher versions as well.

Gradle dependency info:

tantrum-libgdx:

```gradle
implementation "com.github.tommyettinger:tantrum-libgdx:1.12.1.3"
```

tantrum-digital:

```gradle
implementation "com.github.tommyettinger:tantrum-digital:0.5.1.4"
```

tantrum-jdkgdxds:

```gradle
implementation "com.github.tommyettinger:tantrum-jdkgdxds:1.6.4.4"
```

tantrum-regexodus:

```gradle
implementation "com.github.tommyettinger:tantrum-regexodus:0.1.16.4"
```

Most likely, you won't need this, and should use juniper 0.6.1 instead:

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
  <version>1.12.1.3</version>
</dependency>
```

tantrum-digital:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-digital</artifactId>
  <version>0.5.1.4</version>
</dependency>
```

tantrum-jdkgdxds:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-jdkgdxds</artifactId>
  <version>1.6.4.4</version>
</dependency>
```

tantrum-regexodus:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-regexodus</artifactId>
  <version>0.1.16.4</version>
</dependency>
```

Most likely, you won't need this, and should use juniper 0.6.1 instead:

tantrum-juniper:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-juniper</artifactId>
  <version>0.6.0.0</version>
</dependency>
```

### GWT

GWT is not supported because Fury doesn't support it. You can use libGDX Json on GWT;
all the libraries here (except libGDX itself) are supported by [jdkgdxds-interop](https://github.com/tommyettinger/jdkgdxds_interop) with Json.

Like how they support Fury without needing externally-defined Serializers, you can just use cringe
and gand with libGDX Json natively, since they have classes that implement `Json.Serializable`.
You do need jdkgdxds-interop to serialize juniper classes to JSON, though.

## License

Apache 2.0, [see the LICENSE file](LICENSE).