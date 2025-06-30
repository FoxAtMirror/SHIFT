<h1>Jetpack Compose (androidx.compose.\*)</h1>

Современный декларативный UI-фреймворк от Google для Android. Позволяет быстро и удобно создавать адаптивные интерфейсы, минимизируя количество шаблонного кода.<br>
Почему не XML: XML-верстка устарела, требует больше кода и сложнее поддерживается. Compose проще для реактивного UI и лучше интегрируется с Kotlin.


<h1>Material3 (androidx.compose.material3)</h1>

Для стилизации приложения по современным гайдлайнам Material Design 3.<br>
Почему не Material2: Material3 — актуальный стандарт, поддерживает новые компоненты и темы, лучше подходит для новых проектов.


<h1>Retrofit (com.squareup.retrofit2:retrofit, converter-gson)</h1>

Для удобной работы с REST API (randomuser.me). Позволяет легко описывать HTTP-запросы через интерфейсы.<br>
Почему не OkHttp напрямую: Retrofit — надстройка над OkHttp, упрощает работу с API, поддерживает автоматическую сериализацию/десериализацию.<br>
Почему не Ktor/Volley: Retrofit — стандарт де-факто для Android, лучше поддержка, больше примеров, проще интеграция с Gson.


<h1>Gson Converter (com.squareup.retrofit2:converter-gson)</h1>

Для автоматической сериализации/десериализации JSON в data-классы Kotlin.<br>
Почему не Moshi/Kotlinx.serialization: Gson — наиболее распространённый и по умолчанию интегрируется с Retrofit, меньше проблем с совместимостью.


<h1>Kotlin Coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-core, kotlinx-coroutines-android)</h1>

Для асинхронной работы с сетью и потоками без коллбеков, удобное управление жизненным циклом.<br>
Почему не RxJava/Thread: Coroutines проще, лаконичнее, лучше интегрируются с современным Android и Compose, меньше кода и ошибок.


<h1>Coil (io.coil-kt:coil-compose)</h1>

Для загрузки и отображения изображений из интернета в Compose.<br>
Почему не Glide/Picasso: Coil написан на Kotlin, оптимизирован для Compose, проще интеграция, меньше зависимостей, современный API.


<h1>Navigation Compose (androidx.navigation:navigation-compose)</h1>

Для навигации между экранами в Compose-приложении.<br>
Почему не Activity/Fragment Navigation: navigation-compose — нативное решение для Compose, не требует фрагментов, проще и безопаснее.


<h1>ViewModel + Lifecycle (androidx.lifecycle.\*)</h1>

Для хранения состояния и бизнес-логики, переживающей повороты экрана и пересоздание UI.<br>
Почему не обычные классы: ViewModel интегрируется с жизненным циклом, предотвращает утечки памяти, стандарт для архитектуры MVVM.


<h1>Room (androidx.room.\*) (если будет добавлен)</h1>

Зачем: Для локального хранения данных пользователей, чтобы они не терялись при перезапуске.<br>
Почему не SQLite напрямую/Realm/SharedPreferences: Room — официальный ORM от Google, удобный, безопасный, поддерживает миграции и интеграцию с Coroutines/Flow.


<h1>JUnit, Espresso (androidx.test.\*, junit)

Для модульного и UI-тестирования.<br>
Почему не аналоги: Это стандартные библиотеки для тестирования в Android, хорошо поддерживаются и интегрируются с Android Studio.
