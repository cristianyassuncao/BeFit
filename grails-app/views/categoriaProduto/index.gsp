<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'categoriaProduto.label', default: 'CategoriaProduto')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <link rel="stylesheet" href="/BeFit/js/jsTree/dist/themes/default/style.min.css" />
        <script src="/BeFit/js/jsTree/dist/jstree.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#categoriasTree')
                    .on('dblclick.jstree', function (e, data) {
                            var node = $(e.target).closest("li");
                            window.open("/BeFit/categoriaProduto/show/" + node[0].id, "_self");
                    })
                    .jstree({
                        "core" : {
                            "themes" : {
                                "variant" : "large"
                            },
                            "data" : ${raw(categorias)}
                        },
                        "plugins" : [ "wholerow"]
                });
            });
        </script>    
    </head>
    <body>
        <a href="#list-categoriaProduto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nova Categoria de Produtos</g:link></li>
            </ul>
        </div>
        <div id="list-categoriaProduto" class="content scaffold-list" role="main">
            <h1>Categorias de produtos</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div id="categoriasTree"></div>
        </div>
    </body>
</html>