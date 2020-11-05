## Пример простого рабочего CRUD микросервиса на Spring Boot.

Java + Maven + SpringBoot -> Microservice

## An example of a simple working CRUD microservice on Spring Boot.

Это простой пример базового микросервиса на Spring Boot.
Данный микросеврис обрабатывает запросы от клиента, которые приходят на определенный адрес и сохраняет информацию в коллекции.
Реализация сервиса выполнена через интерфейс с двумя методами, это удобно для дальнейшего расширения функционала:

<small>

    addCustomer() - добавляет нового
    getCustomer() - отдает существующего

</small>

*Например для того-чтобы добавить хранение информации в Базе Данных, то нужно просто подменить имплементацию интерфейса, не переписывая весь код.*

Проверку работы микросервиса можно выполнить в "POSTMAN" следующими запросами: 

<small>

     POST: localhost:8080?id=5&name=Petty
     GET: localhost:8080?id=5
     
</small>

<small>

<details>

<summary>класс контроллер...</summary>

>Класс Контроллер обрабатывает запросы, которые приходят на определенный адрес.  
>Для того чтобы сделать класс Контроллером, нужно помеить его аннотацией:
>```java 
>@Controller
>```
>В Spring`е есть функциональность для автоматической передачи объектов в формате JSON между микросервисами, бэком и фронтом. 
>Для этого достаточно добавить следующую аннотацию, чтобы Spring автоматически обрабатывал информацию в формате JSON:
>```java
>@ResponseBody
>```
>Можно *сделать еще проще*, чтобы не писать две предыдущие аннотации, можно добавить одну:
>```java  
>@RestController
>```
>**ВАЖНО!!!**  
>Разница между *@Controller* и *@RestController* в том, что в *@RestController`е* добавлены обе аннотации *@Controller* и *@ResponseBody*.  
>Он автоматически мапит все данные, которые мы отдаем в JSON.
>
</details>

</small>
