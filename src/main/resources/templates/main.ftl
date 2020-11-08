<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>
    <@l.logout/>
    <div>
        <form method="post">
             <input type="text" name="text" placeholder="Введите сообщение">
             <input type="text" name="tag" placeholder="Введите тэг">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
             <button type="submit">Отправить</button>
        </form>
    </div>
        <div>Список сообщений</div>
        <form method="get" action="main">
            <input type="text" name="filter" placeholder="Введите текст для поиска" value="${filter}">
            <button type="submit">Найти</button>
        </form>
    <#list messages as message>
            <div><b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
        <#else><div>Нет сообщений</div>
    </#list>
</@c.page>