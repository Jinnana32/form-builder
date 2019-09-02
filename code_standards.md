# WIP Coding Standards

---

###General
- Remove Logs

---

###Kotlin
- Remove `@NotNull` and `@param:NonNull` because kotlin has `?` already

---

###XML
- Use appcompat views `<AppCompatViewName .../>` for backward compatibility.
- Always try to use `ConstraintLayout` always, to avoid deep hierarchy of views, deep hierarchy will slow down the rendering of the view.
- Clean up mock strings ALWAYSSS.
- Use resources (strings.xml, dimens.xml) instead of hard-coded values. (Android Studio will also tell u)
- Use camel-case ids to easily distinguish on java/kotlin classes which are the views.
- Try to ignore unnecessary/unused warnings such as `RtlSymmetry` unless, you're going to support it.

---

###Fragment Initialization
- Presenters must be detached on `onDestroyView()` instead of `onDestroy()`

---

###Activity Initialization
- `initViews(saveBundleState?)` which is called on `onCreate()` method
- put all initialization of views such as `RecyclerView`, `OnClickListeners`, etc.
- include multi-line comments *(example: `/* init toolbar */`)* per initialization

---

###List UI
- Use `SwipeRefreshLayout` to load/refresh the list.
- Include a placeholder (icon with text) when the list is empty.

---

###Objects
- Create mapper class per object that is needed to be `parcelable`. This happens when `domain` object (which cannot be `parcelable` because it doesn't know *android*) needs to become `parcelable`. (ugh)
- Use `String` on id instead of `Int`
- Don't use mapper class when not necessarily to `parcelable`
- please use `.map()` function on kotlin when mapping array of objects.
Example:

```
yourArrayObject.map { YourObjectMapper.toNewObject(it) }
```

---

###Static Objects for API submission
- This is done to avoid tedious API call just to show for example two static data (which unlikely to update).
- Create the actual object with correct ids defined by API.

---

###Version Control (GIT)
- Interfaces starts below the class name, to avoid dirty file history.

Example:

```
class LoginActivity: AppCompatActivity(),
LoginInterface,
MvpView,
etc... {
...
}
```

---

###IDE Configurations
- Don't use all/wildcard (*) imports, instead, import them one by one.