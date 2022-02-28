# Схема БД

![изображение](https://user-images.githubusercontent.com/71271035/156018064-916574d1-5ae8-45f4-9b43-dca9e4122cfa.png)



# Описание страниц


## Для незарегистрированных пользователей

### Верхнее меню:

* Кнопка "Main page" = переход на главную страницу
* Кнопка "Sign up" = переход на страницу регистрации
* Кнопка "Log In" = переход на страницу входа

### Cтраницы:

1. Главная страница:
   * Список всех курсов (для каждого курса название - ссылка с переходом на страницу курса)

2. Страница регистрации:
   * Форма для заполнения. Поля: логин, пароль, ФИО, ученик или преподаватель (один логин = одна роль), название компании, адрес компании
   * название компании и адрес - только для преподавателей

3. Стриница входа:
   * Страница входа пользователя на сайт под своим логином и паролем. Два поля для ввода: логин, пароль

4. Страница курса:
   * Страница с информацией о курсе:
      * название курса;
      * список занятий курса (для каждого занятия - тема, время начала, время конца);
      * продолжительность и интенсивность курса
      * преподаватели курса: список (ФИО преподавателя, рядом - название компании; название компании - ссылка на страницу компании)

5. Страница компании:
   * Название, адрес
   * Список курсов, проводимых компанией (названия - ссылки с переходом на страницу курса)

## Для учащихся

### Верхнее меню (для всех):

* Кнопка "Main page" = переход на главную страницу (на всех страницах)
* Кнопка "Account" = переход в личный кабинет
* Кнопка "Courses" = переход на страницу с курсами пользователя (см. ниже)
* Кнопка "Log Out" = переход на главную страницу незарегистрированного пользователя

### Cтраницы:

1. Главная страница:
   * Список всех курсов (для каждого курса название - ссылка с переходом на страницу курса)

2. Страница с информацией о пользователе (личный кабинет):
   * Страница с личной информацией пользователя: логин, пароль, ФИО, роль (учащийся).
   * Кнопка "Edit" = переход на страницу редактирования личного кабинета.

3. Страница редактирования личного кабинета
   * Редактирование полей с данными пользователя из предыдущего пункта (поля логин и роль редактировать нельзя)

4. Courses:
   * Страница со всеми курсами, на которые учащийся записан
   * Содержимое страницы: список названий курсов, название - ссылка на страницу соответствующего курса

4. Страница курса:
   * Страница с информацией о курсе:
      * название курса;
      * список занятий курса (для каждого занятия - тема, время начала, время конца);
      * продолжительность и интенсивность курса
      * преподаватели курса: список (ФИО преподавателя, рядом - название компании; название компании - ссылка на страницу компании)
      * учащиеся курса: список ФИО
   * Если учащийся не записан на курс - кнопка "Записаться" = запись на курс, если записан - кнопка "Отписаться"

5. Страница компании:
   * Поля "Название", "Адрес"
   * Список курсов, проводимых компанией (названия - ссылки с переходом на страницу курса)


## Для преподавателей

### Верхнее меню (для всех):

* Кнопка "Main page" = переход на главную страницу (на всех страницах)
* Кнопка "Account" = переход в личный кабинет
* Кнопка "Courses" = переход на страницу с курсами, которые ведёт преподаватель
* Кнопка "Log Out" = переход на главную страницу незарегистрированного пользователя

### Cтраницы:

1. Главная страница:
   * Список всех курсов (для каждого курса название - ссылка с переходом на страницу курса)

2. Личный кабинет:
   * Страница с личной информацией пользователя: логин, пароль, ФИО, роль (преподаватель), компания.
   * Кнопка "Edit" = переход на страницу редактирования личного кабинета.

3. Страница редактирования личного кабинета
   * Редактирование полей с данными пользователя из предыдущего пункта (поля логин и роль редактировать нельзя)

4. Courses:
   * Страница со всеми курсами, которые он ведёт (т.е. где значится преподавателем)
   * Содержимое страницы: список названий курсов, название - ссылка на страницу соответствующего курса, рядом с названием - кнопка "Удалить" = удаление всех данных о курсе
   * кнопка "Создать курс" = появляется страница с полем "название курса" для заполнения = добавление нового курса (1 преподаватель - тот, кто создал курс, продолжительность = интенсивность = 0 часов, занятий нет, учащихся нет)

4. Страница курса:
   * Страница с информацией о курсе:
      * название курса;
      * список занятий курса (для каждого занятия - тема, время начала, время конца);
      * продолжительность и интенсивность курса
      * преподаватели курса: список (ФИО преподавателя, рядом - название компании; название компании - ссылка на страницу компании)
      * учащиеся курса: список ФИО
   * Для преподавателя, ведущего курс: кнопка "Изменить" = переход на страницу редактирования курса

5. Страница компании:
   * Поля "Название", "Адрес"
   * Список курсов, проводимых компанией (названия - ссылки с переходом на страницу курса)

6. Страница редактирования курса (только для преподавателей, ведущих курс).
   * Кнопка "добавить преподавателя" = появляется страница с полем "логин преподавателя" для добавления
   * Кнопка "добавить занятие" = появляется страница с полями "название занятия", "начало", "конец" для добавления нового занятия
   * Список занятий курса: название, рядом кнопка "Удалить" (= удалить занятие из курса)



# Сценарии использования

## Незарегистрированные пользователи

* Просмотр каталога курсов на главной странице:
     * кнопка "Main page" в верхнем меню -> переход на главную страницу со списком курсов.
        
* Просмотр информации о курсе:
     * кнопка "Main page" в верхнем меню -> переход на главную страницу со списком курсов -> название-ссылка курса -> переход на страницу курса с информацией
        
* Регистрация на сайте:
     * кнопка "Sign up" в верхнем меню -> переход на страницу регистрации.
        
* Вход:
     * кнопка "Log in" в верхнем меню -> переход на страницу входа.

* Просмотр информации о компании, проводящеё курс (или просмотр других курсов, проводимых компанией)
     * на странице курса найти преподавателя из этой компании -> название-ссылка компании -> страница компании со списком всех проводимых ей курсов

## Зарегистрированные пользователи

### Все зарегистрированные пользователи

* Просмотр каталога курсов на главной странице:
    * кнопка "Main page" в верхнем меню -> переход на главную страницу со списком курсов.
        
* Просмотр информации о курсе:
    * кнопка "Main page" в верхнем меню -> переход на главную страницу со списком курсов -> название-ссылка курса -> переход на страницу курса с информацией.
        
* Просмотр личного кабинета (информации о пользователе):
    * Кнопка "Account" в верхнем меню -> переход на страницу личного кабинета.
        
* Редактирование Личного кабинета:
    * Кнопка "Account" в верхнем меню -> переход на страницу личного кабинета -> кнопка "Edit" -> переход на страницу редактирования личного кабинета
        
* Просмотр своих курсов:
    * Кнопка "Courses" в верхнем меню -> переход на страницу со списком курсов (курсы, на которые записан, - для ученика; курсы, которые ведёт, - для учителя)

* Просмотр информации о компании, проводящеё курс (или просмотр других курсов, проводимых компанией)
     * на странице курса найти преподавателя из этой компании -> название-ссылка компании -> страница компании со списком всех проводимых ей курсов
        
### Только учащиеся

* Запись на курс:
    * Кнопка "Main page" в верхнем меню -> переход на главную страницу со списком курсов -> название-ссылка курса -> переход на страницу курса с -> кнопка "Записаться".
    
* Отписаться от курса:
    * Кнопка "Courses" в верхнем меню -> переход на страницу со списком курсов, на которые записан -> название-ссылка курса -> переход на страницу курса -> кнопка "Отписаться"

### Только преподаватели

* Создание курса
    * Кнопка "Courses" в верхнем меню -> переход на страницу со списком курсов -> кнопка "создать курс" -> заполнить поле "название курса"
    * На странице Courses появится ссылка на новый курс. Теперь можно отредактировать курс (см ниже), добавив занятия и других преподавателей

* Редактирование курса
    * Кнопка "Courses" в верхнем меню -> переход на страницу со списком курсов -> название-ссылка курса -> переход на страницу курса -> кнопка "Edit" -> переход на страницу редактирования курса


