Поля в аннотации @ManyToOne и ему подобных: https://javarush.com/quests/lectures/questhibernate.level13.lecture05
Spring Security: https://www.geeksforgeeks.org/advance-java/implementing-database-authentication-and-authorization-with-spring-security-6/
Про dto и MapStruct: https://habr.com/ru/articles/818489/
Документация Thymeleaf: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax

@Data = @Getter + @Setter + @RequiredArgsConstructor + @EqualsAndHashCode + @ToString

Spring boot JPA:
save() - сохраняет/изменяет сущность в бд. Сами запросы в бд на изменение происходят в конце транзакции или если в процессе транзакции вызвался flush()
saveAndFlush() - сразу же формирует запросы сохранения/изменения сущности к бд (однако в рамках транзакции откат (rollback) всё ещё возможен)

Картинки хранятся в папке /images вне проекта, чтобы они не сохранялись в .jar после компилирования. 
Чтобы браузер мог получать эти фотки (т.к. они не в static) был сделан WebConfig

Тестовые пользователи: 
CUSTOMER - aa@aa.a aaa
EMPLOYEE - employee@empl.oyee employee
WAREHOUSE_MANAGER - warehouse@manager.com warehousemanager
ADMIN - admin@admin.ad admin

Задачи frontend:
1. В /login все кнопки сделать одного размера и убрать "забыли пароль"
2. В стилях для карточки товара если он уже в корзине, то при наведении поменять цвет текста
3. Исправить смену цвета у изображения ссылки
4. В customer/check-order сделать цвет заголовков таблиц тёмным
5. Во всех таблицах есть зелёная полоска
6. В /admin/updateWarehouseManager (везде) input'ы для статусов слишком большие
7. В /admin/updateWarehouseManager (везде) неправильно отображаются выбираемые магазины
8. В employee/checkOrder выровнить список товаров (сейчас там рандомный класс)
9. Поменять классы в customer/profile
10. В customer/profile сделать так, чтобы кнопки слева всегда были в одном месте
11. Сделать так, чтобы customer/profile и customer/updateCustomer были одинаковы по стилю
12. В принципе исправить orders, profile и updateCustomer
13. Сделать фильтрацию по тегам в home (и сделать кнопку "применить")
14. Проверить в каждом файле используются ли нужные классы

Задачи backend:
1. Исправить проблему с добавлением новых категорий при изменении товара
2. Сделать постраничную работу с бд (то есть работаем условно только с 20 записями за раз)