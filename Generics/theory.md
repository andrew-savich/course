<details><summary>Что такое параметр универсального типа?</summary>
    <p>Это параметр типа обобщения, с помощью которого можно объявлять классы, интерфейсы, методы, для того чтоб можно было
        автоматически обращаться с разнотипными данными
    </p>
</details>

<details><summary>Зачем нужны дженерики? Можете ли вы привести пример того, как дженерики делают программу более гибкой?</summary>
    <p>Обобщения нужны для упрощения программ при работе с разными типами, т.к. блогодаря им нам не нужно создавать разные классы, интерфейсы,
        методы для обработки конкретного типа, а можем создать обобщенный класс, интерфейс, метод. 
    </p>
    <p>Java и раньше предоставляла возможность создавать обобщенные классы, интерфейсы и методы которые оперировали 
        ссылками типа Object. Но они не могли обеспечить типовую безопасность.
    </p>
</details>

<details><summary>Основная причина, по которой дженерики работают с объектами типа object?</summary>
    <p>Для совместимости с ранее написанным кодом до ввода дженерикоа, тк раньше обобщения оперировали ссылками типа Object</p>
</details>

<details><summary>Как объявить универсальный класс? метод? поле? интерфейс?</summary>
    <ul>
        <li><b>класс</b>: class&lt;T, S extends Number&gt; {}</li>
        <li><b>interface</b>: interface&lt;T, S extends Number&gt; {}</li>
        <li><b>методы</b>
            <ul>
                <li> T someMethod() {return (T) new Object();} - в обобщенном классе</li>
                <li> &lt;T&gt; T someMethod() {return (T) new Object();} - в обычном классе</li>
            </ul>
           </li>
        <li><b>поле</b>: T someField; - предварительно объявив класс обобщенным</li>
    </ul>
</details>

<details><summary>Можете ли вы объявить статические поля, типы которых являются параметрами универсального типа?</summary>
    <p>Нет. Можно объявить только статический метод</p>
</details>

<details><summary>Что такое стирание типов?</summary>
    <p>Это процесс при котором компилятор Java стирает все параметры типа и заменяет каждого его первым,
        связанным, если параметр типа ограничивается, или Object, если параметр типа неограничен</p>
</details>

<details><summary>Чем универсальный метод отличается от универсального типа?</summary>
    <p>Отличается тем, что универсальный параметр метода будет виден в области самого метода, а типа в области видимости этого типа(класса)</p>
</details>

<details><summary>Что такое параметр ограниченного типа?</summary>
    <p>Это когда параметр ограничен типом, наследников которого мы можем подставлять при использовании.<br>
        Например если мы хотим чтоб наше обобщение рабтало только с числовыми типами в объявлении мы указываем &lt;T extends Number>    
    </p>
</details>

<details><summary>Правило PECS? Как работает extends и super в дженериках?</summary>
    <a gref="https://habr.com/ru/post/207360/">Использование generic wildcards для повышения удобства Java API</a><br>
    <a href="https://habr.com/ru/post/559268/">Подробно о PECS</a>
    <p><b>PECS</b> (Producer Extends Consumer Super)</p>
    <p>Если метод читает данные из аргумента, то этот аргумент — производитель, а если метод передаёт данные в аргумент, то аргумент является потребителем</p>
    <a href="https://www.baeldung.com/java-generics-interview-questions#q13-when-would-you-choose-to-use-a-lower-bounded-type-vs-an-upper-bounded-type">Q13. When Would You Choose to Use a Lower Bounded Type vs. an Upper Bounded Type?</a>
</details>

<details><summary>Что такое <b>wildcard</b> с верхней/нижней границей?</summary>
    <p><b>Wildcard</b> - это "подстановочный знак" '?', означает, что тип может быть чем угодно</p>
    <ul>виды:
        <li><b>Unbounded Wildcards</b>: List&lt;?&gt; - List из объектов неизвестного типа</li>
        <li><b>Upper Bounded Wildcards</b>: List&lt;? extends Number&gt; - список из объектов Number объектов, и наследников (Integer, Double)</li>
        <li><b>Lower Bounded Wildcards</b>: List&lt;? super Integer&gt; - список из Integer или его суперклассов Number, Object</li>
    </ul>
    <a href="https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html">Docs about wildcard</a>
</details>

<details><summary>Принятые обозначения дженериков?</summary>
    <ul>
        <li><b>E</b> - элемент (Element, обширно используется Java Collections Framework)</li>
        <li><b>K</b> - Key, ключ</li>
        <li><b>V</b> - value, значение</li>
        <li><b>N</b> - number, число</li>
        <li><b>T</b> - тип</li>
        <li><b>S, U, V и т.п.</b> - 2-й, 3-й, 4-й типы</li>
    </ul>
</details>

<details><summary>Какие типы нельзя параметризировать в обобщениях?</summary>
    <p>Примитивные типы нельзя использовать в обобщениях, тк после стирания типов производится приведение к Object</p>
</details>

<details><summary>Как выглядит код дженерик класса после компиляции?</summary>
    <p>Происходит затирание типов, и приведение типов к Object</p>
    <p>Так же компилятор генерирует Bridge методы, для обеспечения полиморфизма</p>
</details>

<details><summary>Могут ли инициализироваться объекты generic типа в generic методе?</summary>
    <p>Да, можно</p>
</details>