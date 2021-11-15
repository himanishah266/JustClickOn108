<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>

<c:set var="list" value="${sessionScope.citylist}"></c:set>
<c:set var="length" value="${f:length(list)}"></c:set>
[
<c:forEach var="i" items="${sessionScope.citylist}" varStatus="j">
{"cityID":"${i.cityID}","cityName":"${i.cityName}"}
<c:if test="${length ne j.count}">,
</c:if>
</c:forEach>
]

