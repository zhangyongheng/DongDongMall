<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="rpos">当前位置: 库存管理 - 列表</div>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form method="post" id="tableForm">
        <table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品颜色</th>
                <th>商品尺码</th>
                <th>市场价格</th>
                <th>销售价格</th>
                <th>库 存</th>
                <th>购买限制</th>
                <th>运 费</th>
                <th>是否赠品</th>
                <th>操 作</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">

            <c:forEach items="${skuList}" var="sku">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="${sku.id}"/></td>
                    <td>${productNo}</td>
                    <td align="center">${sku.colorId}</td>
                    <td align="center">${sku.size}</td>
                    <td align="center"><input type="text" id="marketPrice" value="${sku.marketPrice}"
                                              disabled="disabled"
                                              size="10"/></td>
                    <td align="center"><input type="text" id="skuPrice" value="${sku.skuPrice}" disabled="disabled"
                                              size="10"/></td>
                    <td align="center"><input type="text" id="stockInventory" value="${sku.stockInventory}"
                                              disabled="disabled"
                                              size="10"/></td>
                    <td align="center"><input type="text" id="skuUpperLimit" value="${sku.skuUpperLimit}"
                                              disabled="disabled"
                                              size="10"/></td>
                    <td align="center"><input type="text" id="deliveFee" value="${sku.deliveFee}" disabled="disabled"
                                              size="10"/></td>
                    <td align="center"><c:if test="${!empty sku.skuType} ">是</c:if>
                        <c:if test="${empty sku.skuType}">不是</c:if></td>
                    <td align="center">
                        <a href="#" class="pn-opt update">修改</a> |
                        <a href="#" class="pn-opt save">保存</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </form>
</div>

<script type="text/javascript">
    $(".update").click(function () {
        var currentRow = $(this).parent().parent();
        currentRow.find("#marketPrice").attr("disabled", false);
        currentRow.find("#skuPrice").attr("disabled", false);
        currentRow.find("#stockInventory").attr("disabled", false);
        currentRow.find("#skuUpperLimit").attr("disabled", false);
        currentRow.find("#deliveFee").attr("disabled", false);
        return false;
    });

    $(".save").click(function () {
        var currentRow = $(this).parent().parent();
        var marketPrice = currentRow.find("#marketPrice");
        var skuPrice = currentRow.find("#skuPrice");
        var stockInventory = currentRow.find("#stockInventory");
        var skuUpperLimit = currentRow.find("#skuUpperLimit");
        var deliveFee = currentRow.find("#deliveFee");
        $.ajax({
                    method: "post",
                    url: "/control/sku/update.do",
                    dataType: "json",
                    data: {
                        "id": currentRow.find("input[name='ids']").val(),
                        "marketPrice": marketPrice.val(),
                        "skuPrice": skuPrice.val(),
                        "stockInventory": stockInventory.val(),
                        "skuUpperLimit": skuUpperLimit.val(),
                        "deliveFee": deliveFee.val()
                    },
                    success: function (data) {
                        alert("修改成功");
                    },
                    error: function () {
                        alert("修改失败");
                    }
                }
        );

        marketPrice.attr("disabled", true);
        skuPrice.attr("disabled", true);
        stockInventory.attr("disabled", true);
        skuUpperLimit.attr("disabled", true);
        deliveFee.attr("disabled", true);
        return false;
    });


</script>


</body>
</html>