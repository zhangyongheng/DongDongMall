<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html >
<html>
<head>
    <link href="/res/css/admin.css" rel="stylesheet"/>
    <link href="/res/common/css/theme.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.validate.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.treeview.css" rel="stylesheet"/>
    <link href="/res/common/css/jquery.ui.css" rel="stylesheet"/>

    <!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
    <!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
    <script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
    <script src="/res/common/js/jquery.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
    <script src="/res/common/js/yongheng.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/res/css/style.css"/>

    <title>JEECMS Administrator's Control Panel</title>
    <script type="text/javascript">
        if (top != this) {
            top.location = this.location;
        }
        $(function () {
            $("#username").focus();
            $("#jvForm").validate();
        });
    </script>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-size: 12px;
            background: url(/res/jeecms/img/login/bg.jpg) top repeat-x;
        }

        .input {
            width: 150px;
            height: 17px;
            border: 1px solid #404040;
            border-right-color: #D4D0C8;
            border-bottom-color: #D4D0C8;
        }
    </style>
</head>
<body>
<form id="jvForm" action="login.do" method="post">
    <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="200">&nbsp;</td>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="423" height="280" valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td><img src="/res/jeecms/img/login/ltop.jpg"/></td>
                                </tr>
                                <tr>
                                    <td><img src="/res/jeecms/img/login/llogo.jpg"/></td>
                                </tr>
                            </table>
                        </td>
                        <td width="40" align="center" valign="bottom"><img src="/res/jeecms/img/login/line.jpg"
                                                                           width="23" height="232"/></td>
                        <td valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="90" align="center" valign="bottom"><img
                                            src="/res/jeecms/img/login/ltitle.jpg"/></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                        </div>
                                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
                                            <tr>
                                                <td width="91" height="40" align="right"><strong> 用户名</strong></td>
                                                <td width="211"><input type="input" id="username" name="username"
                                                                       vld="{required:true}" maxlength="100"
                                                                       class="input"/></td>
                                            </tr>
                                            <tr>
                                                <td height="40" align="right"><strong>密码</strong></td>
                                                <td><input name="password" type="password" id="password" maxlength="32"
                                                           vld="{required:true}" class="input"/></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center"><img src="/captcha.svl"
                                                                                    onclick="this.src='/captcha.svl?d='+new Date()*1"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height="40" align="right"><strong>验证码</strong></td>
                                                <td><input name="captcha" type="text" id="captcha" vld="{required:true}"
                                                           class="input"/></td>
                                            </tr>
                                            </#if>
                                            <tr>
                                                <td height="40" colspan="2" align="center">
                                                    <input type="image" src="/res/jeecms/img/login/login.jpg"
                                                           name="submit"/>
                                                    &nbsp; &nbsp; <img name="reg" style="cursor: pointer"
                                                                       src="/res/jeecms/img/login/reset.jpg"
                                                                       onclick="document.forms[0].reset()"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
