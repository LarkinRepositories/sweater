<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>
<h1>Страница авторизации</h1>
    <@l.login "/login" />
<div><a href="/signup">Зарегистрироваться</a> </div>
</@c.page>
