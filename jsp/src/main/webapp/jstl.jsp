<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Using JSTL in JSP</title>
</head>
<body>
    <c:set var="user" value="Nikita Bansode" />

    <c:if test="${not empty user}">
        <p>Welcome, <c:out value="${user}" />!</p>
    </c:if>   <!-- ✅ make sure this is present -->

    <p>Today's date:
        <fmt:formatDate value="${now}" pattern="dd/MM/yyyy"/>
    </p>
</body>
</html>
