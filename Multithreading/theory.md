<details><summary>Что такое <b>многопоточность</b> и для чего она нам нужна</summary>
    <a href="https://habr.com/ru/post/164487/">Многопоточность в Java</a>
    <p><b>Многопоточность</b> - это процесс запуска нескольких потоков выполнения одновременно</p>
    <p>Многопоточность предназначена для эффективного и максимального использования процессорного времени</p>
</details>
<details><summary>Плюсы и минусы многопоточности</summary>
    <ol>Плюсы:
        <li>Возможность выполнения одновременно нескольких действий</li>
        <li>Ускорение/Оптимизация вычислений</li>
    </ol>
    <ol>Минусы:
        <li>Сложность реализации</li>
        <li>Из-за сложности есть возможность допущения ошибок</li>
    </ol>
</details>

<details><summary>Определение <b>процесса, потока, потока демона</b></summary>
    <a href="https://tproger.ru/problems/what-is-the-difference-between-threads-and-processes/">В чем разница между потоком и процессом?</a><br>
    <p><b>Процесс</b> - это экземпляр программы во время выполнения, является независимым объектом, которому выделены системные ресурсы (память, процессорное время)</p>
    <p>Каждый процесс выполняется в отдельном адресном пространстве: один процесс не может получить доступ к переменным и структурам данных другого.</p>
    <p>Если процесс хочет получить доступ к чужим ресурсам, необходимо использовать межпроцессное взаимодействие. Это могут быть конвейеры, файлы, каналы связи между компьютерами и тд</p>
    <br>
    <p><b>Поток</b> - это отдельное исполняемое задание внутри процесса, т.е. одна единица исполнения кода</p>
    <p>Процесс может содержать множество исполняемых потоков: при запуске процесса запускается основной потов исполнения, который может порождать другие потоки</p>
    <p>Потоки, запущенные внутри процесса, разделяют между собой память, выделенную для процесса</p>
    <br>
    <a href="https://ru.tutorialcup.com/java/daemon-thread-in-java.htm#:~:text=%D0%9F%D0%BE%D1%82%D0%BE%D0%BA%20%D0%B4%D0%B5%D0%BC%D0%BE%D0%BD%D0%B0%20%D0%B2%20Java%20%2D%20%D1%8D%D1%82%D0%BE,%D0%94.">Поток демон</a><br>
    <p><b>Поток демона в Java</b> - это поток, генерируемый системой, который работает в фоновом режиме и поддерживает процесс потока пользователя. Он имеет низкий приоритет и выполняет такие задачи, как сборка мусора, финализатор и т.д.</p>
    <p>Запускается автоматически, и не нужно вызывать его отдельно. Срок службы потока демона зависит от пользовательского потока, что означает, что когда пользовательский поток завершается, JVM автоматически завершает потоки демона и не ожидает завершения потока демона</p>
    <p>Несмотря на то, что поток демона является потоком, генерируемым системой, можно установить новый поток как демон, а также проверить, является ли поток демоном или нет</p>
    <ul>Методы:
        <li><b>public final void setDaemon(boolean on)</b> - если параметр true, то устанавливает поток как демон. Можно вызывать только до запуска потока, иначе IllegalThreadStateException</li>
        <li><b>public final boolean isDaemon()</b> - проверяет или поток демон</li>
    </ul>
</details>

<details><summary>Разница между пользовательским потоком и потоком демоном</summary>
    <table>
        <tr>
            <th>Пользовательский поток</th>
            <th>Поток демон</th>
        </tr>
        <tr>
            <td>Высокий приоритетом</td>
            <td>Низкий приоритетом</td>
        </tr>
        <tr>
            <td>Работает на "переднем плане"</td>
            <td>Работает в фоновом режиме</td>
        </tr>
        <tr>
            <td>Выполняет конкретную задачу</td>
            <td>Выполняет вспомогательную задачу</td>
        </tr>
        <tr>
            <td>JVM всегда ожидает завершения активного пользовательского потока перед завершением работы	</td>
            <td>JVM не ждет завершения потока демона перед завершением работы</td>
        </tr>
        <tr>
            <td>Создано приложением Java для выполнения некоторой задачи</td>
            <td>Создано JVM</td>
        </tr>
        <tr>
            <td>Это независимый	</td>
            <td>Это зависит от пользовательских потоков</td>
        </tr>
    </table>
</details>

<details><summary>Псевдо-параллельность</summary>
    <p>Это вид параллелизма, при котором создается видимость паралленьного исполнения задач, потоков, за счет разделения процессорного времени выполнения</p>
    <p>Происходит на однопроцессорных (одноядерных) системах, и обычно управляется ОС</p>
</details>

<details><summary>Жизненный цикл потоков</summary>
    <p>В течение жизненного цикла потоки проходят через множество различных состояний</p>
    <img src="https://russianblogs.com/images/306/4ee6e99a67666c9c8a89359b4cbf32ca.png"><br>
    <ol>В любой момент времени поток может находиться только в одном из следующих состояний:
        <li><b>NEW</b> - новый созданный не запущенный поток</li>
        <li><b>RUNNABLE</b> - выполняется или готовится к запуску ожидая выделения ресурсов</li>
        <li><b>BLOCKED</b> -поток приостановил выполнение, поскольку ожидает получения блокировки монитора</li>
        <li><b>WAITING</b> - приостановлен и ожидает, что какой-то другой поток выполнит определенное действие без ограничения по времени</li>
        <li><b>TIMED_WAITING</b> - приостановлен и ожидает определенный промежуток времени</li>
        <li><b>TERMINATED</b> - завершил выполнение</li>
    </ol>
    <h4>NEW:</h4>
    <p>При инициализации экземпляра потока, поток находится в состоянии <b>NEW</b> до тех пор пока на нем мы не вызовем метод <b>start()</b></p>
    <h4>Runnable:</h4>
    <p>После запуска метода <b>start()</b> на экземпляре потока, поток перекдючается в режим <b>RUNNABLE</b> - что поток начал выполнение, либо
        готовится к выполнению, ожидая выделения ресурсов (например ЦП)
    </p>
    <p>В многопоточной среде плонировщик потоков выделяет для каждого потока определенное время, и относительно этого запускает каждый поток,
        который находится в состоянии RUNNABLE
    </p>
    <h4>Blocked:</h4>
    <p>Поток входит в это состояние, когда ожидает блокировки монитора и пытается получить доступ к разделу кода, который заблокирован другим потоком</p>
    <h4>Waiting:</h4>
    <p>Поток находится в состоянии <b>WAITING</b>, когда он ожидает, пока какой-либо другой поток выполнит определенное действие</p>
    <ul>это состояние достигается вызовом одного из методов:
        <li><b>object.wait()</b> - вызывающий поток останавливает свое выполнение до тех пор, пока не будет вызван метод notify() или notifyAll() каким-либо другим потоком</li>
        <li><b>thread.join()</b> - поток, на экземпляре которого, вызывается этот метод, переключится в режим <b>WAITING</b>, пока поток, в котором он вызывается, не будет завершен</li>
        <li><b>LockSupport.park()</b> - </li>
    </ul>
    <h4>Timed_Waiting:</h4>
    <p>Когда поток ожидает, пока другой поток выполнит определенное действие в течение указанного времени</p>
    <ol>способЫ заставить поток войти в состояние TIMED_WAITING:
        <li><b>thread.sleep(long millis)</b></li>
        <li><b>wait(int timeout)</b> или <b>wait(int timeout, int nanos)</b></li>
        <li><b>thread.join(long millis)</b></li>
        <li><b>LockSupport.parkNanos</b></li>
        <li><b>LockSupport.parkUntil</b></li>
    </ol>
    <h4>Terminated:</h4>
    <p>Когда поток завершает работу или аварийно завершается, он переходит в состояние TERMINATED</p>
</details>
<details><summary>Можно ли стартовать Terminated поток?</summary>
    <p>Нет. Поток не может быть перезапущен после завершения выполнения</p>
</details>
<details><summary>Область видимости ресурсов потоками</summary>
    <a href="https://habr.com/ru/post/510454/">Java-модель памяти (часть 1)</a><br>
    <p>Каждый поток в Java имеет собственный стек. Стек содержит информацию о том, какие методы вызвал поток. Стек потока содержит все локальные переменные для каждого выполняемого метода. Поток может получить доступ только к своему стеку</p>
    <p>Локальные переменные, невидимы для всех других потоков, кроме потока, который их создал. Даже если два потока выполняют один и тот же код, они всё равно будут создавать локальные переменные этого кода в своих собственных стеках. Таким образом, каждый поток имеет свою версию каждой локальной переменной</p>
    <p>Все локальные переменные примитивных типов (boolean, byte, short, char, int, long, float, double) полностью хранятся в стеке потоков и не видны другим потокам. Один поток может передать копию примитивной переменной другому потоку, но не может совместно использовать примитивную локальную переменную.</p>
    <p>Локальная переменная может быть примитивного типа, в этом случае она полностью хранится в стеке потока.</p>
    <p>Локальная переменная также может быть ссылкой на объект. В этом случае ссылка (локальная переменная) хранится в стеке потоков, но сам объект хранится в куче</p>
    <p>Переменные-члены объекта хранятся в куче вместе с самим объектом. Это верно как в случае, когда переменная-член имеет примитивный тип, так и в том случае, если она является ссылкой на объект.</p>
    <p>Статические переменные класса также хранятся в куче вместе с определением класса.</p>
    <p>К объектам в куче могут обращаться все потоки, имеющие ссылку на объект. Когда поток имеет доступ к объекту, он также может получить доступ к переменным-членам этого объекта. Если два потока вызывают метод для одного и того же объекта одновременно, они оба будут иметь доступ к переменным-членам объекта, но каждый поток будет иметь свою собственную копию локальных переменных</p>
    <img src="https://habrastorage.org/webt/lq/yu/0n/lqyu0n9gj6rlphx3epgydd3ea-g.png">
</details>
<details><summary>Volatile</summary>
    <p><b>Volatile</b> - ключевое слово, означает, что значение переменной будет изменяться разными потоками</p>
    <ol>Основы:
        <li>Операции чтения/записи volatile переменной являются атомарными</li>
        <li>Результат операции записи значения в volatile переменную одним потоком, становится виден всем другим потокам, которые используют эту переменную для чтения из нее значения</li>
    </ol>
</details>
<details><summary>Способы создания потоков Java</summary>
    <a href="https://russianblogs.com/article/9415826053/">разница между Thread, Runnable и Callable</a><br>
    <ul>Есть различные способы создания потоков, например:
        <li>Расширить класс Thread, переопределить метод run(), вызвать метод start() на экземпляре класса</li>
        <li>Реализовать интерфейс Runnable, переопределить метод run(), экземпляр класса реализующего Runnable передать в качестве параметра при инициализации объекта класса Thread, и вызвать метод start()</li>
        <li>Реализуйте интерфейс Callable для реализации его метода call(), который выполняется через FutureTask</li>
    </ul>
    <p>Выбор между Thread или Runnable обусловлен отсутствием возможности множественного наследования</p>
    <p>
        Runnable доступен с Java 1.1, Callable с 1.5. Метод call() возвращает значения после выполненияб run() - нет. call() - может бросать исключения
    </p>
</details>
<details><summary>Runnable vs Callable</summary>
    <ul>
        <li>Runnable определяет метод run(), Callable: call()</li>
        <li>call() может возвращать значение, run(): void</li>
        <li>call() может бросать проверяемые исключения, run(): нет</li>
    </ul>
    <h4>использование Runnable:</h4>
    <p>Когда нам надо просто выполнить задачу</p>
    <h4>использование Callable:</h4>
    <p>Когда нам надо получить результат выполнения мы его можем вернуть в call, и так же мы можем обезопасить выполнение выбросом исключения</p>
</details>
<details><summary>Способы остановки потока</summary>
    <p>Ранее для управления выполнением потоков использовались методы suspend() и stop(). Но эти методы устарели в Java 2, поскольку они могли привести к системным сбоям</p>
    <p><b>wait()</b> - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()</p>
</details>
<details><summary>Приоритет потоков</summary>
    <p>Планировщик потоков использует приоритеты потоков исполнения, чтобы принять решение, когда разрешить исполнение каждому потоку. Теоретически высокоприоритетные потоки исполнения получают больше времени ЦП, чем низкоприоритетные. А на практике количество времени ЦП, которое получает поток исполнения, нередко зависит не только от его приоритета, но и от ряда других факторов.</p>
    <p>Чтобы установить приоритет потока исполнения, следует вызвать метод <b>setPriority()</b> из класса Thread. Его общая форма выглядит следующим образом:<br>
        final void setPriority(int уровень)
    </p>
    <p>уровень - это значение от 1 до 10. Так же можно задать константами: MIN_PRIORITY, NORM_PRIORITY, МAX_PRIORITY, которым соответствуют значения 1, 5, и 10 соответственно</p>
</details>
<details><summary>wait() vs sleep()</summary>
    <p><b>wait()</b> - это метод используемый для синхронизации потоков. Он может быть вызван для любого объекта, так как он определен прямо в java.lang.Object, но он может быть вызван только из синхронизированного блока. Он освобождает блокировку (монитор) на объекте, чтобы другой поток мог вскочить и получить блокировку (монитор).</p>
    <p><b>Thread.sleep()</b> - статический метод, который можно вызывать из любого контекста. Thread.sleep() приостанавливает текущий поток и не освобождает блокировки</p>
    <h4>Возобновление потоков после вызова методов wait и sleep</h4>
     <p>sleep(): поток запускается через заданный интервал времени, если он не прерывается</p>
     <p>wait(): Мы можем вывести поток из спящего режима, вызвав методы notify() или notifyAll() на мониторе, который находится в ожидании. Используйте notifyAll() вместо notify(), если требуется вывести из спящего режима все потоки, находящиеся в состоянии ожидания. Как и сам метод wait(), notify() и notifyAll() должны вызываться из синхронизированного контекста.</p>
</details>
<details><summary>notify() vs notifyAll()</summary>
    <p><b>notify()</b> - возобновляет исполнение потока, из которого был вызван метод wait() для того же самого объекта</p>
    <p><b>notifyAll()</b> - возобновляет исполнение всех потоков, из которых был вызван метод wait() для того же самого объекта. Одному из этих потоков предоставляется доступ</p>
    <p>Использование <b>notify()</b> экономит ресурсы т.к. будить один поток быстрее, чем будить все</p>
</details>
<details><summary>Почему wait(), notify() и notifyAll() объявлены в Object классе</summary>
    <p>Если бы эти методы были в Thread то каждый поток должен был бы знать о состоянии другого потока. А так как потоки используют какие то ресурсы, объекты, то логичней чтоб эти методы были у этих ресурсов</p>
</details>
<details><summary>wait() stop() interrupt()?</summary>
    <h4>interrupt()</h4>
    <p>Это метод, который устанавливает потоку флаг interrupt = true. Метод interrupted возвращает текущий статус и очещает (устанавливает в false)<br>
        Метод используется для "лояльной остановки потока". Если у потока есть обработка этого флага, то поток может безопасно завершиться.<br>
        Если поток находится в состоянии ожидания (вызванном вызовом методов sleep, wait, join),тогда бросится исключение InterruptedException 
    </p>
    <h4>stop()</h4>
    <p>метод stор() - останавливал поток без какой-либо дополнительной работы, что может послужить сбоям в дальнейшем. Поток занимался обработкой/изменением данных, после его остановки, данные могут быть "поломаны". Deprecated, т.к. </p>
</details>
<details><summary>join() vs yield()</summary>
    <p><b>join(): </b>метод ожидает завершения того потока исполнения, для которого он вызван. Т.е. вызывающий поток ожидает, когда указанный поток присоединится к нему</p>
    <p><b>yield(): </b>что исполняемый в данный момент поток дает шанс потокам с равным приоритетом в пуле потоков</p>
    <a href="https://javahungry.blogspot.com/2017/05/difference-between-yield-and-join.html">Difference Between Yield And Join Method In Java With Example</a>
</details>
<details><summary>Deadlocks? Как можно диагностировать дэдлоки в коде?</summary>
    <p><b>deadlock</b> - это ошибка, которая происходит когда потоки имеют циклическую зависимость от пары синхронизированных объектов</p>
    <p>Следовательно, приложение может зависнуть или завершиться сбоем, поскольку взаимоблокированные потоки не могут выполняться.</p>
    <img src="https://www.baeldung.com/wp-content/uploads/sites/4/2021/04/Deadlock-1024x807-1-768x605.png"><br><br>
    <ul>Чтобы успешно охарактеризовать сценарий как deadlock, должны одновременно выполняться следующие четыре условия
        <li>
            <p><b>Mutual Exclusion (Взаимное исключение): </b>По крайней мере один ресурс должен удерживаться потоком в неразделяемом режиме. Любой другой поток, запрашивающий этот ресурс, должен ждать</p>
        </li>
        <li><b>Hold and Wait (Держи и жди): </b>поток должен удерживать один ресурс и запрашивать дополнительные ресурсы, которые в настоящее время удерживаются другими потоками</li>
        <li><b>No Preemption (Нет вытеснения): </b>Ресурс не может быть принудительно освобожден из потока. Поток может освободить ресурс добровольно только после того, как он сочтет это возможным.</li>
        <li><b>Circular Wait (Круговое ожидание): </b>Набор потоков существует таким образом, что ожидает ресурс, удерживаемый, ожидая ресурса, удерживаемого</li>
    </ul>
</details>
<details><summary>Livelock</summary>
    <a href="https://medium.com/german-gorelkin/deadlocks-livelocks-starvation-ccd22d06f3ae">Deadlocks, Livelocks и Starvation</a><br>
    <p><b>Livelock</b> - cитуация, в которой два или более потока непрерывно изменяют свои состояния в ответ на изменения в других потоках без какой-либо полезной работы.
        Это похоже на deadlock, но разница в том, что процессы становятся “вежливыми” и позволяют другим делать свою работу</p>
    <p>Выполнение алгоритмов поиска и разрешения deadlock'ов может привести к livelock — взаимная блокировка образуется, сбрасывается, снова образуется, снова сбрасывается и так далее</p>
    <p>Жизненные примеры:</p>
    <p>Двое встречаются лицом к лицу. Каждый из них пытается посторониться, но они не расходятся, а несколько секунд сдвигаются в одну и ту же сторону</p>
    <p>Вы делаете телефонный звонок, но человек на другом конце тоже пытается вам позвонить. Вы оба повесите трубку и попробуйте снова через одно и то же время, что снова создаст такую же ситуацию. Это может продолжаться вечность</p>
    <p>Двое пытаются поужинать, но между ними только одна ложка. Каждый из них слишком вежлив, и передает ложку, если другой еще не ел</p>
</details>
<details><summary>Starvation</summary>
    <a href="https://medium.com/german-gorelkin/deadlocks-livelocks-starvation-ccd22d06f3ae">Deadlocks, Livelocks и Starvation</a><br>
    <p><b>Starvation</b> - это ситуация, когда поток не может получить все ресурсы, необходимые для выполнения его работы</p>
    <p>Это когда одни потоки на себя берут всё время выполнения, другие не могут выполниться</p>
    <p>Жизненные примеры:</p>
    <p>У нас будет два работника. Один жадный(greedyWorker), другой вежливый(politeWorker). Обоим дается одинаковое кол-во времени на их полезную работу — спать по 3 наносекунде.

greedyWorker жадно удерживает общий ресурс(sharedLock) на протяжении всего цикла работы, тогда как politeWorker пытается блокировать его только тогда, когда это необходимо</p>
</details>
<details><summary>Могут ли два потока выполнять два метода (статический и нестатический одновременно)?</summary>
    <p>Да, могут если, методы не синхронизированы</p>
</details>
<details><summary>finalize()</summary>
    <p>Метод класса Object, который вызывается перед удалением объекта</p>
    <p>После того, как объект становится доступным для сборки и, если в нем переопределен метод finalize, то он не вызывается сразу, а помещается в очередь, которая обрабатывается специально созданным для этого потоком</p>
    <p>Есть вероятность, что этот метод не будет вызван совсем. Это может произойти в момент, когда объект уже станет доступным для сборщика мусора и программа завершит свою работу</p>
    <p>Интересной особенностью метода является то, что он может снова сделать объект доступным, присвоив this какой-нибудь переменной, хотя так делать не рекомендуется, т.к. при восстановлении объекта, повторно finalize вызван не будет</p>
    <p>Может случиться еще один редкий момент. У нас есть класс A, в котором реализован метод finalize. Мы создаем класс B extends A, в котором забываем про finalize. Объекты класса B содержат в себе много данных. Когда объекты классы B становятся ненужными, они попадут в очередь на финализацию и определенное время еще будут занимать память, вместо того, чтобы миновать этой очереди и сразу утилизироваться</p>
</details>
<details><summary>Пул потоков</summary>
    <a href="https://www.baeldung.com/thread-pool-java-and-guava">Introduction thread to pool</a><br>
    <a href="https://senior.ua/articles/mnogopotochnost-v-java-lekciya-4-puly-potokov">ПУЛЫ ПОТОКОВ RUNNABLE И CALLABLE</a><br>
    <p><b>Пул потоков</b> - своего рода контейнер потоков, в котором содержатся потоки, которые могут выполнять задачи, и после выполнения одной задачи переходить к следующей</p>
    <p>Проблема: есть 100 задач, мы можем выделить на их выполнение 100 потоков, с одной стороны это должно улучшить 
        производительность, но не всегда, тк на создание потока тратятся ресурсы ПК (память, время ЦП), кроме этого 
        существуют накладные расходы на создание, потока, и переключение потоков
    </p>
    <p>Решение: использовать пул потоков, который мы настроим исходя от возможностей "машины" (кол-во ядер, памяти и тд) и наших бизнес процессов. И например будет 10 потоков которые эффективно выполнят эти 100 задач.</p>
    <uL>Преимущества:
        <li>контроль и управление потоков</li>
        <li>более высокая производительность</li>
        <li>требуется меньше ресурсов</li>
        <li>сниженные накладные расходы</li>
        <li>поток можно использовать несколько раз для нескольких задач</li>
    </uL>
    <p>За создание и управление пулом потоков отвечают несколько классов и интерфейсов из Executor Framework. Основные интерфейсы: Executor, ExecutorService и фабрика Executors</p>
    <p>Интерфейс Executor имеет один метод void execute(Runnable command). После вызова этого метода и передачи задачи на выполнение, задача в будущем будет выполнена асинхронно</p>
    <p>Интерфейс ExecutorService наследуется от интерфейса Executor и предоставляет возможности для выполнения заданий Callable. Для выполнения задач, которые возвращают результат, существует метод submit(), возвращающий объект, который реализует интерфейс Future</p>
    <p>С помощью этого объекта можно узнать, есть ли результат, вызовом метода isDone(). С помощью метода get() можно получить результат выполнения задачи, если он есть. Также можно отменить задание на выполнение при помощи метода cancel()</p>
    <ul>Executors — утилитный класc, который создает классы, реализующие интерфейсы Executor и ExecutorService. Основные реализации пула потоков:
        <li><b>ThreadPoolExecutor</b> — пул потоков, который содержит фиксированное количество потоков. Также этот пул можно создать с использованием конструктора через ключевое слово new</li>
        <li><b>Executors.newCachedThreadPool()</b> — возвращает пул потоков, если в пуле не хватает потоков, в нем будет создан новый поток</li>
        <li><b>Executors.newSingleThreadExecutor()</b> — пул потоков, в котором есть только один поток</li>
        <li><b>ScheduledThreadPoolExecutor</b> — пул потоков позволяет запускать задания с определенной периодичностью или один раз по истечении промежутка времени</li>
    </ul>
</details>
<details><summary>Где используется и как работает synchronized?</summary>
    <p><b>Синхронизация</b> - это процесс, при котором гарантируется, что ресурс будет одновременно использоваться только одним потоком</p>
    <p><b>Монитор</b> - это объект, используемый в качестве взаимоисключающей блокировки. Только один поток исполнения может в одно и то же время владеть монитором</p>
    <p>Для обеспечения такой синхронизации, используется ключевое слово <b>synchronized</b> - которое используется в качестве модификатора в сигнатуре метода </p>
    <p>Так же synchronized может быть блок кода</p>
    <p>Когда поток исполнения оказывается в теле синхронизированного метода, все другие потоки исполнения или любые другие синхронизированные методы, пытающиеся вызвать его для того же самого экземпляра, вынуждены ожидать</p>
</details>
<details><summary>Разница между Class Lock и Object Lock</summary>
    <p><b>Object Lock</b> - блокировка на уровне объекта. Т.е. когда поток хочет выполнить синхронизированный метод для данного объекта, он получает блокировку на уровне объекта. Одновременно только один поток может выполнять синхронизированный метод у объекта</p>
    <p><b>Class Lock</b> - блокировка на уровне класса. Т.е. когда поток хочет выполнить синхронизированный статический метод данного объекта, он получает блокировку на уровне класса. Одновременно только один поток может выполнять синхронизированный статический метод класса</p>
</details>
<details><summary>BlockingQueue</summary>
    <a href="https://java-online.ru/concurrent-queue-block.xhtml">Блокирующие очереди пакета concurrent</a><br>
    <p>Интерфейс BlockingQueue определяет блокирующую очередь, наследующую свойства интерфейса Queue, в которой элементы хранятся в порядке «первый пришел, первый вышел» (FIFO – first in, first out)</p>
    <p>Реализация данного интерфейса обеспечивает блокировку потока в двух случаях:<br>
        при попытке получения элемента из пустой очереди;
        при попытке размещения элемента в полной очереди.
    </p>
    <p>Когда поток пытается получить элемент из пустой очереди, то он переводится в состояние ожидания до тех пор, пока какой-либо другой поток не разместит элемент в очереди. Аналогично при попытке положить элемент в полную очередь; поток ставится в ожидание до тех пор, пока другой поток не заберет элемент из очереди и, таким образом, не освободит место в ней</p>
    <p>Естественно, понятие "полная очередь" подразумевает ограничение размера очереди</p>
    <p>BlockingQueue изящно решает проблему передачи собранных одним потоком элементов для обработки в другой поток без явных хлопот о проблемах синхронизации</p>
    <p>BlockingQueue не признает нулевых элементов (null) и вызывает NullPointerException при попытке добавить или получить такой элемент</p>
    <p>Нулевой элемент возвращает метод poll, если в течение таймаута не был размещен в очереди очередной элемент</p>
    <ul>Реализации:
        <li><b>ArrayBlockingQueue</b> - реализует классический ограниченного размера кольцевой буфер FIFO — «первым прибыл - первым убыл». Новые элементы вставляются в хвост очереди; операции извлечения отдают элемент из головы очереди. Создаваемая емкость очереди не может быть изменена. Попытки вставить (put) элемент в полную очередь приведет к блокированию работы потока; попытка извлечь (take) элемент из пустой очереди также блокирует поток</li>
        <li><b>LinkedBlockingQueue</b> - основанный связанном списке, сохраняет порядок вставки и выдачи элементов FIFO — «первым прибыл - первым убыл». Новые элементы вставляются в хвост очереди; операции чтения извлекают элемент из головы очереди</li>
        <li><b>LinkedBlockingDeque</b> - Класс LinkedBlockingDeque создает двунаправленную очередь с реализацией интерфейса BlockingDeque, наследуемого от интерфейса Deque. Данный класс может иметь ограничение на количество элементов в очереди. Если ограничение не задано, то оно равно значению Integer.MAX_VALUE</li>
        <li><b>SynchronousQueue</b> - формирует блокирующую очередь, в которой каждая операция добавления в одном потоке должна ждать соответствующей операции удаления в другом потоке и наоборо</li>
        <li><b>DelayQueue</b> - неограниченная очередь блокирования элементов, реализует интерфейс Delayed и позволяет извлекать элемент с некоторой временно́й задержкой</li>
    </ul>
</details>
<details><summary>Барьеры. Класс CyclicBarrier</summary>
    <p><b>Барьер</b> - это средство синхронизации, которое используется для того, чтобы некоторое множество потоков ожидало друг-друга в некоторой точке программы, называемой точкой синхронизации
        В тот момент, когда все потоки достигают точки синхронизации они разблокируются и могут продолжить выполнение
    </p>
    <p>CyclicBarrier применяется в ситуациях, когда два или несколько потоков исполнения должны находиться в режиме ожидания в предопределенной точке исполнения до тех пор, пока все эти потоки не достигнут данной точки</p>
    <ul>конструкторы:
        <li>CyclicBarrier(int количество_потоков)</li>
        <li>CyclicBarrier(int количество_потоков, Runnable действие)</li>
    </ul>
</details>
<details><summary>Монитор</summary>
    <p></p>
</details>
<details><summary>Критическая секция</summary>
    <p><b>Критическая секция (synchronized block)</b>Часть кода (не целый метод), к которой мы хотим предотвратить доступ одновременно нескольких потоков</p>
</details>