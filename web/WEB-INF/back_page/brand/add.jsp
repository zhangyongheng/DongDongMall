<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <title>咚咚商城-add</title>
    <link href="/res/css/admin.css" rel="stylesheet"/>
    <link href="/res/common/css/theme.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.validate.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.treeview.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.ui.css" rel="stylesheet"/>

    <script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
    <script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
    <script src="/res/common/js/yongheng.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/res/css/style.css"/>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 品牌管理 - 添加</div>
    <form class="ropt">
        <input type="submit" value="返回列表" class="return-button"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box" style="float:right">
    <form id="jvForm" action="/control/brand/addBrand.do" method="post" enctype="multipart/form-data">
        <table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
            <tbody>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h">
                    <span class="pn-frequired">*</span>
                    品牌名称:
                </td>
                <td width="80%" class="pn-fcontent">
                    <input type="text" class="required" name="name" maxlength="100"/>
                </td>
            </tr>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h">
                    <span class="pn-frequired">*</span>
                    上传商品图片(90x150尺寸):
                </td>
                <td width="80%" class="pn-fcontent">
                    注:该尺寸图片必须为90x150。
                </td>
            </tr>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h"></td>
                <td width="80%" class="pn-fcontent">
                    <img width="100" height="100" id="allImgUrl"/>
                    <input type="file" name="pic"/>
                </td>
            </tr>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h">
                    品牌描述:
                </td>
                <td width="80%" class="pn-fcontent">
                    <input type="text" class="required" name="description" maxlength="80" size="60"/>
                </td>
            </tr>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h">
                    排序:
                </td>
                <td width="80%" class="pn-fcontent">
                    <input type="text" class="required" name="sort" maxlength="80"/>
                </td>
            </tr>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h">
                    是否可用:
                </td>
                <td width="80%" class="pn-fcontent">
                    <input type="radio" name="isVisit" value="1" checked="checked"/>可用
                    <input type="radio" name="isVisit" value="0"/>不可用
                </td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <td class="pn-fbutton" colspan="2">
                    <input type="submit" class="submit" value="提交"/> &nbsp;
                    <input type="reset" class="reset" value="重置"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<script>
    $(".return-button").click(function () {
        window.location.href = "/control/brand/list.do";
        return false;
    });

    $("input:file").change(function () {
        $("#jvForm").ajaxSubmit({
            url: "/upload/pic.do",
            method: "post",
            dataType: "json",
            success: function (data) {
                alert("成功");
            },
            error: function () {
                alert("失败");
            }

        });


    });

</script>

</body>
</html>