<details><summary>Что такое коллекции и зачем они нам нужны?</summary>
    <p>Это структура данных, способная хранить в себе однотипные элементы, имеющая методы для обработки этих данных</p>
</details>

<details><summary>Иерархия коллекций</summary>
    <img src="https://highload.today/wp-content/uploads/2021/08/image8-3.png" width="70%">
</details>

<details><summary>Почему map не является частью коллекций</summary>
    <p>Разные структуры данных: List, Set, Queue - набор объектов одного типа. Map - набор пар Ключ-Значение</p>
    <p>List, Set, Queue имеют метод add, который принимает значение в качестве параметра для его добавления.<br>
    Map имеют метод put - который принимает параметры в виде ключ-значение для их добавления </p>
    <p>List, Set и Queue обеспечивают итерацию по значению, тогда как Map имеет 
        ключи для итерации, которые в конечном итоге представляют собой Set и Values as Collection.</p>
</details>

<details><summary>Интерфейс Collection?</summary>
    <p>Это обобщенный интерфейс служит основанием, на котором построен весь каркас коллекций, поскольку он должен быть реализован всеми классами коллекций.</p>
    <p>Collection расширяет интерфейс Iterable. Это означает, что все коллекции можно перебирать, организовав цикл for bach</p>
    <p>В интерфейсе Collection определяются основные методы, которые должны иметь все коллекции:<br>
    add, addAll, clear, contains, containsAll, equals, hashCode, isEmpty, iterator, remove, removeAll, retainAll, size, stream, toArray</p>
</details>