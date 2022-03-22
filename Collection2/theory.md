<details><summary>Работа List? В каких ситуациях использовать</summary>
    <p><b>List</b> - это тип данных, в котором каждый элемент содержит какой-то контент (объект сылочного типа данных),
        а также ссылку на следующий элемент списка
    </p>
    <p>Интерфейс List объединяет несколько реализаций: <b>ArrayList, LinkedList, Vector, Stack</b></p>
    <img src="https://vertex-academy.com/tutorials/wp-content/uploads/2018/06/list-java-vertex-academy.png" width="30%" ><br>
    <p>Основное преимущество списка по сравнению с массивом - его можно легко расширять</p>
    <ul>методы:
        <li><b>int size()</b></li>
        <li><b>boolean isEmpty()</b></li>
        <li><b>boolean contains(Object o)</b></li>
        <li><b>Iterator&lt;E&gt; iterator()</b></li>
        <li><b>Object[] toArray()</b></li>
        <li><b>boolean add(E e)</b></li>
        <li><b>boolean remove(Object o)</b></li>
        <li><b>boolean containsAll(Collection&lt;?&gt; c)</b></li>
        <li><b>boolean addAll(Collection&lt;? extends E&gt; c)</b></li>
        <li><b>void clear()</b></li>
        <li><b>E get(int index)</b></li>
        <li><b>E set(int index, E element)</b></li>
        <li><b>int indexOf(Object o)</b></li>
        <li><b>int lastIndexOf(Object o)</b></li>
        <li><b>of(E... elements)</b> - статические методы</li>
        <li><b>default void replaceAll(UnaryOperator&lt;E&gt; operator)</b> - default method</li>
        <li><b>default void sort(Comparator&lt;? super E&gt; c)</b> - default method</li>
    </ul>
    <ul>использование когда:
        <li>есть элементы, которые могут повторяться</li>
        <li>нужен доступ к элементам по индексу</li>
        <li>возможны null</li>
    </ul>
</details>

<details><summary>Работа ArrayList</summary>
    <p>ArrayList одна из реализаций интерфейса List. В основе ArrayList лежит идея динамического массива, с возможностью
        добавлять и удалять элементы, при этом будет увеличиваться или уменьшаться по мере необходимости
    </p>
    <ul>Конструкторы:
        <li>public ArrayList()</li>
        <li>public ArrayList(int initialCapacity)</li>
        <li>public ArrayList(Collection&lt;? extends E&gt; c)</li>
    </ul>
    <p>При инициализации ArrayList с помощью конструктора без параметров, под капотом, создается массив <b>elementData</b>
    с дефолтным количеством элементов <b>capacity</b> 10 типа Object.
    </p>
    <p>Так же можно инициализировать ArrayList с определенным кол-вом элементов, используя конструктор <b>public ArrayList(int initialCapacity)</b>,
    в случаи передачи 0 - будет инициализирован пустой массив, при передаче отрицательного значения будет выбрашено исключение IllegalArgumentException
    </p>
    <ol>Добавление элементов: list.add("0"):
        <li>проверяется, достаточно ли места в массиве для вставки нового элемента: ensureCapacity(size + 1);</li>
        <li>если достаточно, элемент добавляется в конец массива: elementData[size++] = element;</li>
        <li>если нет, вызывается метод grow(size + 1) в котором производится увеличение capacity, затем
            копирование существующего массива в новый, с учетом нового размера (capacity) где в конечном итоге вызывается
            нативный метод: System.arraycopy()
        </li>
    </ol>
    <ol>Добавление в «середину» списка: list.add(5, "100"):
        <li>проверяется, достаточно ли места в массиве для вставки нового элемента: ensureCapacity(size+1);</li>
        <li>подготавливается место для нового элемента с помощью: System.arraycopy()</li>
        <li>перезаписывается значение у элемента с указанным индексом: elementData[index] = element; size++;</li>
    </ol>
    <ol>Удаление элементов по индексу:
        <li>Определяется какое количество элементов надо скопировать: int numMoved = size - index - 1;</li>
        <li>затем копируем элементы используя System.arraycopy()</li>
        <li>Уменьшается размер массива и последнему элементу присваивается null: elementData[--size] = null</li>
    </ol>
    <p>При удалении по значению, в цикле просматриваются все элементы списка, до тех пор пока не будет найдено соответствие. Удален будет лишь первый найденный элемент.</p>
    
</details>