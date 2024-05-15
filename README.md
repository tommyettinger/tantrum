# tantrum

A little bit of Fury for various libGDX-related libraries.

This lets [Fury](https://fury.apache.org) (currently 0.5.0) de/serialize objects from [libGDX](https://libgdx.com) and several
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

  - tantrum-libgdx is at version 1.12.1.0, compatible with libGDX 1.12.1
  - tantrum-digital is at version 0.4.8.1, compatible with digital 0.4.8
  - tantrum-juniper is at version 0.6.0.0, compatible with juniper 0.6.0
    - Starting in juniper 0.6.1, it shouldn't need any `Serializer`s registered from tantrum. 
  - tantrum-jdkgdxds is at version 1.5.3.0, compatible with jdkgdxds 1.5.3
  - tantrum-regexodus is at version 0.1.15.0, compatible with RegExodus 0.1.15

All of these sub-libraries depend on Java 8, and will work with higher versions as well.

Gradle dependency info:

tantrum-libgdx:

```gradle
implementation "com.github.tommyettinger:tantrum-libgdx:1.12.1.0"
```

tantrum-digital:

```gradle
implementation "com.github.tommyettinger:tantrum-digital:0.4.8.1"
```

tantrum-jdkgdxds:

```gradle
implementation "com.github.tommyettinger:tantrum-jdkgdxds:1.5.3.0"
```

tantrum-regexodus:

```gradle
implementation "com.github.tommyettinger:tantrum-regexodus:0.1.15.0"
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
  <version>1.12.1.0</version>
</dependency>
```

tantrum-digital:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-digital</artifactId>
  <version>0.4.8.1</version>
</dependency>
```

tantrum-jdkgdxds:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-jdkgdxds</artifactId>
  <version>1.5.3.0</version>
</dependency>
```

tantrum-regexodus:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-regexodus</artifactId>
  <version>0.1.15.0</version>
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