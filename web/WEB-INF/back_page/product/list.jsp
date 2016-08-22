<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
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
    <div class="rpos">当前位置: 商品管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加" onclick="javascript:window.location.href='toAdd.do'"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="/control/product/list.do" method="post" style="padding-top:5px;">
        <input type="hidden" value="1" name="page"/>
        名称: <input type="text" onkeyup="changePageNo()" value="${name}" name="name"/>
        <select onchange="changePageNo()" name="brandId">
            <c:forEach var="brand" items="${brands}">
                <option value="${brand.id}" <c:if test="${brand.id == brandId}">selected</c:if>>
                ${brand.name}</option>
            </c:forEach>
        </select>
        <select onchange="changePageNo()" name="isShow">
            <option value="1">上架</option>
            <option selected="selected" value="0">下架</option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <form method="post" id="tableForm">
        <input type="hidden" value="" name="pageNo"/>
        <input type="hidden" value="" name="queryName"/>
        <table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>图片</th>
                <th width="4%">新品</th>
                <th width="4%">热卖</th>
                <th width="4%">推荐</th>
                <th width="4%">上下架</th>
                <th width="12%">操作选项</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">

            <c:forEach items="${productPageModel.list}" var="product">

                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="${product.id}"/></td>
                    <td>${product.no}</td>
                    <td align="center">${product.name}</td>
                    <td align="center"><img width="50" height="50" src="/res/img/pic/ppp0.jpg"/></td>
                    <td align="center"><c:if test="${product.isNew != 0}">是</c:if><c:if test="${product.isNew == 0}">不是</c:if></td>
                    <td align="center"><c:if test="${product.isHot != 0}">是</c:if><c:if test="${product.isHot == 0}">不是</c:if></td>
                    <td align="center"><c:if test="${product.isCommend != 0}">是</c:if><c:if test="${product.isCommend == 0}">不是</c:if></td>
                    <td align="center"><c:if test="${product.isShow != 0}">是</c:if><c:if test="${product.isShow == 0}">不是</c:if></td>
                    <td align="center">
                        <a href="#" class="pn-opt">查看</a> | <a href="#" class="pn-opt">修改</a> |
                        <a href="#" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a> |
                        <a href="../sku/list.jsp" class="pn-opt">库存</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <div class="page pb15">
				<span class="r inb_a page_b">
					<span id="previousNo" style="display:none" class="inb" title="上一页"><samp>&lt;&lt;</samp>上一页</span>
                    <a href="/control/product/list.do?page=${productPageModel.previousPageNo}" id="previous"
                       title="上一页"><samp>
                        &lt;&lt;</samp>上一页</a>
                    <c:forEach var="i" begin="1" end="${productPageModel.totalPages}" step="1">
                        <a href="/control/product/list.do?page=${i}"
                           <c:if test="${productPageModel.pageNo == i}">class="inb current"</c:if>> ${i}</a>

                    </c:forEach>

                    <span id="nextNo" class="inb" title="下一页" style="display:none">下一页<samp>&gt;&gt;</samp></span>
                    <a href="/control/product/list.do?page=${productPageModel.nextPageNo}" id="next"
                       title="下一页">下一页<samp>
                        &gt;&gt;</samp></a>
                    共<var id="pageTotal" class="orange">${productPageModel.totalPages}</var>页 到第
                    <input type="text" id="number" name="number" class="txts" size="3"/>页
                    <input type="button" id="skip" class="hand btn60x20" value='确定'/>
				</span>
        </div>

        <div class="page pb15"><span class="r inb_a page_b"></span></div>
        <div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/>
            <input class="add" type="button" value="上架" onclick="optShow();"/>
            <input class="del-button" type="button" value="下架" onclick="optNotShow();"/>
        </div>
    </form>
</div>

<script>
    function getTableForm() {
        return document.getElementById('tableForm');
    }
    function optDelete() {
        if (Pn.checkedCount('ids') <= 0) {
            alert("请至少选择一个!");
            return;
        }
        if (!confirm("确定删除吗?")) {
            return;
        }
        var f = getTableForm();
        f.action = "o_delete.do";
        f.submit();
    }

    function optShow() {
        if (Pn.checkedCount('ids') <= 0) {
            alert("请至少选择一个!");
            return;
        }
        if (!confirm("确定上架吗?")) {
            return;
        }
        var form = getTableForm();
        form.action = "show.do?show=1";
        form.submit();
    }

    function optNotShow() {
        if (Pn.checkedCount('ids') <= 0) {
            alert("请至少选择一个!");
            return;
        }
        if (!confirm("确定下架吗?")) {
            return;
        }
        var form = getTableForm();
        form.action = "show.do?show=0";
        form.submit();
    }


    function changePageNo() {
        $("input[name='pageNo']").val(1);
    }
</script>

</body>
</html>