<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html >
<html>
<head>

    <title>咚咚商城-list</title>
    <link href="/res/css/admin.css" rel="stylesheet"/>
    <link href="/res/common/css/theme.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.validate.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.treeview.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.ui.css" rel="stylesheet"/>

    <script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
    <script src="/res/common/js/jquery.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
    <script src="/res/common/js/yongheng.js" type="text/javascript"></script>
    <script src="/res/js/admin.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/res/css/style.css"/>

</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 品牌管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="/control/brand/list.do" method="get" style="padding-top:5px;">
        品牌名称: <input id="findName" type="text" name="name" value="${name}"/>
        <select id="visit" name="visit">
            <option value="1" <c:if test="${visit == 1}">selected</c:if>>是</option>
            <option value="0" <c:if test="${visit == 0}">selected</c:if>>不是</option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
        <thead class="pn-lthead">
        <tr>
            <th width="20"><input type="checkbox"/></th>
            <th>品牌ID</th>
            <th>品牌名称</th>
            <th>品牌图片</th>
            <th>品牌描述</th>
            <th>排序</th>
            <th>是否可用</th>
            <th>操作选项</th>
        </tr>
        </thead>
        <tbody class="pn-ltbody">

        <c:forEach var="brand" items="${pageModel.list}">
            <tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
                <td><input type="checkbox" value="8" name="${brand.id}"/></td>
                <td align="center">${brand.id}</td>
                <td align="center">${brand.name}</td>
                <td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
                <td align="center">${brand.description}</td>
                <td align="center">${brand.sort}</td>
                <td align="center"><c:if test="${brand.isVisit == 1}">是</c:if><c:if
                        test="${brand.isVisit == 0}">不是</c:if></td>
                <td align="center">
                    <a class="pn-opt" href="#">修改</a> |
                    <a class="delete pn-opt" href="/control/brand/deleteBrand.do?id=${brand.id}&findName=${name}&visit=${visit}">删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
    <div class="page pb15">
				<span class="r inb_a page_b">
					<span id="previousNo" style="display:none" class="inb" title="上一页"><samp>&lt;&lt;</samp>上一页</span>
                    <a href="/control/brand/list.do?page=${pageModel.previousPageNo}" id="previous" title="上一页"><samp>
                        &lt;&lt;</samp>上一页</a>
                    <c:forEach var="i" begin="1" end="${pageModel.totalPages}" step="1">
                        <a href="/control/brand/list.do?page=${i}"
                           <c:if test="${pageModel.pageNo == i}">class="inb current"</c:if>> ${i}</a>

                    </c:forEach>

                    <span id="nextNo" class="inb" title="下一页" style="display:none">下一页<samp>&gt;&gt;</samp></span>
                    <a href="/control/brand/list.do?page=${pageModel.nextPageNo}" id="next" title="下一页">下一页<samp>&gt;&gt;</samp></a>
                    共<var id="pageTotal" class="orange">${pageModel.totalPages}</var>页 到第
                    <input type="text" id="number" name="number" class="txts" size="3"/>页
                    <input type="button" id="skip" class="hand btn60x20" value='确定'/>
				</span>
    </div>
</div>


<script>
    if (${pageModel.pageNo == pageModel.totalPages}) {
        $("#next").css("display", "none");
        $("#nextNo").css("display", "");
    }

    if (${pageModel.pageNo == pageModel.topPageNo}) {
        $("#previous").css("display", "none");
        $("#previousNo").css("display", "");
    }

    $("#skip").click(function () {
        var pageNum = $("#number").val()
        if (pageNum != null && pageNum != "") {
            window.location.href = "/control/brand/list.do?page=" + pageNum;
        }
        $(this).blur();
    });

    $(".add").click(function () {
        window.location.href = "/control/brand/add.do"
    });

    $(".delete").click(function () {
        if (!confirm('您确定删除吗？')) {
            return false;
        }
    });

</script>


</body>
</html>