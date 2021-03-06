## Пример простого рабочего CRUD микросервиса на Spring Boot.

Maven + SpringBoot -> (CRUD) Microservice

## An example of a simple working CRUD microservice on Spring Boot.

Это простой пример базового REST-приложения с минимальной конфигурацией без использования Базы данных.
Данный микросеврис обрабатывает запросы от клиента и сохраняет информацию в коллекцию.
Приложение использует интерфейс с тремя методами и это удобно для дальнейшего расширения функционала:

<small>

    addCustomer() // добавить нового
    getCustomer() // отдать существующего
    removeCustomer() // удалить существующего

</small>

Например, чтобы хранить информацию в Базе данных, нам можно просто подменить реализацию интерфейса, не переписывая весь код.

Проверку работы приложения можно выполнить в "POSTMAN" следующими запросами: 

<small>

     POST: localhost:8080?id=5&name=Anna
     GET: localhost:8080?id=5
     DELETE: localhost:8080?id=5
     
</small>

<small>

<details><summary>REST-контроллер...</summary>

<small>

>*Контроллер* обрабатывает запросы, которые приходят на определенный адрес.
>Для того чтобы сделать класс Контроллером, нужно помеить его аннотацией:
>```java 
>@Controller
>```
>Если необходимо, чтобы результат работы метода в контроллере был выведен непосредственно в тело ответа на запрос, 
>а не послужил адресом перехода и не был помещён как параметр в модель, нужно указать непосредственно перед методом аннотацию *@ResponseBody*.
>Это означает, что возвращаемое значение метода будет составлять тело HTTP-ответа и автоматически упакует объект в формат JSON. 
>Для этого достаточно добавить следующую аннотацию:
>```java
>@ResponseBody
>```
>Но можно сделать еще проще и создать *REST-контроллер*, добавив только одну аннотацию, чтобы не писать две предыдущие.
>```java  
>@RestController
>```
>*REST-контроллер* обрабатывает запросы и автоматически мапит все данные в JSON.
>
>**ВАЖНО!!!**    
>Разница между *@Controller* и *@RestController* состоит в том, *@RestController`е* включает в себя обе аннотации *@Controller* и *@ResponseBody*.
>Это означает, что нам не нужно аннотировать наши методы-обработчики с помощью *@ResponseBody*.

</small>

</details>


<details><summary>Разница в архитектурах MVC и RESTful...</summary>

<small>

>На одном конце у вас есть архитектура MVC, которая основана на вашем обычном веб-приложении, использующем веб-страницы, и браузер делает запрос страницы:
>```
>Browser <---> Controller <---> Model
>               |      |
>               +-View-+
>```
>Браузер делает запрос, контроллер (@Controller) получает модель (@Entity) и создает представление (JSP) из модели, и представление возвращается обратно клиенту. **Это базовая архитектура веб-приложения**.
>
>С другой стороны, у нас есть архитектура RESTful. В этом случае *View отсутствует*. Контроллер отправляет обратно только модель (или представление ресурса, в более терминах RESTful). Клиент может быть приложением JavaScript, серверным приложением Java, любым приложением, в котором мы предоставляем наш REST API. В этой архитектуре клиент решает, что делать с этой моделью.
>
>К примеру Twitter, как веб-API (REST), который позволяет нашим приложениям использовать его API для получения таких вещей, как обновления статуса, чтобы мы могли использовать его для размещения этих данных в нашем приложении. Эти данные будут иметь некоторый формат, например JSON.
>
>При работе со Spring MVC он был бы построен для обработки базовой архитектуры веб-приложений. Существуют разные разновидности сигнатур методов, которые позволяют создавать представление из наших методов. Метод может возвращать ModelAndView там, где мы его явно создаем, или есть неявные способы, где мы можем вернуть некоторый произвольный объект, который устанавливается в атрибуты модели. Но в любом случае где-то в цикле "запрос-ответ", будет создано *представление*.
>
>
>Когда же мы используем @ResponseBody, мы говорим, что **не хотим создавать представление**. Мы просто хотим отправить возвращаемый объект, как тело в любом указанном нами формате.

</small>

</details>


</small>

