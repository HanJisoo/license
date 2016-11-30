/**
 * Created by user on 2016-11-30.
 */

/**
 * Pagination
 */
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

/**
 * Attach Machine List Data
 */
function addRow(data){
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
            $("#nextBtn").show()
        }
        $("#nodata").addClass("uk-hidden");
    }
    $("#loading").addClass("uk-hidden");
}

/**
 * Get Machine List Data
 */
function getList(page){
    $.ajax({
        type: "get",
        cache: false,
        url: "/machine/list?page="+page,
        async: true,
        success: function(data){
            console.log(data);
            pagination(data);
            addRow(data);
        },
        error: function(xhr,Textstatus,error) {
            alert(Textstatus);
        }
    });
}