<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>
    <h1>Регистрация</h1>
{{#messages}}
    <h2>{{messages}}</h2>
{{/messages}}
<@l.login "/signup" />
</@c.page>