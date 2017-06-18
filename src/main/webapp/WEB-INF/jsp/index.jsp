<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<html>
<head>
	<script type="text/javascript" src="${baseURL}/resources/jquery.js"></script>
	<script>
		window.applicationBasePathLocation = ${baseURL};
	</script>
</head>

<body>

${baseURL}
<div id="main-content">


</div>
<div id="create-topic"></div>
<script src="${baseURL}/resources/bundle.js"></script>
</body>

</html>