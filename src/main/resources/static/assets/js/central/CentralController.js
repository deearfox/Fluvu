var CentralController = new function(){

    this.list = function(){
        $('#centralTableBody').empty();

        $.get("/central", function(data){
            $.each(data, function(i, item){
                $('<td>').append(
                    $('<td>').text(item.idCentral),
                    $('<td>').text(item.nome),
                    $('<td>').text(item.cnpj),
                    $('<td>').text(item.acao),
                    $('<td class="actions"><a href=""><i class="bi bi-pencil-square" onclick="CentralController.edit('+item.idCentral)
                )
            })
        })
    }

}

this.delete = function(idCentral){
    $.ajax({
        url: '/central/' +idCentral,
        method:'DELETE',
        contentType: 'application/json',
        success: function(result){
            CentralController.list();
        },
        error: function(request, msg, error){
            alert('erro ao deletar')
        }
    });
}

/*this.save = function(){
    var idCentralToEdit = $("#centralId").val();

    if(idCentralToEdit == null || idCentralToEdit == ""){
        var central = this.getDadosCentralModal();

        $.ajax({
            url: '/central',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            data: JSON, stringify(central),
            success: function(){
                $("#centralId").val("");
                $('#cadastrarCentral').modal('hide');
                CentralController.list();
                CentralController.LimparDadosCentralModal();
            },
            error: function( request,msg,error){
                $("#centralId").val("");
                $('#cadastrarCentral').modal('hide');
                CentralController.list();
                CentralController.LimparDadosCentralModal();
            }
        });
    }
    else{
        CentralController.update(idCentralToEdit);
    }
}*/
