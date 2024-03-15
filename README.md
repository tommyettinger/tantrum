# tantrum

A little bit of Fury for various libGDX-related libraries.

This lets [Fury](https://fury.apache.org) 0.4.x (currently 0.4.1) de/serialize objects from several libraries that, by
sheer coincidence, were all written by @tommyettinger (me). These are, or will be,
[RegExodus](https://github.com/tommyettinger/RegExodus), [digital](https://github.com/tommyettinger/digital),
[jdkgdxds](https://github.com/tommyettinger/jdkgdxds), [juniper](https://github.com/tommyettinger/juniper),
and [cringe](https://github.com/tommyettinger/cringe). Currently, digital, juniper, jdkgdxds, and RegExodus work; cringe is being implemented.

This repo is modeled after [kryo-more](https://github.com/tommyettinger/kryo-more). There is a kryo-more sub-library
for an older version of simple-graphs and the current version of gand, but gand mostly replaces what simple-graphs
does while enabling serialization, and gand also doesn't need any external code to be able to use Fury.

## How to get

Each sub-library has its own version, linked to the version of the library it de/serializes.
The last component of the version is usually .0, but can be increased for bug-fixes to the same linked library version,
or if Fury itself had a (compatible) update available but the linked library did not have an update.

  - tantrum-digital is at version 0.4.7.0, compatible with digital 0.4.7
  - tantrum-juniper is at version 0.5.0.0, compatible with juniper 0.5.0
  - tantrum-jdkgdxds is at version 1.4.8.0, compatible with jdkgdxds 1.4.8
  - tantrum-regexodus is at version 0.1.15.0, compatible with jdkgdxds 0.1.15

All of these sub-libraries depend on Java 8, and will work with higher versions as well.

Gradle dependency info:

tantrum-digital:

```gradle
implementation "com.github.tommyettinger:tantrum-digital:0.4.7.0"
```

tantrum-juniper:

```gradle
implementation "com.github.tommyettinger:tantrum-juniper:0.5.0.0"
```

tantrum-jdkgdxds:

```gradle
implementation "com.github.tommyettinger:tantrum-jdkgdxds:1.4.8.0"
```

tantrum-regexodus:

```gradle
implementation "com.github.tommyettinger:tantrum-regexodus:0.1.15.0"
```

**The following dependency will not work yet.** The library was only created a very short while ago!

tantrum-cringe:

```gradle
implementation "com.github.tommyettinger:tantrum-cringe:0.1.0.0-SNAPSHOT"
```

Maven dependency info:

tantrum-digital:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-digital</artifactId>
  <version>0.4.7.0</version>
</dependency>
```

tantrum-juniper:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-juniper</artifactId>
  <version>0.5.0.0</version>
</dependency>
```

tantrum-jdkgdxds:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-jdkgdxds</artifactId>
  <version>1.4.8.0</version>
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

**The following dependency will not work yet.** The library was only created a very short while ago!

tantrum-cringe:

```xml
<dependency>
  <groupId>com.github.tommyettinger</groupId>
  <artifactId>tantrum-cringe</artifactId>
  <version>0.1.0.0-SNAPSHOT</version>
</dependency>
```

### GWT

GWT is not supported because Fury doesn't support it. You can use libGDX Json on GWT; except for cringe,
all the libraries here are supported by [jdkgdxds-interop](https://github.com/tommyettinger/jdkgdxds_interop) with Json. You can just use cringe
with libGDX Json natively, since it has classes that implement `Json.Serializable`.

## License

Apache 2.0, [see the LICENSE file](LICENSE).