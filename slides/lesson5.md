## **5. Advanced UI - part II**

---

#### **Vectors in Compose**

* `painterResource`
  * `VectorDrawable`
  * `BitmapDrawable` (rasterized imgs)

```kotlin
Icon(
  painter = painterResource(R.drawable.ic_android),
  contentDescription = null,
  tint = Color.Red
)
```

<img src="slides/images/vector_drawable.png" width=100 />

---

#### **Vectors in Compose**

* `ImageVector`
  * `Icons` by **material**
  *  Visual styles: `Filled` (`Default`), `Outlined`, `Rounded`, `TwoTone`, and `Sharp`

```kotlin
Icon(
  painter = rememberVectorPainter(image = Icons.Default.Add),
  contentDescription = null,
  tint = Color.Red
)
```

<img src="slides/images/vector_drawable2.png" width=100 />

---

#### **Vectors in Compose**

* `ImageVector`s are created with a DSL

```kotlin
public val Icons.Filled.Add: ImageVector
  get() {
    if (_add != null) {
      return _add!!
    }
    _add = materialIcon(name = "Filled.Add") {
      materialPath {
          moveTo(19.0f, 13.0f)
          horizontalLineToRelative(-6.0f)
          verticalLineToRelative(6.0f)
          horizontalLineToRelative(-2.0f)
          verticalLineToRelative(-6.0f)
          horizontalLineTo(5.0f)
          verticalLineToRelative(-2.0f)
          horizontalLineToRelative(6.0f)
          verticalLineTo(5.0f)
          horizontalLineToRelative(2.0f)
          verticalLineToRelative(6.0f)
          horizontalLineToRelative(6.0f)
          verticalLineToRelative(2.0f)
          close()
      }
    }
    return _add!!
}
```

---

#### **Vectors in Compose**

```kotlin
// Load the animated vector drawable
val image = AnimatedImageVector.
      animatedVectorResource(R.drawable.animated_vector)

val atEnd by remember { mutableStateOf(false) }
Icon(
    // paint it
    painter = rememberAnimatedVectorPainter(image, atEnd),
    contentDescription = null // decorative element
)
```

<img src="slides/images/animatedvectordrawable.gif" width=200 />

---

#### **Theming** 🎨

---

#### **Material Design** 🎨

* A **design system**
* Theming and components

```groovy
dependencies {
    implementation "androidx.compose.material:material:$version"
}
```

---

#### **Material Design** 🎨

* Applying material to a subtree

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val speakersRepository = FakeSpeakerRepository()
            MaterialTheme {
              // Any composables here
              LazySpeakersScreen(speakers)
            }
        }
    }
}
```

---

#### **Material** 🎨

* Material components built on top of it
* `TextField`, `TopAppBar`, `Card`, `Button`, `Scaffold`, `FloatingActionButton`...

---

```kotlin
MaterialTheme { // colors, typographies, shapes provided 👇
  Scaffold(
    topBar = { TopAppBar(title = { Text("My app") }) },
    content = { contentPadding ->
      Column(Modifier.padding(contentPadding)) {
        TextField(
          value = "",
          label = { Text("Insert some text") },
          onValueChange = {})
        Button(onClick = { /*TODO*/ }) {
          Text("Click me!")
        }
      }
    }
  )
}
```

---

<img src="slides/images/material2.png" width=300 />

---

#### **`MaterialTheme`**

Exposes colors, typography & shapes to the subtree

```kotlin
MaterialTheme(
    colors = …,
    typography = …,
    shapes = …
) {
    // app content (can read from those)
}
```

---

Custom themes. Making our app material

---

Writing our first animation

---

Advanced animations

---

Drag and swipe gestures

---

resources
