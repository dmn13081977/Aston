<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2> All People </h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>


    <c:forEach var="person" items="${allPeople}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="personId" value="${person.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deletePerson">
            <c:param name="personId" value="${person.id}"/>
        </c:url>

        <tr>
            <td>${person.name}</td>
            <td>${person.surname}</td>
            <td>${person.department}</td>
            <td>${person.salary}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addPerson'"/>
</body>
</html>