<details><summary>Введение</summary>
<a href="https://habr.com/ru/post/103830/">Загрузка классов в Java. Теория</a><br>
<p><b>ClassLoader Java</b> - это часть JRE, которая динамически загружает классы Java в JVM</p>
<p>Используется для поставки в JVM скомпилированного байт-кода, который, хранится в файлах с расширением .class,
    но может быть также получен из других источников, например, загружен по сети или же сгенерирован самим приложением
</p>
<p>Некоторые базовые классы из rt.jar (java.lang.* в частности) загружаются при старте приложения. Классы расширений
    ($JAVA_HOME/lib/ext), пользовательские и большинство системных классов загружаются по мере их использования
</p>
<p>Одной из особенностей Java является модель динамической загрузки классов, которая позволяет загружать исполняемый 
    код в JRE не перезагружая основное приложение
</p>
<p>Исходный код, написанный на Java, сначала компилируется в байт-код с помощью компилятора javac, входящего в состав JDK.
    Байт-код сохраняется в бинарный файл в специальный class-файл. Затем эти class-файлы динамически (при необходимости) 
    загружаются в память загрузчиком классов (ClassLoader)
</p>
<ul><b>что делает classloader:</b>
    <li>поиск и импорт бинарных данных класса</li>
    <li>проверка правильности импортируемых классов</li>
    <li>выделяет и инициализирует память для переменных класса</li>
</ul>
</details>
<details><summary>Этапы загрузки классов</summary>
    <ul>
        <li><b>Загрузка (loading)</b> -  поиск и импорт бинарных данных для типа по его имени, создание класса или 
            интерфейса из этого бинарного представления
        </li>
        <li><b>Связывание, линковка (linking)</b>
            <ul>
                <li><b>Верификация (verification)</b> - проверка корректности импортируемого типа</li>
                <li><b>Подготовка (preparation)</b> - выделение памяти для статических переменных класса и инициализация 
                    памяти значениями по умолчанию
                </li>
                <li><b>Разрешение (resolution)</b> - преобразование символьных ссылок типов в прямые ссылки</li>
            </ul>
        </li>
        <li><b>Инициализация (initialization)</b> - вызов Java-кода, который инициализирует переменные класса их правильными 
            начальными значениями
        </li>
        <li><b></b> - </li>
    </ul>
</details>
<details><summary>виды загрузчиков</summary>
    <ul>
        <li><b>Bootstrap</b> - этот classloader загружает Java core библиотеки, которые находятся в директориях: JAVA_HOME/jre/lib 
            или JAVA_HOME/jmods для Java 9 и выше.
        </li>
        <li><b>System Classloader</b> - системный загрузчик, реализованный уже на уровне JRE. Этим загрузчиком загружаются 
            классы, пути к которым указаны в переменной окружения CLASSPATH<br>
            Управлять загрузкой системных классов можно с помощью ключа -classpath или системной опцией java.class.path.
        </li>
        <li><b>Extension Classloader</b> - загрузчик расширений, загружает классы из директории $JAVA_HOME/lib/ext</li>
    </ul>
    <h4>Понятия</h4>
    <p><b>Current Classloader</b> - это загрузчик класса, код которого в данный момент исполняется. Текущий загрузчик 
        используется по умолчанию для загрузки классов в процессе исполнения
    </p>
    <p><b>Context Classloader</b> - загрузчик контекста текущего потока. Получить и установить данный загрузчик можно с 
        помощью методов Thread.getContextClassLoader()/Thread.setContextClassLoader()<br>
        Загрузчик контекста устанавливается автоматически для каждого нового потока. При этом, используется загрузчик родительского потока
    </p>
</details>
<details><summary>Как происходит загрузка классов</summary>
    <ol>Реализация по-умолчанию подразумевает следующую последовательность действий:
        <li>вызов findLoadedClass() для поиска загружаемого класса в кеше;</li>
        <li>если класса в кеше не оказалось, происходит вызов getParent().loadClass() для делегирования права загрузки родительскому загрузчику;</li>
        <li>если иерархия родительских загрузчиков не смогла загрузить класс, происходит вызов findClass() для непосредственной загрузки класса.</li>
    </ol>
</details>
<details><summary>Этапы получения работающей JVM</summary>
    <p><b>загрузка байт-кода из ресурсов и создание экземпляра класса Class:</b>
        сюда входит поиск запрошенного класса среди загруженных ранее, получение байт-кода для загрузки и проверка его 
        корректности, создание экземпляра класса Class (для работы с ним в runtime), загрузка родительских классов. 
        Если родительские классы и интерфейсы не были загружены, то и рассматриваемый класс считается не загруженным.
    </p>
    <p><b>связывание (или линковка):</b>
        <ul>этот этап разбивается еще на три стадии:
            <li><b>Verification</b> - проверка корректности полученного байт-кода</li>
            <li><b></b> - выделение оперативной памяти под статические поля и инициализация их значениями по умолчанию 
                (при этом явная инициализация, если она есть, происходит уже на этапе инициализации)
            </li>
            <li><b>Resolution</b> - разрешение символьных ссылок типов, полей и методов</li>
        </ul>
    </p>
    <p><b>инициализация полученного объекта</b></p>
    <ul>эти этапы выполняются последовательно со следующими требованиями:
        <li>Класс должен быть полностью загружен прежде, чем слинкован</li>
        <li>Класс должен быть полностью проверен и подготовлен прежде, чем проинициализирован</li>
        <li>Ошибки разрешения ссылок происходят во время выполнения программы, даже если были обнаружены на этапе линковки</li>
    </ul>
</details>
<details><summary>Пользовательский classloader</summary>
    <p>Java classloader написан на Java, следовательно, можно написать собственный загрузчик классов не вникая в тонкости JVM.
        Каждый classloader имеет родительский загрузчик, который определяется, когда создается экземпляр нового загрузчика
        классов или устанавливается системный загрузчик JVM по умолчанию
    </p>
    <ul>это дает нам возможности:
        <li>для загрузки или выгрузки классов во время выполнения (например, для динамической загрузки библиотек во время выполнения, например из ресурса HTTP)
            <ul>Это важная особенность для:</li>
                <li>реализация скриптовых языков, таких как Jython (реализация Python, предназнач. для работы на платформе Java)</li>
                <li>использование bean билдеров</li>
                <li>обеспечение определяемой пользователем расширяемости</li>
            </ul>
        <li>изменить способ загрузки байт-кода (например, можно использовать зашифрованный байт-код Java класса)</li>
        <li>изменение уже загруженного байт-кода (например, для сплетения аспектов во время загрузки при использовании аспектно-ориентированного программирования)</li>
    </ul>
</details>
<details><summary>Реализация собственного classloader</summary>
    <ul>При реализации пользовательских загрузчиков важно помнить:
        <li>любой загрузчик должен явно или неявно расширять класс java.lang.ClassLoader</li>
        <li>любой загрузчик должен поддерживать модель делегирования загрузки, образуя иерархию</li>
        <li>в классе java.lang.ClassLoader уже реализован метод непосредственной загрузки — defineClass(...), который байт-код преобразует в java.lang.Class, осуществляя его валидацию</li>
        <li>механизм рекурентного поиска также реализован в классе java.lang.ClassLoader и заботиться об это не нужно</li>
        <li>для корректной реализации загрузчика достаточно лишь переопределить метод findClass() класса java.lang.ClassLoader</li>
    </ul>
</details>
<details><summary>Принципы загрузки классов:</summary>
    <p><b>Делегирование</b><br>
        Запрос на загрузку класса передается родительскому загрузчику, и попытка загрузить класс самостоятельно выполняется, 
        только если родительский загрузчик не смог найти и загрузить класс. Такой подход позволяет загружать классы тем загрузчиком,
        который максимально близко находится к базовому. Так достигается максимальная область видимости классов. 
        Каждый загрузчик ведет учет классов, которые были загружены именно им, помещая их в свой кэш. 
        Множество этих классов и называется областью видимости.
    </p>
    <p><b>Видимость</b><br>
        Загрузчик видит только «свои» классы и классы «родителя» и понятия не имеет о классах, которые были загружены его «потомком».
    </p>
    <p><b>Уникальность</b><br>
        Класс может быть загружен только однажды. Механизм делегирования позволяет убедиться, что загрузчик,
        инициирующий загрузку класса, не перегрузит загруженный ранее в JVM класс.
    </p>
</details>