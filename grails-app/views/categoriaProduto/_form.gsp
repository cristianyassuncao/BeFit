<link rel="stylesheet" href="${createLinkTo(dir:'js/jsTree/dist/themes/default', file: 'style.min.css')}"/>
<g:javascript src="jsTree/dist/jstree.min.js"/>
<script type="text/javascript">
    $(function () {
        function getAllChildren(treeObj, nodeId, result) {
            if (nodeId == "") return;
            var node = treeObj.get_node(nodeId);
            result.push(node);
            if (node.children) {
                for (var i = 0; i < node.children.length; i++) {
                    getAllChildren(treeObj, node.children[i], result);
                }
            }
        }
    
        $('#categoriasTree')
            .on('ready.jstree', function (e, data) {
               var children = []
               getAllChildren($('#categoriasTree').jstree(), $("#id").val(), children);
               jQuery.each( children, function( i, val ) {
                    $('#categoriasTree').jstree().disable_node(val);
               });
            })
            .on('changed.jstree', function (e, data) {
                var i, j, r = [];
                for(i = 0, j = data.selected.length; i < j; i++) {
                  r.push(data.instance.get_node(data.selected[i]).id);
                }
                if (r != []) {
                    $("#categoriaPai").val(r[0]);
                }
            })
            .jstree({
                "core" : {
                    "multiple": false,
                    "themes" : {
                        "dots": false,
                        "icons": false,
                        "variant" : "large"
                    },
                    "data" : ${raw(categorias)}
                },
                "checkbox" : {
                  "keep_selected_style": false,
                  "three_state": false
                },
                "plugins" : [ "wholerow", "checkbox"]
        });
    });
</script>
<g:hiddenField id="id" name="id" value="${categoriaProdutoInstance?.id}" />
<div class="campos">
    <div class="campo">
	<div class="nome">
            <g:message code="categoriaProduto.nome.label" default="Nome" />
            <span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:textField name="nome" value="${categoriaProdutoInstance?.nome}" maxlength="100" size="70"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
	<div class="nome">
            <g:message code="categoriaProduto.categoriaPai.label"/>
	</div>
        <div class="valor">
            <input type="hidden" id="categoriaPai" name="categoriaPai.id"/>
            <div id="categoriasTree"></div>
        </div>    
    </div>
</div>