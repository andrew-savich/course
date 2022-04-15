<h2>Streams IO:</h2>
<details><summary>Что такое IO и какие типы io стримов ты знаешь? (byte and character)</summary>
    <p><b>Потоки ввода-вывода</b> - это абстракция для поставки или потребления информации. Поток ввода-вывода связан с б
        физическим устройством ввода-вывода (файл на жестком диске, интернет соединение и тд)
    </p>
    <ul>Виды потоков
        <li><b>Байтовый</b> - средства для управления вводом и выводом отдельных байтов, например, при чтении и записи двоичных данных.
            InputStream, OutputStream - абстрактные классы, определяющие абстрактные методы read() и write() для чтения и записи байт соответственно
        </li>
        <li><b>Символьный</b> - средства управления вводом и выводом отдельных символов. Reader, Writer - абстрактные классы, управляющие потокми ввода/вывода
            символов в Кодировке Юникод.
        </li>
    </ul>
</details>
<details><summary>Приведи примеры I / O стримов? (OutputStream, Writer)</summary>
    <ul>Байтовые:
        <li><b>FileInputStream</b> - читает данные из файла</li>
        <li><b>BufferedInputStream</b> - буферизованный поток ввода</li>
        <li><b>ObjectInputStream</b> - поток ввода объектов</li>
        <li><b>FileOutputStream</b> - поток вывода, записывающий данные в файл</li>
        <li><b>BufferedOutputStream</b> - буферизованный поток вывода</li>
        <li><b>PrintStream</b> - поток вывода, содержащий методы print{) и println()</li>
    </ul>
    <ul>Строковые:
        <li><b>FileReader</b> - Поток ввода, читающий символы из файла</li>
        <li><b>BufferedReader</b> - буферизованный поток ввода символов</li>
        <li><b>FilterReader</b> - Фильтрованный поток чтения</li>
        <li><b>FileWriter</b> - Поток вывода, записывающий символы в файл</li>
        <li><b>BufferedWriter</b> - Буферизированный поток вывода символов</li>
        <li><b>StringWriter</b> - Поток вывода, записывающий символы в строку</li>
    </ul>
</details>
<details><summary>Что делает поток, если его не закрыть?</summary>
    <p>Не закрытый поток использует ресурсы, которые были выделены для него</p>
</details>
<details><summary>Как правильно закрывать поток?</summary>
    <p>Для закрытия потоков используется метод close()</p>
    <p>Потоки в Java могут выбрасывать исключения, по этому работа с ними происходит в блоках try-catch</p>
    <p>Если во время работы с потоком будет выброшено исключение, мы должны в блоке finally вызывать метод close() у экземпляра потока</p>
    <p>Либо, если поток реализует интерфейс AutoCloseable, то мы можем использовать try-catch с ресурсами</p>
</details>
<details><summary>Как работают следующие элементы пакета io: InputStream, OutputStream, Reader, Writer?</summary>
    <p><b>InputStream</b> - абстрактный класс описывающий абстрактный метод read(), является суперклассом для всех классов,
        которые представляют поток чтения байт
        <ul>Методы:
            <li><b>abstract int read() throws IOException</b> - возвращает целочисленное представление следующего байта в потоке. Когда в потоке не останется доступных для чтения байтов, данный метод возвратит число -1</li>
            <li><b>int read(byte b[]) throws IOException</b> - считывает байты из потока в массив buffer. После чтения возвращает число считанных байтов. Если ни одного байта не было считано, то возвращается число -1</li>
            <li><b>int read(byte[] buffer, int offset, int length)</b> - считывает некоторое количество байтов, равное length, из потока в массив buffer. При этом считанные байты помещаются в массиве, начиная со смещения offset, то есть с элемента buffer[offset]. Метод возвращает число успешно прочитанных байтов</li>
            <li><b>void close() throws IOException</b> - закрывает поток</li>
            <li><b>int available() throws IOException</b> - возвращает количество байтов, доступных для чтения в потоке</li>
            <li><b>long skip(long n) throws IOException</b> - пропускает в потоке при чтении некоторое количество байт, которое равно number</li>
        </ul>
    </p>
    <p><b>OutputStream</b> - абстрактный класс описывающий абстрактный метод write(), является суперклассом для всех классов,
        которые представляют поток вывода байт.
        <ul>Методы:
            <li><b>abstract void write(int b) throws IOException</b> - записывает в выходной поток один байт, который представлен целочисленным параметром b</li>
            <li><b>void write(byte buffer[]) throws IOException</b> - записывает в выходной поток массив байтов buffer</li>
            <li><b>void write(byte[] buffer, int offset, int length)</b> - записывает в выходной поток некоторое число байтов, равное length, из массива buffer, начиная со смещения offset, то есть с элемента buffer[offset]</li>
            <li><b>void close() throws IOException</b> - закрывает поток</li>
            <li><b>void flush() throws IOException</b> - очищает буфер вывода, записывая все его содержимое</li>
        </ul>
    </p>
    <p><b>Reader</b> - абстрактный класс для чтения потоков символов. Его подклассы должны реализовать методы read() и close()</p>
    <p><b>Writer</b> - абстрактный класс для записи символов в поток. Его подклассы должны реализовать методы write(char[], int, int), flush() и close()</p>
</details>
<details><summary>Для чего реализованы различные потоки ввода вывода</summary>
    <p>Если мы работаем с потоками представляющие текстовую информацию, удобней использовать символьные потоки. И если работает с байтами либо с бинарной информацией, то
        надо использовать байтовые потоки
    </p>
    <p>Существуют различные реализации, так как источник или приемник информации может быть разный (файл на диске, порт сетевой карты, usb интерфейс ПК и тд)
        каждый этот источник/приемник работает по разному, для этого и нужны разные реализации
    </p>
</details>
<details><summary>try-catch область видимости переменных?</summary>
    <p>Блоки try-catch-finally создают свои отдельные области видимости. Всё что объявленно в try не будет доступно в catch или finally</p>
    <p>всё что объявленно в блоке ресурсов, будет доступно в блоке try</p>
</details>
<details><summary>Что такое RandomAccessFile?</summary>
    <a href="https://docs.oracle.com/javase/7/docs/api/java/io/RandomAccessFile.html">RandomAccessFile - docs</a><br>
    <a href="https://www.baeldung.com/java-write-to-file#write-with-randomaccessfile">RandomAccessFile - Baeldung</a>
    <p>Позволяет перемещаться по файлу, читать из него или писать в него</p>
</details>
<details><summary>Какие типы (записи/чтения) файлов бывают?</summary>
    <p>У файлов есть может быть атрибут "только для чтения". Такой файл можно открыть и просмотреть, как и любой другой файл, но запись в файл будет невозможна</p>
</details>
<details><summary>Сепораторы путей Java</summary>
    <ul>
        <li>"/" - Unix системы</li>
        <li>"\\" - Windows</li>
    </ul>
</details>
<details><summary>Что ты знаешь о классах аддонах в рамках IO?</summary>
    <p>В IO существуют классы буферизированных потоков такие как InputBufferedStream, OutputBufferedStream, BufferedReader и BufferedReader. Они обеспечивают более быструю
        работы с потоками, т.к. для буфера выделяется память, а чтение/запись из памяти гораздо быстрей, чем, например, из файла. Так же производительность достигается
        за счет возможности одновременного ввода-вывода в поток
    </p>
</details>
<h2>Сериализация:</h2>
<details><summary>Что такое сериализация? Для чего она нам? Приведи примеры сериализации?</summary>
    <p>Это процесс записи состояния объектов в поток вывода байтов с возможностью дальнейшего восстановления</p>
    <p>Сериализация нужна, для обмена данными, между машинами. Например, нам нужно передать объект по сети, мы его сериализуем в поток байт, передаем по сети,
        на другой машине принимают этот поток и десериализуют обратно в поток. Так же происходит поддержка кроссплатформенности
    </p>
    <p>Для сериализации объектов, класс этого объекта должен реализовывать интерфейс маркер <b>Serializable</b></p>
    <p>Значения полей, которые не нужно сериализовать, помечаются модификатором <b>transirnt</b></p>
</details>
<details><summary>Правила сериализации?</summary>
    <ul>transient используется для:
        <li>полей, которые несут приватную информацию (пароли)</li>
        <li>полей, которые вычисляются проограммно, в зависимости от других полей</li>
        <li>полей, которые не влияют на состояние объекта, служебная информация или информация для дебага</li>
        <li>полей, классы которых не реализуют интерфейс Serializable (логгеры, потоки ввода-вывода, объекты, которые хранят соединения с базой данных и прочие служебные классы)</li>
    </ul>
</details>
<details><summary>Что в рамках десериализации/сериализации будет являться успехом?</summary>
    <p>Когда мы получим после десериализации состояние объекта, которое было до сериализации</p>
</details>
<details><summary>Поведение базового и потомка при сериализации?</summary>
    <p>1. Если родительский класс будет реализовывать Serializable, то и потомок этого класса тоже будет сеарелизуемым</p>
    <p>2. Если класс родитель не будет серивлизуемым, а потомок буде, то для успешной десериализации, надо чтоб у класса родителя был конструктор без параметров</p>
</details>
<details><summary>Интерфейсы реализуемые при сериализации?</summary>
    <p><b>Serializable</b> - интерфейс маркер, без методов</p>
    <p><b>Externalizable</b> - интерфейс содержит два метода, которые необходимо реализовать – writeExternal(ObjectOutput) и readExternal(ObjectInput). В этих методах как раз и находится логика сериализации/десериализации</p>
</details>