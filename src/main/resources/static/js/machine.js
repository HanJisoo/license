function pagination(data){
    var curIndex = data.currentIndexPage;
    var size = data.endPage - data.startPage + 1;
    var listHtml = "";
    $('#pagination').html('');
    for(var i = 0; i < size; i++){
        var index = data.startPage + i;
        if(index == curIndex){
            listHtml = listHtml + "<li class='uk-active'><span>" + index + "</span></li>";
        }else{
            listHtml = listHtml + "<li><a role='button' onclick='getList(" + index + ");'>" + index + "</a></li>";
        }
    }
    $('#pagination').html(listHtml);
}

function addMachineRow(data){
    $("#nodata").addClass("uk-hidden");
    $("#nextBtn").hide();
    $("#loading").removeClass("uk-active");
    $('#item_list').html("");
    var list='';
    $.each(data.machineList, function(i, item){
        with(item){
            list+="<tr>"+
                "<td class='uk-text-center'>" + machineNo + "</td>"+
                "<td class='uk-text-center'>" + serialKey + "</td>"+
                "<td class='uk-text-center'>" + clientCompanyName + "</td>"+
                "<td class='uk-text-center'>" + stateValue + "</td>"+
                "<td class='uk-text-center'>" + adminCompanyName + "</td>"+
                "<td class='uk-text-center'>" + countryValue + "</td>"+
                "<td class='uk-text-center'>" + modelValue + "</td>"+
                "<td class='uk-text-center'>" + licenseEndDate + "</td>"+
                "<td class='uk-text-center'>" + "down" + "</td>" +
                '</tr>';
        }
    });
    if (page==1 && (data.length == 0)) {
        $("#nodata").removeClass("uk-hidden");
        $("#nextBtn").hide();
    } else {

        $('#item_list').append(list);

        if(data.length>=data.offset){
            $("#nextBtn").show();
        }
        $("#nodata").addClass("uk-hidden");
    }
    $("#loading").addClass("uk-hidden");
}

function getList(page){
    $.ajax({
        type: "get",
        cache: false,
        url: "/machine/list?page="+page,
        async: true,
        success: function(data){
            console.log(data);
            pagination(data);
            addMachineRow(data);
        },
        error: function(xhr,Textstatus,error) {
            alert(Textstatus);
        }
    });
}

function setMenuOnclickListener(menu){
    $("#statistics").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });
    $("#machine").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });
    $("#partner").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });
    $("#customer").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });
    $("#contact").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });
    $("#admin").click( function() {
        window.location.href='/machine/view/list';
        return false;
    });

    if(menu == "machine"){
        $("#machine-button").addClass("uk-active");
    }else if(menu == "statistics"){
        $("#statistics-button").addClass("uk-active");
    }else if(menu == "partner"){
        $("#partner-button").addClass("uk-active");
    }else if(menu == "customer"){
        $("#customer-button").addClass("uk-active");
    }else if(menu == "contact"){
        $("#contact-button").addClass("uk-active");
    }else if(menu == "admin"){
        $("#admin-button").addClass("uk-active");
    }
}

function setAddButtonListener() {
    $('#add-button').click( function() {
        window.location.href='/machine/view/add';
        return false;
    });
}

function addOptionByCategory(category, codeControlList){
    var list;
    var html = "";
    var node;

    if(category == "model"){
        list = codeControlList.modelAll;
        node = $("#model-select");
    }else if(category == "state"){
        list = codeControlList.stateAll;
        node = $("#state-select");
    }else if(category == "virus"){
        list = codeControlList.virusAll;
        node = $("#virus-select");
    }else if(category == "producer"){
        list = codeControlList.producerAll;
        node = $("#producer-select");
    }else if(category == "country"){
        list = codeControlList.countryAll;
        node = $("#country-select");
    }

    $.each(list, function(i, item){
        with(item){
            var num = i + 2;
            html+= "<option value='" + num + "'>" + value + "</option>";
        }
    });

    node.append(html);
}

function addSelectOption(codeControlList){
    addOptionByCategory("model", codeControlList);
    addOptionByCategory("state", codeControlList);
    addOptionByCategory("virus", codeControlList);
    addOptionByCategory("producer", codeControlList);
    addOptionByCategory("country", codeControlList);
}
