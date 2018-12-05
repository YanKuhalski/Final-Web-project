<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
    <head>
        <style type="text/css">
            TABLE {
             border-collapse: collapse; /* Убираем двойные границы между ячейками */
             border: 4px solid black; /* Рамка вокруг таблицы */
            }    
            TH{
             background: #dc0; /* Цвет фона таблицы */
            }
            TD, TH {
             padding: 5px; /* Поля вокруг текста */
             border: 2px solid black; /* Рамка вокруг ячеек */
            }
        </style>
     </head> 
<body>
<jsp:include page ="../fragments/header.jsp"/>
<table >
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Is Active</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <td>Yan</td>
        <td>Yan12345</td>
        <td>Yes</td>
        <td><a href="">Удалить</a></td>
        <td><a href="">Редактировать</a></td>
        <td><a href="">Разблокировать</a></td>
        <td><a href="">Заблокировать</a></td>    
    </tr>
</table>
    <input type="submit" value="Add new">
</body>
</html>
