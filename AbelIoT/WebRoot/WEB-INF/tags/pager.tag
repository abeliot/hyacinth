    <%@ tag language="java" pageEncoding="UTF-8"%>  
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 	
    <%@ attribute name="pageList" type="com.abeliot.framework.base.PageList" required="true"%>  
    <%@ attribute name="pagerRange" type="java.lang.Long" required="true"%>  
    <%@ attribute name="formId" type="java.lang.String" required="true"%>  
    <%  
        long begin = Math.max(1, pageList.index - pagerRange/2);  
        long end = Math.min(begin + (pagerRange-1), pageList.totalPage);  
          
        request.setAttribute("p_begin", begin);  
        request.setAttribute("p_end", end);  
    %>  
        <table class="pager">  
        <tr>  
             <% if (pageList.index != 1){%>  
                    <td><a href="javascript:gotoPage(${formId}, 1)">首页</a></td>  
                    <td><a href="javascript:gotoPage(${formId}, ${pageList.prevIndex })">上一页</a></td>  
             <%}else{%>  
                    <td class="disabled"><a href="javascript:">首页</a></td>  
                    <td class="disabled"><a href="javascript:">上一页</a></td>  
             <%}%>  
       
            <c:forEach var="i" begin="${p_begin}" end="${p_end}">  
                <c:choose>  
                    <c:when test="${i == pageList.index}">  
                        <td class="active"><a href="javascript:">${i}</a></td>  
                    </c:when>  
                    <c:otherwise>  
                        <td><a href="javascript:gotoPage(${formId}, ${i})">${i}</a></td>  
                    </c:otherwise>  
                </c:choose>  
            </c:forEach>  
      
             <% if (pageList.index == pageList.totalPage){%>  
                    <td class="disabled"><a href="javascript:">下一页</a></td>  
                    <td class="disabled"><a href="javascript:">末页</a></td>  
             <%}else{%>  
                    <td><a href="javascript:gotoPage(${formId}, ${pageList.nextIndex })">下一页</a></td>  
                    <td><a href="javascript:gotoPage(${formId}, ${pageList.totalPage })">末页</a></td>  
             <%}%>  
             <td><a>共${pageList.totalPage}页</a></td>  
             <td class="input_li">跳转到:<input type="text" id="p_pageIndex" maxlength="4" value="${pageList.index}"/>页 
             							<input type="button" id="gotoBtn" onclick="gotoPageByBtn(${formId}, ${pageList.totalPage })" value="GO"/></td>  
             <td class="input_li"> 每页: 
             <input type="text" id="p_pageSizeField" onchange="gotoPage(${formId},${pageList.index})" maxlength="2" value="${pageList.pageSize}""/>
             </td>  
        </tr>  
        </table>  