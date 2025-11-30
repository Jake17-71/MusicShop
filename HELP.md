Поля в аннотации @ManyToOne и ему подобных: https://javarush.com/quests/lectures/questhibernate.level13.lecture05
Spring Security: https://www.geeksforgeeks.org/advance-java/implementing-database-authentication-and-authorization-with-spring-security-6/
Про dto и MapStruct: https://habr.com/ru/articles/818489/
Документация Thymeleaf: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax

@Data = @Getter + @Setter + @RequiredArgsConstructor + @EqualsAndHashCode + @ToString

Тестовые пользователи: 
CUSTOMER - aa@aa.a aaa
EMPLOYEE - employee@empl.oyee employee
WAREHOUSE_MANAGER - warehouse@manager.com warehousemanager
ADMIN - admin@admin.ad admin

Задачи:
1. Почему-то в updateStore не работает выбор исходного значения статуса (всегда выбирается ACTIVE), 
хотя есть полностью аналогичный код в updateAdmin и там всё нормально (в итоге приходится прописывать .name())
2. В updateAdmin первая строчка намного длиннее остальных
3. Исправить плашку с выбором категорий, если их нет
4. Сделать /home
5. Как в updateProduct.html сделать вывод картинки и автоматический выбор исходных категорий
6. Сделать в newCategory и updateCategory большое поле для ввода текста (textarea)
7. Сделать показ изображения при добавлении и изменении товара
8. Сделать в admin/dashboard большее расстояние между таблицами
9. Сделать, чтобы при выборе магазина (например, при создании сотрудника) можно было 
вбивать текст и сокаращать список подходящий магазинов