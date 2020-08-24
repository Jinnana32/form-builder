<h1>Form builder</h1>

<h2>Description</h2>
<p>A simple dynamic form handler</p>

<h2>Dependencies</h2>
<ul>
    <li>
        <h3>UI</h3>
        <ol>
            <li>Support Library (Android X) - <a href = "https://developer.android.com/jetpack/androidx/migrate">https://developer.android.com/jetpack/androidx/migrate</a></li>
            <li>CircleImageView - <a href="https://github.com/hdodenhof/CircleImageView">https://github.com/hdodenhof/CircleImageView</a></li>
            <li>Swipe Layout - <a href="https://github.com/daimajia/AndroidSwipeLayout">https://github.com/daimajia/AndroidSwipeLayout</a></li>
            <li>Month Picker - <a href = "https://github.com/premkumarroyal/MonthAndYearPicker">https://github.com/premkumarroyal/MonthAndYearPicker</a></li>
            <li>Date Range - <a href = "https://github.com/ArchitShah248/CalendarDateRangePicker">https://github.com/ArchitShah248/CalendarDateRangePicker</a></li>
        </ol>
    </li>
    <li>
        <h3>Service</h3>
        <ol>
            <li>Firebase Core - <a href = "https://firebase.google.com/docs/android/setup">https://firebase.google.com/docs/android/setup</a></li>
            <li>Retrofit - <a href = "https://square.github.io/retrofit/">https://square.github.io/retrofit/</a></li>
            <li>RxJava - <a href ="https://github.com/ReactiveX/RxJava">https://github.com/ReactiveX/RxJava</a></li>
            <li>RxBinding - <a href = "https://github.com/JakeWharton/RxBinding">https://github.com/JakeWharton/RxBinding</a></li>
            <li>Okhttp - <a href = "https://github.com/square/okhttp">https://github.com/square/okhttp</a></li>
        </ol>
    </li>
    <li>
        <h3>Helper</h3>
        <ol>
            <li>Koin - <a href = "https://github.com/InsertKoinIO/koin">https://github.com/InsertKoinIO/koin</a></li>
            <li>Fast Adapter - <a href = "https://github.com/mikepenz/FastAdapter">https://github.com/mikepenz/FastAdapter</a></li>
        </ol>
    </li>
</ul>

<h2>Requirements</h2>
<ul>
    <li>64-bit distribution capable of running 32-bit applications</li>
    <li>3 GB RAM minimum, 8 GB RAM recommended; plus 1 GB for the Android Emulator</li>
    <li>2 GB of available disk space minimum, 4 GB Recommended (500 MB for IDE + 1.5 GB for Android SDK and emulator system image)</li>
    <li>1280 x 800 minimum screen resolution</li>
</ul>

<h2>Architectural Patterns</h2>
<ul>
    <li>
        <h3>Model-view-presenter</h3>
        <a href = "https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter">https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter</a>
        <p>Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern, and is used mostly for building user interfaces. In MVP, the presenter assumes the functionality of the "middle-man". In MVP, all presentation logic is pushed to the presenter.</p>
        <ul>
            <li>The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.</li>
            <li>The view is a passive interface that displays data (the model) and routes user commands (events) to the presenter to act upon that data.</li>
            <li>The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.</li>
        </ul>
        <img src = "https://cdn-images-1.medium.com/max/1600/1*p2JvbgEir0BusDiiVHMvIA.png" width = "500" height = "300"/>
    </li>
    <li>
        <h3>The Clean Architecture</h3>
        <a href = "https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html">https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html</a>
        <p>Clean Architecture combines a group of practices that produce systems Independent of databases, frameworks, external agencies, and libraries</p>
        <img src = "https://cdn-images-1.medium.com/max/719/1*ZNT5apOxDzGrTKUJQAIcvg.png" width = "500" height = "300"/>
    </li>
</ul>


