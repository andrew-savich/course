<details><summary>Switch-выражения</summary>
    <p><b>Switch-выражения</b> — это оператор switch с улучшенным синтаксисом и функциональностью</p>
    <p>можно определять более одного условия для одного и тот же случая</p>
    <p>не нужно использовать ключевое слово break, чтобы остановить выполнение. При использовании switch-выражений 
        выполняется только правая часть соответствующего случая, если применяется синтаксис со стрелкой (->)
    </p>
    <p>поскольку операторы switch стали switch-выражениями, а выражения вычисляют значение, то теперь они могут 
        возвращать значение
    </p>
    <p>выражения switch являются исчерпывающими. Если вы забудете указать случай в выражении switch, то получите ошибку 
        во время компиляции. Если вы охватываете все случаи, вам не нужно иметь случай “по умолчанию”
    </p>
    <p>Возможность выполнения блок кода</p>
</details>

<details><summary>Текстовые блоки</summary>
    <img src="src/main/resources/textblocks.png" />
</details>

<details><summary>Сопоставление с образцом (Pattern Matching) для instanceof</summary>
   
</details>

<details><summary>Полезные NullPointerException</summary>
    <img src="src/main/resources/npe.png" />
</details>

<details><summary>Записи (Record)</summary>
    <p>Тип record создает неизменяемый класс с приватными финализированными полями, геттерами, методом toString, а также 
        методами equals и hashCode
    </p>
    <img src="src/main/resources/record.png" />
</details>

<details><summary>Запечатанные классы (sealed)</summary>
    <p>При помощи этой функции класс может указывать, какие классы могут его расширять</p>
    <img src="src/main/resources/sealed.png" />
</details>

<details><summary>toList() в стримах</summary>
    <p>Было:</p>
    <img src="src/main/resources/toListBefore.png" />
    <p>Стало:</p>
    <img src="src/main/resources/toListNow.png" />
</details>