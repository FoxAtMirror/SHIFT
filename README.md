1. Jetpack Compose (androidx.compose.\*)
Зачем: Современный декларативный UI-фреймворк от Google для Android. Позволяет быстро и удобно создавать адаптивные интерфейсы, минимизируя количество шаблонного кода.
Почему не XML: XML-верстка устарела, требует больше кода и сложнее поддерживается. Compose проще для реактивного UI и лучше интегрируется с Kotlin.
2. Material3 (androidx.compose.material3)
Зачем: Для стилизации приложения по современным гайдлайнам Material Design 3.
Почему не Material2: Material3 — актуальный стандарт, поддерживает новые компоненты и темы, лучше подходит для новых проектов.
3. Retrofit (com.squareup.retrofit2:retrofit, converter-gson)
Зачем: Для удобной работы с REST API (randomuser.me). Позволяет легко описывать HTTP-запросы через интерфейсы.
Почему не OkHttp напрямую: Retrofit — надстройка над OkHttp, упрощает работу с API, поддерживает автоматическую сериализацию/десериализацию.
Почему не Ktor/Volley: Retrofit — стандарт де-факто для Android, лучше поддержка, больше примеров, проще интеграция с Gson.
4. Gson Converter (com.squareup.retrofit2:converter-gson)
Зачем: Для автоматической сериализации/десериализации JSON в data-классы Kotlin.
Почему не Moshi/Kotlinx.serialization: Gson — наиболее распространённый и по умолчанию интегрируется с Retrofit, меньше проблем с совместимостью.
5. Kotlin Coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-core, kotlinx-coroutines-android)
Зачем: Для асинхронной работы с сетью и потоками без коллбеков, удобное управление жизненным циклом.
Почему не RxJava/Thread: Coroutines проще, лаконичнее, лучше интегрируются с современным Android и Compose, меньше кода и ошибок.
6. Coil (io.coil-kt:coil-compose)
Зачем: Для загрузки и отображения изображений из интернета в Compose.
Почему не Glide/Picasso: Coil написан на Kotlin, оптимизирован для Compose, проще интеграция, меньше зависимостей, современный API.
7. Navigation Compose (androidx.navigation:navigation-compose)
Зачем: Для навигации между экранами в Compose-приложении.
Почему не Activity/Fragment Navigation: navigation-compose — нативное решение для Compose, не требует фрагментов, проще и безопаснее.
8. ViewModel + Lifecycle (androidx.lifecycle.\*)
Зачем: Для хранения состояния и бизнес-логики, переживающей повороты экрана и пересоздание UI.
Почему не обычные классы: ViewModel интегрируется с жизненным циклом, предотвращает утечки памяти, стандарт для архитектуры MVVM.
9. Room (androidx.room.\*) (если будет добавлен)
Зачем: Для локального хранения данных пользователей, чтобы они не терялись при перезапуске.
Почему не SQLite напрямую/Realm/SharedPreferences: Room — официальный ORM от Google, удобный, безопасный, поддерживает миграции и интеграцию с Coroutines/Flow.
10. JUnit, Espresso (androidx.test.\*, junit)
Зачем: Для модульного и UI-тестирования.
Почему не аналоги: Это стандартные библиотеки для тестирования в Android, хорошо поддерживаются и интегрируются с Android Studio.
