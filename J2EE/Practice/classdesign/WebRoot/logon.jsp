<%@ page contentType="text/html;charset=GB2312" %>
<form method="post" action="logon.jsp?action=logon">
    <table>
        <tr>
            <td>�û�����</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>���룺</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <input type="hidden" name="origin_uri" value="${requestScope.origin_uri}">
        </tr>
        <tr>
            <td><input type="reset" value="����"></td>
            <td><input type="submit" value="�ύ"></td>
        </tr>
    </table>
</form>