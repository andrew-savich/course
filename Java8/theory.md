<details><summary>Interface. Defaults and static methods</summary>
    <p><b>Интерфейс</b> - это абстрактный тип, используемый для описания поведения, которое должны реализовать классы</p>
    <ol>
        <li><b>Функциональный</b> - имеет один метод для реализации</li>
        <li><b>Маркер</b> - не имеет методов для реализации</li>
    </ol>
    <p><b>Default methods</b> - это методы по умолчанию, помечаются ключевым словом <b>default</b><br>
        Предназначены для наделения классов поведением по умолчанию.
    </p>
    <p><b>Методы по умолчанию решают проблему:</b> Если бы не было методов по умолчанию, при добавлении дополнительной 
        реализации интерфейсу (добавление нового метода), то пришлось бы изменять все классы, которые уже до этого 
        реализовывали этот интерфейс.
    </p>
    <ul>Особенности методов по умолчанию:
        <li>Их можно не переопределять, кроме случая, когда класс реализует два или более интерфейса, 
            в которых определены дефолтные методы с одинаковой сигнатурой или класс расширяет класс и 
            имплиментирует один и более интерфейсов, которые (класс и интерфейс(ы)) имеют методы с одинаковой сигнатурой
        </li>
    </ul>
    <h4>Статические методы в интерфейсах</h4>
    <ul>Статические методы интерфейса
        <li>помечаются ключевым словом static</li>
        <li>привязываются к этому интерфейсу</li>
        <li>нельзя переопределить</li>
        <li>неявно <b>public</b>, который можно опустить, тк избыточная информация</li>
    </ul>
    <p><b>Поля интерфейса:</b> неявно public static final</p>
</details>

<details><summary>Functional paradigm in Java</summary>
    <p><b>функциональное программирование</b> - это программирование, в котором функции являются объектами, и их можно 
            присваивать переменным, передавать в качестве аргументов другим функциям, возвращать в качестве результата 
            от функций и т.п.
    </p>
</details>
<details><summary>Лямбда-выражения</summary>
    <p><b>Лямбда-выражения</b>является анонимным (т.е. безымянным) методом. Но этот метод не выполняется самостоятельно,
        а служит для реализации метода, определяемого в функциональном интерфейсе. Таким образом, лямбдавыражение 
        приводит к некоторой форме анонимного класса. Нередко лямбда-выражения называют также замыканиями.
    </p>
    <p><b>Лямбда-выражения</b> - упрощённая запись анонимного класса, реализующего функциональный интерфейс. Можно даже сказать, 
            что лямбда-выражение является реализацией абстрактного метода этого функционального интерфейса<br>
        <b>Функциональный интерфейс в Java</b> — интерфейс, в котором объявлен только один абстрактный метод. Default 
            методов может быть сколь угодно. Этот интерфейс можно пометить анотацией <b>@FunctionalInterface</b>
    </p>
    <ul>Особенности лямбда:
        <li>Лямбда выражение состоит из аргументов и тела функции (реализации) разделенных <b>-></b></li>
        <li>Аргументы указываются в круглых скобках через запятую</li>
        <li>Если аргумент один, скобки можно опустить></li>
        <li>Типы аргументов можно не указывать. Если указываем тип аргумента, в таком случаи, указываем для всех аргументов</li>
        <li>Возвращаемый тип и возможные выбрасываемые исключения JVM берёт из интерфейса</li>
        <li>если тело состоит только из одной строки, то фигурные скобки, точку с запятой (;) и директиву return можно тоже опустить</li>
    </ul>
    <ol>Типы:
        <li>Однострочные</li>
        <li>Блочные (многострочные)</li>
    </ol>
</details>
<details><summary>Ссылки на методы</summary>
    <p><b>Ссылки на методы (Method References)</b> – это компактные лямбда выражения</p>
    <p>System.out::println эквивалентно x -> System.out.println(x)</p>
    <ul>Варианты ссылок на методы:
        <li>object::instanceMethod</li>
        <li>Class::staticMethod</li>
        <li>Class::instanceMethod: String::compareToIgnoreCase эквивалентно (x, y) -> x.compareToIgnoreCase(y)</li>
        <li>Class::instanceMethod: String::compareToIgnoreCase эквивалентно (x, y) -> x.compareToIgnoreCase(y)</li>
    </ul>
</details>

<details><summary>Когда использовать функциональные интерфейсы, лямбда, и ссылки на методы</summary>
    <p>Лямбда-выражения используются для создания анонимных методов. Однако иногда лямбда-выражение не делает ничего, кроме вызова существующего метода. 
        В таких случаях часто проще обратиться к существующему методу по имени. Ссылки на методы позволяют это сделать; это компактные, 
        легко читаемые лямбда-выражения для методов, у которых уже есть имя.
    </p>
    <ul>Когда использовать лямбда
        <li>Когда нужно инкапсулировать одну единицу поведения, которую нужно передать другому коду</li>
        <li>Когда нужен простой экземпляр функционального интерфейса (например, вам не нужен конструктор, именованный тип, поля или дополнительные методы)
        </li>
    </ul>
</details>

<details><summary>Optional</summary>
    <a href="https://habr.com/ru/post/658457/">Java 8: гид по классу Optional</a><br>
    <p><b>Optional</b> - это класс-оболочка, который содержит ссылку на какой-то другой объект</p>
    <p>Предназначен для предоставления решений для обеспечения удобства обработки возможных null-значений</p>
    <ul>Методы:
        <li><b>Optional.empty()</b> - создает пустой Optional</li>
        <li><b>Optional.of(obj)</b> - создает Optional, с объектом obj, obj е должен быть null</li>
        <li><b>Optional.ofNullable(obj)</b> - создает Optional, с объектом obj, obj может быть null</li>
        <li><b>isPresent()</b> - проверяет есть ли что-то внутрию. Возвращает true, если оборачиваемое значение не null</li>
        <li><b>ifPresent(() -> {})</b> - Выполняет действия, если объект не null</li>
        <li><b>orElse()</b> - возвращает или само значение из Optional или переданный аргумент</li>
        <li><b>orElseThrow()</b> - вместо предоставления дефолтного метода выбрасывает исключение</li>
        <li><b>get()</b> - получить значение из Optional</li>
        <li><b>filter()</b> - принимает предикат в качестве аргумента и возвращает объект Optional. Если значение проходит условие, заданное предикатом</li>
        <li><b>map()</b> - берет существующее значение, выполняет вычисления и возвращает их результат, обернутый в объект Optional</li>
    </ul>
</details>

<details><summary>Stream API</summary>
    <p><b>Stream API</b> - новый инструмент языка Java, который позволяет использовать функциональный стиль при работе с 
        разными структурами данных. Который преобразует источник данных (коллекция, массив) в последовательность объектов
    </p>
    <p>Предназначен для упрощения работы с наборами данных, в частности, упростить операции фильтрации, сортировки и 
        другие манипуляции с данными
    </p>
    <ul>Особенности:
        <li>Методы Stream API не изменяют исходные коллекции, уменьшая количество побочных эффектов</li>
        <li>Там, где раньше пришлось бы проходить циклом, стримы значительно сокращают количество кода</li>
        <li>Cложные операции по обработке данных благодаря Stream API выглядят лаконично и понятно. В общем, писать становится удобнее, а читать — проще.</li>
    </ul>
    <ul>Способы создания:
        <li><b>Stream.empty()</b> - пустой стрим</li>
        <li><b>list.stream()</b> - Стрим из List</li>
        <li><b>map.entrySet().stream()</b> - Стрим из Map</li>
        <li><b>Arrays.stream(array)</b> - Стрим из массива</li>
        <li><b>Stream.of("1", "2", "3")</b> - Стрим из указанных элементов</li>
        <li><b>IntStream.of(1, 2, 3),DoubleStream.of(1.1, 2.3)</b> - из прмитивов</li>
    </ul>
    <ul>Виды операций Stream API
        <li><b>Промежуточные (“intermediate”, ещё называют “lazy”)</b> - обрабатывают поступающие элементы и возвращают 
            стрим. Промежуточных операторов в цепочке обработки элементов может быть много.<br>
            Все промежуточные операции возвращают типизированный интерфейс Streamlt;gt;
        </li>
        <li><b>Терминальные (“terminal”, ещё называют “eager”)</b> - обрабатывают элементы и завершают работу стрима, 
            так что терминальный оператор в цепочке может быть только один<br>
            инициируют всю цепочку преобразований, закрывают поток и возвращают модифицированные данные. Закрытый поток повторно использовать нельзя.
        </li>
    </ul>
    <ul>особенности
        <li>Обработка не начнётся до тех пор, пока не будет вызван терминальный оператор. list.stream().filter(s -> s > 5) 
            (не возьмёт ни единого элемента из списка);
        </li>
        <li>Экземпляр, стрима нельзя использовать более одного раза</li>
    </ul>
    <ul><a href="https://devmark.ru/article/stream-api-intermediate-opers" > промежуточные операции</a>
        <li><b>filter(Predicate predicate)</b> - фильтрует стрим, пропуская только те элементы, что проходят по условию
            (Predicate встроенный функциональный интерфейс, добавленный в Java SE 8 в пакет java.util.function. 
            Проверяет значение на “true” и “false”);
        </li>
        <li><b>map(Function mapper)</b> - даёт возможность создать функию с помощью которой мы будем изменять каждый элемент
            и пропускать его дальше (Функциональный интерфейс Function&lt;T,R&gt; представляет функцию перехода от объекта 
            типа T к объекту типа R)
        </li>
        <li><b>flatMap(Function&lt;T, Stream&lt;R&gt;&gt; mapper)</b> - Разворачивание многомерных структур.<br>
            Предположим, у вас есть многомерная структура (двумерный массив элементов типа Integer) и вы хотите его<br>
            развернуть (сделать «плоским»), просто помещая каждый подмассив в конец результирующего:<br>
            Integer[][] array2d = new Integer[][]{{1, 2}, {3, 4}};<br>
            Stream&lt;Integer&gt; stream = Arrays.stream(array2d).flatMap(Arrays::stream); // [1, 2, 3, 4]
        </li>
        <li><b>peek()</b> - Если требуется получить доступ к элементу, никак его при этом не меняя. Например, в целях 
            логирования мы хотим вывести значение элемента в консоль<br>
            Stream.of(1, 2, 3, 4, 5, 6).peek(System.out::println)
        </li>
        <li><b>distinct()</b> - Если в стриме несколько элементов имеют одинаковые значения, а вы хотите получить только уникальные</li>
        <li><b>sorted()</b> - По умолчанию он использует «натуральный порядок», т.е. сортировку по возрастанию<br>
            Перегруженная версия этого метода принимает интерфейс Comparator, поэтому вы можете задать свои собственные правила сортировки или воспользоваться готовыми:<br>
            Stream.of(2, 1, 3, 5, 4, 6).sorted(Comparator.naturalOrder()))<br>
            Stream.of(2, 1, 3, 5, 4, 6).sorted(Comparator.reverseOrder())
        </li>
        <li><b>limit()</b> - Для получения первых N элементов. В данном случае мы берём первые 3 элемента:<br>
                Stream.of(1, 2, 3, 4, 5, 6).limit(3) // [1, 2, 3]
        </li>
        <li><b>skip()</b> - Чтобы пропустить нужное количество первых элементов</li>
    </ul>
    <ul><a href="https://devmark.ru/article/stream-api-terminal-opers" >Терминальные операции:</a>
        <li><b>collect()</b> - Преобразование в коллекцию<br>
            List&lt;String&gt; fruits = Stream.of("apple", "banana", "lemon", "orange").collect(Collectors.toList());<br>
            Map&lt;String, String&gt; fruits = Stream.of("apple", "banana", "lemon", "orange").collect(Collectors.toMap(e -> e.substring(0, 1), e -> e));
        </li>
        <li><b>forEach()</b> - Итерация по элементам. Обход элементов стрима. Его смысл полностью аналогичен языковой конструкции for<br>
            Stream.of(5, 3, 2, 10, 8).forEach(System.out::println);
        </li>
        <li><b>count()</b> - Подсчёт количества элементов. Аналог метода size() в коллекциях и поля length в массивах. Возвращает long<br>
            long count = Stream.of("apple", "banana", "lemon", "orange").count(); // 4
        </li>
        <li><b>min(), max()</b> - Минимальное и максимальное значения. В качестве параметра они принимают класс Comparator.</li>
        <li><b>findFirst()</b> - Поиск первого подходящего элемента</li>
        <li><b>allMatch()</b> - Чтобы проверить все элементы стрима на соответствие некоторому условию<br>
            boolean isAllPositive = Stream.of(1, 2, 3, 4, 5).allMatch(e -&gt; e &gt; 0); // true
        </li>
        <li><b>noneMatch()</b> - проверить, что ни один элемент не удовлетворяет условию</li>
        <li><b>anyMatch()</b> - проверить наличие хотя бы одного элемента, удовлетворяющего условию</li>
    </ul>
</details>

<details><summary>New Date/Time API</summary>
    <p>Новый же Java 8 Date/Time API содержит неизменные, потокобезопасные классы с продуманным дизайном на любой вкус и цвет. 
        Содержатся они в пакете java.time
    </p>
    <p>старый Java API для работы с датами был не потокобезопасный, вместо того чтобы думать о датах и времени, 
        разработчикам приходилось думать о том, как уберечь себя от ошибок в многопоточной среде. Код классов java.util.Date 
        и SimpleDateFormatter несовершенен (к примеру месяцы начинались с 1, а дни - с 0), что делало сложным их поддержку
    </p>
    <ul>классы в java.time
        <li><b>LocalDate</b> - дата без времени и временных зон</li>
        <li><b>LocalTime</b> - время без даты и временных зон</li>
        <li><b>LocalDateTime</b> - дата и время без временных зон</li>
        <li><b>ZonedDateTime</b> - дата и время с временной зоной</li>
        <li><b>DateTimeFormatter</b> - форматирует даты в строки и наоборот, только для классов java.time</li>
        <li><b>Instant</b> - колличество секунд с Unix epoch time (полночь 1 января 1970 UTC)</li>
        <li><b>Duration</b> - продолжительность в секундах и наносекундах</li>
        <li><b>Period</b> - период времени в годах, месяцах и днях</li>
        <li><b>TemporalAdjuster</b> - корректировщик дат (к примеру, может получить дату следующего понедельника)</li>
    </ul>
    <ul>Методы:
        <li>получить текущую дату и/или время:<br>
            LocalDate.now(); // 2018-01-20<br>
            LocalTime.now(); // 08:07:35.113028<br>
            LocalDateTime.now();// 2018-01-20T08:07:35.113120
        </li>
        <li>задать нужную дату:<br>
            LocalDate.of(2020, Month.SEPTEMBER, 23); // 2020-09-23<br>
            LocalDate.of(2021, 1, 1); // 2021-01-01<br>
            LocalDate.ofYearDay(2020, 361); // 2020-12-26<br>
        </li>
        <li>задать нужное время ( of(), ofSecondsOfDay(), ofNanoOfDay()):<br>
            LocalTime.of(12, 10); // 12:10<br>
            LocalTime.of(18, 15, 10); // 18:15:10<br>
            LocalTime.of(23, 59, 59, 700); // 23:59:59.000000700<br>
            LocalTime.ofSecondOfDay(9_124); // 02:32:04<br>
            LocalTime.ofNanoOfDay(100_000_000_000L); // 00:01:40
        </li>
        <li>задать нужную дату и время:<br>
            LocalDateTime.of(1992, Month.AUGUST, 24, 12, 0); // 1992-08-24T12:00<br>
            LocalDateTime.of(2004, Month.AUGUST, 23, 17, 15, 2); // 2004-08-23T17:15:02<br>
            LocalDateTime.of(2008, Month.JANUARY, 6, 20, 45, 2, 2); // 2008-01-06T20:45:02.000000002<br>
            LocalDateTime.of(2009, 1, 13, 9, 7); // 2009-01-13T09:07<br>
            LocalDateTime.of(2012, 4, 4, 6, 16); // 2012-04-04T06:16<br>
            LocalDateTime.of(2018, 10, 14, 4, 20); // 2018-10-14T04:20<br>
            LocalDateTime.of(LocalDate.now(), LocalTime.now()); // 2018-01-20T09:19:48.603054
        </li>
        <li>Добавление в LocalDate (методы plus(), plusDays(),  plusWeeks(), plusMonths()):<br>
            LocalDate now = LocalDate.now(); // 2018-01-21<br>
            LocalDate plus2Days = now.plusDays(2); // 2018-01-23<br>
            LocalDate plusWeek = now.plusWeeks(1); // 2018-01-28<br>
            LocalDate plus3Months = now.plusMonths(3); // 2018-04-21<br>
            LocalDate plusPeriod = now.plus(Period.ofDays(3)); // 2018-01-24<br>
            LocalDate plusMillennia = now.plus(1, ChronoUnit.MILLENNIA); // 3018-01-21<br>
            При добавлении к LocalDate всегда создается новый экземпляр класса т.к. все классы в новом API являются неизменяемыми.
        </li>
        <li>Отнимание в LocalDate (методы plus(), plusDays(),  plusWeeks(), plusMonths()):<br>
            LocalDate now = LocalDate.now(); // 2018-01-21<br>
            LocalDate minusDays = now.minusDays(3); // 2018-01-18<br>
            LocalDate minusWeeks = now.minusWeeks(2); // 2018-01-07<br>
            LocalDate minusMonths = now.minusMonths(4); // 2017-09-21<br>
            LocalDate minusPeriod = now.minus(Period.ofDays(1)); // 2018-01-20<br>
            LocalDate minusEras = now.minus(1, ChronoUnit.CENTURIES); // 1918-01-21
        </li>
        <li>Добавление в LocalTime:<br>
            LocalTime now = LocalTime.now(); // 08:49:39.678703<br>
            LocalTime plusNanos = now.plusNanos(100_000); // 08:49:39.678803<br>
            LocalTime plusSeconds = now.plusSeconds(20); // 08:49:59.678703
            LocalTime plusMinutes = now.plusMinutes(20); // 09:09:39.678703<br>
            LocalTime plusHours = now.plusHours(6); // 14:51:58.601216<br>
            LocalTime plusMillis = now.plus(Duration.ofMillis(100)); // 08:49:39.778703<br>
            LocalTime plusHalfDay = now.plus(1, ChronoUnit.HALF_DAYS); // 20:49:39.678703
        </li>
        <li>Отнимание в LocalTime:<br>
            LocalTime now = LocalTime.now(); // 08:57:19.743004<br>
            LocalTime minusNanos = now.minusNanos(100_000); // 08:57:19.742904<br>
            LocalTime minusSeconds = now.minusSeconds(20); // 08:56:59.743004<br>
            LocalTime minusMinutes = now.minusMinutes(20); // 08:37:19.743004<br>
            LocalTime minusHours = now.minusHours(6); // 02:57:19.743004<br>
            LocalTime minusMillis = now.minus(Duration.ofMillis(100)); // 08:57:19.643004<br>
            LocalTime minusHalfDay = now.minus(1, ChronoUnit.HALF_DAYS); // 20:57:19.743004
        </li>
        <li>Сравнение дат (isAfter() а так же isBefore()):<br>
            LocalDate now = LocalDate.now();<br>
            LocalDate _2017 = LocalDate.of(2017, 9, 23);<br>
            boolean after = now.isAfter(_2017);// true<br>
            boolean before = now.isBefore(_2017);// false<br>
        </li>
        <li>Сравнение времени:<br>
            LocalTime now = LocalTime.now();<br>
            LocalTime _2HoursAfter = now.plusHours(2);<br>
            boolean after = now.isAfter(_2HoursAfter); // false<br>
            boolean before = now.isBefore(_2HoursAfter); // true<br>
        </li>
    </ul>
    <h4>Форматирование</h4>
    <p> LocalDate:<br>
        LocalDate now = LocalDate.now();<br>
        String basicIsoDate = now.format(DateTimeFormatter.BASIC_ISO_DATE); // 20180128<br>
        String isoDate = now.format(DateTimeFormatter.ISO_DATE); // 2018-01-28<br>
        String isoWeekDate = now.format(DateTimeFormatter.ISO_WEEK_DATE); // 2018-W04-7<br>
        String isoLocalDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2018-01-28<br>
        String isoOrdinalDate = now.format(DateTimeFormatter.ISO_ORDINAL_DATE); // 2018-028<br>
        Если же нужного нам формата нет, всегда можно задать свой:<br><br>
        LocalDate now = LocalDate.now();<br>
        String native = now.format(DateTimeFormatter.ofPattern("dd MMM yyyy")); // 28 Jan 2018<br>
        String french = now.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRANCE)); // 28 jan. 2018<br><br>
        LocalTime:<br>
        LocalTime now = LocalTime.now();<br>
        String isoLocalTime = now.format(DateTimeFormatter.ISO_LOCAL_TIME); // 08:09:31.514569<br>
        String isoTime = now.format(DateTimeFormatter.ISO_TIME); // 08:09:31.514569<br>
        LocalTime now = LocalTime.now();<br>
        String nativeFormat = now.format(DateTimeFormatter.ofPattern("hh:mm:ss ")); // 08:10:43<br>
        String engFormat = now.format(DateTimeFormatter.ofPattern("h:mm a")); // 08:10 AM<br><br>
        LocalDateTime:<br>
        LocalDateTime now = LocalDateTime.now();
        String rfcFormat = now.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss")); // Sun, 28 Jan 2018 08:24:31
        String basicIsoDate = now.format(DateTimeFormatter.BASIC_ISO_DATE); // 20180128
        String isoDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME); // 2018-01-28T08:24:31.412511
        String isoLocalDateTime = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME); // 2018-01-28T08:24:31.412511
        String isoLocalDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2018-01-28
    </p>
    <h4>ZonedDateTime</h4>
    <p>ZonedDateTime содержит внутри себя LocalDateTime и ZoneId>br>
        ZonedDateTime now = ZonedDateTime.now(); // 2018-02-10T08:49:50.886682+01:00[Europe/Warsaw]<br>
        LocalDate localDate = LocalDate.of(2018, 1, 1);<br>
        LocalTime localTime = LocalTime.of(10, 30);<br>
        ZoneId zone = ZoneId.of("Europe/Kiev");<br>
        ZonedDateTime kievTime = ZonedDateTime.of(localDate, localTime, zone); // 2018-01-01T10:30+02:00[Europe/Kiev]<br><br>
        Конвертация ZonedDateTime между зонами:<br>
        Конвертация между временными зонами происходит с помощью метода withZoneSameInstant()<br>
        LocalDate localDate = LocalDate.of(2018, 1, 1);<br>
        LocalTime localTime = LocalTime.of(10, 30);<br>
        ZoneId zone = ZoneId.of("Europe/Kiev");<br><br>
        ZonedDateTime kievTime = ZonedDateTime.of(localDate, localTime, zone); // 2018-01-01T10:30+02:00[Europe/Kiev]<br>
        ZonedDateTime nyTime = kievTime.withZoneSameInstant(ZoneId.of("America/New_York")); // 2018-01-01T03:30-05:00[America/New_York]<br>
        ZonedDateTime japanTime = kievTime.withZoneSameInstant(ZoneOffset.of("-09:00")); // 2017-12-31T23:30-09:00<br><br>
        получить все временные зоны:<br>
        List&lt;String&gt; zones = new ArrayList&lt;&gt;(ZoneId.getAvailableZoneIds());
        zones.forEach(System.out::println);
    </p>
</details>