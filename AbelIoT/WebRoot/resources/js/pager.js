/**
 * 分页跳转脚本
 */

function gotoPage(pageQueryForm, pageIndex){  
//    alert(pageQueryForm + ", " + pageIndex);  
    //var queryForm = document.getElementById(formId);  
//    var action = pageQueryForm.action;  
    var pageSize = document.getElementById("p_pageSizeField").value;  
//    action += "&pageIndex=" + pageIndex + "&pageSize=" + pageSize;  
//    alert(action);  

    pageQueryForm["pageSize"].value = pageSize;
    pageQueryForm["pageIndex"].value = pageIndex;
//    alert(pageQueryForm["pageSize"].value);
//    alert(pageQueryForm["pageIndex"].value);
//    pageQueryForm.action = action;
    pageQueryForm.submit();  
}  
  
function gotoPageByBtn(formId, totalPage){  
    var pageIndex = document.getElementById("p_pageIndex").value;  
    var pageIndexInt = parseInt(pageIndex);  
      
    if(pageIndexInt>0 && pageIndexInt<=totalPage){  
        gotoPage(formId, pageIndex);  
    }  
    else{  
        alert("输入页数超出范围!");  
    }  
}

